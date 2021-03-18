package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Categoria;
import logic.CategoriaController;

@WebServlet("/EditCategoria")

public class EditCategoria extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    public EditCategoria() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Categoria cat= new Categoria();		
		CategoriaController ctrl= new CategoriaController();		
		String descrip= request.getParameter("descrip");
		int id = Integer.parseInt(request.getParameter("id"));
		
		cat.setIdCategoria(id);
		cat.setDescCategoria(descrip);
		cat=ctrl.editCategoria(cat);
		request.setAttribute("categoriaEditada", cat);
		request.setAttribute("categorias", ctrl.listarCategorias());
		request.getRequestDispatcher("ListCategorias").forward(request, response);
	}

}
