package Casa;

import java.util.ArrayList;

public class MainCasa {

	public static void main(String[] args) {

		Direccion direccionCasa = new Direccion();
		direccionCasa.setNombreVia("la pantomima");
		direccionCasa.setTipoVia("calle");
		direccionCasa.setCp("55555");
		direccionCasa.setNumero("5");
		
	
		Persona propietario = new Persona();
		propietario.setDireccion(direccionCasa);
		propietario.setDni("02343445i");
		propietario.setEdad(25);
		propietario.setNombre("Rigo");
		

		Habitacion banio = new Habitacion();
		banio.setM2(12);
		banio.setTipoHabitacion("Baño");
		
		Habitacion cocina = new Habitacion();
		cocina.setM2(32);
		cocina.setTipoHabitacion("Cocina");

		Persona inquilino1 = new Persona();
		inquilino1.setNombre("don felix");
		inquilino1.setDni("3265435r");
		inquilino1.setEdad(35);
		inquilino1.setDireccion(direccionCasa);
		
		Persona inquilino2 = new Persona();
		inquilino2.setNombre("manue");
		inquilino2.setDni("6545356t");
		inquilino2.setEdad(87);
		inquilino2.setDireccion(direccionCasa);

	
		Casa casa = new Casa();
		casa.setDireccion(direccionCasa);
		casa.setPrecio(600);
		casa.setPropietario(propietario);
		
		
		ArrayList<Habitacion> listaHabitaciones = new ArrayList<Habitacion>();
		listaHabitaciones.add(cocina);
		listaHabitaciones.add(banio);
		
		casa.setListaHabitaciones(listaHabitaciones);
		
	
		ArrayList<Persona> listaInquilinos = new ArrayList<Persona>();
		listaInquilinos.add(inquilino1);
		listaInquilinos.add(inquilino2);
		
		casa.setListaInquilinos(listaInquilinos);
	
		System.out.println(casa);
		
	}

}
