package ar.com.curso.poi.accept;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.junit.Test;

import ar.com.curso.poi.controladores.ControladorHome;

public class AceptacionIT {
	ControladorHome controlador = new ControladorHome();

	@Test
	public void validaElPoiMasCercano() throws Exception {
		String url = "http://localhost:8080/pois-app/Buenos_Aires_Turismo/retornapoicercano/-34.6037389/-58.3837644";
		String data = llamarUrl(url);
		assertThat(data).contains("Cuartetas");
	}

	public String llamarUrl(String url) throws Exception {
		URL urlConnect = new URL(url);
		URLConnection connection = urlConnect.openConnection();
		connection.connect();
		return new BufferedReader(new InputStreamReader(connection.getInputStream())).readLine();
	}

}
