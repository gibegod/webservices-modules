package com.example.producingwebservice.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.producingwebservice.model.TarjetaModel;

@Repository
public interface TarjetaRepository extends CrudRepository<TarjetaModel, Long>{
	public abstract Optional<TarjetaModel> findByNumero(String numero);
}
