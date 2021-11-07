package com.example.producingwebservice.model;

import java.util.Date;

import javax.persistence.Column;
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
@Getter
@Setter
public class ReclamoModel {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 100000)
	private String comentarioComprador;
	@Column(length = 100000)
	private String comentarioResolucion;
	private String estado;
	private Boolean aceptado;
	private Date fecha;
	
	@ManyToOne
	@JoinColumn(name = "id_venta")
	private VentaModel venta;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario_mesa_ayuda")
	private UsuarioModel usuarioMesaAyuda;

}
