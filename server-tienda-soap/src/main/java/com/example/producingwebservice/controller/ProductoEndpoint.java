package com.example.producingwebservice.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.producingwebservice.model.ProductoModel;
import com.example.producingwebservice.services.ProductoService;

import io.spring.guides.gs_producing_web_service.AddProductoRequest;
import io.spring.guides.gs_producing_web_service.AddProductoResponse;
import io.spring.guides.gs_producing_web_service.GetProductoRequest;
import io.spring.guides.gs_producing_web_service.GetProductoResponse;
import mapper.ProductoMapper;

@CrossOrigin(origins="http://127.0.0.1:5500" ,methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
@Endpoint
public class ProductoEndpoint {
	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";
	
	private ProductoService productoService;
	ProductoMapper productoMapper = new ProductoMapper();
	
	@Autowired
	public ProductoEndpoint (ProductoService productoService) {
		this.productoService = productoService;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductoRequest")
	@ResponsePayload
	public GetProductoResponse getProducto(@RequestPayload GetProductoRequest request) {
		GetProductoResponse response = new GetProductoResponse();
		Optional<ProductoModel> p = Optional.empty();
		p = productoService.buscarProducto(request.getName());
		if (p.isPresent()) {
			response.setProducto(productoMapper.toProductoXML(p.get(), true));
		}
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addProductoRequest")
	@ResponsePayload
	public AddProductoResponse addProducto(@RequestPayload AddProductoRequest request) {
		AddProductoResponse response = new AddProductoResponse();
		response.setEstado(productoService.guardarProducto(request.getProducto()));
		return response;
	}

}
