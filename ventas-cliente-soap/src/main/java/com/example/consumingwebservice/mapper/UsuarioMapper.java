package com.example.consumingwebservice.mapper;

import java.util.List;

import com.example.consumingwebservice.dto.UsuarioDomicilioCuentasBancariasDTO;
import com.example.consumingwebservice.wsdl.CuentaBancaria;
import com.example.consumingwebservice.wsdl.Domicilio;
import com.example.consumingwebservice.wsdl.Usuario;

public class UsuarioMapper {
	public UsuarioDomicilioCuentasBancariasDTO toUsuarioDTO(Usuario user, List<Domicilio> addresses,List<CuentaBancaria> bankAccounts) {
		UsuarioDomicilioCuentasBancariasDTO dto = new UsuarioDomicilioCuentasBancariasDTO();
		dto.setId(user.getId());
		dto.setApellido(user.getApellido());
		dto.setUsuario(user.getUsuario());
		dto.setContrasenia(user.getContrasenia());
		dto.setDni(user.getDni());
		dto.setNombre(user.getNombre());
		dto.setTelefono(user.getTelefono());
		dto.setDomicilios(addresses);
		dto.setCuentasBancarias(bankAccounts);
		
		return dto;
	}
}
