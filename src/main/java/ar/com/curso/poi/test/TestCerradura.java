package ar.com.curso.poi.test;
import static org.assertj.core.api.Assertions.*;
import org.junit.Test;

import ar.com.curso.poi.kata.tdd.Cerradura;
public class TestCerradura {
	Cerradura cerradura = new Cerradura(1234, 3);
	
	@Test
	public void alAbrirConClaveIncorrectaNoDeberiaAbrir(){
		cerradura.abrir(1);
		assertThat(cerradura.estaCerrada()).isTrue();
	}
	
	@Test
	public void alAbrirLaCerraduraNoDeberiaEstarCerrada(){
		cerradura.abrir(1234);
		assertThat(cerradura.estaCerrada()).isFalse();
	}
	
	@Test
	public void alCrearLaCerraduraDeberiaEstarCerrada(){
		assertThat(cerradura.estaCerrada()).isTrue();
	}
	
	@Test
	public void alFallarNVecesSeguidasLaCerraduraSeBloquea(){
		cerradura.abrir(1);
		cerradura.abrir(1);
		cerradura.abrir(1);	
		assertThat(cerradura.fueBloqueada()).isTrue();
	}
	
	@Test
	public void alAbrirCerraduraNoTieneBloqueo(){
		cerradura.abrir(1234);	
		assertThat(cerradura.fueBloqueada()).isFalse();
	}
	
	@Test
	public void alFallarNVecesYAcertarLaCerraduraNoSeBloquea(){
		cerradura.abrir(1);
		cerradura.abrir(1);
		cerradura.abrir(1234);	
		cerradura.abrir(1);
		assertThat(cerradura.fueBloqueada()).isFalse();
	}
}
