package com.tutorial.spring.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tutorial.spring.backend.dtos.PersonaDto;
import com.tutorial.spring.backend.mappers.PersonaMapper;
import com.tutorial.spring.backend.repositories.PersonaRepository;
import com.tutorial.spring.backend.utilities.Optional;

@Service
public class PersonaService {

	@Autowired
	@Qualifier("personaRepository")
	private PersonaRepository repository;

	@Autowired
	@Qualifier("personaMapperImpl")
	private PersonaMapper mapper;

	public PersonaService() {
		// TODO Auto-generated constructor stub
	}

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Optional<PersonaDto> buscarPorId(Integer id) {
		return Optional.of(repository.findById(id)).map(mapper::toDto);
	}

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PersonaDto> buscarTodos() {
		return mapper.toDtos(repository.findAll());
	}

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PersonaDto> buscarPorNombres(String pnombre, String snombre, String papellido, String sapellido) {
		return mapper.toDtos(repository.findByNombres(pnombre, snombre, papellido, sapellido));
	}

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PersonaDto> buscarPorEdad(Integer edad) {
		return mapper.toDtos(repository.findByEdad(edad));
	}

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PersonaDto> buscarPorApellidos(String papellido, String sapellido) {
		return mapper.toDtos(repository.findByApellidos(papellido, sapellido));
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Optional<PersonaDto> actualizar(PersonaDto persona) {
		return Optional.ofNullable(mapper.toDto(repository.save(mapper.toEntity(persona))));
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Optional<PersonaDto> crear(PersonaDto persona) {
		return actualizar(persona);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void eliminar(PersonaDto persona) {
		repository.delete(mapper.toEntity(persona));
	}

}
