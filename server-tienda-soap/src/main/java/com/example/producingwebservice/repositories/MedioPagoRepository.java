package com.example.producingwebservice.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.producingwebservice.model.MedioPagoModel;

@Repository
public interface MedioPagoRepository extends CrudRepository<MedioPagoModel, Long>{

}
