package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.JSONSerializerMap;

import dao.GradeDBManager;
import dao.GradeDBuitl;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * http://localhost:8085/ExamSystems/login?name=value1&jobnumber=123456
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		//注册
		
		//request 获取表单数据
		request.setCharacterEncoding("utf8");
	   	response.setCharacterEncoding("utf8");
	    response.setContentType("text/json; charset=utf-8");
	    PrintWriter out = response.getWriter();
	    
	      String jobnumber=request.getParameter("jobnumber");
	      String name=request.getParameter("name");
	      //开启数据库
	      Connection  connect  =GradeDBuitl.getConnect();
	      GradeDBManager gradedb=new GradeDBManager(connect);
	       boolean isok;
	      
	       JSONArray jsonarray = new JSONArray(); 
		   JSONObject json=new JSONObject();
				
	       try {
	    	   isok = gradedb.insertUser(name, jobnumber);
	    	   		json.put("result", isok);
			       if(isok) {
			    	 json.put("name",name);
			    	 json.put("jobnumber", jobnumber);

			     }			     
			     jsonarray.add(json);
			     //out.println(jsonarray);
			 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("exception", e.getMessage());

		}
	       finally {
	    	   GradeDBuitl.closeConnect(connect);
	 	      	request.setAttribute("jsonArray", jsonarray);
	 	      	request.getRequestDispatcher("/WEB-INF/jsppc/addUser.jsp").forward(request,response);
	 	         
	       }
	      
	}

	private  void  login() {
		
	}
	//预留app接口
	private void inject() {

	     
	}
	
	
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
