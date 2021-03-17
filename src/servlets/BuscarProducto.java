package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Producto;
import logic.ProductoController;

@WebServlet("/BuscarProducto")

public class BuscarProducto extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    public BuscarProducto() {
    	
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductoController ctrl= new ProductoController();
		Producto prod= new Producto();
		int id= Integer.parseInt(request.getParameter("id"));
		prod.setIdProducto(id);
		prod =ctrl.getById(prod);
			
		request.setAttribute("productoEditar", prod);
		request.getRequestDispatcher("editarProducto.jsp").forward(request, response);
	}
}

