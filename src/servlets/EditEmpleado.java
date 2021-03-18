package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Persona;
import logic.PersonaController;

@WebServlet("/EditEmpleado")

public class EditEmpleado extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public EditEmpleado() {
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
		String cuil=request.getParameter("cuil");
				
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
		per.setCuil(cuil);
		per=ctrl.editPersona(per);
				
		request.setAttribute("empleadoEditado", per);
		request.setAttribute("empleado", ctrl.listarEmpleados());
		request.getRequestDispatcher("ListEmpleados").forward(request, response);
	}

}
