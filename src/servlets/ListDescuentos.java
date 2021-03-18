package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Descuento;
import logic.DescuentoController;

@WebServlet("/ListDescuentos")

public class ListDescuentos extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    public ListDescuentos() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DescuentoController ctrl= new DescuentoController();
		LinkedList<Descuento> descuentos= new LinkedList<Descuento>();
		descuentos=ctrl.listarDescuentos();
		request.setAttribute("descuentos", descuentos);
        request.getRequestDispatcher("listarDescuentos.jsp").forward(request, response);
	}
}
