package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Proveedor;
import logic.ProveedorController;

@WebServlet("/BuscarProveedor")

public class BuscarProveedor extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    public BuscarProveedor() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ProveedorController ctrl= new ProveedorController();
		Proveedor prov= new Proveedor();
		int id= Integer.parseInt(request.getParameter("id"));
		prov.setIdProveedor(id);
		prov =ctrl.getById(prov);
		request.setAttribute("proveedorEditar", prov);
		request.getRequestDispatcher("editarProveedor.jsp").forward(request, response);
	}

}
