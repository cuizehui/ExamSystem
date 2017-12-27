package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

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
 * Servlet implementation class deleteSlt
 */
@WebServlet("/DeleteSlt")
public class DeleteSlt extends BaseServlet{
	private static final long serialVersionUID = 1L;
	JSONArray jsonarray;



	@Override
	protected void doCommentGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String jobnumber=(String) request.getParameter("jobnumber");
		
		GradeDBManager gdbManager=new GradeDBManager( GradeDBuitl.getConnect());
		try {	
				boolean result =gdbManager.deletBynumber(jobnumber);
				jsonarray=new JSONArray();
				JSONObject jsonobject=new JSONObject();
				if(result) {
					jsonobject.put("result", "ok");
				}
				else {
					jsonobject.put("result","nok");
				}
				jsonarray.add(jsonobject);
				
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			request.setAttribute("exception", e.getMessage());
		}
			
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
	protected void doWebGet(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			request.setAttribute("jsonarray", jsonarray);
			System.out.println("helloword");
			request.getRequestDispatcher("WEB-INF/jsppc/deletUser.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
