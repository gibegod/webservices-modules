package com.example.producingwebservice.utils;

import lombok.Getter;

@Getter
public enum Estado {

	INICIADO ("INICIADO"), 
	OK ("OK"), 
	FINALIZADO ("FINALIZADO"),
	EN_PREPARACION ("EN_PREPARACION"),
	CANCELADO ("CANCELADO");
	
	private final String estado;
	
	private Estado(String estado) {
		this.estado = estado;
	}
	
}
