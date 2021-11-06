package com.example.consumingwebservice.dto;

import java.util.List;

import com.example.consumingwebservice.wsdl.Domicilio;
import com.example.consumingwebservice.wsdl.Tarjeta;
import com.example.consumingwebservice.wsdl.TipoUsuario;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class UsuarioDomicilioTarjetaDTO {
	private long id;
	private String nombre;
	private String apellido;
	private String dni;
	private String usuario;
	private String contrasenia;
	private String telefono;
	private TipoUsuario tipoUsuario;
	private List<Domicilio> domicilios;
	private List<Tarjeta> tarjetas;
}
