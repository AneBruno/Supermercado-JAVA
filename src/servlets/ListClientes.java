package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Data.*;
import entidades.*;
import logic.PersonaController;

@SuppressWarnings("unused")
@WebServlet("/ListClientes")

public class ListClientes extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    public ListClientes() {
        super();
       
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PersonaController ctrl= new PersonaController();
		//LinkedList<Persona> personas= new LinkedList<Persona>();
		LinkedList<Persona> clientes= new LinkedList<Persona>();
		clientes=ctrl.listarClientes();
		//request.getAttribute("usuario");
		request.setAttribute("listado", clientes);
        request.getRequestDispatcher("listarClientes.jsp").forward(request, response);
  
	}

}
