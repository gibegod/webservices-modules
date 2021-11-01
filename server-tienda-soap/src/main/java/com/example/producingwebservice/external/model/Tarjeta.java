package com.example.producingwebservice.external.model;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Tarjeta {
	
	private Long idTarjeta;
	private String nombre;
	private String tipo;
	private float limiteMensual;
	private float saldo;
	private String numero;
	private String cvc;		
	private LocalDate vencimiento;
	private Long dniUsuario;
	
}
