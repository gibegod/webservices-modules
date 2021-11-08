package com.example.consumingwebservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DomicilioDTO {
	
	private String calle;
	private String numero;
    private String piso;
    private String departamento;
    private String localidad;
    private String provincia;
    private String pais;
    private Long idUsuario;
    private Boolean activo;

}
