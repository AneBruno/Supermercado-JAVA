package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Descuento;
import logic.DescuentoController;

@WebServlet("/BuscarDescuento")

public class BuscarDescuento extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public BuscarDescuento() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DescuentoController ctrl= new DescuentoController();
		Descuento dcto= new Descuento();
		int id= Integer.parseInt(request.getParameter("id"));
		dcto.setIdDcto(id);
		dcto =ctrl.getById(dcto);
		request.setAttribute("descuentoEditar", dcto);
		request.getRequestDispatcher("editarDescuento.jsp").forward(request, response);
	}

}
