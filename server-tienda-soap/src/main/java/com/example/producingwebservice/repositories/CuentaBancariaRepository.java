package com.example.producingwebservice.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.producingwebservice.model.CuentaBancariaModel;
import com.example.producingwebservice.model.UsuarioModel;

public interface CuentaBancariaRepository extends CrudRepository<CuentaBancariaModel, Long>{
	public abstract Iterable<CuentaBancariaModel> findByVendedor(UsuarioModel vendedor);
}