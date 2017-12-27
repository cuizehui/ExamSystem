package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BaseServlet  extends HttpServlet  {

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		    doCommentGet(request, response);
		    String fromtype=request.getParameter("fromtype");
		    System.out.println("--"+fromtype);
		 if(request.getParameter("fromtype").equals("android")){
				doAndroidGet(request,response);
			}
	    else if(request.getParameter("fromtype").equals("web")) {
			doWebGet(request,response);		 
		}
		
		
			
	}
	

	@Override 
 	protected  void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	

	protected  abstract  void doCommentGet(HttpServletRequest request, HttpServletResponse response) throws IOException ;



	protected  abstract  void doAndroidGet(HttpServletRequest request, HttpServletResponse response) throws IOException  ;
	


	protected  abstract  void doWebGet(HttpServletRequest request, HttpServletResponse response) ;





}
