package com.restbasico.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restbasico.modelo.entidad.Juego;

@RestController
public class ServicioMensajes {
	
	@Autowired
	private Juego j1 = new Juego();
	
	@GetMapping("juego")
	private Juego juego() {
		return j1;
	}
	
	@PutMapping("modif")
	private String modificacion() {
		j1.setPrecio(j1.getPrecio() + 10);
		return "DONE";
	}
}