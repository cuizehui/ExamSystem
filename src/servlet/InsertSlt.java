package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
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
 * 添加servlet
 */
@WebServlet("/InsertSlt")
public class InsertSlt extends BaseServlet {
	private static final long serialVersionUID = 1L;
	JSONArray jsonarray;
 
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	

	@Override
	protected void doAndroidGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("doandroidget");
		response.setCharacterEncoding("utf8");
	     response.setContentType("text/json; charset=utf-8");
		PrintWriter out = response.getWriter();
	    System.out.println(jsonarray.toString());
	     out.write(jsonarray.toString());
	    out.close();
	}

	@Override 
	protected void doCommentGet(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("docommentget");
		// TODO Auto-generated method stub
		
		   		Connection  connect  =GradeDBuitl.getConnect();
		   		GradeDBManager gradedb=new GradeDBManager(connect);
		   		boolean isok;
		   		 jsonarray = new JSONArray(); 
			    JSONObject json=new JSONObject();
		try {
			 	request.setCharacterEncoding("utf8");
		       String jobnumber=request.getParameter("jobnumber");
		       String name=request.getParameter("name");
		   
			 isok = gradedb.insertUser(name, jobnumber);
			 json.put("result", isok);
		       if(isok) {
		    	 json.put("name",name);
		    	 json.put("jobnumber", jobnumber);
			     }			     
			     jsonarray.add(json);
	       } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JSONObject errojson=new JSONObject();
			errojson.put("result", "false");
			request.setAttribute("exception", e.getMessage());
		   jsonarray.add(errojson);
	       }
			catch (Exception e) {
			// TODO: handle exception
		   }
		   finally {
	    	   GradeDBuitl.closeConnect(connect); 
	    }
	}
	
	@Override
	protected void doWebGet(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		   System.out.println("dowebget");
	      	try {
	      		 request.setAttribute("jsonArray", jsonarray);
				 request.getRequestDispatcher("/WEB-INF/jsppc/addUser.jsp").forward(request,response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	      
	}



}
