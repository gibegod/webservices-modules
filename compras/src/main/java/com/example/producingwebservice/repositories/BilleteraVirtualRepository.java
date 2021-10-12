package com.example.producingwebservice.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.producingwebservice.model.BilleteraVirtualModel;

@Repository
public interface BilleteraVirtualRepository extends CrudRepository<BilleteraVirtualModel, Long> {

}
