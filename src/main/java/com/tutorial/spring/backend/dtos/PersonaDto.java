package com.tutorial.spring.backend.dtos;

public class PersonaDto {

	Integer id;
	String pnombre;
	String snombre;
	String papellido;
	String sapellido;
	Integer edad;

	public PersonaDto() {

	}

	public PersonaDto(Integer id) {
		this(id, null, null);
	}

	public PersonaDto(Integer id, String pnombre, String papellido) {
		this.id = id;
		this.pnombre = pnombre;
		this.papellido = papellido;
	}

	public PersonaDto(String pnombre, String papellido) {
		this(null, pnombre, papellido);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPnombre() {
		return pnombre;
	}

	public void setPnombre(String pnombre) {
		this.pnombre = pnombre;
	}

	public String getSnombre() {
		return snombre;
	}

	public void setSnombre(String snombre) {
		this.snombre = snombre;
	}

	public String getPapellido() {
		return papellido;
	}

	public void setPapellido(String papellido) {
		this.papellido = papellido;
	}

	public String getSapellido() {
		return sapellido;
	}

	public void setSapellido(String sapellido) {
		this.sapellido = sapellido;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

}
