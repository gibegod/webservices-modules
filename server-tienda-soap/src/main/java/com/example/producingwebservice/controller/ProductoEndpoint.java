package com.example.producingwebservice.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.producingwebservice.model.CategoriaProductoModel;
import com.example.producingwebservice.model.ProductoModel;
import com.example.producingwebservice.services.CategoriaProductoService;
import com.example.producingwebservice.services.ProductoService;

import io.spring.guides.gs_producing_web_service.AddCategoriaProductoRequest;
import io.spring.guides.gs_producing_web_service.AddCategoriaProductoResponse;
import io.spring.guides.gs_producing_web_service.AddProductoRequest;
import io.spring.guides.gs_producing_web_service.AddProductoResponse;
import io.spring.guides.gs_producing_web_service.GetCategoriasProductoRequest;
import io.spring.guides.gs_producing_web_service.GetCategoriasProductoResponse;
import io.spring.guides.gs_producing_web_service.GetProductoPorIdRequest;
import io.spring.guides.gs_producing_web_service.GetProductoPorIdResponse;
import io.spring.guides.gs_producing_web_service.GetProductoRequest;
import io.spring.guides.gs_producing_web_service.GetProductoResponse;
import io.spring.guides.gs_producing_web_service.GetProductosPorIdVendedorRequest;
import io.spring.guides.gs_producing_web_service.GetProductosPorIdVendedorResponse;
import io.spring.guides.gs_producing_web_service.GetProductosPorNameRequest;
import io.spring.guides.gs_producing_web_service.GetProductosPorNameResponse;
import io.spring.guides.gs_producing_web_service.GetProductosRequest;
import io.spring.guides.gs_producing_web_service.GetProductosResponse;
import io.spring.guides.gs_producing_web_service.UpdateProductoRequest;
import io.spring.guides.gs_producing_web_service.UpdateProductoResponse;
import mapper.CategoriaProductoMapper;
import mapper.ProductoMapper;

@CrossOrigin(origins="http://127.0.0.1:5500" ,methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
@Endpoint
public class ProductoEndpoint {
	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";
	
	ProductoMapper productoMapper = new ProductoMapper();
	CategoriaProductoMapper categoriaMapper = new CategoriaProductoMapper();
	
	@Autowired
	ProductoService productoService;
	@Autowired
	CategoriaProductoService categoriaProductoService;
	
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductoRequest")
	@ResponsePayload
	public GetProductoResponse getProducto(@RequestPayload GetProductoRequest request) {
		GetProductoResponse response = new GetProductoResponse();
		Optional<ProductoModel> p = productoService.buscarProducto(request.getName());
		if (p.isPresent()) {
			response.setProducto(productoMapper.toProductoXML(p.get(), true));
		}
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductoPorIdRequest")
	@ResponsePayload
	public GetProductoPorIdResponse getProducto(@RequestPayload GetProductoPorIdRequest request) {
		GetProductoPorIdResponse response = new GetProductoPorIdResponse();
		Optional<ProductoModel> p = productoService.buscarProducto(request.getId());
		if (p.isPresent()) {
			response.setProducto(productoMapper.toProductoXML(p.get(), true));
		}
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductosRequest")
	@ResponsePayload
	public GetProductosResponse getProductos(@RequestPayload GetProductosRequest request) {
		GetProductosResponse response = new GetProductosResponse();
		Iterable<ProductoModel> lstProductos = productoService.traerProductos();
		for (ProductoModel p : lstProductos) {
			response.getProducto().add(productoMapper.toProductoXML(p, true));
		}		
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductosPorIdVendedorRequest")
	@ResponsePayload
	public GetProductosPorIdVendedorResponse getProductos(@RequestPayload GetProductosPorIdVendedorRequest request) {
		GetProductosPorIdVendedorResponse response = new GetProductosPorIdVendedorResponse();
		Iterable<ProductoModel> lstProductos = productoService.traerProductosPorVendedor(request.getId());
		for (ProductoModel p : lstProductos) {
			response.getProducto().add(productoMapper.toProductoXML(p, true));
		}		
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductosPorNameRequest")
	@ResponsePayload
	public GetProductosPorNameResponse getProductosPorName(@RequestPayload GetProductosPorNameRequest request) {
		GetProductosPorNameResponse response = new GetProductosPorNameResponse();
		Iterable<ProductoModel> lstProductos = productoService.traerProductosPorName(request.getName());
		for (ProductoModel p : lstProductos) {
			response.getProducto().add(productoMapper.toProductoXML(p, true));
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
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateProductoRequest")
	@ResponsePayload
	public UpdateProductoResponse updateProducto(@RequestPayload UpdateProductoRequest request) {
		UpdateProductoResponse response = new UpdateProductoResponse();
		response.setEstado(productoService.modificarProducto(request.getProducto()));
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addCategoriaProductoRequest")
	@ResponsePayload
	public AddCategoriaProductoResponse addCategoriaProducto(@RequestPayload AddCategoriaProductoRequest request) {
		AddCategoriaProductoResponse response = new AddCategoriaProductoResponse();
		response.setEstado(categoriaProductoService.guardarCategoriaProducto(request.getCategoriaProducto()));
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCategoriasProductoRequest")
	@ResponsePayload
	public GetCategoriasProductoResponse getCategoriasProducto(@RequestPayload GetCategoriasProductoRequest request) {
		GetCategoriasProductoResponse response = new GetCategoriasProductoResponse();
		Iterable<CategoriaProductoModel> lstCategoriasProducto = categoriaProductoService.traerCategoriasProducto();
		for (CategoriaProductoModel cpM : lstCategoriasProducto) {
			response.getCategoriaProducto().add(categoriaMapper.toCategoriaProductoXML(cpM));
		}
		return response;
	}

}
