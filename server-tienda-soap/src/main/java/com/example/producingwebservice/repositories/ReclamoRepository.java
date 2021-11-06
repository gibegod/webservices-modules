package com.example.producingwebservice.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.producingwebservice.model.ReclamoModel;

@Repository
public interface ReclamoRepository extends CrudRepository<ReclamoModel, Long>{
}
