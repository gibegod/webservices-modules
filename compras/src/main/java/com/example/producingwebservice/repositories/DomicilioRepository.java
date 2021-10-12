package com.example.producingwebservice.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.producingwebservice.model.DomicilioModel;

@Repository
public interface DomicilioRepository extends CrudRepository<DomicilioModel, Long>{

}
