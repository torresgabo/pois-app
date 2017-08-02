package ar.com.curso.poi.controladores;

import java.util.ArrayList;
import java.util.List;

public class Servicios {
	private String servicio;
	
	public Servicios(String servicio) {
		this.servicio=servicio;
	}
	
	public static List<Servicios> getServicios(){
		List<Servicios> lista = new ArrayList<Servicios>();
		lista.add(new Servicios("Buenos_Aires_Turismo"));
		return lista;
	}

	public String getServicio() {
		return servicio;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
	}
	
	
}
