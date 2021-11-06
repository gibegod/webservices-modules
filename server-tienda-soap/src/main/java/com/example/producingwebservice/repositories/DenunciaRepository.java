package com.example.producingwebservice.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.producingwebservice.model.CategoriaDenunciaModel;
import com.example.producingwebservice.model.DenunciaModel;
import com.example.producingwebservice.model.ProductoModel;
import com.example.producingwebservice.model.UsuarioModel;

@Repository
public interface DenunciaRepository extends CrudRepository<DenunciaModel, Long>{
	
	public abstract Optional<DenunciaModel> findByProducto(ProductoModel producto);
	public abstract Optional<DenunciaModel> findByCategoria(CategoriaDenunciaModel categoria);
	public abstract Optional<DenunciaModel> findByComprador(UsuarioModel comprador);
	
}
