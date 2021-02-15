package servlets;

import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Descuento;
import logic.DescuentoController;

/**
 * Servlet implementation class EditDescuento
 */
@WebServlet("/EditDescuento")
public class EditDescuento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditDescuento() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);  que es esto ??
		
		DescuentoController ctrl= new DescuentoController();
		Descuento dcto= new Descuento();
	
		Double porcentaje= Double.parseDouble(request.getParameter("porc"));
		
		//SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");
			
		int id = Integer.parseInt(request.getParameter("id"));
		//Date fechaI= Date.parse(request.getParameter("fechaIni"));
		String fechaSting=(request.getParameter("fechaIni"));
		Date fechaI=parseDate(fechaSting);
		
		fechaSting=(request.getParameter("fechaFin"));
		Date fechaF=parseDate(fechaSting);
		
		dcto.setIdDcto(id);
		dcto.setPorcDcto(porcentaje);
		dcto.setFechaDctoInicio(fechaI);
		dcto.setFechaDctoFin(fechaF);
		
		
		dcto=ctrl.editDescuento(dcto);
		
		
		request.setAttribute("descuento-editado", dcto);
		request.setAttribute("listado", ctrl.listarDescuentos());
		request.getRequestDispatcher("listarDescuentos.jsp").forward(request, response);
	
		
	}

	
	public static Date parseDate(String fechaString){
		
		 SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	     Date fecha = null;
	     
	     try { fecha = formato.parse(fechaString);  } 
	     catch (ParseException ex) { System.out.println(ex);   }
	    
	     return fecha;
	    }	
		
	
	
}
