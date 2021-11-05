package com.example.producingwebservice.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.producingwebservice.model.CategoriaProductoModel;
import com.example.producingwebservice.model.ProductoModel;
import com.example.producingwebservice.model.UsuarioModel;

@Repository
public interface ProductoRepository extends CrudRepository<ProductoModel, Long>{
	public abstract Optional<ProductoModel> findByNombre(String nombre);
	public abstract Optional<ProductoModel> findByCategoria(CategoriaProductoModel categoria);
	public abstract Optional<ProductoModel> findByVendedor(UsuarioModel vendedor);
	
	@Query(nativeQuery=true,value="SELECT * from producto p where p.stock_actual > 0 and activo = 1")
	public abstract Iterable<ProductoModel> findAllWithStock();
	
	@Query(nativeQuery=true,value="SELECT * from producto p where p.fk_usuario =:id")
	public abstract Iterable<ProductoModel> findAllByIdVendedor(long id);
	
	@Query(nativeQuery=true,value="SELECT * from producto p where p.nombre like CONCAT('%',:name,'%')")
	public abstract Iterable<ProductoModel> findAllByName(@Param("name") String name);
}
