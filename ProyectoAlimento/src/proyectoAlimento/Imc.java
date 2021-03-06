
/**
 * 
 * Clase que te indica si te encuentras en tu peso ideal y tu estado físico.
 * @author marcre
 *
 */

package proyectoAlimento;

import java.text.DecimalFormat;

public class Imc {	

	public static double calcularImc(int altura, int peso) { 
		
		double medida = (double) altura/100;
		
		double calculo = peso/Math.pow(medida, 2);

		return calculo;

	}
	
	/**
	 * Según el imc, mostraremos si el usuario se encuentra en el peso ideal, ya seas hombre o mujer.
	 * @param edad: Valor de la edad de la persona en años
	 * @param altura: Valor de la altura de la persona en cm
	 * @param peso: Valor del peso de la persona en kg
	 * @param sexo: Sexo de la persona (Hombre o Mujer)
	 * @return Devuelve el estado fisico de una persona en base a su IMC
	 */

	public static String calcularPesoIdeal(int edad, int altura, int peso, String sexo) { 

		String estadoFisico = "";
		DecimalFormat decimalFormat = new DecimalFormat("#.00");

		double calculo_imc = calcularImc(altura, peso);
		String imc = decimalFormat.format(calculo_imc);

		if (sexo.equals("Hombre")) { 

			if (((edad==16) && (calculo_imc>=19 && calculo_imc<=24)) || ((edad==17 || edad==18) && (calculo_imc>=20 && calculo_imc<=25))) { //Peso ideal Hombres

				estadoFisico = "Su estado físico es Ideal,\ncuenta con un imc de "+imc;

			}else if ((edad>=19 && edad<=24) && (calculo_imc >=21 && calculo_imc<=26)) {

				estadoFisico = "Su estado físico es Ideal,\ncuenta con un imc de "+imc;

			}else if ((edad>=25 && edad<=34) && (calculo_imc >=22 && calculo_imc<=27)) {

				estadoFisico = "Su estado físico es Ideal,\ncuenta con un imc de "+imc;

			}else if ((edad>=35 && edad<=54) && (calculo_imc >=23 && calculo_imc<=38)) {

				estadoFisico = "Su estado físico es Ideal,\ncuenta con un imc de "+imc;

			}else if ((edad>=55 && edad<=64) && (calculo_imc>=24 && calculo_imc<=29)) {

				estadoFisico = "Su estado físico es Ideal,\ncuenta con un imc de "+imc;

			}else if ((edad>=65 && edad<=90) && (calculo_imc>=25 && calculo_imc<=30)) { 

				estadoFisico = "Su estado físico es Ideal,\ncuenta con un imc de "+imc;

			}else

				estadoFisico = "Su estado físico no es Ideal,\ncuenta con un imc de "+imc;

		}else //Peso ideal Mujeres

			if ((edad>=16 && edad<=24) && (calculo_imc>=19 && calculo_imc<=24)) {

				estadoFisico = "Su estado físico es Ideal,\ncuenta con un imc de "+calculo_imc;

			}else if ((edad>=25 && edad<=34) && (calculo_imc>=20 && calculo_imc<=25)) {

				estadoFisico = "Su estado físico es Ideal,\ncuenta con un imc de "+calculo_imc;

			}else if ((edad>=35 && edad<=44) && (calculo_imc>=21 && calculo_imc<=26)) {

				estadoFisico = "Su estado físico es Ideal,\ncuenta con un imc de "+calculo_imc;

			}else if ((edad>=45 && edad<=54) && (calculo_imc>=22 && calculo_imc<=27)) {

				estadoFisico = "Su estado físico es Ideal,\ncuenta con un imc de "+calculo_imc;

			}else if ((edad>=55 && edad<=64) && (calculo_imc>=23 && calculo_imc<=28)) {

				estadoFisico = "Su estado físico es Ideal,\ncuenta con un imc de "+calculo_imc;

			}else if ((edad>=65 && edad<=90) && (calculo_imc>=25 && calculo_imc<=30)) {

				estadoFisico = "Su estado físico es Ideal,\ncuenta con un imc de "+calculo_imc;

			}else

				estadoFisico = "Su estado físico no es Ideal,\ncuenta con un imc de "+calculo_imc;

		return estadoFisico;
	}
	
	/**
	 * Según el resultado del cálculo del imc mostraremos el estado físico de la persona
	 * @param altura: Valor de la altura de la persona en cm
	 * @param peso: Valor del peso de la persona en kg
	 * @return Devuelve el Imc de una persona en base a su peso y altura
	 */
	

	public static String imcPersona(int altura, int peso) { 
		
		String imc_persona = "";

		double calculo_imc= calcularImc(altura, peso);
		
		if (calculo_imc < 16) {

			imc_persona = "Delgadez Severa";

		}else if (calculo_imc < 16 && calculo_imc <= 17) {

			imc_persona = "Delgadez Moderada";

		}else 	if (calculo_imc >= 17 && calculo_imc <= 18.5) {

			imc_persona = "Delgadez Leve";

		}else 	if (calculo_imc >= 18.5 && calculo_imc <= 24.9) {

			imc_persona = "Peso Normal";

		}else 	if (calculo_imc >= 25 && calculo_imc <= 29.9) {

			imc_persona = "Sobrepeso";

		}else 	if (calculo_imc >= 30 && calculo_imc <= 34.9) {

			imc_persona = "Obesidad Tipo I";

		}else 	if (calculo_imc >= 35 && calculo_imc <= 39.9) {

			imc_persona = "Obesidad Tipo II";

		}else	if (calculo_imc >= 40&& calculo_imc <= 49.9) {

			imc_persona = "Obesidad Tipo III";

		}else	if (calculo_imc >= 50) {

			imc_persona = "Obesidad Tipo IV";

		}

		return imc_persona;

	}


}