package com.example.consumingwebservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.consumingwebservice.VentasClient;
import com.example.consumingwebservice.wsdl.AddProductoResponse;
import com.example.consumingwebservice.wsdl.GetProductoResponse;
import com.example.consumingwebservice.wsdl.GetProductosPorIdVendedorResponse;
import com.example.consumingwebservice.wsdl.GetProductosResponse;
import com.example.consumingwebservice.wsdl.Producto;
import com.example.consumingwebservice.wsdl.UpdateProductoResponse;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/productos")
public class ProductoController {
	
	@Autowired
	VentasClient ventasClient;
	
	@PostMapping(path= "/addProducto")
	public String addProducto(@RequestBody Producto producto) {
		AddProductoResponse response = ventasClient.addProducto(producto);
		return response.getEstado();
	}
	
	@GetMapping(path="/getProductoName={name}")
	public Producto getProductoPorNombre(@PathVariable("name") String name) {
		GetProductoResponse response = ventasClient.getProductoPorNombre(name);
		return response.getProducto();
	}
	
	@GetMapping(path = "/")
	public List<Producto> getProductos(){
		GetProductosResponse response = ventasClient.getProductos();
		return response.getProducto();
	}
	
	@GetMapping(path = "/{id}")
	public List<Producto> getProductosPorIdVendedor(@PathVariable("id") Long id){
		GetProductosPorIdVendedorResponse response = ventasClient.getProductosPorIdVendedor(id);
		return response.getProducto();
	}
	
	@PostMapping(path = "/updateProducto")
	public String updateProducto(@RequestBody Producto producto) {
		UpdateProductoResponse response = ventasClient.updateProducto(producto);
		return response.getEstado();
	}

}
