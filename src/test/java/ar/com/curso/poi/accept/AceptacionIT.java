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
		String url = "http://localhost:8080/pois-app/Buenos_Aires_Turismo/retornapoicercano/-34.6037389/-58.3821189";
		String data = llamarUrl(url);
		assertThat(data).contains("Cuartetas");
	}
	
	
	@Test
	public void devolverA300MetrosUnSoloPoint() throws Exception {
		String url = "http://localhost:8080/pois-app/Buenos_Aires_Turismo/poisDeUnRadio/-34.6037389/-58.3821189/300";
		String data = llamarUrl(url);
		assertThat(data).contains("Cuartetas");
		
	}
	
	@Test
	public void devolverA600MetrosUnSoloPoint() throws Exception {
		String url = "http://localhost:8080/pois-app/Buenos_Aires_Turismo/poisDeUnRadio/-34.6037389/-58.3821189/600";
		String data = llamarUrl(url);
		assertThat(data).contains("Cuartetas");
		assertThat(data).contains("Palacio");
		
	}
	
	@Test
	public void devolverA2000MetrosUnSoloPoint() throws Exception {
		String url = "http://localhost:8080/pois-app/Buenos_Aires_Turismo/poisDeUnRadio/-34.6037389/-58.3821189/2000";
		String data = llamarUrl(url);
		assertThat(data).contains("Cuartetas");
		assertThat(data).contains("Palacio de la Pizza");
		assertThat(data).contains("Cabildo");
		assertThat(data).contains("Cuartito");
		
	}
	

	public String llamarUrl(String url) throws Exception {
		URL urlConnect = new URL(url);
		URLConnection connection = urlConnect.openConnection();
		connection.connect();
		return new BufferedReader(new InputStreamReader(connection.getInputStream())).readLine();
	}
	
	

}
