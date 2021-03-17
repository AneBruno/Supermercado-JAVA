package logic;

import java.util.LinkedList;


import Data.*;
import entidades.*;

public class DescuentoController {

	
	private DataDescuento dd;

	
	public DescuentoController() {
		dd=new DataDescuento();
	}

	public LinkedList<Descuento> listarDescuentos() {
		return dd.getAll();
	}

	public Descuento editDescuento (Descuento d) {
		return dd.editDescuento(d);
	}
	public void deleteDescuento (Descuento d) {
		 dd.deleteDescuento(d);
	}
	
	public Descuento getById(Descuento d) {
		Descuento des=new Descuento();
		des=dd.getById(d);
		return des;
	}
	
	public Descuento add(Descuento d) {
		return dd.add(d);
	}
	
	public int contarDctos(){
		LinkedList<Descuento> descuentos = new LinkedList<Descuento>();
		descuentos= dd.getAllActivos();
		int cant= descuentos.size();
		return cant;
	}
	
	 
}
