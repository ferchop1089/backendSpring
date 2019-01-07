package com.tutorial.spring.backend.mappers;

import java.util.List;

public interface Converter<E,D> {
	
	public D toDto(E entity);
	
	public List<D> toDtos(Iterable<E> entities);
	
	public E toEntity(D dto);
	
	public List<E> toEntities(List<D> dtos);
	
}