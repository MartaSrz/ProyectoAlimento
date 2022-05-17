package proyectoAlimento;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Clase que sirve para calcular si la persona (seas Hombre o Mujer) consume una cantidad correcta de alimentos en gramos.
 * @author marcre
 *
 */

public class CalculoValorIdeal{

	private final static double GRASAINICIALIDEAL=44.0;
	private final static double GRASAFINALIDEAL=76.0;
	private final static double AZUCARINICIALIDEAL=25.0;
	private final static double AZUCARFINALIDEAL=30.0;
	private final static double PROTEINAIDEALHOMBRE=56.0;
	private final static double PROTEINAIDEALMUJER=46.0;
	private final static double HIDRATOSIDEAL=135.0;
	private final static double POTASIOIDEALHOMBRE=3.4;
	private final static double POTASIOIDEALMUJER=2.6;
	private final static double CALCIOIDEALINICIAL=1.0;
	private final static double CALCIOIDEALFINAL=1.3;
	private static final double SALIDEAL=5.0;
	private final static double HIERROIDEALHOMBRE=3.8;
	private final static double HIERROIDEALMUJER=2.3;

	/**
	 * 
	 * @param GRASAINICIALIDEAL: Valor mínimo de grasas que debe ingerir una persona durante el día
	 * @param GRASAFINALIDEAL: Valor máximo de grasas que debe ingerir una persona durante el día
	 * @param AZUCARINICIALIDEAL: Valor mínimo de azúcar que debe ingerir una persona durante el día
	 * @param AZUCARFINALIDEAL: Valor máximo de azúcar que debe ingerir una persona durante el día
	 * @param PROTEINAIDEALHOMBRE: Valor ideal de proteínas que debe ingerir un hombre durante el día
	 * @param PROTEINAIDEALMUJER: Valor ideal de proteínas que debe ingerir una mujer durante el día
	 * @param HIDRATOSIDEAL: Valor ideal de hidratos que debe ingerir una persona durante el día
	 * @param POTASIOIDEALHOMBRE: Valor ideal de potasio que debe ingerir un hombre durante el día
	 * @param POTASIOIDEALMUJER: Valor ideal de potasio que debe ingerir una mujer durante el día
	 * @param CALCIOIDEALINICIAL: Valor mínimo de calcio que debe ingerir una persona durante el día
	 * @param CALCIOIDEALFINAL: Valor máximo de calcio que debe ingerir una persona durante el día
	 * @param SALIDEAL: Valor ideal de sal que debe ingerir una persona durante el día
	 * @param HIERROIDEALHOMBRE: Valor ideal de hierro que debe ingerir un hombre durante el día
	 * @param HIERROIDEALMUJER: Valor ideal de hierro que debe ingerir una mujer durante el día
	 */
	
	public static double getGrasainicialideal() {
		return GRASAINICIALIDEAL;
	}

	public static double getGrasafinalideal() {
		return GRASAFINALIDEAL;
	}

	public static double getAzucarinicialideal() {
		return AZUCARINICIALIDEAL;
	}

	public static double getAzucarfinalideal() {
		return AZUCARFINALIDEAL;
	}

	public static double getProteinaidealhombre() {
		return PROTEINAIDEALHOMBRE;
	}

	public static double getProteinaidealmujer() {
		return PROTEINAIDEALMUJER;
	}

	public static double getHidratosideal() {
		return HIDRATOSIDEAL;
	}

	public static double getPotasioidealhombre() {
		return POTASIOIDEALHOMBRE;
	}

	public static double getPotasioidealmujer() {
		return POTASIOIDEALMUJER;
	}

	public static double getCalcioidealinicial() {
		return CALCIOIDEALINICIAL;
	}
	
	public static double getCalcioidealfinal() {
		return CALCIOIDEALFINAL;
	}

	public static double getSalideal() {
		return SALIDEAL;
	}

