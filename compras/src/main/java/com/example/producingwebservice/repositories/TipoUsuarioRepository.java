package com.example.producingwebservice.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.producingwebservice.model.TipoUsuarioModel;

@Repository
public interface TipoUsuarioRepository extends CrudRepository<TipoUsuarioModel, Long>{
	public abstract Optional<TipoUsuarioModel> findByTipo(String tipo);
}
