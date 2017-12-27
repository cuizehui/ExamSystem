package servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Enumeration;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import tools.ExecShell;



/**
 * Servlet implementation class AddExamFileSlt
 */
@WebServlet("/AddExamFileSlt")


//使用注解@MultipartConfig将一个Servlet标识为支持文件上传
@MultipartConfig//标识Servlet支持文件上传


public class AddExamFileSlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddExamFileSlt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			doPost(request,response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 request.setCharacterEncoding("utf-8");
         response.setCharacterEncoding("utf-8");
         response.setContentType("text/html;charset=utf-8");
        
         Enumeration<String> heads = request.getHeaderNames();  
         while (heads.hasMoreElements()) {  
             String header = heads.nextElement();  
             System.out.println(header + "=" + request.getHeader(header));  
         }  
        
         //获取文件
         Part part = request.getPart("filename");  
         
        Collection<String> headerNames = part.getHeaderNames();    
         for (String header : headerNames) {  
             System.out.println(header + "=" + part.getHeader(header));  
         }
         
         ///home/cuizehui/eclipse-workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/ExamSystems/
         String path = request.getServletContext().getResource("").getPath();
         System.out.println("path::::"+ path);
         copyfile(part,path);
         //转发至当前页
         request.getRequestDispatcher("WEB-INF/jsppc/addExamFile.jsp").forward(request, response);
         
     
	}
	
	  public void copyfile(Part part ,String path){
		    InputStream is;
			try {
				is = part.getInputStream();
				 String filename = new String(getFilename(part).getBytes(), "UTF-8");  
		         File file = new File(path+"/file");  
		         if (!file.exists() || !file.isDirectory()) {  
		             file.mkdir();  
		         }  
		           
		         FileOutputStream fos = new FileOutputStream(new File(file + File.separator + filename));  
		         byte[] buf = new byte[1024];  
		         while (is.read(buf) != -1) {  
		             fos.write(buf);  
		         }  
		         fos.flush();  
		         fos.close();  
		         is.close();
			
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
	        		  
	  }
	
	  public String getFilename(Part part) {  
	        String contentDispositionHeader = part.getHeader("content-disposition");  
	        String[] elements = contentDispositionHeader.split(";");  
	        for (String element : elements) {  
	            if (element.trim().startsWith("filename")) {  
	                return element.substring(element.indexOf('=') + 1).trim().replace("\"", "");  
	            }  
	        }  
	        return null;  
	    }  

	 

}
