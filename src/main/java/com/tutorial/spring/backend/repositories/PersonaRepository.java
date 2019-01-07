package com.tutorial.spring.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tutorial.spring.backend.entities.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {

	@Query(name = "Persona.findByNombres")
	public List<Persona> findByNombres(@Param("pnombre") String pnombre, @Param("snombre") String snombre,
			@Param("papellido") String papellido, @Param("sapellido") String sapellido);

	@Query(name = "Persona.findByEdad")
	public List<Persona> findByEdad(@Param("edad") Integer edad);

	@Query(name = "Persona.findByApellidos")
	public List<Persona> findByApellidos(@Param("papellido") String papellido, @Param("sapellido") String sapellido);

}
