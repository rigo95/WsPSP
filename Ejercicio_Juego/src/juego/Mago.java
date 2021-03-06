package juego;

public class Mago extends Personaje{

	private int inteligencia;

	public int getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
	}

	@Override
	public void atacar(Personaje p) {
		if (this.getArma() instanceof Hechizo) {
			System.out.println("Mi hechizo es critico");
			this.getArma().usar();
			p.setVida(p.getVida() - 19);
			
		} else {
			System.out.println("Lanzando ataque ");
			this.getArma().usar();
			p.setVida(p.getVida() - 9);
		}

	}
}
