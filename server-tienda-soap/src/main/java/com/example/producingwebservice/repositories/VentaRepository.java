package com.example.producingwebservice.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.producingwebservice.model.VentaModel;

@Repository
public interface VentaRepository extends CrudRepository<VentaModel, Long>{
	
	@Query(nativeQuery=true,value="SELECT * from venta v where v.id_vendedor =:id")
	public abstract Iterable<VentaModel> findAllByIdVendedor(long id);
	
	@Query(nativeQuery=true,value="SELECT * from venta v where v.id_comprador =:id")
	public abstract Iterable<VentaModel> findAllByIdComprador(long id);

}
