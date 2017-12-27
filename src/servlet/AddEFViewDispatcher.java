package servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import tools.ExecShell;
import tools.SplitTool;

/**
 * Servlet implementation class AddExamFileDispatcher
 */
@WebServlet("/AddExamFileDispatcher")
public class AddEFViewDispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEFViewDispatcher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");
		
		
		showfiles(request);
	
      
		request.getRequestDispatcher("WEB-INF/jsppc/addExamFile.jsp").forward(request,response);
		
		
		
	}

	
	/**
	 * 展示本地已经存在的文件
	 * @param request
	 */
	private void showfiles(HttpServletRequest request) {
		// TODO Auto-generated method stub
	    
        ExecShell execshell =new  ExecShell();
        String path;
		try {
			path = request.getServletContext().getResource("").getPath();
			  //
	        StringBuilder result =execshell.execSelectFile(path);
	        
	        String resultString= result.toString();
	        //\\s+ 分割空格
	        String  resultarray[] =resultString.split("\\s+");
	        System.out.println(":"+resultarray.length);        
	        request.setAttribute("files",resultarray );
	        System.out.println(":"+resultString);
	        
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	

}
