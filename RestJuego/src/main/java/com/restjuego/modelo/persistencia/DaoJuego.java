package com.restjuego.modelo.persistencia;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.restjuego.modelo.entidad.Juego;

@Component
public class DaoJuego {

	private List<Juego> listaJuegos;
	private int cont = 0;

	public DaoJuego() {
		Juego j1 = new Juego();
		j1.setId(cont++);
		j1.setNombre("Metal Gear Solid V");
		j1.setCompania("Bethestha");
		j1.setPrecio(59.99);
		j1.setPuntuacion(10);

		Juego j2 = new Juego();
		j2.setId(cont++);
		j2.setNombre("Fifa 21");
		j2.setCompania("EA Sport");
		j2.setPrecio(59.69);
		j2.setPuntuacion(8);

		listaJuegos = new ArrayList<Juego>();
		listaJuegos.add(j1);
		listaJuegos.add(j2);
	}

	
	public List<Juego> listado() {
		return listaJuegos;
	}


	public Juego buscar(int id) {
		Juego j = null;
		for (Juego juego : listaJuegos) {
			if (juego.getId() == id) {
				j = juego;
				break;
			}
		}
		return j;
	}


	public Juego alta(Juego j) {
		j.setId(cont++);
		listaJuegos.add(j);
		return j;
	}

	
	public Juego modificar(Juego jModif) {
		Juego j = buscar(jModif.getId());
		if (j != null) {
			j.setNombre(jModif.getNombre());
			j.setCompania(jModif.getCompania());
			j.setPrecio(jModif.getPrecio());
			j.setPuntuacion(jModif.getPuntuacion());
		}
		return j;
	}

	
	public Juego borrar(int id) {
		Juego j = buscar(id);
		if (j != null) {
			listaJuegos.remove(id);
		}
		return j;
	}
}
