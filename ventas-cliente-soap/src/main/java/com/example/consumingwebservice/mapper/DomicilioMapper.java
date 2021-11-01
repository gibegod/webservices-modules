package com.example.consumingwebservice.mapper;

import com.example.consumingwebservice.dto.DomicilioDTO;
import com.example.consumingwebservice.wsdl.Domicilio;
import com.example.consumingwebservice.wsdl.Usuario;

import lombok.experimental.UtilityClass;

@UtilityClass
public class DomicilioMapper {
	
	public Domicilio dtoToXML(DomicilioDTO domicilioDTO) {
		Domicilio domicilio = new Domicilio(); 
		
		domicilio.setCalle(domicilioDTO.getCalle());
		domicilio.setNumero(domicilioDTO.getNumero());
		domicilio.setPiso(domicilioDTO.getPiso());
		domicilio.setDepartamento(domicilioDTO.getDepartamento());
		domicilio.setLocalidad(domicilioDTO.getLocalidad());
		domicilio.setProvincia(domicilioDTO.getProvincia());
		domicilio.setPais(domicilioDTO.getPais());
		
		Usuario usuario = new Usuario();
		usuario.setId(domicilioDTO.getIdUsuario());
		domicilio.setUsuario(usuario);
		
		return domicilio;
		
	}

}