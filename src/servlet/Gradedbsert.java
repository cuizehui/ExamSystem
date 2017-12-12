package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import dao.GradeDBManager;
import dao.GradeDBuitl;

/**
 * Servlet implementation class Gradedbsert
 */
@WebServlet("/Gradedbsert")
public class Gradedbsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Connection connect;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Gradedbsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	  	response.setCharacterEncoding("utf8");
       
	  	String type=request.getParameter("type");
	  	
	    if(type!=null) {
	    	int requesttype=Integer.parseInt(type);
		  
	    	PrintWriter out = response.getWriter();
		  
		     connect= GradeDBuitl.getConnect();
		     
		    GradeDBManager gradedb=new GradeDBManager(connect);
		   
	        if(requesttype==1) {
	     	
	     	   selectAllGrade(request,out,gradedb,response);
	     	   
	        }else if(requesttype==2) {
	     	   
	     	   changeGrade(request,out,gradedb) ;
	        }
	        
	    }
	  
    		   
    	
    
          
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	private void changeGrade(HttpServletRequest request, 	PrintWriter out ,GradeDBManager gradedb) {
		
		
	  		String jobid=request.getParameter("jobnumber");
	  		String gradeString=request.getParameter("grade");
		
	  				
	  		int grade=Integer.parseInt(gradeString);	
	  		boolean isok= gradedb.updataGrade(jobid, grade);
	  		
	  		GradeDBuitl.closeConnect(connect);
	  		
	  		JSONObject json=new JSONObject();
	  		json.put("changeok", isok);
	  		JSONArray jsonArray=new JSONArray();
	  		jsonArray.add(json);
	  		out.println(jsonArray);
	
	}

	
	private void selectAllGrade(HttpServletRequest request,PrintWriter out ,GradeDBManager gradedb,HttpServletResponse response) {
			      ResultSet rs= gradedb.selectUser();
		  
	      //javabean
	
	      // 展开结果集数据库
        try {
    		JSONArray jsonArray=new JSONArray();
			while(rs.next()){
			      // 通过字段检索
					String name = rs.getString("name");
			       String jobnumber = rs.getString("jobnumber");
			       String grade=rs.getString("grade");
			         Timestamp timedata = rs.getTimestamp("current_time");
			        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			        String time=simpleDateFormat.format(timedata);
			        System.out.println(time);
			       JSONObject json=new JSONObject();
			       json.put("name", name);
			       json.put("jobnumber", jobnumber);
			       json.put("grade", grade);
			       json.put("time",time);
			       jsonArray.add(json);
			  }
			GradeDBuitl.closeConnect(connect);
			rs.close();
			out.print(jsonArray);
		
			try {
				
				
				request.setAttribute("jsonArray", jsonArray);
				request.getRequestDispatcher("/WEB-INF/jsppc/Allresult.jsp").forward(request,response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void selectGdBydata(HttpServletRequest request,PrintWriter out ,GradeDBManager gradedb,HttpServletResponse response) {
		
		
		
	}
	
}
