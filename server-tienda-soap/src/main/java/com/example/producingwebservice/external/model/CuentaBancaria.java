package com.example.producingwebservice.external.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CuentaBancaria {
	
	private Long idCuentaBancaria;
	private String banco;
	private Long idVendedor;
	private String alias;
	private String cbu;
	private String dni;
	private Float saldo;

}
