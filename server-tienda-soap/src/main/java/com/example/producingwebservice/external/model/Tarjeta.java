package com.example.producingwebservice.external.model;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Tarjeta {
	
	private Long id;
	private String nombre;
	private String tipo;
	private float limiteMensual;
	private float saldo;
	private String numero;
	private String cvc;		
	private Date vencimiento;
	private Long dniUsuario;
	
}
