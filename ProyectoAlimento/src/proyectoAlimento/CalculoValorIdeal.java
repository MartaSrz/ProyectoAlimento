package proyectoAlimento;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Clase que sirve para calcular si la persona (seas Hombre o Mujer) consume una cantidad correcta de alimentos en gramos.
 * @author marcre
 *
 */

public class CalculoValorIdeal{
	private static DecimalFormat decimalFormat = new DecimalFormat("0.00");
	private final static double GRASA_INICIAL_IDEAL=60.0;
	private final static double GRASA_FINAL_IDEAL=80.0;
	private final static double AZUCAR_IDEAL=25.0;
	private final static double PROTEINA_IDEAL_HOMBRE=56.0;
	private final static double PROTEINA_IDEAL_MUJER=46.0;
	private final static double HIDRATOS_IDEAL=135.0;

	private final static double POTASIO_IDEAL_HOMBRE=3400.0;
	private final static double POTASIO_IDEAL_MUJER=2600.0;
	private final static double CALCIO_IDEAL_INICIAL=1.2;
	private final static double CALCIO_IDEAL_FINAL=1.3;
	private static final double SAL_IDEAL=5.0;
	private final static double PORCENTAJE_GRASA_SATURADA_IDEAL=7.0;


	public static double getGrasainicialideal() {
		return GRASA_INICIAL_IDEAL;
	}

	public static double getGrasafinalideal() {
		return GRASA_FINAL_IDEAL;
	}

	public static double getAzucarideal() {
		return AZUCAR_IDEAL;
	}

	public static double getProteinaidealhombre() {
		return PROTEINA_IDEAL_HOMBRE;
	}

	public static double getProteinaidealmujer() {
		return PROTEINA_IDEAL_MUJER;
	}

	public static double getHidratosideal() {
		return HIDRATOS_IDEAL;
	}

	public static double getPotasioidealhombre() {
		return POTASIO_IDEAL_HOMBRE;
	}

	public static double getPotasioidealmujer() {
		return POTASIO_IDEAL_MUJER;
	}

	public static double getCalcioidealinicial() {
		return CALCIO_IDEAL_INICIAL;
	}

	public static double getCalcioidealfinal() {
		return CALCIO_IDEAL_FINAL;
	}

	public static double getSalideal() {
		return SAL_IDEAL;
	}

	public static double getGrasaSaturadaideal() {
		return PORCENTAJE_GRASA_SATURADA_IDEAL;
	}

	/**
	 * 
	 * @param alimentos: Valores que contenga el alimento en gramos y el nombre del alimento
	 * @param alimentosElegidos: El nombre de los alimentos
	 * @param cantidadesElegidas: Las cantidades de los alimentos
	 * @return devuelve la grasa inicial ideal
	 * 
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
		String grasasString = decimalFormat.format(grasasTotales);
		grasasString =grasasString.replace(",", ".");

		grasasTotales = Double.parseDouble(grasasString);
		
		return grasasTotales;

	} 

	/**
	 * @param alimentosElegidos: Lista de los alimentos que ha seleccionado el usuario
	 * @param cantidadesElegidas: Cantidad de cada uno de los alimentos que ha seleccionado el usuario
	 * @param alimentos: Valores que contenga el alimento en gramos
	 * @return Devuelve las grasas totales
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
	 * @param alimentosElegidos: Lista de los alimentos que ha seleccionado el usuario
	 * @param cantidadesElegidas: Cantidad de cada uno de los alimentos que ha seleccionado el usuario
	 * @param alimentos: Valores que contenga el alimento en gramos
	 * @param persona los datos de la persona con el fin de averiguar su sexo
	 * @return Devuelve los azucares totales
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
	 * @param alimentosElegidos: Lista de los alimentos que ha seleccionado el usuario
	 * @param cantidadesElegidas: Cantidad de cada uno de los alimentos que ha seleccionado el usuario
	 * @param alimentos: Valores que contenga el alimento en gramos
	 * @return Devuelve las proteinas ideales de un hombre
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
	 * @param alimentosElegidos: Lista de los alimentos que ha seleccionado el usuario
	 * @param cantidadesElegidas: Cantidad de cada uno de los alimentos que ha seleccionado el usuario
	 * @param alimentos: Valores que contenga el alimento en gramos
	 * @param persona: Los datos de la persona con el fin de averiguar su sexo
	 * @return Devuelve el potasio ideal 
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
	 * @param alimentosElegidos: Lista de los alimentos que ha seleccionado el usuario
	 * @param cantidadesElegidas: Cantidad de cada uno de los alimentos que ha seleccionado el usuario
	 * @param alimentos: Valores que contenga el alimento en gramos
	 * @return Devuelve el calcio ideal
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
	 * @param alimentosElegidos: Lista de los alimentos que ha seleccionado el usuario
	 * @param cantidadesElegidas: Cantidad de cada uno de los alimentos que ha seleccionado el usuario
	 * @param alimentos: Valores que contenga el alimento en gramos
	 * @return Devuelve el total de sal ideal
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
	 * @param alimentosElegidos: Lista de los alimentos que ha seleccionado el usuario
	 * @param cantidadesElegidas: Cantidad de cada uno de los alimentos que ha seleccionado el usuario
	 * @param alimentos: Valores que contenga el alimento en gramos
	 * @return Devuelve el total de grasas saturadas ideal
	 */

