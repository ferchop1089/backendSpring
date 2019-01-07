package com.tutorial.spring.backend.mappers;

import org.mapstruct.Mapper;

import com.tutorial.spring.backend.dtos.PersonaDto;
import com.tutorial.spring.backend.entities.Persona;

@Mapper(componentModel = "spring")
public interface PersonaMapper extends Converter<Persona, PersonaDto> {

}
