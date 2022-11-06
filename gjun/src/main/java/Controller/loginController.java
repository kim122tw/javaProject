package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.member.implMember;
import Model.member;


public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public loginController() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	/*
		 * 1.接收->request->username,password
		 * 2.判斷-->queryMember
		 * !=null-->true-->LoginSuccess
		 * false-->LoginError
		 */
    	String username = request.getParameter("username");
    	String password = request.getParameter("password");
    	HttpSession session = request.getSession();
    	
    	member m = new implMember().queryMember(username, password);
    	
    	if (m != null) {
    		session.setAttribute("M", m);
    		response.sendRedirect("member/loginSuccess.jsp");
    	} else {
    		response.sendRedirect("member/loginError.jsp");
    	}
	}

}
