package juego;

public class Guerrero extends Personaje{
	private int fuerza;

	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}

	@Override
	public void atacar(Personaje p) {
		if (this.getArma() instanceof Espada) {
			System.out.println("Mi espada es critico");
			this.getArma().usar();
			p.setVida(p.getVida() - 25);

		} else if (this.getArma() instanceof Arco) {
			System.out.println("Mi arco es critico");
			this.getArma().usar();
			p.setVida(p.getVida() - 16);

		} else {
			
			p.setVida(p.getVida() - 17);
		}

	}
}
