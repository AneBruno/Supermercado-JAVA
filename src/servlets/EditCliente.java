package servlets;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Persona;
import logic.PersonaController;

@WebServlet("/EditCliente")

public class EditCliente extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public EditCliente() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Persona per= new Persona();	
		PersonaController ctrl= new PersonaController();		
		String nombre= request.getParameter("name");		
		String apellido= request.getParameter("surname");				
		String tDoc= request.getParameter("tipoDoc");		
		String nDoc= request.getParameter("nroDoc");	
		String telefono= request.getParameter("tel");	
		String direccion= request.getParameter("direc");	
		String email= request.getParameter("email");
		String pass= request.getParameter("pass");		
		int id = Integer.parseInt(request.getParameter("id"));

		per.setIdPersona(id);
		per.setTipoDoc(tDoc);
		per.setNroDoc(nDoc);
		per.setNombre(nombre);
		per.setApellido(apellido);
		per.setTelefono(telefono);
		per.setDireccion(direccion);
		per.setEmail(email);
		per.setPassword(pass);
		per=ctrl.editPersona(per);
		
		request.setAttribute("cliente-editado", per);
		request.setAttribute("listado", ctrl.listarClientes());
		request.getRequestDispatcher("listarClientes.jsp").forward(request, response);
			
	}
	

}
