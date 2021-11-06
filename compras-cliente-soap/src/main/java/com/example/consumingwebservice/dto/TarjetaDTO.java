package com.example.consumingwebservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TarjetaDTO {
	
	private String numero;
	private String cvc;
    private Long idComprador;

}
