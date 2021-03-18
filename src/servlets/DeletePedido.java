package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.*;
import logic.*;

@WebServlet("/DeletePedido")

public class DeletePedido extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public DeletePedido() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PedidoController ctrl= new PedidoController();
		Pedido p= new Pedido();
		int id = Integer.parseInt(request.getParameter("id"));
		p.setIdPedido(id);
		p =ctrl.getById(p);
		ctrl.deletePedido(p);
		
		request.setAttribute("descuentos", ctrl.listarPedidos());
		request.getRequestDispatcher("ListDescuentos").forward(request, response);
	
	}

}
