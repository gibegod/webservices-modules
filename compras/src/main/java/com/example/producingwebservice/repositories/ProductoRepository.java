package com.example.producingwebservice.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.producingwebservice.model.ProductoModel;

@Repository
public interface ProductoRepository extends CrudRepository<ProductoModel, Long>{

}
