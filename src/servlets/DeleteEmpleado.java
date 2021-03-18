package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Persona;
import logic.PersonaController;

@WebServlet("/DeleteEmpleado")

public class DeleteEmpleado extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    public DeleteEmpleado() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PersonaController ctrl= new PersonaController();
		Persona per= new Persona();	
		int id = Integer.parseInt(request.getParameter("id"));

		per.setIdPersona(id);
		per =ctrl.getById(per);
		per=ctrl.deletePersona(per);
		request.setAttribute("empleados", ctrl.listarEmpleados());
		request.getRequestDispatcher("ListEmpleados").forward(request, response);
	
	}

}
