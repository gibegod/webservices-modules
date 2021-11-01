package com.example.consumingwebservice.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.consumingwebservice.ComprasClient;
import com.example.consumingwebservice.dto.DomicilioDTO;
import com.example.consumingwebservice.dto.UsuarioDomicilioTarjetaDTO;
import com.example.consumingwebservice.dto.UsuarioLoginDTO;
import com.example.consumingwebservice.mapper.DomicilioMapper;
import com.example.consumingwebservice.mapper.UsuarioMapper;
import com.example.consumingwebservice.wsdl.AddDomicilioResponse;
import com.example.consumingwebservice.wsdl.AddTarjetaResponse;
import com.example.consumingwebservice.wsdl.AddUsuarioResponse;
import com.example.consumingwebservice.wsdl.GetDomiciliosResponse;
import com.example.consumingwebservice.wsdl.GetTarjetasResponse;
import com.example.consumingwebservice.wsdl.GetUsuarioResponse;
import com.example.consumingwebservice.wsdl.LoginValResponse;
import com.example.consumingwebservice.wsdl.Tarjeta;
import com.example.consumingwebservice.wsdl.UpdateUsuarioResponse;
import com.example.consumingwebservice.wsdl.Usuario;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private ComprasClient comprasClient;
	
	private UsuarioMapper usermap = new UsuarioMapper();

	@GetMapping(path = "/{name}")
	public UsuarioDomicilioTarjetaDTO getUsuario(@PathVariable("name") String usuario) {
		GetUsuarioResponse user = comprasClient.getUser(usuario);
		
		UsuarioDomicilioTarjetaDTO dto = new UsuarioDomicilioTarjetaDTO();
		if (!Objects.isNull(user.getUsuario())) { 
			GetDomiciliosResponse addresses = comprasClient.getAddresses(user.getUsuario().getUsuario());
			GetTarjetasResponse cards = comprasClient.getCards(user.getUsuario().getUsuario());
			
			dto = usermap.toUsuarioDTO(user.getUsuario(), addresses.getDomicilio(), cards.getTarjeta());
		}
		
		return dto;
	}

	@PostMapping(path = "/login")
	public String validarUser(@RequestBody UsuarioLoginDTO usuario) {
		LoginValResponse response = comprasClient.validator(usuario.getUser(), usuario.getPass());
		return response.getEstado();
	}

	@PostMapping(path = "/update")
	public String modificarUser(@RequestBody Usuario usuario) {
		UpdateUsuarioResponse response = comprasClient.updateUser(usuario);
		return response.getEstado();
	}

	@PostMapping(path = "/register")
	public String registrarUser(@RequestBody Usuario usuario) {
		AddUsuarioResponse response = comprasClient.signInUser(usuario);
		return response.getEstado();
	}

	@PostMapping(path = "/domicilio")
	public String agregarDomicilio(@RequestBody DomicilioDTO domicilio) {
		AddDomicilioResponse response = comprasClient.addDomicilio(DomicilioMapper.dtoToXML(domicilio));
		return response.getEstado();
	}

	@PostMapping(path = "/tarjeta")
	public String agregaTarjeta(@RequestBody Tarjeta tarjeta) {
		AddTarjetaResponse response = comprasClient.addTarjeta(tarjeta);
		return response.getEstado();
	}
}
