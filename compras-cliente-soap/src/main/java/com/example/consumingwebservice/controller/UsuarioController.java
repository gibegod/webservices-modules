package com.example.consumingwebservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.consumingwebservice.ComprasClient;
import com.example.consumingwebservice.dto.UsuarioLoginDTO;
import com.example.consumingwebservice.wsdl.GetUsuarioResponse;
import com.example.consumingwebservice.wsdl.LoginValResponse;
import com.example.consumingwebservice.wsdl.UpdateUsuarioResponse;
import com.example.consumingwebservice.wsdl.Usuario;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	@Autowired
	ComprasClient comprasClient;

	@GetMapping(path = "/{name}")
	public Usuario getUsuario(@PathVariable("name") String name) {
		GetUsuarioResponse response = comprasClient.getUser(name);
		return response.getUsuario();
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
}