	public static double getHierroidealhombre() {
		return HIERROIDEALHOMBRE;
	}

	public static double getHierroidealmujer() {
		return HIERROIDEALMUJER;
	}

	/**
	 * 
	 * @param alimentos: Valores que contenga el alimento en gramos y el nombre del alimento
	 * @param alimentosElegidos: El nombre de los alimentos
	 * @param cantidadesElegidas: Las cantidades de los alimentos
	 * @return
	 */

	public boolean isGrasaIdeal(Alimento []alimentos, ArraysToString<String> alimentosElegidos, ArraysToString<Integer> cantidadesElegidas) {

		double grasas = 0;
		double grasas_totales = 0;
		boolean isIdeal = false;

		int size = alimentosElegidos.size();
		int length = alimentos.length;

		for (int i=0; i<size; i++) {

			for (int j=0; j<length; j++) {

				String nombre_alimento = alimentos[j].getNombre();

				if (alimentos[i].equals(nombre_alimento)) {

					String cantidad=cantidadesElegidas.get(i).toString();
					int cantidad_elegida=Integer.parseInt(cantidad);

					if (cantidad_elegida > 100 || cantidad_elegida < 100) {

						grasas += alimentos[j].getGrasas() * cantidad_elegida / 100;

					}else

						grasas += alimentos[j].getGrasas();

				}

			}

		}

		grasas_totales += grasas;

		if (grasas_totales >= GRASAINICIALIDEAL && grasas_totales <= GRASAFINALIDEAL) { 
			return !isIdeal; // Devuelvo un boolean como true
		}else
			return isIdeal; //Devuelvo un boolean como false



	}

	/**
	 * 
	 * @param alimento: Valores que contenga el alimento en gramos
	 * @return
	 */

	public boolean isAzucarIdeal(Alimento []alimentos, ArraysToString<String> alimentosElegidos, ArraysToString<Integer> cantidadesElegidas) {

		double azucares = 0;
		double azucares_totales = 0;
		boolean isIdeal = false;

		int size = alimentosElegidos.size();
		int length = alimentos.length;

		for (int i=0; i<size; i++) {

			for (int j=0; j<length; j++) {

				String nombre_alimento = alimentos[j].getNombre();

				if (alimentos[i].equals(nombre_alimento)) {

					String cantidad=cantidadesElegidas.get(i).toString();
					int cantidad_elegida=Integer.parseInt(cantidad);

					if (cantidad_elegida > 100 || cantidad_elegida < 100) {

						azucares += alimentos[j].getAzucar() * cantidad_elegida / 100;

					}else

						azucares += alimentos[j].getAzucar();

				}

			}

		}

		azucares_totales += azucares;

		if (azucares_totales >= AZUCARINICIALIDEAL && azucares_totales <= AZUCARFINALIDEAL) {
			return !isIdeal;
		}else
			return isIdeal;

	}

	/**
	 * 
	 * @param alimento: Valores que contenga el alimento en gramos
	 * @param sexo: Género de la persona (Hombre o Mujer)
	 * @return
	 */

	public boolean isProteinaIdeal(Alimento []alimentos, Persona sexo, ArraysToString<String> alimentosElegidos, ArraysToString<Integer> cantidadesElegidas) {

		double proteinas_hombres = 0;
		double proteinas_mujeres = 0;
		double proteinas_totales_hombres = 0;		
		double proteinas_totales_mujeres = 0;
		boolean isIdeal = false;

		int size = alimentosElegidos.size();
		int length = alimentos.length;

		for (int i=0; i<size; i++) {

			for (int j=0; j<length; j++) {

				String nombre_alimento = alimentos[j].getNombre();

				if (alimentos[i].equals(nombre_alimento)) {

					String cantidad=cantidadesElegidas.get(i).toString();
					int cantidad_elegida=Integer.parseInt(cantidad);

					if (cantidad_elegida > 100 || cantidad_elegida < 100) {

						proteinas_hombres += alimentos[j].getProteinas() * cantidad_elegida / 100;
						proteinas_mujeres += alimentos[j].getProteinas() * cantidad_elegida / 100;

					}else

						proteinas_hombres += alimentos[j].getProteinas();
					proteinas_mujeres += alimentos[j].getProteinas();

				}

			}

		}

		proteinas_totales_hombres+= proteinas_hombres;		
		proteinas_totales_mujeres += proteinas_mujeres;


		if (proteinas_totales_hombres == PROTEINAIDEALHOMBRE) {
			return !isIdeal;
		}else if (proteinas_totales_mujeres == PROTEINAIDEALMUJER) {
			return !isIdeal;
		}else 
			return isIdeal;

	}

