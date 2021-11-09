package com.example.consumingwebservice.mapper;

import com.example.consumingwebservice.dto.ProductoDTO;
import com.example.consumingwebservice.wsdl.CategoriaProducto;
import com.example.consumingwebservice.wsdl.Producto;
import com.example.consumingwebservice.wsdl.Usuario;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ProductoMapper {
	
	public Producto dtoToXML(ProductoDTO producto) {
		Producto productoXML = new Producto();
		
		productoXML.setNombre(producto.getNombre());
		productoXML.setDescripcion(producto.getDescripcion());
		productoXML.setImagen(producto.getImagen());
		productoXML.setPrecio(producto.getPrecio());
		productoXML.setStockInicial(producto.getStockInicial());
		productoXML.setStockActual(producto.getStockActual());
		productoXML.setActivo(producto.isActivo());
		
		CategoriaProducto categoria = new CategoriaProducto();
		categoria.setNombre(producto.getNombreCategoria());
		productoXML.setCategoria(categoria);
		
		Usuario usuario = new Usuario();
		usuario.setId(producto.getIdVendedor());
		productoXML.setVendedor(usuario);
		
		productoXML.setDebito(producto.isDebito());
		productoXML.setCredito(producto.isCredito());
		
		return productoXML;
	}

}
