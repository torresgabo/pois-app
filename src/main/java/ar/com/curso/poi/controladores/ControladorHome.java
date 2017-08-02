package ar.com.curso.poi.controladores;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.google.gson.Gson;

import ar.com.curso.poi.tdd.PoiBean;
import ar.com.curso.poi.tdd.CalculadorDeDistancias;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.ws.rs.GET;

@Path("/")
public class ControladorHome {

	@GET
	@Path("/test")
	public String hola(){
		return "Test OK! Not OK!";
	}
	
	@GET
	@Path("/retoranpois")
	public String retoranpois(@PathParam("servicio") String servicio){
		Gson gson = new Gson();
		
		if (validaServicio(servicio)){
			List<PoiBean> obj = new PoiBean().getPois();
			String json = gson.toJson(obj); 
			return json;
		}else{
			Mensaje mensaje = new Mensaje();
			mensaje.setStatus("BAD");
			mensaje.setMensaje("Servicio no encontrado");
			return gson.toJson(mensaje);
		}
		
		
	}
	
	@GET
	@Path("/{servicio}/retornapoicercano/{longitud}/{latitud}")
	public String retornapoicercano(@PathParam("servicio") String servicio, @PathParam("longitud") String lon ,@PathParam("latitud") String lat){
		
		List<PoiBean> obj = PoiBean.filtraPois(servicio);
		Double  latitud = Double.parseDouble(lat);
		Double longitud =Double.parseDouble(lon);
		
		for (int i=0; i<obj.size(); i++){
			obj.get(i).setDistancia(CalculadorDeDistancias.distanciaCoord(latitud, longitud, Double.parseDouble(obj.get(i).getLatitud()), Double.parseDouble(obj.get(i).getLongitud())));
			
		}
		Collections.sort(obj,new Comparator<PoiBean>() {

			public int compare(PoiBean o1, PoiBean o2) {
				return (int) (o1.getDistancia()-o2.getDistancia());
			}
			
		});
		
		
		Gson gson = new Gson();
		
		if (validaServicio(servicio)){
			String json = gson.toJson(obj.isEmpty() ? obj:obj.get(0)); 
			return json;
		}else{
			Mensaje mensaje = new Mensaje();
			mensaje.setStatus("BAD");
			mensaje.setMensaje("Servicio no encontrado");
			return gson.toJson(mensaje);
		}
	}
	
	
	@GET
	@Path("/{servicio}/poisDeUnRadio/{longitud}/{latitud}/{radio}")
	public String poisDeUnRadio(@PathParam("servicio") String servicio, @PathParam("longitud") String lon ,@PathParam("latitud") String lat, @PathParam("radio") String rad){
	
		
		List<PoiBean> obj = PoiBean.filtraPois(servicio);
		Double  latitud = Double.parseDouble(lat);
		Double longitud =Double.parseDouble(lon);
		Integer radio =Integer.parseInt(rad);
		List<PoiBean> poisSegunRadio = new ArrayList<PoiBean>();
		
		for (int i=0; i<obj.size(); i++){
			obj.get(i).setDistancia(CalculadorDeDistancias.distanciaCoord(latitud, longitud, Double.parseDouble(obj.get(i).getLatitud()), Double.parseDouble(obj.get(i).getLongitud())));
			if (obj.get(i).getDistancia()<=radio) 
				poisSegunRadio.add(obj.get(i));
		}
				
		
		
		Gson gson = new Gson();
		
		if (validaServicio(servicio)){
			String json = gson.toJson(poisSegunRadio); 
			return json;
		}else{
			Mensaje mensaje = new Mensaje();
			mensaje.setStatus("BAD");
			mensaje.setMensaje("Servicio no encontrado");
			return gson.toJson(mensaje);
		}
		
	}
	
	
	
	public boolean validaServicio(String servicio){
		List<Servicios> listaServicio=Servicios.getServicios();
		for (int i=0;i<listaServicio.size();i++){
			if (listaServicio.get(i).getServicio().equals(servicio))
				return true;
		}
		return false;
	}
	
}





