package com.example.producingwebservice.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.producingwebservice.model.ProductoMedioPagoModel;

@Repository
public interface ProductoMedioPagoRepository extends CrudRepository<ProductoMedioPagoModel, Long>{

}
