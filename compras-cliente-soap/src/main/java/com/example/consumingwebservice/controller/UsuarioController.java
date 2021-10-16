package com.example.consumingwebservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.consumingwebservice.ComprasClient;
import com.example.consumingwebservice.wsdl.GetUsuarioResponse;
import com.example.consumingwebservice.wsdl.LoginValResponse;
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
	
	@GetMapping(path = "/login")// Solo para TEST - Pasarlo a POST
	public String validarUsuario(@RequestParam("user") String user , @RequestParam("pass") String pass) {
		LoginValResponse response = comprasClient.validator(user, pass);
		return response.getEstado();
	}
}
