package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Descuento;
import entidades.Persona;
import logic.DescuentoController;

/**
 * Servlet implementation class ListDescuentos
 */
@WebServlet("/ListDescuentos")
public class ListDescuentos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListDescuentos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		DescuentoController ctrl= new DescuentoController();
		LinkedList<Descuento> descuentos= new LinkedList<Descuento>();
	
		//Veo a donde lo direcciono:
				Persona per= new Persona();
				per= (Persona)request.getSession(true).getAttribute("usuario");
				if(per.isCliente()==true) {
					descuentos=ctrl.listarDescuentosAct();
					request.setAttribute("descuentos", descuentos);
					 request.getRequestDispatcher("descuentos.jsp").forward(request, response);
				}else {
					descuentos=ctrl.listarDescuentos();
					request.setAttribute("descuentos", descuentos);
					 request.getRequestDispatcher("listarDescuentos.jsp").forward(request, response);
				}
		

	}

}
