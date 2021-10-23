package com.example.consumingwebservice.mapper;

import java.util.List;

import com.example.consumingwebservice.dto.UsuarioDomicilioTarjetaDTO;
import com.example.consumingwebservice.wsdl.Domicilio;
import com.example.consumingwebservice.wsdl.Tarjeta;
import com.example.consumingwebservice.wsdl.Usuario;

public class UsuarioMapper {
	public UsuarioDomicilioTarjetaDTO toUsuarioDTO(Usuario user, List<Domicilio> addresses,List<Tarjeta> cards) {
		UsuarioDomicilioTarjetaDTO dto = new UsuarioDomicilioTarjetaDTO();
		dto.setId(user.getId());
		dto.setApellido(user.getApellido());
		dto.setUsuario(user.getUsuario());
		dto.setContrasenia(user.getContrasenia());
		dto.setDni(user.getDni());
		dto.setNombre(user.getNombre());
		dto.setTelefono(user.getTelefono());
		dto.setDomicilios(addresses);
		dto.setTarjetas(cards);
		
		return dto;
	}
}
