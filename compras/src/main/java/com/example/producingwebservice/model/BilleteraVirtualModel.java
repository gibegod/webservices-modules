package com.example.producingwebservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "billetera_virtual")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class BilleteraVirtualModel {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter private Long id;
	@Getter @Setter private Float saldo;
	@OneToOne
	@JoinColumn(name = "FK_USUARIO", nullable = false, updatable = false)
	@Getter @Setter private UsuarioModel vendedor;
	
}
