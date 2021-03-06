package com.restjuego.modelo.entidad;



public class Juego {
	private int id;
	private String nombre;
	private String compania;
	private double precio;
	private int puntuacion;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCompania() {
		return compania;
	}

	public void setCompania(String compania) {
		this.compania = compania;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	@Override
	public String toString() {
		return "Juego [id=" + id + ", nombre=" + nombre + ", compania=" + compania + ", precio=" + precio
				+ ", puntuacion=" + puntuacion + "]";
	}

}

