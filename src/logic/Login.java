package logic;

import java.util.LinkedList;

import Data.*;
import entidades.*;

@SuppressWarnings("unused")
public class Login {
		
		private DataPersona dp;
		private DataProducto dprod;
		private DataCategoria dc;
		
		public Login() {
			dp=new DataPersona();
		}
	
		public Persona validate(Persona p) {
			/* para hacer m�s seguro el manejo de passwords este ser�a un lugar 
			 * adecuado para generar un hash de la password utilizando un cifrado
			 * asim�trico como sha256 y utilizar el hash en lugar de la password en plano 
			 */
			return dp.getByUser(p);
		}

		/*public LinkedList<Producto> getByDescCat(String cat){
			
			Categoria categ= dc.getById(cat);
			return dprod.getByDescCat(categ);
		}*/
}