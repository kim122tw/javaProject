
package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.porder.implPorder;
import Model.porder;


public class updatePorderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public updatePorderController() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("BIG5");
    	
    	int ID = Integer.parseInt(request.getParameter("id"));
    	porder m = new implPorder().queryPorder(ID);
    	m.setDesk(request.getParameter("desk"));
    	m.setA(Integer.parseInt(request.getParameter("A")));
    	m.setB(Integer.parseInt(request.getParameter("B")));
    	m.setC(Integer.parseInt(request.getParameter("C")));
    	
    	new implPorder().update(m);
    	response.sendRedirect("porder/update.jsp");
	}

}
