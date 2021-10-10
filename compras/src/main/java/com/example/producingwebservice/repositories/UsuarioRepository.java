package com.example.producingwebservice.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.producingwebservice.model.UsuarioModel;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long>{
	public abstract UsuarioModel findByNombre(String name);
	
	public abstract Optional<UsuarioModel> findByDni(String dni);
	public abstract Optional<UsuarioModel> findByUsuario(String usuario);
	public abstract Optional<UsuarioModel> findByContrasenia(String contrasenia);

}
