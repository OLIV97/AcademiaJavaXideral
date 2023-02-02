package testEjercicios;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import pruebasUnitarias.Ejercicios;

class TestExercises {

	@DisplayName("El siguiente test espera una cadena y debe retornarla inversa")
	@Test
	void testPalabrasInversas() {	
		assertEquals("aloh euq lat neub .aid",Ejercicios.palabrasInversas("hola que tal buen dia."));
	}
	
	@DisplayName("El siguiente test espera solo espacios y debe regresarlos tal cual")
	@Test
	void testPalabrasInveversaEspacios() {	
		assertEquals("    ",Ejercicios.palabrasInversas("    "));
	}
	
	@DisplayName("El siguiente tet espera una cadena con camel case inversa")
	@Test
	void testPalabrasInveversaCamelCase() {	
		assertEquals("aloH euQ laT neuB .aiD",Ejercicios.palabrasInversas("Hola Que Tal Buen Dia."));
	}
	
	@DisplayName("El siguiente tet espera una cadena vacia y debe regresar una vacia")
	@Test
	void testPalabrasInveversaVacia() {	
		assertEquals("",Ejercicios.palabrasInversas(""));
	
	}
	
	@DisplayName("El siguiente tet espera una cadena de una sola letra y regresa la misma")
	@Test
	void testPalabrasInveversaUnaLetra() {	
		assertEquals("a",Ejercicios.palabrasInversas("a"));
	}
	
	@DisplayName("El siguiente tet espera un numero de "
			+ "varios digitos y suma todos para generar un nuevo numero asi hasta llegar a un digito")
	@Test
	void testRaizDigital() {	
		assertEquals(6,Ejercicios.raiz_digital(132189));
	
	}

}
