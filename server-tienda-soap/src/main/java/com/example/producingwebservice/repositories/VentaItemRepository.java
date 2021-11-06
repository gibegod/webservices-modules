package com.example.producingwebservice.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.producingwebservice.model.VentaItemModel;

@Repository
public interface VentaItemRepository extends CrudRepository<VentaItemModel, Long>{

}
