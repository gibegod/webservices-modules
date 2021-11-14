package com.example.producingwebservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "producto")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class ProductoModel {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter private Long id;
	
	private String nombre;
	
	@Column(length = 100000) 
	private String descripcion;
	
	@Column(length = 100000) 
	private String imagen;
	
	private Float precio;
	private Integer stockInicial;
	private Integer stockActual;
	private Boolean activo;
	private Boolean debito;
	private Boolean credito;
	
	@ManyToOne
	@JoinColumn(name = "FK_CATEGORIAPRODUCTO", nullable = false, updatable = false)
	private CategoriaProductoModel categoria;
	
	@ManyToOne
	@JoinColumn(name = "FK_USUARIO", nullable = false, updatable = false)
	private UsuarioModel vendedor;
	
	@Transient
	private Integer cantidad;

}
