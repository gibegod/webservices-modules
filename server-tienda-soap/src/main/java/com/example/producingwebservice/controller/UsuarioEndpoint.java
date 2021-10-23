package com.example.producingwebservice.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.producingwebservice.model.CuentaBancariaModel;
import com.example.producingwebservice.model.UsuarioModel;
import com.example.producingwebservice.services.CuentaBancariaService;
import com.example.producingwebservice.services.DomicilioService;
import com.example.producingwebservice.services.TarjetaService;
import com.example.producingwebservice.services.UsuarioService;

import io.spring.guides.gs_producing_web_service.AddCuentaBancariaRequest;
import io.spring.guides.gs_producing_web_service.AddCuentaBancariaResponse;
import io.spring.guides.gs_producing_web_service.AddUsuarioRequest;
import io.spring.guides.gs_producing_web_service.AddUsuarioResponse;
import io.spring.guides.gs_producing_web_service.GetCuentasBancariasRequest;
import io.spring.guides.gs_producing_web_service.GetCuentasBancariasResponse;
import io.spring.guides.gs_producing_web_service.GetUsuarioRequest;
import io.spring.guides.gs_producing_web_service.GetUsuarioResponse;
import io.spring.guides.gs_producing_web_service.LoginValRequest;
import io.spring.guides.gs_producing_web_service.LoginValResponse;
import io.spring.guides.gs_producing_web_service.UpdateUsuarioRequest;
import io.spring.guides.gs_producing_web_service.UpdateUsuarioResponse;
import mapper.CuentaBancariaMapper;
import mapper.DomicilioMapper;
import mapper.TarjetaMapper;
import mapper.UsuarioMapper;

@CrossOrigin(origins="http://127.0.0.1:5500" ,methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
@Endpoint
public class UsuarioEndpoint {
	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

	private UsuarioService usuarioService;
	UsuarioMapper usuarioMap = new UsuarioMapper();
	DomicilioMapper domicilioMap = new DomicilioMapper();
	CuentaBancariaMapper cuentaBancariaMap = new CuentaBancariaMapper();
	TarjetaMapper tarjetaMap = new TarjetaMapper();

	@Autowired
	DomicilioService domicilioService = new DomicilioService();
	@Autowired
	TarjetaService tarjetaService = new TarjetaService();
	@Autowired
	CuentaBancariaService cuentaBancariaService = new CuentaBancariaService();

	@Autowired
	public UsuarioEndpoint(UsuarioService usuarioS) {
		this.usuarioService = usuarioS;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUsuarioRequest")
	@ResponsePayload
	public GetUsuarioResponse getUsuario(@RequestPayload GetUsuarioRequest request) {
		GetUsuarioResponse response = new GetUsuarioResponse(); 
		Optional<UsuarioModel> u = Optional.empty();
		u = usuarioService.buscarUsuario(request.getName());
		if(u.isPresent()) {
			response.setUsuario(usuarioMap.toUsuarioXML(u.get(),true));
		}
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addUsuarioRequest")
	@ResponsePayload
	public AddUsuarioResponse addUsuario(@RequestPayload AddUsuarioRequest request) {
		AddUsuarioResponse response = new AddUsuarioResponse();
		response.setEstado(usuarioService.guardarUsuario(request.getUsuario()));
		
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateUsuarioRequest")
	@ResponsePayload
	public UpdateUsuarioResponse updateUsuario(@RequestPayload UpdateUsuarioRequest request) {
		UpdateUsuarioResponse response = new UpdateUsuarioResponse();
		response.setEstado(usuarioService.modificarUsuario(request.getUsuario()));
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "loginValRequest")
	@ResponsePayload
	public LoginValResponse loginVal(@RequestPayload LoginValRequest request) {
		LoginValResponse response = new LoginValResponse();
		response.setEstado(usuarioService.validarUsuario(request.getUsuario(), request.getContrasenia()));
		
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCuentasBancariasRequest")
	@ResponsePayload
	public GetCuentasBancariasResponse getCuentasBancarias(@RequestPayload GetCuentasBancariasRequest request) {
		GetCuentasBancariasResponse response = new GetCuentasBancariasResponse();
		if (request.getUsuario() != null) {
			if (cuentaBancariaService.buscarCuentaBancaria(request.getUsuario())!= null) {
				for (CuentaBancariaModel item : cuentaBancariaService.buscarCuentaBancaria(request.getUsuario())) {
					response.getCuentaBancaria().add( cuentaBancariaMap.toCuentaBancariaXML(item));
				}
			}
		}
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addCuentaBancariaRequest")
	@ResponsePayload
	public AddCuentaBancariaResponse addCuentaBancaria(@RequestPayload AddCuentaBancariaRequest request) {
		AddCuentaBancariaResponse response = new AddCuentaBancariaResponse();
		response.setEstado(cuentaBancariaService.guardarCuentaBancaria(request.getCuentaBancaria()));
		return response;
	}

}
