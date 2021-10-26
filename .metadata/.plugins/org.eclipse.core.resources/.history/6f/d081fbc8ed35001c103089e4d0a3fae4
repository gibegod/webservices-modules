package com.example.producingwebservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.producingwebservice.services.VentaService;

import io.spring.guides.gs_producing_web_service.AddVentaRequest;
import io.spring.guides.gs_producing_web_service.AddVentaResponse;
import io.spring.guides.gs_producing_web_service.FinalizeVentaRequest;
import io.spring.guides.gs_producing_web_service.FinalizeVentaResponse;

@CrossOrigin(origins="http://127.0.0.1:5500" ,methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
@Endpoint
public class VentaEndpoint {
	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";
	
	@Autowired
	VentaService ventaService;
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addVentaRequest")
	@ResponsePayload
	public AddVentaResponse addVenta(@RequestPayload AddVentaRequest request) {
		AddVentaResponse response = new AddVentaResponse();
		response.setEstado(ventaService.guardarVenta(request.getIdPedido(), request.getIdVendedor()));
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "finalizeVentaRequest")
	@ResponsePayload
	public FinalizeVentaResponse finalizeVenta(@RequestPayload FinalizeVentaRequest request) {
		FinalizeVentaResponse response = new FinalizeVentaResponse();
		response.setEstado(ventaService.finalizarVenta(request.getIdVenta()));
		return response;
	} 

}
