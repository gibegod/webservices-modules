package com.example.producingwebservice.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.producingwebservice.model.VentaModel;

@Repository
public interface VentaRepository extends CrudRepository<VentaModel, Long>{

}