	public static double totalGrasaSaturadaIdeal(Alimento []alimentos, ArraysToString<String> alimentosElegidos, ArraysToString<Integer> cantidadesElegidas) {

		double grasasSaturadas = 0;
		double grasasSaturadasTotales = 0;

		int size = alimentosElegidos.size();
		int length = alimentos.length;

		for (int i=0; i<size; i++) {

			for (int j=0; j<length; j++) {

				if (alimentosElegidos.get(i).equals(alimentos[j].getNombre())) {

					String cantidad=cantidadesElegidas.get(i).toString();
					int cantidadElegida=Integer.parseInt(cantidad);

					if (cantidadElegida > 100 || cantidadElegida < 100) {

						grasasSaturadas += alimentos[j].getGrasasSaturadas() * cantidadElegida / 100;

					}else

						grasasSaturadas += alimentos[j].getGrasasSaturadas();

				}

			}

		}

		grasasSaturadasTotales += grasasSaturadas;

		return grasasSaturadasTotales;


	}
	/**
	 * @param alimentosElegidos: Lista de los alimentos que ha seleccionado el usuario
	 * @param cantidadesElegidas: Cantidad de cada uno de los alimentos que ha seleccionado el usuario
	 * @param alimentos: Valores que contenga el alimento en gramos
	 * @return Devuelve el porcentaje total de grasas saturadas ideal
	 */

	public static String totalPorcentajeGrasaSaturadaIdeal(Alimento []alimentos,ArraysToString<String> alimentosElegidos, ArraysToString<Integer> cantidadesElegidas) {



		double grasaSaturadaTotal = totalGrasaSaturadaIdeal(alimentos,alimentosElegidos, cantidadesElegidas);

		double kcalTotal=0;

		int size = alimentosElegidos.size();
		int length = alimentos.length;

		for (int i=0; i<size; i++) {

			for (int j=0; j<length; j++) {

				if (alimentosElegidos.get(i).equals(alimentos[j].getNombre())) {

					String cantidad=cantidadesElegidas.get(i).toString();
					int cantidadElegida=Integer.parseInt(cantidad);

					if (cantidadElegida > 100 || cantidadElegida < 100) {

						kcalTotal += alimentos[j].getKcal() * cantidadElegida / 100;

					}else

						kcalTotal += alimentos[j].getKcal();

				}

			}

		}

		double valorIdealKcal = (kcalTotal * PORCENTAJE_GRASA_SATURADA_IDEAL / 100);

		double valorKcalGrasaSaturada = (grasaSaturadaTotal * 9);

		String porcentaje = decimalFormat.format((valorKcalGrasaSaturada * PORCENTAJE_GRASA_SATURADA_IDEAL) / valorIdealKcal);

		return porcentaje;

	}
	/**
	 * @param alimentosElegidos: Lista de los alimentos que ha seleccionado el usuario
	 * @param cantidadesElegidas: Cantidad de cada uno de los alimentos que ha seleccionado el usuario
	 * @param alimentos: Valores que contenga el alimento en gramos
	 * @return Devuelve si las grasas son o no ideales
	 */

