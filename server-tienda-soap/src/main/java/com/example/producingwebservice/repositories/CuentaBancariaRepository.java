package com.example.producingwebservice.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.producingwebservice.model.CuentaBancariaModel;

@Repository
public interface CuentaBancariaRepository extends CrudRepository<CuentaBancariaModel, Long>{
	
	public abstract Optional<CuentaBancariaModel> findByIdCuentaBancaria(Long idCuentaBancaria);
	
}
