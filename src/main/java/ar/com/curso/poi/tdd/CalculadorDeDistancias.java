package ar.com.curso.poi.tdd;

public class CalculadorDeDistancias {

	public static double distanciaCoord(double lat1, double lng1, double lat2, double lng2) {
		// double radioTierra = 3958.75;//en millas
		double radioTierra = 6371;// en kilómetros
		double dLat = Math.toRadians(lat2 - lat1);
		double dLng = Math.toRadians(lng2 - lng1);
		double sindLat = Math.sin(dLat / 2);
		double sindLng = Math.sin(dLng / 2);
		double va1 = Math.pow(sindLat, 2)
				+ Math.pow(sindLng, 2) * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));
		double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));
		double distancia = radioTierra * va2;

//		var x1=new google.maps.LatLng(50.995093,-16.417091);
//		var x2=new google.maps.LatLng(50.997698,-16.41788);
//		var distancia = google.maps.geometry.spherical.computeDistanceBetween(x1, x2);
		
		return distancia *1000;
	}

}
