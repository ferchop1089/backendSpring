package com.tutorial.spring.backend.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Person")
/*@NamedQueries({
	@NamedQuery(
		name = "Persona.findByNombres",
		query = "SELECT p FROM Persona p WHERE p.pnombre = :pnombre AND p.snombre = :snombre AND p.papellido = :papellido AND p.sapellido = :sapellido"
	)
})*/
public class Persona implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "fname", nullable = false, length = 100)
	private String pnombre; //varchar(100) not null,
	
	@Column(name = "sname", nullable = true, length = 100)
	private String snombre; //varchar(100)
	
	@Column(name = "fsurname", nullable = false, length = 100)
	private String papellido; //varchar(100) not null,
	
	@Column(name = "ssurname", nullable = true, length = 100)
	private String sapellido;  //varchar(100),
	
	@Column(name = "age", nullable = true, length = 3)
	private Integer edad; //int(5)

	
	public Persona() {
		
	}
	
	public Persona(Integer id) {
		this(id, null, null);
	}
	
	public Persona(Integer id, String pnombre, String papellido) {
		this.id = id;
		this.pnombre = pnombre;
		this.papellido = papellido;
	}
	
	public Persona(String pnombre, String papellido) {
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
