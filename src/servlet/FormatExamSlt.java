package servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;

import tools.SplitTool;

/**
 * Servlet implementation class FormatExamSlt
 */
@WebServlet("/FormatExamSlt")
public class FormatExamSlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormatExamSlt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
 
	    String filename=	  request.getParameter("filename");
        String filepath = request.getServletContext().getResource("").getPath()+"file/"+filename;
        String examfile= readfile(filepath);
        JSONArray jsonarray=  SplitTool.splitExam(examfile); 
        request.setAttribute("jsonarray",jsonarray);
	    request.getRequestDispatcher("WEB-INF/jsppc/seeFile.jsp").forward(request, response);
	         
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	public  String readfile(String filepath) {
	       String  paths=null;
			try {
	         File file = new File(filepath);  
	         System.out.println("filepath :"+filepath);
	         InputStream  is = new FileInputStream(file);
		      
	         if (!file.exists() ) {  
	         System.out.println("文件不存在");
	         }     
	         StringBuilder builder = new StringBuilder();
	         byte[] buf = new byte[1024];  
	         while (is.read(buf) != -1) {      
	        	
	        	 builder.append(new String(buf));
	        	 
	         }  
	         is.close();
	         paths=builder.toString();
	  
	         return paths;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return paths;
		}  
     		  
				

}
}