	public static boolean isGrasaIdeal(Alimento []alimentos, ArraysToString<String> alimentosElegidos, ArraysToString<Integer> cantidadesElegidas) {

		boolean isIdeal=true;

		double grasasTotales = totalGrasaIdeal(alimentos, alimentosElegidos, cantidadesElegidas);

		if (grasasTotales >= GRASA_INICIAL_IDEAL && grasasTotales <= GRASA_FINAL_IDEAL) { 
			return isIdeal; // Devuelvo un boolean como true
		}else
			return !isIdeal; //Devuelvo un boolean como false

	}
	/**
	 * @param alimentosElegidos: Lista de los alimentos que ha seleccionado el usuario
	 * @param cantidadesElegidas: Cantidad de cada uno de los alimentos que ha seleccionado el usuario
	 * @param alimentos: Valores que contenga el alimento en gramos
	 * @return Devuelve si los azucares son o no ideales
	 */

	public static boolean isAzucarIdeal(Alimento []alimentos, ArraysToString<String> alimentosElegidos, ArraysToString<Integer> cantidadesElegidas) {

		boolean isIdeal=true;

		double azucarTotal = totalAzucarIdeal(alimentos, alimentosElegidos, cantidadesElegidas);

		if (azucarTotal <= AZUCAR_IDEAL) {
			return isIdeal;
		}else
			return !isIdeal;

	}

	/**
	 * @param alimentosElegidos: Lista de los alimentos que ha seleccionado el usuario
	 * @param cantidadesElegidas: Cantidad de cada uno de los alimentos que ha seleccionado el usuario
	 * @param alimentos: Valores que contenga el alimento en gramos
	 * @return Devuelve si las grasas saturadas son o no ideales
	 */
	public static boolean isGrasaSaturadaIdeal(Alimento []alimentos,ArraysToString<String> alimentosElegidos, ArraysToString<Integer> cantidadesElegidas) {

		boolean isIdeal = true;

		double grasaSaturadaTotal = totalGrasaSaturadaIdeal(alimentos,alimentosElegidos, cantidadesElegidas);

		double kcalTotal=0;

		int size = alimentosElegidos.size();
		int length = alimentos.length;

		for (int i=0; i<size; i++) {

			for (int j=0; j<length; j++) {

				if (alimentosElegidos.get(i).equals(alimentos[j].getNombre())) {

					String cantidad=cantidadesElegidas.get(i).toString();
					int cantidadElegida=Integer.parseInt(cantidad);

					if (cantidadElegida > 100 || cantidadElegida < 100) {

						kcalTotal += alimentos[j].getKcal() * cantidadElegida / 100;

					}else

						kcalTotal += alimentos[j].getKcal();

				}

			}

		}

		double valorIdealKcal = ((kcalTotal * PORCENTAJE_GRASA_SATURADA_IDEAL) / 100);

		double valorKcalGrasaSaturada = (grasaSaturadaTotal * 9);

		if (valorKcalGrasaSaturada <= valorIdealKcal) {
			return isIdeal;
		}else
			return !isIdeal;

	}
	/**
	 * @param alimentosElegidos: Lista de los alimentos que ha seleccionado el usuario
	 * @param cantidadesElegidas: Cantidad de cada uno de los alimentos que ha seleccionado el usuario
	 * @param persona: Los valores del usuario que está usando la aplicacion
	 * @param alimentos: Valores que contenga el alimento en gramos
	 * @return Devuelve si las proteinas son o no ideales
	 */

