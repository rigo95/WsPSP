package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

	public static final int PORT = 5555;
	public static final String IP_SERVER = "localhost";
	
	public static void main(String[] args) {
	
		ServerSocket servidorSocket = null;
		Socket socketConexion = null;
		PrintStream salida = null;
		InputStreamReader entrada = null;
		
		try {
			servidorSocket = new ServerSocket();
			InetSocketAddress direccion = new InetSocketAddress(IP_SERVER, PORT);
			servidorSocket.bind(direccion);
			
			while (true) {
				socketConexion = servidorSocket.accept();
				
				entrada = new InputStreamReader(socketConexion.getInputStream());
				BufferedReader bf = new BufferedReader(entrada);
				
				String stringRecibido = bf.readLine();
				
				System.out.println(stringRecibido);
				
				String[] operadores = stringRecibido.split("-");
				int num1 = Integer.parseInt(operadores[0]);
				int num2 = Integer.parseInt(operadores[1]);
				int operacion = Integer.parseInt(operadores[2]);
				int res = 0;
				
				switch (operacion) {
				case 1:
					res = num1 + num2;					
					break;
					
				case 2:
					res = num1 - num2;					
					break;

				case 3:
					res = num1 * num2;
					break;
				
				case 4:
					res = num1 / num2;
					break;
					
				default:
					break;
				}			
				
				salida = new PrintStream(socketConexion.getOutputStream());
				salida.println(res);
				
			}
			
		} catch (IOException e) {
	
			e.printStackTrace();
		} finally {
			try {
				if (salida != null && entrada != null) {
					salida.close();
					entrada.close();
					socketConexion.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
}
