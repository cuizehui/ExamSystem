package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tools.ExecShell;

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
		
	    //展示已有文件
        ExecShell execshell =new  ExecShell();
        //
        StringBuilder result =execshell.execSelectFile();
        String resultString= result.toString();
        
        //\\s+ 分割空格
        String  resultarray[] =resultString.split("\\s+");
        System.out.println(":"+resultarray.length);        
        request.setAttribute("files",resultarray );
        System.out.println(":"+resultString);
		
		request.getRequestDispatcher("WEB-INF/jsppc/addExamFile.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
