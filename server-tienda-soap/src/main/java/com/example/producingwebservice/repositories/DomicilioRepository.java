package com.example.producingwebservice.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.producingwebservice.model.DomicilioModel;
import com.example.producingwebservice.model.UsuarioModel;

@Repository
public interface DomicilioRepository extends CrudRepository<DomicilioModel, Long>{
	public abstract Iterable<DomicilioModel> findByComprador(UsuarioModel comprador);
	
	@Query(nativeQuery=true,value="SELECT * from domicilio d where d.id = :id and d.activo = 1")
	public abstract Optional<DomicilioModel> findByIdActivo(long id);
	
}
