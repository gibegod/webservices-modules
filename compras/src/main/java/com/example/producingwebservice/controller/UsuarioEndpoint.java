package com.example.producingwebservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.producingwebservice.services.UsuarioService;

import io.spring.guides.gs_producing_web_service.AddUsuarioRequest;
import io.spring.guides.gs_producing_web_service.AddUsuarioResponse;
import io.spring.guides.gs_producing_web_service.GetUsuarioRequest;
import io.spring.guides.gs_producing_web_service.GetUsuarioResponse;

@CrossOrigin(origins="http://127.0.0.1:5500" ,methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
@Endpoint
public class UsuarioEndpoint {
	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

	private UsuarioService usuarioService;

	@Autowired
	public UsuarioEndpoint(UsuarioService usuarioS) {
		this.usuarioService = usuarioS;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUsuarioRequest")
	@ResponsePayload
	public GetUsuarioResponse getUsuario(@RequestPayload GetUsuarioRequest request) {
		GetUsuarioResponse response = new GetUsuarioResponse();
		response.setUsuario(usuarioService.findUsuario(request.getName()));

		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addUsuarioRequest")
	@ResponsePayload
	public AddUsuarioResponse addUsuario(@RequestPayload AddUsuarioRequest request) {
		AddUsuarioResponse response = new AddUsuarioResponse();
		response.setUsuario(usuarioService.guardarUsuario(request.getUsuario()));
		
		return response;
	}

}
