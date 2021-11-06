package com.example.producingwebservice.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.producingwebservice.model.CategoriaProductoModel;
import com.example.producingwebservice.repositories.CategoriaProductoRepository;

import io.spring.guides.gs_producing_web_service.CategoriaProducto;

@Service
public class CategoriaProductoService {
	
	@Autowired
	CategoriaProductoRepository categoriaRepository;
	
	public String guardarCategoriaProducto(String categoria) {
		String estado="";
		Optional<CategoriaProductoModel> categoriaOptional = Optional.empty();
		CategoriaProductoModel cPModel = new CategoriaProductoModel();
		CategoriaProductoModel cPModelSave = new CategoriaProductoModel();
		try {
			categoriaOptional = categoriaRepository.findByNombre(categoria);
		}catch(Exception e){
			e.getMessage();
		}
		
		if (categoriaOptional.isPresent()) {
			estado = "ERROR, categoria existente";
		}else {
			cPModel.setNombre(categoria);
			cPModelSave = categoriaRepository.save(cPModel);
			estado = "OK";
		}
		return estado;
	}
	
	public Iterable<CategoriaProductoModel> traerCategoriasProducto(){
		Iterable<CategoriaProductoModel> lstCategoriasProducto = new ArrayList<>();
		try {
			lstCategoriasProducto = categoriaRepository.findAll();
		}catch(Exception e) {
			
		}
		return lstCategoriasProducto;
	}
	
	

}
