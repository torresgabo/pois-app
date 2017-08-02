package ar.com.curso.poi.test;

import static org.assertj.core.api.Assertions.*;

import java.io.DataInputStream;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLConnection;

import org.junit.Test;

import ar.com.curso.poi.controladores.ControladorHome;
import ar.com.curso.poi.tdd.PoiBean;

public class ServicioTestATDD {
	ControladorHome controlador = new ControladorHome();

	@Test
	public void validaElPoiMasCercano() {
		// Obelisco
		// lon -34.6037389
		// lat -58.3837644
		try {
			String url = "http://localhost:8080/pois-app/Buenos_Aires_Turismo/retornapoicercano/-34.6037389/-58.3837644";

			String data = llamarUrl(url);

			assertThat(data).contains("Cuartetas");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String llamarUrl(String url) throws Exception {

		URL urlConnect = new URL(url);
		URLConnection connection = urlConnect.openConnection();
		DataInputStream inStream = new DataInputStream(connection.getInputStream());
		return inStream.readLine();
	}

}
