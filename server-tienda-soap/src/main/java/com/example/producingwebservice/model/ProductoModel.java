package com.example.producingwebservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
public class ProductoModel {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter private Long id;
	@Getter @Setter private String nombre;
	@Getter @Setter private String descripcion;
	@Getter @Setter private String imagen;
	@Getter @Setter private Float precio;
	@Getter @Setter private Integer stockInicial;
	@Getter @Setter private Integer stockActual;
	@Getter @Setter private Boolean activo;
	
	@ManyToOne
	@JoinColumn(name = "FK_CATEGORIAPRODUCTO", nullable = false, updatable = false)
	@Getter @Setter private CategoriaProductoModel categoria;
	@ManyToOne
	@JoinColumn(name = "FK_USUARIO", nullable = false, updatable = false)
	@Getter @Setter private UsuarioModel vendedor;

}
