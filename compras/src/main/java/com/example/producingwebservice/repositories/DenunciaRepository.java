package com.example.producingwebservice.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.producingwebservice.model.DenunciaModel;

@Repository
public interface DenunciaRepository extends CrudRepository<DenunciaModel, Long>{

}
