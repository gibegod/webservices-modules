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
@Table(name = "usuario")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UsuarioModel {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter private long id;
	@Getter @Setter private String nombre;
	@Getter @Setter private String apellido;
	@Getter @Setter private String dni;
	@Getter @Setter private String usuario;
	@Getter @Setter private String contrasenia;
	@Getter @Setter private String telefono;
	@ManyToOne
	@JoinColumn(name = "FK_TIPOUSUARIO", nullable = false)
	@Getter @Setter private TipoUsuarioModel tipo;
	
}
