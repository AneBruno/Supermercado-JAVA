package servlets;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entidades.Categoria;
import entidades.Persona;
import entidades.Producto;
import logic.CategoriaController;
import logic.ProductoController;

@WebServlet("/ListProductosMenosMas")

public class ListProductosMenosMas extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    public ListProductosMenosMas() {
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

		productos=ctrl.listarMenosMas();	
				
       //Veo a donde lo direcciono:
  		Persona per= new Persona();
  		per= (Persona)request.getSession(true).getAttribute("usuario");
		if(per==null){
			request.getRequestDispatcher("error-sesion.jsp").forward(request, response);
		}else
  		// si es cliente solo me traigo las categorias y los productos activos
  		if(per.isCliente()==true) {
  			categorias= ctrlCat.listCategoriasActivas();
			categorias=ctrlCat.listCategoriasNoVacias(categorias);
  			request.setAttribute("categorias", categorias);
  			
  			LinkedList<Producto> prods_activos= new LinkedList<Producto>();
  			for (Producto p: productos) {
  				if (p.getFecha_hora_baja()==null) {
  					prods_activos.add(p);
  				}
  			}
  			 request.setAttribute("productos", prods_activos);
  			 request.getRequestDispatcher("productos.jsp").forward(request, response);
  			 
  			 //si es empleado traigo activos y no activos
  			
  		}else {
  			categorias=ctrlCat.listAllCategorias();
  			request.setAttribute("categorias", categorias);
  			request.setAttribute("productos", productos);
  			request.getRequestDispatcher("listarProductos.jsp").forward(request, response);
  		}
        
	}

}
