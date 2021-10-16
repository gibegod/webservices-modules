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
@Table(name = "cuentaBancaria")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CuentaBancariaModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter private Long id;
	@Getter @Setter private String banco;
	@Getter @Setter private String alias;
	@Getter @Setter private String cvu;
	@Getter @Setter private String dni;
	@Getter @Setter private String movimientos;
	@ManyToOne
	@JoinColumn(name = "FK_USUARIO", nullable = false, updatable = false)
	@Getter @Setter private UsuarioModel vendedor;
}
