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
import com.example.consumingwebservice.dto.ProductoDTO;
import com.example.consumingwebservice.mapper.ProductoMapper;
import com.example.consumingwebservice.wsdl.AddCategoriaProductoResponse;
import com.example.consumingwebservice.wsdl.AddProductoResponse;
import com.example.consumingwebservice.wsdl.CategoriaProducto;
import com.example.consumingwebservice.wsdl.GetCategoriasProductoResponse;
import com.example.consumingwebservice.wsdl.GetProductoPorIdResponse;
import com.example.consumingwebservice.wsdl.GetProductoResponse;
import com.example.consumingwebservice.wsdl.GetProductosPorIdVendedorResponse;
import com.example.consumingwebservice.wsdl.GetProductosPorNameResponse;
import com.example.consumingwebservice.wsdl.GetProductosResponse;
import com.example.consumingwebservice.wsdl.Producto;
import com.example.consumingwebservice.wsdl.UpdateProductoResponse;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/productos")
public class ProductoController {
	
	@Autowired
	private VentasClient ventasClient;
	
	@PostMapping(path= "/addProducto")
	public String addProducto(@RequestBody ProductoDTO producto) {
		AddProductoResponse response = ventasClient.addProducto(ProductoMapper.dtoToXML(producto));
		return response.getEstado();
	}
	
	@GetMapping(path="/ProductoId={id}")
	public Producto getProductoPorId(@PathVariable("id") Long id) {
		GetProductoPorIdResponse response = ventasClient.getProductoPorId(id);
		return response.getProducto();
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
	
	@GetMapping(path= "/name={name}")
	public List<Producto> getProductosPorName(@PathVariable("name") String name){
		GetProductosPorNameResponse response = ventasClient.getProductosPorName(name);
		return response.getProducto();
	}
	
	@PostMapping(path = "/updateProducto")
	public String updateProducto(@RequestBody Producto producto) {
		UpdateProductoResponse response = ventasClient.updateProducto(producto);
		return response.getEstado();
	}
	
	@PostMapping(path="/addCategoria")
	public String addCategoriaProducto(@RequestBody String categoria) {
		AddCategoriaProductoResponse response = ventasClient.addCategoriaProducto(categoria);
		return response.getEstado();
	}
	
	@GetMapping(path="/categorias")
	public List<CategoriaProducto> getCategoriasProducto(){
		GetCategoriasProductoResponse response = ventasClient.getCategoriasProducto();
		return response.getCategoriaProducto();
	}

}
