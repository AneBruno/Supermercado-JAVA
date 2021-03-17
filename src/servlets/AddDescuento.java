package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.sql.Date;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Descuento;
import logic.DescuentoController;

@SuppressWarnings("unused")
@WebServlet("/AddDescuento")

public class AddDescuento extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
 
    public AddDescuento() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< HEAD

		response.getWriter().append("Served at: ").append(request.getContextPath());
=======
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
>>>>>>> refs/remotes/origin/master
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Descuento d = new Descuento();
		Descuento descuento= new Descuento();
		DescuentoController ctrl = new DescuentoController();
		
		try {
		
		String porc= request.getParameter("porc");
		Double porcen= Double.parseDouble(porc);
		
		String desde = request.getParameter("desde");
	    Date fecha_desde=Date.valueOf(desde);
	    
		String hasta = request.getParameter("hasta");
	    Date fecha_hasta=Date.valueOf(hasta);
		
		d.setPorcDcto(porcen);
		d.setFechaDctoInicio(fecha_desde);
		d.setFechaDctoFin(fecha_hasta);
		descuento= ctrl.add(d);
		
		request.setAttribute("nuevoDesc", descuento);
		request.getRequestDispatcher("ListDescuentos").forward(request, response);
		
		}
		
		catch (IllegalArgumentException iae)	
		{
			request.setAttribute("message_iae", "Ingrese correctamente el formato de la fecha (A�O-MES-DIA), Respetar separacion con guiones");
			request.getRequestDispatcher("crearDcto.jsp").forward(request, response);
		}
	}

}