	/**
	 * 
	 * @param alimento: Valores que contenga el alimento en gramos
	 * @return
	 */

	public boolean isHidratosIdeal(Alimento []alimentos, ArraysToString<String> alimentosElegidos, ArraysToString<Integer> cantidadesElegidas) {

		double hidratos = 0;
		double hidratos_totales = 0;
		boolean isIdeal = false;

		int size = alimentosElegidos.size();
		int length = alimentos.length;

		for (int i=0; i<size; i++) {

			for (int j=0; j<length; j++) {

				String nombre_alimento = alimentos[j].getNombre();

				if (alimentos[i].equals(nombre_alimento)) {

					String cantidad=cantidadesElegidas.get(i).toString();
					int cantidad_elegida=Integer.parseInt(cantidad);

					if (cantidad_elegida > 100 || cantidad_elegida < 100) {

						hidratos += alimentos[j].getHidratos() * cantidad_elegida / 100;

					}else

						hidratos += alimentos[j].getHidratos();

				}

			}

		}

		hidratos_totales += hidratos;

		if (hidratos_totales == HIDRATOSIDEAL) {
			return !isIdeal;
		}else
			return isIdeal;

	}

	/**
	 * 
	 * @param alimento: Valores que contenga el alimento en gramos
	 * @param sexo: Género de la persona (Hombre o Mujer)
	 * @return
	 */

	public boolean isPotasioIdeal(Alimento []alimentos, Persona sexo, ArraysToString<String> alimentosElegidos, ArraysToString<Integer> cantidadesElegidas) {

		double potasio_hombres = 0;
		double potasio_mujeres = 0;
		double potasio_total_hombres = 0;
		double potasio_total_mujeres = 0;
		boolean isIdeal = false;

		int size = alimentosElegidos.size();
		int length = alimentos.length;

		for (int i=0; i<size; i++) {

			for (int j=0; j<length; j++) {

				String nombre_alimento = alimentos[j].getNombre();

				if (alimentos[i].equals(nombre_alimento)) {

					String cantidad=cantidadesElegidas.get(i).toString();
					int cantidad_elegida=Integer.parseInt(cantidad);

					if (cantidad_elegida > 100 || cantidad_elegida < 100) {

						potasio_hombres += alimentos[j].getPotasio() * cantidad_elegida / 100;
						potasio_mujeres += alimentos[j].getPotasio() * cantidad_elegida / 100;

					}else

						potasio_hombres += alimentos[j].getPotasio();
					potasio_mujeres += alimentos[j].getPotasio();

				}

			}

		}

		potasio_total_hombres+= potasio_hombres;		
		potasio_total_mujeres += potasio_mujeres;


		if (potasio_total_hombres == POTASIOIDEALHOMBRE) {
			return !isIdeal;
		}else if (potasio_total_mujeres == POTASIOIDEALMUJER) {
			return !isIdeal;
		}else 
			return isIdeal;
	}

	/**
	 * 
	 * @param alimento: Valores que contenga el alimento en gramos
	 * @return
	 */

