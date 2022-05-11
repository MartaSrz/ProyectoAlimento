/**
 * 
 * Esta clase sirve para poner un to string distinto a lo que suele salir en ArrayList.
 * @author marta
 *
 */
package proyectoAlimento;

import java.util.ArrayList;
import java.util.Arrays;

public class ArraysToString <T> extends ArrayList{

	@Override
	public String toString() {
		String cadena="";
		int size=size();
		for (int i=0; i<size; i++) {
			if (get(i) instanceof String) {
				cadena+=get(i)+"\n";
			}else
				cadena+=get(i)+" g\n";
		}
		return cadena;
	}
	

}
