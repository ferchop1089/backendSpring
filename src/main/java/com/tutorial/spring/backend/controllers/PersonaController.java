package com.tutorial.spring.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.spring.backend.dtos.PersonaDto;
import com.tutorial.spring.backend.services.PersonaService;

@CrossOrigin
@RestController
@RequestMapping(path = "/servicios/v0")
public class PersonaController {

	@Autowired
	@Qualifier("personaService")
	private PersonaService service;

	public PersonaController() {
		// TODO Auto-generated constructor stub
	}

	@GetMapping(path = "/personas/{id}")
	public PersonaDto buscarPorId(@PathVariable("id") Integer id) {
		return service.buscarPorId(id)
				.orElseThrow(() -> new RuntimeException("No se encontró la persona por el id: " + id));
	} 

	@GetMapping(path = "/personas")
	public List<PersonaDto> buscarTodos() {
		return service.buscarTodos();
	}

	@PostMapping(path = "/personas")
	public PersonaDto crearPersona(@RequestBody PersonaDto persona) {
		return service.crear(persona).orElseThrow(() -> new RuntimeException("No fue posible crear la persona"));
	}

	@PutMapping(path = "/personas")
	public PersonaDto actualizarPersona(@RequestBody PersonaDto persona) {
		return service.actualizar(persona)
				.orElseThrow(() -> new RuntimeException("No fue posible actualizar la persona"));
	}

	@DeleteMapping(path = "/personas/{id}")
	public ResponseEntity<String> borrarPersonaPorId(@PathVariable("id") Integer id) {
		service.eliminarPorId(id);
		return new ResponseEntity<>("La persona ha sido eliminada", HttpStatus.OK);
	}

}
