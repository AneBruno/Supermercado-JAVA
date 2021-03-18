package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CerrarSesion")

public class CerrarSesion extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public CerrarSesion() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 HttpSession sesion = request.getSession();
		 sesion.invalidate();
		if ( sesion== null || sesion.getAttribute("email") == null) { 
			//response.sendRedirect("index.jsp"); // No logged-in user found, so redirect to login page. 
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		} else { response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1. response.setHeader("Pragma", "no-cache"); // HTTP 1.0. response.setDateHeader("Expires", 0); chain.doFilter(req, res); } 
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
	}

}
