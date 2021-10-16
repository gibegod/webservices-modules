package com.example.producingwebservice.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.producingwebservice.model.ReclamoModel;
import com.example.producingwebservice.model.UsuarioModel;

@Repository
public interface ReclamoRepository extends CrudRepository<ReclamoModel, Long>{
	public abstract Optional<ReclamoModel> findByComprador(UsuarioModel comprador);
}
