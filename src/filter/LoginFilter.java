package filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import dao.GradeDBManager;
import dao.GradeDBuitl;

/**
 * Servlet Filter implementation class LoginFilters
 *登录验证
 */
@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		String jNstring=request.getParameter("jobnumber");
		if(jNstring!=null) {
			
			
		
		Connection connect=GradeDBuitl.getConnect();
		GradeDBManager gradeDBManager=new GradeDBManager(connect);
		boolean isExist=gradeDBManager.selectUserExist(jNstring);
		
		if(isExist) {
			//用户存在允许 增删改
			request.getRequestDispatcher("/LoginFilter/Gradedbsert").forward(request,response);
			System.out.println("Exist");
		}
		else {
			PrintWriter out = response.getWriter();
			out.print("notExist");
		}
		
		}
		else {
			System.out.println("jobnumber ==null");
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
