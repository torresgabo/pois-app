package ar.com.curso.poi.test;

import org.junit.Test;

import ar.com.curso.poi.tdd.CalculadorDeDistancias;

import static org.assertj.core.api.Assertions.*;

public class CalculadorDeDistanciasTest {
	
	@Test
	public void laDistanciaEntreCNELyCityMallDeberiaSer264Metros() {
		CalculadorDeDistancias calculador = new CalculadorDeDistancias();
		double longitudMall = -79.9118256;
		double latitudMall = -2.1416008;
		double longitudCnel = -79.9138252;
		double latitudCnel = -2.1421382;
		double distancia = calculador.distanciaCoord(latitudCnel, longitudCnel, latitudMall, longitudMall);
		assertThat(distancia).isBetween(214.0, 314.0);

	}

}
