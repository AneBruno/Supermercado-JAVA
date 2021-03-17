package servlets;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Persona;
import logic.PersonaController;

@WebServlet("/AddClientes")

public class AddClientes extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    public AddClientes() {
    	
        super();
        
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Persona per= new Persona();
		Persona cli= new Persona();
		PersonaController ctrl= new PersonaController();
		
		String nombre= request.getParameter("name");	
		String apellido= request.getParameter("surname");			
		String tDoc= request.getParameter("tipoDoc");	
		String nDoc= request.getParameter("nroDoc");	
		String telefono= request.getParameter("tel");		
		String direccion= request.getParameter("direc");				
		String email= request.getParameter("email");
		String pass= request.getParameter("pass");
	
		per.setTipoDoc(tDoc);
		per.setNroDoc(nDoc);
		per.setNombre(nombre);
		per.setApellido(apellido);
		per.setTelefono(telefono);
		per.setDireccion(direccion);
		per.setEmail(email);
		per.setPassword(pass);
		per.setCuil("");
		per.setFechaIngreso(null);
		java.sql.Date timeNow = new Date(Calendar.getInstance().getTimeInMillis());
		per.setFechaRegistro(timeNow);

		cli=ctrl.addPersona(per);

		request.setAttribute("nuevoCliente", cli);
		request.getRequestDispatcher("listarClientes.jsp").forward(request, response);
			
		}
	
			//cartel de q esta mal
		
	}


