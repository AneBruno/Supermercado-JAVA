package logic;

import java.util.LinkedList;
import Data.*;
import entidades.*;


public class ProductoController {

private DataProducto dp;

	
	public ProductoController() {
		dp=new DataProducto();
	}

	
	public LinkedList<Producto> listarProductos() {
		return dp.getAll();
	}

	public Producto editProducto (Producto p) {
		return dp.editProducto(p);
	}
	public Producto deleteProducto (Producto p) {
		return dp.deleteProducto(p);
	}
	
	public Producto getById(Producto p) {
		Producto prod=new Producto();
		prod=dp.getById(p);
		return prod;
	}
	
	public void addProducto(Producto p) {
		 dp.add(p);
	}
	
	public LinkedList<Producto> listarByCategoria (Categoria cat){
		return dp.getByCategoria(cat);
	}
	
}


