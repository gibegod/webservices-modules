package com.example.consumingwebservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.consumingwebservice.VentasClient;
import com.example.consumingwebservice.wsdl.AddProductoResponse;
import com.example.consumingwebservice.wsdl.AddUsuarioResponse;
import com.example.consumingwebservice.wsdl.GetProductoPorIdResponse;
import com.example.consumingwebservice.wsdl.GetProductoResponse;
import com.example.consumingwebservice.wsdl.GetProductosResponse;
import com.example.consumingwebservice.wsdl.Producto;
import com.example.consumingwebservice.wsdl.Usuario;

@RestController
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	VentasClient ventasClient;
	
	@GetMapping (path = "/productoName={name}")
	public Producto getProducto (@PathVariable("name") String name) {
		GetProductoResponse response = ventasClient.getProducto(name);
		return response.getProducto();
	}
	
	@GetMapping (path = "/productoId={id}")
	public Producto getProductoPorId (@PathVariable("id") long id) {
		GetProductoPorIdResponse response = ventasClient.getProductoPorId(id);
		return response.getProducto();
	}
	
	@GetMapping (path = "/productos")
	public List<Producto> getProductos () {
		GetProductosResponse response = ventasClient.getProductos();
		return response.getProducto();
	}
	
	@PostMapping(path = "/addProducto")
	public String addProducto(@RequestBody Producto producto) {
		AddProductoResponse response = ventasClient.addProducto(producto);
		return response.getEstado();
	}
	
	/*@PostMapping(path = "/updateProducto")
	public String updateProducto(@RequestBody Producto producto) {
		AddProductoResponse response = ventasClient.updateProducto(producto);
		return response.getEstado();
	}*/

}
