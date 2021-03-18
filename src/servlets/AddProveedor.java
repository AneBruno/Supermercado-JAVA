package servlets;

import java.io.IOException;
//import java.sql.Date;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Proveedor;
import logic.ProveedorController;

@WebServlet("/AddProveedor")

public class AddProveedor extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    public AddProveedor() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Proveedor prov = new Proveedor();
		ProveedorController ctrl = new ProveedorController();
		
		// idProveedor, telefono, email, razonSocial, fechaBaja
		
		String tel= request.getParameter("tel");
		String email= request.getParameter("email");
		String razonSocial= request.getParameter("razonS");
		
		String baja = request.getParameter("baja");
	    Date fecha_baja=Date.valueOf(baja);
	    prov.setFechaBaja(fecha_baja);
	    
	    prov.setTelefono(tel);
	    prov.setMail(email);
	    prov.setRazonSocial(razonSocial);
	    
	    prov= ctrl.add(prov);

		request.setAttribute("nuevoProv", prov);
		request.setAttribute("proveedores", ctrl.listarProveedores());
		request.getRequestDispatcher("ListProveedores").forward(request, response);
	}

}
