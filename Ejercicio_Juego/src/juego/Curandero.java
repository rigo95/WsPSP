package juego;

public class Curandero extends Personaje{

	private int sabiduria;

	public int getSabiduria() {
		return sabiduria;
	}

	public void setSabiduria(int sabiduria) {
		this.sabiduria = sabiduria;
	}

	@Override
	public void atacar(Personaje p) {
		if (this.getArma() instanceof Rezos) {
			System.out.println("Mi rezo es critico");
			this.getArma().usar();
			p.setVida(p.getVida() - 21);

		} else {
		
			this.getArma().usar();
			p.setVida(p.getVida() - 6);
		}
	}

	@Override
	public String toString() {
		return super.toString() + " Sabiduría: " + sabiduria;
	}

}