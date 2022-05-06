package proyectoAlimento;

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
	private final static double PROTEINAIDEALHOMBRE=140.0;
	private final static double PROTEINAIDEALMUJER=170.0;
	private final static double HIDRATOSIDEAL=135.0;
	private final static double POTASIOIDEALHOMBRE=3.4;
	private final static double POTASIOIDEALMUJER=2.6;
	private final static double CALCIOIDEAL=0.9;
	private static final double SALIDEAL=5.0;
	private final static double HIERROIDEALHOMBRE=3.8;
	private final static double HIERROIDEALMUJER=2.3;
	
	/**
	 * 
	 * @param alimento: Valores que contenga el alimento en gramos
	 * @return
	 */


	public boolean CalcularGrasaIdeal(Alimento []alimento) {

		double grasas_totales = 0;

		for (int i=0; i<alimento.length; i++) {

			grasas_totales += alimento[i].getGrasas();

		}

		if (grasas_totales >= GRASAINICIALIDEAL && grasas_totales <= GRASAFINALIDEAL) {
			return true;
		}else
			return false;

	}
	
	/**
	 * 
	 * @param alimento: Valores que contenga el alimento en gramos
	 * @return
	 */

	public boolean CalcularAzucarIdeal(Alimento []alimento) {

		double azucares_totales = 0;

		for (int i=0; i<alimento.length; i++) {

			azucares_totales += alimento[i].getAzucar();

		}

		if (azucares_totales >= AZUCARINICIALIDEAL && azucares_totales <= AZUCARFINALIDEAL) {
			return true;
		}else
			return false;

	}
	
	/**
	 * 
	 * @param alimento: Valores que contenga el alimento en gramos
	 * @param sexo: Género de la persona (Hombre o Mujer)
	 * @return
	 */

	public boolean CalcularProteinaIdeal(Alimento []alimento, Persona sexo) {

		double proteinas_totales_hombres = 0;		
		double proteinas_totales_mujeres = 0;


		for (int i=0; i<alimento.length; i++) {

			if (sexo.equals("Hombre")) {
				proteinas_totales_hombres += alimento[i].getProteinas();	
			}else
				proteinas_totales_mujeres += alimento[i].getProteinas();


		}

		if (proteinas_totales_hombres == PROTEINAIDEALHOMBRE) {
			return true;
		}else if (proteinas_totales_mujeres == PROTEINAIDEALMUJER) {
			return true;
		}else 
			return false;

	}
	
	/**
	 * 
	 * @param alimento: Valores que contenga el alimento en gramos
	 * @return
	 */

	public boolean CalcularHidratosIdeal(Alimento []alimento) {

		double hidratos_totales = 0;

		for (int i=0; i<alimento.length; i++) {

			hidratos_totales += alimento[i].getHidratos();

		}

		if (hidratos_totales == HIDRATOSIDEAL) {
			return true;
		}else
			return false;

	}
	
	/**
	 * 
	 * @param alimento: Valores que contenga el alimento en gramos
	 * @param sexo: Género de la persona (Hombre o Mujer)
	 * @return
	 */

	public boolean CalcularPotasioIdeal(Alimento []alimento, Persona sexo) {

		double potasio_total_hombres = 0;
		double potasio_total_mujeres = 0;
		
		for (int i=0; i<alimento.length; i++) {

			if (sexo.equals("Hombre")) {
				potasio_total_hombres += alimento[i].getHierro();	
			}else
				potasio_total_mujeres += alimento[i].getHierro();


		}

		if (potasio_total_hombres == POTASIOIDEALHOMBRE) {
			return true;
		}else if (potasio_total_mujeres == POTASIOIDEALMUJER) {
			return true;
		}else 
			return false;
	}
	
	/**
	 * 
	 * @param alimento: Valores que contenga el alimento en gramos
	 * @return
	 */

	public boolean CalcularCalcioIdeal(Alimento []alimento) {

		double calcio_total = 0;

		for (int i=0; i<alimento.length; i++) {

			calcio_total += alimento[i].getCalcio();

		}

		if (calcio_total == CALCIOIDEAL) {
			return true;
		}else
			return false;

	}
	
	/**
	 * 
	 * @param alimento: Valores que contenga el alimento en gramos
	 * @return
	 */

	public boolean CalcularSalIdeal(Alimento []alimento) {

		double sal_total = 0;

		for (int i=0; i<alimento.length; i++) {

			sal_total += alimento[i].getSal();

		}

		if (sal_total == SALIDEAL) {
			return true;
		}else
			return false;

	}
	
	/**
	 * 
	 * @param alimento: Valores que contenga el alimento en gramos
	 * @param sexo: Género de la persona (Hombre o Mujer)
	 * @return
	 */

	public boolean CalcularHierroIdeal(Alimento []alimento, Persona sexo) {

		double hierro_total_hombres = 0;
		double hierro_total_mujeres = 0;

		for (int i=0; i<alimento.length; i++) {

			if (sexo.equals("Hombre")) {
				hierro_total_hombres += alimento[i].getHierro();	
			}else
				hierro_total_mujeres += alimento[i].getHierro();


		}

		if (hierro_total_hombres == HIERROIDEALHOMBRE) {
			return true;
		}else if (hierro_total_mujeres == HIERROIDEALMUJER) {
			return true;
		}else 
			return false;

	}
}
