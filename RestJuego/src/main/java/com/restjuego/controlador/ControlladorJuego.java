package com.restjuego.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restjuego.modelo.entidad.Juego;
import com.restjuego.modelo.persistencia.DaoJuego;

@RestController
public class ControlladorJuego {



		@Autowired
		private DaoJuego daoJuego;

		@GetMapping("juegos")
		public ResponseEntity<List<Juego>> listar() {
			List<Juego> lista = daoJuego.listado();
			ResponseEntity<List<Juego>> re = new ResponseEntity<List<Juego>>(lista, HttpStatus.OK);
			return re;
		}


		@GetMapping("juegos/{id}")
		public ResponseEntity<Juego> consultar(@PathVariable("id") int id_juego) {
			System.out.println("El id del juego es: ");

			Juego j = daoJuego.buscar(id_juego);
			HttpStatus hs = null;
			if (j != null) {
				hs = HttpStatus.OK;
			} else {
				hs = HttpStatus.NOT_FOUND;
			}

			ResponseEntity<Juego> re = new ResponseEntity<Juego>(j, hs);
			return re;
		}

		
		@PostMapping("juegos")
		public ResponseEntity<Juego> altaVideojuego(@RequestBody Juego j) {
			Juego jAlta = daoJuego.alta(j);
			ResponseEntity<Juego> re = new ResponseEntity<Juego>(jAlta, HttpStatus.CREATED);
			return re;
		}


		@PutMapping("juegos/{id}")
		public ResponseEntity<Juego> modificar(@RequestBody Juego j, @PathVariable("id") int id_juego) {
			j.setId(id_juego);

			Juego jModificado = daoJuego.modificar(j);

			HttpStatus hs = null;
			if (jModificado != null) {
				hs = HttpStatus.OK;
			} else {
				hs = HttpStatus.NOT_FOUND;
			}

			ResponseEntity<Juego> re = new ResponseEntity<Juego>(jModificado, hs);
			return re;
		}

		
		@DeleteMapping("juegos/{id}")
		public ResponseEntity<Juego> borrar(@PathVariable("id") int id_juego) {
			Juego j = daoJuego.borrar(id_juego);

			HttpStatus hs = null;
			if (j != null) {
				hs = HttpStatus.OK;
			} else {
				hs = HttpStatus.NOT_FOUND;
			}

			ResponseEntity<Juego> re = new ResponseEntity<Juego>(j, hs);
			return re;

		}

	}
