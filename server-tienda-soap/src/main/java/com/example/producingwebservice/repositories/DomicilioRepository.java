package com.example.producingwebservice.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.producingwebservice.model.DomicilioModel;
import com.example.producingwebservice.model.UsuarioModel;

@Repository
public interface DomicilioRepository extends CrudRepository<DomicilioModel, Long>{
	public abstract Optional<DomicilioModel> findByComprador(UsuarioModel comprador);

}
