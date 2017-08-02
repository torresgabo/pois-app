package ar.com.curso.poi.kata.tdd;

public class Cerradura {
	private boolean cerrada;
	private int claveApertura;
	private int aperturaExistosa;
	private int aperturaFallida;
	private int fallosPermitidos;
	private boolean bloqueada;

	public Cerradura(int claveDeApertura, int cantidadDeFallosConsecutivosQueLaBloquean) {
		this.claveApertura = claveDeApertura;
		this.fallosPermitidos = cantidadDeFallosConsecutivosQueLaBloquean;
		this.aperturaExistosa = 0;
		this.aperturaFallida = 0;
		this.cerrada = true;
		this.bloqueada = false;

	}

	public boolean abrir(int clave) {
		if (clave == this.claveApertura) {
			this.cerrada = false;
			this.aperturaExistosa++;
			this.aperturaFallida = 0;
		} else {
			this.cerrada = true;
			this.aperturaFallida++;
		}

		if (this.cerrada == true) {
			if (this.aperturaFallida == this.fallosPermitidos) {
				this.cerrada = true;
				this.bloqueada = true;
			}
		}
		return this.cerrada;
	}

	public void cerrar() {
		this.cerrada = true;
	}

	public boolean estaAbierta() {
		if (this.cerrada == false) {
			return true;
		}
		return false;
	}

	public boolean fueBloqueada() {
		return this.bloqueada;
	}

	public boolean estaCerrada() {
		return this.cerrada;
	}

	public int contarAperturasExitosas() {
		return aperturaExistosa;
	}

	public int contarAperturasFallidas() {
		return aperturaFallida;
	}
}
