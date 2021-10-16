package com.example.producingwebservice.model;

import java.util.Date;

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
@Table(name = "reclamo")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ReclamoModel {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter private Long id;
	@Getter @Setter private String comentarioComprador;
	@Getter @Setter private String estado;
	@Getter @Setter private String comentarioResolucion;
	@Getter @Setter private Date fecha;
	@ManyToOne
	@JoinColumn(name = "FK_USUARIO_COMPRADOR", nullable = false, updatable = false)
	@Getter @Setter private UsuarioModel comprador;
	@ManyToOne
	@JoinColumn(name = "FK_USUARIO_MESA", nullable = false, updatable = false)
	@Getter @Setter private UsuarioModel mesaAyuda;

}
