package servlet;

import java.io.IOException;
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
public class DeleteSlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteSlt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String jobnumber=(String) request.getParameter("jobnumber");
		
		GradeDBManager gdbManager=new GradeDBManager( GradeDBuitl.getConnect());
		try {
			
				boolean result =gdbManager.deletBynumber(jobnumber);
				JSONObject jsonobject=new JSONObject();
				JSONArray jsonarray=new JSONArray();
				if(result) {
					jsonobject.put("result", "ok");
				}
				else {
					jsonobject.put("result","nok");
				}
				jsonarray.add(jsonobject);
				request.setAttribute("jsonarray", jsonarray);
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			request.setAttribute("exception", e.getMessage());
		}
		request.getRequestDispatcher("WEB-INF/jsppc/deletUser.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
