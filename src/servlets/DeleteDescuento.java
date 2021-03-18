package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.*;
import logic.*;

@WebServlet("/DeleteDescuento")

public class DeleteDescuento extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public DeleteDescuento() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DescuentoController ctrl= new DescuentoController();
		Descuento d= new Descuento();
		int id = Integer.parseInt(request.getParameter("id"));
		d.setIdDcto(id);
		d =ctrl.getById(d);
		ctrl.deleteDescuento(d);		
		request.setAttribute("descuentos", ctrl.listarDescuentos());
		request.getRequestDispatcher("ListDescuentos").forward(request, response);
	
	}

}
