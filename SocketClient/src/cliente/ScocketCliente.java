package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ScocketCliente {

	public static final int PORT = 5555;
	public static final String IP_SERVER = "localhost";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String opc = "";
		
		do {
			System.out.println("Continuar con la operación?");
			opc = sc.nextLine();
			
			if (opc.equals("si")) {

				Socket socketCliente = null;
				InputStreamReader entrada = null;
				PrintStream salida = null;

				InetSocketAddress direccionServidor = new InetSocketAddress(IP_SERVER, PORT);

				try {
					socketCliente = new Socket();
					socketCliente.connect(direccionServidor);
					System.out.println("Conexión establecida" + IP_SERVER + " - " + PORT);

					entrada = new InputStreamReader(socketCliente.getInputStream());
					salida = new PrintStream(socketCliente.getOutputStream());

					System.out.println("Introduce dos números ");
					String num1 = sc.nextLine();
					String num2 = sc.nextLine();
					System.out.println("Introduce la operación: (1: Sumar, 2: Restar, 3: Multiplicar, 4: Dividir)");
					String operacion = sc.nextLine();

					String operandos = num1 + "-" + num2 + "-" + operacion;
					salida.println(operandos);

					BufferedReader bf = new BufferedReader(entrada);

					String result = bf.readLine();

					System.out.println("cliente: " + result);

				} catch (IOException e) {
				
					e.printStackTrace();
				}
			}
		} while (opc.equals("s"));
	}
}