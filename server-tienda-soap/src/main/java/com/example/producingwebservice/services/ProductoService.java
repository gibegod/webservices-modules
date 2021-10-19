package com.example.producingwebservice.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.producingwebservice.model.CategoriaProductoModel;
import com.example.producingwebservice.model.ProductoMedioPagoModel;
import com.example.producingwebservice.model.ProductoModel;
import com.example.producingwebservice.model.UsuarioModel;
import com.example.producingwebservice.repositories.CategoriaProductoRepository;
import com.example.producingwebservice.repositories.MedioPagoRepository;
import com.example.producingwebservice.repositories.ProductoMedioPagoRepository;
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
	@Autowired
	ProductoMedioPagoRepository prodMedioPagoRepository;
	@Autowired
	MedioPagoRepository medioPagoRepository;
	
	ProductoMapper productoMapper = new ProductoMapper();
	
	public Optional<ProductoModel> buscarProducto(String name){
		Optional<ProductoModel> foundProducto = Optional.empty();
		try {
			foundProducto = productoRepository.findByNombre(name);
		}catch(Exception e) {
			
		}
		return foundProducto;
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
			ProductoModel productoModel = new ProductoModel();
			productoModel = productoRepository.save(productoMapper.toProductoModel(producto, categoriaSave, usuarioSave));
			prodMedioPagoRepository.save(new ProductoMedioPagoModel(productoModel, medioPagoRepository.findById(producto.getMedioPago().getId()).get()));
			estado = "OK";
		}
		return estado;
	}
	
	/*public String modificarProducto(Producto producto) {
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
		}catch(Exception e) {
			e.getMessage();
		}
		
		//puedo hacer update de todo, solo si el stockActual == stockInicial
		if (foundProductoPorNombre.get().getStockActual() == foundProductoPorNombre.get().getStockInicial()) {
			ProductoModel productoModel = new ProductoModel();
			productoModel = productoRepository.save(productoMapper.toProductoModel(producto, categoriaSave, usuarioSave));
			estado = "OK";
		}else {
			//solo se hace update del stock y del medio de pago
			estado = "OK";
		}
		
		return estado;
	}*/

}
