package juego;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		

		Arma rezo = new Rezos();
		rezo.setTipo("aleluya");

		Arma espada1 = new Espada();
		espada1.setTipo("The best");



		Curandero c1 = new Curandero();
		c1.setVida(100);
		c1.setArma(espada1);
		c1.setSabiduria(90);

		Curandero c2 = new Curandero();
		Arma rezo2 = new Rezos();
		rezo.setTipo("aleluya");
		c2.setVida(100);
		c2.setArma(rezo2);
		c2.setSabiduria(22);

		Mago m1 = new Mago();
		m1.setNombre("Magordito");
		m1.setVida(100);
		m1.setArma(espada1);
		m1.setInteligencia(47);



		boolean continuar = true;
		String cont = "";
		int huida = 0;

		Personaje j1 = c1;
		Personaje j2 = c2;

		titulo();
	
		System.out.print(" player1: ");
		String player1 = sc.nextLine();
		j1.setNombre(player1);

		System.out.print("player2 : ");
		String player2 = sc.nextLine();
		j2.setNombre(player2);

		while (continuar) {

			if (j1.getVida() <= 0 || j2.getVida() <= 0) {
				continuar = false;
			} else {
				
				System.out.println(" player1: " + j1.getNombre() );
				System.out.print(j1.getNombre() + " pulsa cualquier boton para atacar o x para salir ");
				cont = sc.nextLine();

				if (cont.equalsIgnoreCase("x")) {
					continuar = false;
					huida = 1;

				} else {
					j1.atacar(j2);
					System.out.println();
					System.out.println(j1);
					System.out.println(j2);

					if (j2.getVida() <= 0) {
						continuar = false;

					} else {

						System.out.println("player2: " + j2.getNombre() );
						System.out
								.print(j2.getNombre() + " pulsa cualquier boton para atacar o x para salir ");
						cont = sc.nextLine();

						if (cont.equalsIgnoreCase("x")) {
							continuar = false;
							huida = 2;

						} else {
							j2.atacar(j1);
							System.out.println();
							System.out.println(j1);
							System.out.println(j2);

						}
					}
				}

			}
		}

		
		finalPartida();
		
		if (huida == 0) {
			if (j1.getVida() > 0) {
				System.out.println("player1 ha ganado la partida"+ j1.getNombre());
				
			} else {
				System.out.println("player2 ha ganado la partida" + j2.getNombre());
				 
			}

		} else if (huida == 1) {
			System.out.println(" player1 ha huido");
			System.out.println("player2 ha ganado la partida");

		} else if (huida == 2) {
			System.out.println("player2 ha huido");
			System.out.println("player1 ha ganado la partida ");
		}
		

		sc.close();
	}
	
	public static void titulo() { 
		System.out.println("FICGGHTTT");
	
	}
	
	public static void finalPartida() {
		System.out.println("ITS OVER");
		
	}

}
