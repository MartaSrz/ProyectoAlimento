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

	private static Alimento alimentos[];
	private static ArraysToString<String> alimentosElegidos= new ArraysToString<>();
	private static ArraysToString<Integer> cantidadesElegidas= new ArraysToString<>();

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

	public static double totalGrasaIdeal(Alimento []alimentos, ArraysToString<String> alimentosElegidos, ArraysToString<Integer> cantidadesElegidas) {

		double grasas = 0;
		double grasasTotales = 0;

		int size = alimentosElegidos.size();
		int length = alimentos.length;

		for (int i=0; i<size; i++) {

			for (int j=0; j<length; j++) {

				if (alimentosElegidos.get(i).equals(alimentos[j].getNombre())) {

					String cantidad=cantidadesElegidas.get(i).toString();
					int cantidadElegida=Integer.parseInt(cantidad);

					if (cantidadElegida > 100 || cantidadElegida < 100) {

						grasas += alimentos[j].getGrasas() * cantidadElegida / 100;

					}else

						grasas += alimentos[j].getGrasas();

				}

			}

		}
		
		grasasTotales += grasas;

		return grasasTotales;


	}

	/**
	 * 
	 * @param alimento: Valores que contenga el alimento en gramos
	 * @return
	 */

	public static double totalAzucarIdeal(Alimento []alimentos, ArraysToString<String> alimentosElegidos, ArraysToString<Integer> cantidadesElegidas) {

		double azucares = 0;
		double azucaresTotales = 0;

		int size = alimentosElegidos.size();
		int length = alimentos.length;

		for (int i=0; i<size; i++) {

			for (int j=0; j<length; j++) {

				if (alimentosElegidos.get(i).equals(alimentos[j].getNombre())) {

					String cantidad=cantidadesElegidas.get(i).toString();
					int cantidadElegida=Integer.parseInt(cantidad);

					if (cantidadElegida > 100 || cantidadElegida < 100) {

						azucares += alimentos[j].getAzucar() * cantidadElegida / 100;

					}else

						azucares += alimentos[j].getAzucar();

				}

			}

		}

		azucaresTotales += azucares;

		return azucaresTotales;
	}

	/**
	 * 
	 * @param alimento: Valores que contenga el alimento en gramos
	 * @param sexo: Género de la persona (Hombre o Mujer)
	 * @return
	 */

	public static double totalProteinaIdeal(Alimento []alimentos, Persona persona, ArraysToString<String> alimentosElegidos, ArraysToString<Integer> cantidadesElegidas) {

		double proteinasHombres= 0;
		double proteinasMujeres = 0;
		double proteinasTotalesHombres = 0;		
		double proteinasTotalesMujeres = 0;

		int size = alimentosElegidos.size();
		int length = alimentos.length;

		for (int i=0; i<size; i++) {

			for (int j=0; j<length; j++) {

				if (alimentosElegidos.get(i).equals(alimentos[j].getNombre())) {

					String cantidad=cantidadesElegidas.get(i).toString();
					int cantidadElegida=Integer.parseInt(cantidad);

					if (cantidadElegida > 100 || cantidadElegida < 100) {

						proteinasHombres += alimentos[j].getProteinas() * cantidadElegida / 100;
						proteinasMujeres += alimentos[j].getProteinas() * cantidadElegida / 100;

					}else

						proteinasHombres += alimentos[j].getProteinas();
					proteinasMujeres += alimentos[j].getProteinas();

				}

			}

		}

		proteinasTotalesHombres+= proteinasHombres;		
		proteinasTotalesMujeres += proteinasMujeres;

		if (persona.getSexo().equalsIgnoreCase("mujer")) {
			return proteinasTotalesMujeres;
		}else{
			return proteinasTotalesHombres;
		}

	}

	/**
	 * 
	 * @param alimento: Valores que contenga el alimento en gramos
	 * @return
	 */

	public static double totalHidratosIdeal(Alimento []alimentos, ArraysToString<String> alimentosElegidos, ArraysToString<Integer> cantidadesElegidas) {

		double hidratos = 0;
		double hidratosTotales = 0;

		int size = alimentosElegidos.size();
		int length = alimentos.length;

		for (int i=0; i<size; i++) {

			for (int j=0; j<length; j++) {

				if (alimentosElegidos.get(i).equals(alimentos[j].getNombre())) {

					String cantidad=cantidadesElegidas.get(i).toString();
					int cantidadElegida=Integer.parseInt(cantidad);

					if (cantidadElegida > 100 || cantidadElegida < 100) {

						hidratos += alimentos[j].getHidratos() * cantidadElegida / 100;

					}else

						hidratos += alimentos[j].getHidratos();

				}

			}

		}

		hidratosTotales += hidratos;

		return hidratosTotales;
	}

	/**
	 * 
	 * @param alimento: Valores que contenga el alimento en gramos
	 * @param sexo: Género de la persona (Hombre o Mujer)
	 * @return
	 */

	public static double totalPotasioIdeal(Alimento []alimentos, Persona persona, ArraysToString<String> alimentosElegidos, ArraysToString<Integer> cantidadesElegidas) {

		double potasioHombres = 0;
		double potasioMujeres = 0;
		double potasioTotalHombres = 0;
		double potasioTotalMujeres = 0;

		int size = alimentosElegidos.size();
		int length = alimentos.length;

		for (int i=0; i<size; i++) {

			for (int j=0; j<length; j++) {

				if (alimentosElegidos.get(i).equals(alimentos[j].getNombre())) {

					String cantidad=cantidadesElegidas.get(i).toString();
					int cantidadElegida=Integer.parseInt(cantidad);

					if (cantidadElegida > 100 || cantidadElegida < 100) {

						potasioHombres += alimentos[j].getPotasio() * cantidadElegida / 100;
						potasioMujeres += alimentos[j].getPotasio() * cantidadElegida / 100;

					}else

						potasioHombres += alimentos[j].getPotasio();
					potasioMujeres += alimentos[j].getPotasio();

				}

			}

		}

		potasioTotalHombres+= potasioHombres;		
		potasioTotalMujeres += potasioMujeres;

		if (persona.getSexo().equalsIgnoreCase("mujer")) {
			return potasioTotalMujeres;
		}else{
			return potasioTotalHombres;
		}

	}

	/**
	 * 
	 * @param alimento: Valores que contenga el alimento en gramos
	 * @return
	 */

	public static double totalCalcioIdeal(Alimento []alimentos, ArraysToString<String> alimentosElegidos, ArraysToString<Integer> cantidadesElegidas) {

		double calcio = 0;
		double calcioTotal = 0;

		int size = alimentosElegidos.size();
		int length = alimentos.length;

		for (int i=0; i<size; i++) {

			for (int j=0; j<length; j++) {

				if (alimentosElegidos.get(i).equals(alimentos[j].getNombre())) {

					String cantidad=cantidadesElegidas.get(i).toString();
					int cantidadElegida=Integer.parseInt(cantidad);

					if (cantidadElegida > 100 || cantidadElegida < 100) {

						calcio += alimentos[j].getCalcio() * cantidadElegida / 100;

					}else

						calcio += alimentos[j].getCalcio();

				}

			}

		}

		calcioTotal += calcio;

		return calcioTotal;

	}

	/**
	 * 
	 * @param alimento: Valores que contenga el alimento en gramos
	 * @return
	 */

	public static double totalSalIdeal(Alimento []alimentos, ArraysToString<String> alimentosElegidos, ArraysToString<Integer> cantidadesElegidas) {

		double sal = 0;
		double salTotal = 0;

		int size = alimentosElegidos.size();
		int length = alimentos.length;

		for (int i=0; i<size; i++) {

			for (int j=0; j<length; j++) {

				if (alimentosElegidos.get(i).equals(alimentos[j].getNombre())) {

					String cantidad=cantidadesElegidas.get(i).toString();
					int cantidadElegida=Integer.parseInt(cantidad);

					if (cantidadElegida > 100 || cantidadElegida < 100) {

						sal += alimentos[j].getSal() * cantidadElegida / 100;

					}else

						sal += alimentos[j].getSal();

				}

			}

		}

		salTotal += sal;

		return salTotal;

	}

	/**
	 * 
	 * @param alimento: Valores que contenga el alimento en gramos
	 * @param sexo: Género de la persona (Hombre o Mujer)
	 * @return
	 */

	public static double totalHierroIdeal(Alimento []alimentos, Persona persona, ArraysToString<String> alimentosElegidos, ArraysToString<Integer> cantidadesElegidas) {

		double hierroHombres = 0;
		double hierroMujeres = 0;		
		double hierroTotalHombres = 0;
		double hierroTotalMujeres = 0;

		int size = alimentosElegidos.size();
		int length = alimentos.length;

		for (int i=0; i<size; i++) {

			for (int j=0; j<length; j++) {

				if (alimentosElegidos.get(i).equals(alimentos[j].getNombre())) {

					String cantidad=cantidadesElegidas.get(i).toString();
					int cantidadElegida=Integer.parseInt(cantidad);

					if (cantidadElegida > 100 || cantidadElegida < 100) {

						hierroHombres += alimentos[j].getHierro() * cantidadElegida / 100;
						hierroMujeres += alimentos[j].getHierro() * cantidadElegida / 100;

					}else

						hierroHombres += alimentos[j].getHierro();
					hierroMujeres += alimentos[j].getHierro();

				}

			}

		}

		hierroTotalHombres+= hierroHombres;		
		hierroTotalMujeres += hierroMujeres;

		if (persona.getSexo().equalsIgnoreCase("mujer")) {
			return hierroTotalMujeres;
		}else{
			return hierroTotalHombres;
		}

	}

	public static boolean isGrasaIdeal(Alimento []alimentos, ArraysToString<String> alimentosElegidos, ArraysToString<Integer> cantidadesElegidas) {

		boolean isIdeal=true;

		double grasasTotales = totalGrasaIdeal(alimentos, alimentosElegidos, cantidadesElegidas);

		if (grasasTotales >= GRASAINICIALIDEAL && grasasTotales <= GRASAFINALIDEAL) { 
			return isIdeal; // Devuelvo un boolean como true
		}else
			return !isIdeal; //Devuelvo un boolean como false



	}

	public static boolean isAzucarIdeal(Alimento []alimentos, ArraysToString<String> alimentosElegidos, ArraysToString<Integer> cantidadesElegidas) {

		boolean isIdeal=true;

		double azucarTotal = totalAzucarIdeal(alimentos, alimentosElegidos, cantidadesElegidas);

		if (azucarTotal >= AZUCARINICIALIDEAL && azucarTotal <= AZUCARFINALIDEAL) {
			return isIdeal;
		}else
			return !isIdeal;


	}

	public static boolean isProteinaIdeal(Alimento []alimentos, Persona persona, ArraysToString<String> alimentosElegidos, ArraysToString<Integer> cantidadesElegidas) {

		boolean isIdeal = true;

		double proteinasTotalesHombre = totalProteinaIdeal(alimentos,persona, alimentosElegidos, cantidadesElegidas);
		double proteinasTotalesMujer = totalProteinaIdeal(alimentos,persona, alimentosElegidos, cantidadesElegidas);

		if (proteinasTotalesHombre == PROTEINAIDEALHOMBRE) {
			return isIdeal;
		}else if (proteinasTotalesMujer == PROTEINAIDEALMUJER) {
			return isIdeal;
		}else 
			return !isIdeal;

	}

	public static boolean isHidratosIdeal(Alimento []alimentos, ArraysToString<String> alimentosElegidos, ArraysToString<Integer> cantidadesElegidas) {

		boolean isIdeal = true;

		double hidratosTotales = totalHidratosIdeal(alimentos, alimentosElegidos, cantidadesElegidas);

		if (hidratosTotales == HIDRATOSIDEAL) {
			return isIdeal;
		}else
			return !isIdeal;

	}

	public static boolean isPotasioIdeal(Alimento []alimentos, Persona persona, ArraysToString<String> alimentosElegidos, ArraysToString<Integer> cantidadesElegidas) {

		boolean isIdeal = true;
		double potasioTotalHombre = totalProteinaIdeal(alimentos,persona, alimentosElegidos, cantidadesElegidas);
		double potasioTotalMujer = totalProteinaIdeal(alimentos,persona, alimentosElegidos, cantidadesElegidas);

		if (potasioTotalHombre == POTASIOIDEALHOMBRE) {
			return isIdeal;
		}else if (potasioTotalMujer == POTASIOIDEALMUJER) {
			return isIdeal;
		}else 
			return !isIdeal;

	}

	public static boolean isCalcioIdeal(Alimento []alimentos,ArraysToString<String> alimentosElegidos, ArraysToString<Integer> cantidadesElegidas) {

		boolean isIdeal = true;

		double calcioTotal = totalCalcioIdeal(alimentos, alimentosElegidos, cantidadesElegidas);


		if (calcioTotal >= CALCIOIDEALINICIAL && calcioTotal <= CALCIOIDEALFINAL) {
			return isIdeal;
		}else
			return !isIdeal;

	}

	public static boolean isSalIdeal(Alimento []alimentos,ArraysToString<String> alimentosElegidos, ArraysToString<Integer> cantidadesElegidas) {

		boolean isIdeal = true;

		double salTotal = totalSalIdeal(alimentos, alimentosElegidos, cantidadesElegidas);

		if (salTotal == SALIDEAL) {
			return isIdeal;
		}else
			return !isIdeal;

	}

	public static boolean isHierroIdeal(Alimento []alimentos, Persona persona, ArraysToString<String> alimentosElegidos, ArraysToString<Integer> cantidadesElegidas) {

		boolean isIdeal = true;

		double hierroTotalHombre = totalHierroIdeal(alimentos,persona, alimentosElegidos, cantidadesElegidas);
		double hierroTotalMujer = totalHierroIdeal(alimentos,persona, alimentosElegidos, cantidadesElegidas);


		if (hierroTotalHombre == HIERROIDEALHOMBRE) {
			return isIdeal;
		}else if (hierroTotalMujer == HIERROIDEALMUJER) {
			return isIdeal;
		}else 
			return !isIdeal;

	}

}