	public boolean isCalcioIdeal(Alimento []alimentos, ArraysToString<String> alimentosElegidos, ArraysToString<Integer> cantidadesElegidas) {

		double calcio = 0;
		double calcio_total = 0;
		boolean isIdeal = false;

		int size = alimentosElegidos.size();
		int length = alimentos.length;

		for (int i=0; i<size; i++) {

			for (int j=0; j<length; j++) {

				String nombre_alimento = alimentos[j].getNombre();

				if (alimentos[i].equals(nombre_alimento)) {

					String cantidad=cantidadesElegidas.get(i).toString();
					int cantidad_elegida=Integer.parseInt(cantidad);

					if (cantidad_elegida > 100 || cantidad_elegida < 100) {

						calcio += alimentos[j].getCalcio() * cantidad_elegida / 100;

					}else

						calcio += alimentos[j].getCalcio();

				}

			}

		}

		calcio_total += calcio;

		if (calcio_total >= CALCIOIDEALINICIAL && calcio_total <= CALCIOIDEALFINAL) {
			return !isIdeal;
		}else
			return isIdeal;

	}

	/**
	 * 
	 * @param alimento: Valores que contenga el alimento en gramos
	 * @return
	 */

	public boolean isSalIdeal(Alimento []alimentos, ArraysToString<String> alimentosElegidos, ArraysToString<Integer> cantidadesElegidas) {

		double sal = 0;
		double sal_total = 0;
		boolean isIdeal = false;

		int size = alimentosElegidos.size();
		int length = alimentos.length;

		for (int i=0; i<size; i++) {

			for (int j=0; j<length; j++) {

				String nombre_alimento = alimentos[j].getNombre();

				if (alimentos[i].equals(nombre_alimento)) {

					String cantidad=cantidadesElegidas.get(i).toString();
					int cantidad_elegida=Integer.parseInt(cantidad);

					if (cantidad_elegida > 100 || cantidad_elegida < 100) {

						sal += alimentos[j].getSal() * cantidad_elegida / 100;

					}else

						sal += alimentos[j].getSal();

				}

			}

		}

		sal_total += sal;


		if (sal_total == SALIDEAL) {
			return !isIdeal;
		}else
			return isIdeal;

	}

	/**
	 * 
	 * @param alimento: Valores que contenga el alimento en gramos
	 * @param sexo: Género de la persona (Hombre o Mujer)
	 * @return
	 */

	public boolean isHierroIdeal(Alimento []alimentos, Persona sexo, ArraysToString<String> alimentosElegidos, ArraysToString<Integer> cantidadesElegidas) {

		double hierro_hombres = 0;
		double hierro_mujeres = 0;		
		double hierro_total_hombres = 0;
		double hierro_total_mujeres = 0;
		boolean isIdeal = false;

		int size = alimentosElegidos.size();
		int length = alimentos.length;

		for (int i=0; i<size; i++) {

			for (int j=0; j<length; j++) {

				String nombre_alimento = alimentos[j].getNombre();

				if (alimentos[i].equals(nombre_alimento)) {

					String cantidad=cantidadesElegidas.get(i).toString();
					int cantidad_elegida=Integer.parseInt(cantidad);

					if (cantidad_elegida > 100 || cantidad_elegida < 100) {

						hierro_hombres += alimentos[j].getHierro() * cantidad_elegida / 100;
						hierro_mujeres += alimentos[j].getHierro() * cantidad_elegida / 100;

					}else

						hierro_hombres += alimentos[j].getHierro();
					hierro_mujeres += alimentos[j].getHierro();

				}

			}

		}

		hierro_total_hombres+= hierro_hombres;		
		hierro_total_mujeres += hierro_mujeres;

		if (hierro_total_hombres == HIERROIDEALHOMBRE) {
			return !isIdeal;
		}else if (hierro_total_mujeres == HIERROIDEALMUJER) {
			return !isIdeal;
		}else 
			return isIdeal;

	}
}