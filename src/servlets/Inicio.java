package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Data.*;
import entidades.*;
import logic.*;

@SuppressWarnings("unused")
@WebServlet("/Inicio")

public class Inicio extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Boolean email_format, pass_format;
		Persona per = new Persona();
		Login ctrl = new Login();
		
			
		String email= request.getParameter("email");
		String pass= request.getParameter("pass");
		
		//VALIDAR FORMATO EMAIL Y PASSWORD
		email_format= emailIsValid(email);
		pass_format= passIsValid(pass);
		
		if(email_format==true && pass_format==true) {
			per.setEmail(email);
			per.setPassword(pass);
			
		//\VALIDAR QUE EXISTA EN LA BDD
			per= ctrl.validate(per);
			
			if (per!=null) {
				
				//VEO SI ES CLIENTE O EMPLEADO
				
				if(per.isCliente()) {
					
					request.getSession().setAttribute("usuario", per);
					request.getRequestDispatcher("mainpage.jsp").forward(request, response);
					
				}
				else if(per.isEmpleado()) {
					request.getSession().setAttribute("usuario", per);
					request.getRequestDispatcher("mainpage-admin.jsp").forward(request, response);
					
					
				}
				
				
			}
			else {
				request.setAttribute("message_def", "Usuario y/o incorrectos, intente nuevamente");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
		
		else {
			request.setAttribute("message_sec", "Los datos ingresados son invalidos, la contrase�a debe tener al menos 8 caracteres y no m�s de 15");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	
	}

	
		private static boolean emailIsValid(String email) {
	      String email_string = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	      return email.matches(email_string);
	   }
	
		private static boolean passIsValid(String pass) {
		      String pass_string = "^([a-zA-Z0-9@*#]{6,15})$"; //Match all alphanumeric character and predefined wild characters. Password must consists of at least 8 characters and not more than 15 characters.
		      return pass.matches(pass_string);
		   }	
}
