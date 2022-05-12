package proyectoAlimento;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PruebaJUnit {
	
	private static Persona p;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		p = new Persona("Pepe","Hombre",61,173,18); //Creación del objeto p de la clase Persona
	
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("Pruebas finalizadas");
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCalculoImcFunciona() { // Caso en el que funciona
		
		double resultado = Imc.calcular_imc(p.getAltura(),p.getPeso());
		assertEquals(20.381569714992146,resultado);
	}
	
	@Test
	void testCalculoImcNoFunciona() { // Caso en el que no funciona
		
		double resultado = Imc.calcular_imc(p.getAltura(),p.getPeso());
		assertEquals(3,resultado);
	}

}
