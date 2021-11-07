package com.example.producingwebservice.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.producingwebservice.model.VentaItemModel;
import com.example.producingwebservice.model.VentaModel;

@Repository
public interface VentaItemRepository extends CrudRepository<VentaItemModel, Long>{
	
	public abstract List<VentaItemModel> findByVenta(VentaModel venta);

}