	public static boolean isProteinaIdeal(Alimento []alimentos, Persona persona, ArraysToString<String> alimentosElegidos, ArraysToString<Integer> cantidadesElegidas) {

		boolean isIdeal = true;

		double proteinasTotalesHombre = totalProteinaIdeal(alimentos,persona, alimentosElegidos, cantidadesElegidas);
		double proteinasTotalesMujer = totalProteinaIdeal(alimentos,persona, alimentosElegidos, cantidadesElegidas);

		if (proteinasTotalesHombre == PROTEINA_IDEAL_HOMBRE) {
			return isIdeal;
		}else if (proteinasTotalesMujer == PROTEINA_IDEAL_MUJER) {
			return isIdeal;
		}else 
			return !isIdeal;

	}
	
	/**
	 * @param alimentosElegidos: Lista de los alimentos que ha seleccionado el usuario
	 * @param cantidadesElegidas: Cantidad de cada uno de los alimentos que ha seleccionado el usuario
	 * @param alimentos: Valores que contenga el alimento en gramos
	 * @return Devuelve si los hidratos son o no ideales
	 */

	public static boolean isHidratosIdeal(Alimento []alimentos, ArraysToString<String> alimentosElegidos, ArraysToString<Integer> cantidadesElegidas) {

		boolean isIdeal = true;

		double hidratosTotales = totalHidratosIdeal(alimentos, alimentosElegidos, cantidadesElegidas);

		if (hidratosTotales == HIDRATOS_IDEAL) {
			return isIdeal;
		}else
			return !isIdeal;

	}
	
	/**
	 * @param alimentosElegidos: Lista de los alimentos que ha seleccionado el usuario
	 * @param cantidadesElegidas: Cantidad de cada uno de los alimentos que ha seleccionado el usuario
	 * @param persona: Los valores del usuario que está usando la aplicacion
	 * @param alimentos: Valores que contenga el alimento en gramos
	 * @return Devuelve si el potasio es o no ideal
	 */

	public static boolean isPotasioIdeal(Alimento []alimentos, Persona persona, ArraysToString<String> alimentosElegidos, ArraysToString<Integer> cantidadesElegidas) {

		boolean isIdeal = true;
		double potasioTotalHombre = totalProteinaIdeal(alimentos,persona, alimentosElegidos, cantidadesElegidas);
		double potasioTotalMujer = totalProteinaIdeal(alimentos,persona, alimentosElegidos, cantidadesElegidas);

		if (potasioTotalHombre == POTASIO_IDEAL_HOMBRE) {
			return isIdeal;
		}else if (potasioTotalMujer == POTASIO_IDEAL_MUJER) {
			return isIdeal;
		}else 
			return !isIdeal;

	}
	
	/**
	 * @param alimentosElegidos: Lista de los alimentos que ha seleccionado el usuario
	 * @param cantidadesElegidas: Cantidad de cada uno de los alimentos que ha seleccionado el usuario
	 * @param alimentos: Valores que contenga el alimento en gramos
	 * @return Devuelve si los hidratos son o no ideales
	 */

	public static boolean isCalcioIdeal(Alimento []alimentos,ArraysToString<String> alimentosElegidos, ArraysToString<Integer> cantidadesElegidas) {

		boolean isIdeal = true;

		double calcioTotal = totalCalcioIdeal(alimentos, alimentosElegidos, cantidadesElegidas);


		if (calcioTotal >= CALCIO_IDEAL_INICIAL && calcioTotal <= CALCIO_IDEAL_FINAL) {
			return isIdeal;
		}else
			return !isIdeal;

	}
	
	/**
	 * @param alimentosElegidos: Lista de los alimentos que ha seleccionado el usuario
	 * @param cantidadesElegidas: Cantidad de cada uno de los alimentos que ha seleccionado el usuario
	 * @param alimentos: Valores que contenga el alimento en gramos
	 * @return Devuelve si la sal es o no ideal
	 */

	public static boolean isSalIdeal(Alimento []alimentos,ArraysToString<String> alimentosElegidos, ArraysToString<Integer> cantidadesElegidas) {

		boolean isIdeal = true;

		double salTotal = totalSalIdeal(alimentos, alimentosElegidos, cantidadesElegidas);

		if (salTotal <= SAL_IDEAL) {
			return isIdeal;
		}else
			return !isIdeal;

	}

}