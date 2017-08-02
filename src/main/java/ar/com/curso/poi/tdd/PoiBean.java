package ar.com.curso.poi.tdd;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrador
 *
 */
public class PoiBean {
	private String longitud;
	private String latitud;
	private String nombre;
	private String descripcion;
	private String servicio;
	private double distancia;

	public PoiBean() {

	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}
	
	

	public String getServicio() {
		return servicio;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

	public List<PoiBean> getPois() {

		List<PoiBean> pois = new ArrayList();

		PoiBean item = new PoiBean();
		// 		long 		latitud
		//		-34.6033254,-58.3795235 Pizzería "Las Cuartetas"
		//		-34.5980574,-58.3870766 El Cuartito 
		//		-34.6041472,-58.3771743 El Palacio de la Pizza 
		//		-34.6088526,-58.3759679 Cabildo de Buenos Aires

		item.descripcion = "Pizzería 'Las Cuartetas'";
		item.latitud = "-58.3795235";
		item.longitud = "-34.6033254";
		item.nombre = "Pizzería 'Las Cuartetas'";
		item.servicio = "Buenos_Aires_Turismo";

		pois.add(item);

		item = new PoiBean();

		item.descripcion = "El Cuartito";
		item.latitud = "-58.3870766";
		item.longitud = "-34.5980574";
		item.nombre = "El Cuartito";
		item.servicio = "Buenos_Aires_Turismo";

		pois.add(item);

		item = new PoiBean();

		item.descripcion = "El Palacio de la Pizza";
		item.latitud = "-58.3771743";
		item.longitud = "-34.6041472";
		item.nombre = "El Palacio de la Pizza";
		item.servicio = "Buenos_Aires_Turismo";

		pois.add(item);

		item = new PoiBean();

		item.descripcion = "Cabildo de Buenos Aires";
		item.latitud = "-58.3759679";
		item.longitud = "-34.6088526";
		item.nombre = "Cabildo de Buenos Aires";
		item.servicio = "Buenos_Aires_Turismo";

		pois.add(item);

		return pois;
	}
	
	public static List<PoiBean> filtraPois(String servicio){
		List<PoiBean> listaPois = new PoiBean().getPois();
		for (int i=0;i<listaPois.size();i++){
			if(!listaPois.get(i).getServicio().equals(servicio)){
				listaPois.remove(i);
				i--;
			}
		}
		return listaPois;
	}

}
