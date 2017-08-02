package ar.com.curso.poi.test;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

import ar.com.curso.poi.controladores.ControladorHome;
import ar.com.curso.poi.tdd.PoiBean;

public class ServicioTest {
	ControladorHome controlador = new ControladorHome();
	@Test
	public void validaSiServicioNoExiste(){
		
		assertThat(controlador.validaServicio("Argentina")).isFalse();
	}
	
	@Test
	public void validaSiServicioExiste(){
		assertThat(controlador.validaServicio("Buenos_Aires_Turismo")).isTrue();
	}
	
	@Test
	public void validaNoEsPoisVacio(){
		assertThat(new PoiBean().getPois().isEmpty()).isFalse();
	}
	
}
