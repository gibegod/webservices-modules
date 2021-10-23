package com.example.producingwebservice.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.producingwebservice.model.CategoriaProductoModel;
import com.example.producingwebservice.model.ProductoModel;
import com.example.producingwebservice.model.UsuarioModel;
import com.example.producingwebservice.repositories.CategoriaProductoRepository;
import com.example.producingwebservice.repositories.ProductoRepository;
import com.example.producingwebservice.repositories.UsuarioRepository;

import io.spring.guides.gs_producing_web_service.Producto;
import mapper.ProductoMapper;

@Service
@Component
public class ProductoService {
	
	@Autowired
	ProductoRepository productoRepository;
	@Autowired
	CategoriaProductoRepository categoriaProductoRepository;
	@Autowired
	UsuarioRepository usuarioRepository;
	
	ProductoMapper productoMapper = new ProductoMapper();
	
	public Optional<ProductoModel> buscarProducto(String name){
		Optional<ProductoModel> foundProducto = Optional.empty();
		try {
			foundProducto = productoRepository.findByNombre(name);
		}catch(Exception e) {
			
		}
		return foundProducto;
	}
	
	public Optional<ProductoModel> buscarProducto(Long id){
		Optional<ProductoModel> foundProducto = Optional.empty();
		try {
			foundProducto = productoRepository.findById(id);
		}catch(Exception e) {
			
		}
		return foundProducto;
	}
	
	/*public Iterable<ProductoMedioPagoModel> traerMediosPago(long id){
		Iterable<ProductoMedioPagoModel> lstProdMediosPago = new ArrayList<>();
		Optional<ProductoModel> prodModelOP = buscarProducto(id);
		ProductoModel productoModel = prodModelOP.get();
		try {
			lstProdMediosPago = prodMedioPagoRepository.findByProducto(productoModel);
		}catch(Exception e) {
			
		}
		return lstProdMediosPago;
	}*/
	
	public Iterable<ProductoModel> traerProductos(){
		Iterable<ProductoModel> lstProductos = new ArrayList<>();
		try {
			lstProductos = productoRepository.findAll();
		}catch(Exception e) {
			
		}
		return lstProductos;
	}
	
	public String guardarProducto (Producto producto) {
		String estado="";
		Optional<CategoriaProductoModel> c = Optional.empty();
		Optional<UsuarioModel> u = Optional.empty();
		Optional<ProductoModel> foundProductoPorNombre = Optional.empty();
		CategoriaProductoModel categoriaSave = new CategoriaProductoModel();
		CategoriaProductoModel categoriaModel = new CategoriaProductoModel();
		UsuarioModel usuarioSave = new UsuarioModel();
		try {
			c = categoriaProductoRepository.findByNombre(producto.getCategoria().getNombre());
			u = usuarioRepository.findById(producto.getVendedor().getId());
			foundProductoPorNombre = productoRepository.findByNombre(producto.getNombre());
			System.out.println(foundProductoPorNombre);
		}catch(Exception e) {
			e.getMessage();
		}
		if (c.isPresent()) {
			categoriaSave = c.get();
		}else {
			categoriaModel.setNombre(producto.getCategoria().getNombre());
			categoriaSave = categoriaProductoRepository.save(categoriaModel);
		}
		
		usuarioSave = u.get();
		
		if (u.isPresent() && foundProductoPorNombre.isPresent()) {
			estado = "ERROR";
		}else {
			productoRepository.save(productoMapper.toProductoModel(producto, categoriaSave, usuarioSave));
			//prodMedioPagoRepository.save(new ProductoMedioPagoModel(productoModel, medioPagoRepository.findById(producto.getMedioPago().getId()).get()));
			
			estado = "OK";
		}
		return estado;
	}
	
	public String modificarProducto(Producto producto) {
		String estado="";
		Optional<CategoriaProductoModel> c = Optional.empty();
		Optional<UsuarioModel> u = Optional.empty();
		Optional<ProductoModel> foundProductoPorNombre = Optional.empty();
		CategoriaProductoModel categoriaSave = new CategoriaProductoModel();
		CategoriaProductoModel categoriaModel = new CategoriaProductoModel();
		UsuarioModel usuarioSave = new UsuarioModel();
		try {
			foundProductoPorNombre = productoRepository.findByNombre(producto.getNombre());
			c = categoriaProductoRepository.findByNombre(producto.getCategoria().getNombre());
			u = usuarioRepository.findById(producto.getVendedor().getId());
			
		}catch(Exception e) {
			e.getMessage();
		}
		if (c.isPresent()) {
			categoriaSave = c.get();
		}else {
			categoriaModel.setNombre(producto.getCategoria().getNombre());
			categoriaSave = categoriaProductoRepository.save(categoriaModel);
		}
		
		usuarioSave = u.get();
		
		if (u.isPresent() && !foundProductoPorNombre.isPresent()) {
			estado = "ERROR";
		}else {
			//preguntar si el stockActual == stockInicial
			if (producto.getStockActual() == producto.getStockInicial()) {
				//se puede actualizar todo
				productoRepository.save(productoMapper.toProductoModel(producto, categoriaSave, usuarioSave));
				estado = "OK";
			}else {
				//solo se puede actualizar el stock y el medio de pago
				ProductoModel productoModel = new ProductoModel();
				productoModel.setStockActual(producto.getStockActual().intValue());
				productoModel.setDebito(producto.isDebito());
				productoModel.setCredito(producto.isCredito());
				productoRepository.save(productoMapper.toProductoModel(producto, categoriaSave, usuarioSave));
				estado = "OK";				
			}
		}		
		return estado;
	}

}
