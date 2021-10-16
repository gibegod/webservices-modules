package com.example.producingwebservice.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.producingwebservice.model.CategoriaProductoModel;

public interface CategoriaProductoRepository extends CrudRepository<CategoriaProductoModel, Long>{
	public abstract Optional<CategoriaProductoModel> findByNombre(String nombre);
}
