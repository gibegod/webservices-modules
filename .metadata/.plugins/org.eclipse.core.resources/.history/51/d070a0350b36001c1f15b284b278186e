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
@Table(name = "tarjeta")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class TarjetaModel {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter private Long id;
	@Getter @Setter private float limiteMensual;
	@Getter @Setter private float saldo;
	@Getter @Setter private String numero;
	@Getter @Setter private String cvc;
	@Getter @Setter private String tipo;
	@Getter @Setter private String nombre;
	@Getter @Setter private Date vencimiento;
	@ManyToOne
	@JoinColumn(name = "FK_USUARIO", nullable = false, updatable = false)
	@Getter @Setter private UsuarioModel comprador;
}
