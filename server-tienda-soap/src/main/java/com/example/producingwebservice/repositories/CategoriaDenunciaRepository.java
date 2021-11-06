package com.example.producingwebservice.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.producingwebservice.model.CategoriaDenunciaModel;

@Repository
public interface CategoriaDenunciaRepository extends CrudRepository<CategoriaDenunciaModel, Long>{
	
	public abstract Optional<CategoriaDenunciaModel> findByNombre(String nombre);

}
