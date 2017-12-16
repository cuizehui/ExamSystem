package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import dao.GradeDBManager;
import dao.GradeDBuitl;

/**
 * 根据日期查询 servlet
 */
@WebServlet("/selectSlt")
public class selectSlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public selectSlt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF8");
		// TODO Auto-generated method stub
		String startdata=request.getParameter("startTime");
		String  enddata=request.getParameter("endTime");
		String  jobnumber=request.getParameter("selectjobnumber");
	
		
	
			if(startdata!=null&&enddata!=null) {
				System.out.println("11");
				JSONArray jsonArray = selectGdByData(startdata,enddata);
				response.getWriter().println(jsonArray);
				request.setAttribute("startTime",startdata);
				request.setAttribute("endTime",enddata);
				request.setAttribute("jsonArray", jsonArray);
				request.getRequestDispatcher("/WEB-INF/jsppc/Allresult.jsp").forward(request,response);
//				response.sendRedirect(arg0).;
			}
			if(startdata!=null) {
				selectGdBysData(startdata);
			}
			if(enddata!=null) 
			{
				selectGdByeData(startdata);
			}	
	}
		
		
	

	private void selectGdByeData(String startdata) {
		// TODO Auto-generated method stub
		
	}

	private void selectGdBysData(String startdata) {
		// TODO Auto-generated method stub
		
	}
	

	private JSONArray selectGdByData(String startdata, String enddata) {
		// TODO Auto-generated method stub
		 JSONArray jsonArray=new JSONArray();
			
		Connection connect = GradeDBuitl.getConnect();
		 GradeDBManager gradeDBManager=new GradeDBManager(connect);
		 ResultSet rs= gradeDBManager.selectbydata(startdata, enddata);
	 if(rs!=null) {
			 try {
				while(rs.next()){
				      // 通过字段检索
						String name = rs.getString("name");
				       String jobnumber = rs.getString("jobnumber");
				       String grade=rs.getString("grade");
				       Timestamp timedata = rs.getTimestamp("current_time");
				        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				        String time=simpleDateFormat.format(timedata);
				        
				       JSONObject json=new JSONObject();
				       json.put("name", name);
				       json.put("jobnumber", jobnumber);
				       json.put("grade", grade);
				       json.put("time",time);
				       jsonArray.add(json);
				       System.out.println("ss");
				       
				       
				   	
				  }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	 
		 }
		 return jsonArray;
	}


	private void selectbyJBnumber() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
