package com.example.consumingwebservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DenunciaDTO {
    
    private Long idCategoria;
    private Long idProducto;
    private Long idComprador;
    private String comentario;

}
