package com.example.consumingwebservice.dto;

import java.util.List;

import com.example.consumingwebservice.wsdl.Ventaitem;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class CategoriaProductoDTO {
	
	private String nombre;

}
