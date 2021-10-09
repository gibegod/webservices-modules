package com.example.producingwebservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipousuario")
public class TipoUsuarioModel {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	
	private String tipo;
	public TipoUsuarioModel() {
		super();
		
	}
	public TipoUsuarioModel(Long id, String tipo) {
		super();
		this.id = id;
		this.tipo = tipo;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	

}
