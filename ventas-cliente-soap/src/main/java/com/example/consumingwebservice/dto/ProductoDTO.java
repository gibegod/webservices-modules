package com.example.consumingwebservice.dto;

import java.math.BigDecimal;
import java.math.BigInteger;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductoDTO {
	
    private String nombre;
    private String descripcion;
    private String imagen;
    private BigDecimal precio;
    private BigInteger stockInicial;
    private BigInteger stockActual;
    private boolean activo;
    private String nombreCategoria;
    private Long idVendedor;
    private boolean debito;
    private boolean credito;

}
