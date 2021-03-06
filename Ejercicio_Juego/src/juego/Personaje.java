package juego;

public abstract class Personaje {
	private String nombre;
	private Arma arma;
	private int vida;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Arma getArma() {
		return arma; 
	}

	public void setArma(Arma arma) {
		this.arma = arma;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		if (vida < 0) {
			this.vida = 0;
		} else {
			this.vida = vida;
		}
	}

	public abstract void atacar(Personaje p);

	@Override
	public String toString() {
		return " : " + nombre + "Arma: " + arma.getClass().getSimpleName() + ": " + vida;
	}
}
