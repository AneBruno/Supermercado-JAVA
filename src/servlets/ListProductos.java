package servlets;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entidades.*;
import logic.*;

@WebServlet("/ListProductos")

public class ListProductos extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public ListProductos() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ProductoController ctrl= new ProductoController();
		CategoriaController ctrlCat= new CategoriaController();
		
		LinkedList<Producto> productos= new LinkedList<Producto>();
		LinkedList<Categoria> categorias= new LinkedList<Categoria>();
		
		request.setAttribute("descrip", null);
		
		//Veo a donde lo direcciono:
		Persona per= new Persona();
		per= (Persona)request.getSession(true).getAttribute("usuario");
		if(per.isCliente()==true) {
			productos= ctrl.listAllProductos();
			categorias= ctrlCat.listCategoriasActivas();
			LinkedList<Producto> prods_activos= new LinkedList<Producto>();
			for (Producto prod: productos) {
				if (prod.getFecha_hora_baja()==null) {
					prods_activos.add(prod);
				}
			}	

			request.setAttribute("categorias", categorias);
			request.setAttribute("productos", prods_activos);
			request.getRequestDispatcher("productos.jsp").forward(request, response);
			
			 //request.setAttribute("pedido", null);
		}else {
			 productos=ctrl.listAllProductos();
			 categorias= ctrlCat.listAllCategorias();
			 request.setAttribute("productos", productos);
			 request.setAttribute("categorias", categorias);
			 request.getRequestDispatcher("listarProductos.jsp").forward(request, response);
		}
	}
}
