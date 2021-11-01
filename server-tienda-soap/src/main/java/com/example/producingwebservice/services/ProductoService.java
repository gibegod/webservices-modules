package com.example.producingwebservice.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.producingwebservice.model.CategoriaProductoModel;
import com.example.producingwebservice.model.ProductoModel;
import com.example.producingwebservice.model.UsuarioModel;
import com.example.producingwebservice.repositories.CategoriaProductoRepository;
import com.example.producingwebservice.repositories.ProductoRepository;
import com.example.producingwebservice.repositories.UsuarioRepository;
import com.example.producingwebservice.utils.Estado;

import io.spring.guides.gs_producing_web_service.Producto;
import mapper.ProductoMapper;

@Service
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
	
	public Iterable<ProductoModel> traerProductos(){
		Iterable<ProductoModel> lstProductos = new ArrayList<>();
		try {
			lstProductos = productoRepository.findAllWithStock();
		}catch(Exception e) {
			
		}
		return lstProductos;
	}
	
	public Iterable<ProductoModel> traerProductosPorVendedor(long id){
		Iterable<ProductoModel> lstProductos = new ArrayList<>();
		try {
			lstProductos = productoRepository.findAllByIdVendedor(id);
		}catch(Exception e) {
			
		}
		return lstProductos;
	}
	
	public Iterable<ProductoModel> traerProductosPorName(String name){
		Iterable<ProductoModel> lstProductos = new ArrayList<>();
		try {
			lstProductos = productoRepository.findAllByName(name);
		}catch(Exception e) {
			
		}
		return lstProductos;
	}
	
	public String guardarProducto (Producto producto) {
		if(productoRepository.findByNombre(producto.getNombre()).isPresent()) {
			return "Error, el producto ya existe!";
		}		
		
		Optional<UsuarioModel> vendedor = usuarioRepository.findById(producto.getVendedor().getId());
		if(!vendedor.isPresent()) {
			return "Error, vendedor no encontrado!";
		}
		
		Optional<CategoriaProductoModel> categoria = categoriaProductoRepository.findByNombre(producto.getCategoria().getNombre());
		if(!categoria.isPresent()) {
			CategoriaProductoModel categoriaModel = new CategoriaProductoModel();
			categoriaModel.setNombre(producto.getCategoria().getNombre());
			categoriaProductoRepository.save(categoriaModel);
			
			categoria = Optional.of(categoriaModel);
		}		
		
		
		productoRepository.save(productoMapper.toProductoModel(producto, categoria.get(), vendedor.get()));
		
		return Estado.OK.name();
	}
	
	public String modificarProducto(Producto producto) {
		String estado="";
		Optional<CategoriaProductoModel> c = Optional.empty();
		Optional<UsuarioModel> u = Optional.empty();
		Optional<ProductoModel> foundProductoPorNombre = Optional.empty();
		CategoriaProductoModel categoriaSave = new CategoriaProductoModel();
		CategoriaProductoModel categoriaModel = new CategoriaProductoModel();
		
		try {
			foundProductoPorNombre = productoRepository.findByNombre(producto.getNombre());
			c = categoriaProductoRepository.findByNombre(producto.getCategoria().getNombre());
			u = usuarioRepository.findById(producto.getVendedor().getId());			
		}catch(Exception e) {
			e.getMessage();
		}
		
		if (!foundProductoPorNombre.isPresent()) {
			estado = "ERROR, producto a actualizar no encontrado";
			return estado;
		}
		
		//puedo hacer update de todo, solo si el stockActual == stockInicial
		if (c.isPresent()) {
			categoriaSave = c.get();
		}else {
			categoriaModel.setNombre(producto.getCategoria().getNombre());
			categoriaSave = categoriaProductoRepository.save(categoriaModel);
		}
		
		//preguntar si el stockActual == stockInicial
		if (foundProductoPorNombre.get().getStockActual() == foundProductoPorNombre.get().getStockInicial()) {
			//se puede actualizar todo
			ProductoModel pM = productoRepository.findById(producto.getId()).orElseThrow(()->new RuntimeException("Producto no encontrado!"));
			pM = productoMapper.updateAll(pM, producto, categoriaSave, u.get());				
			productoRepository.save(pM);
			estado = "OK";
		}else {
			//solo se puede actualizar el stock y el medio de pago
			ProductoModel pM = productoRepository.findById(producto.getId()).orElseThrow(()->new RuntimeException("Producto no encontrado!"));
			pM = productoMapper.updateSomeFields(pM, producto);				
			productoRepository.save(pM);
			estado = "OK, sólo se actualizaron medios de pago y stock actual";				
		}
		
		return estado;
	}

}