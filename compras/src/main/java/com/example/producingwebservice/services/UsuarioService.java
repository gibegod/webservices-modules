package com.example.producingwebservice.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.example.producingwebservice.model.UsuarioModel;
import com.example.producingwebservice.repositories.UsuarioRepository;

import io.spring.guides.gs_producing_web_service.Usuario;

@Service
@Component
public class UsuarioService {
	private static final Map<String, Usuario> users = new HashMap<>();
	@Autowired
	UsuarioRepository usuarioRepository;

	public Usuario findUsuario(String name) {
		Assert.notNull(name, "El nombre del usuario no tiene que ser nulo");
		UsuarioModel u = new UsuarioModel();
		u = usuarioRepository.findByNombre(name);
		Usuario usuarioXML = new Usuario();
		usuarioXML.setNombre(u.getNombre());
		usuarioXML.setApellido(u.getApellido());
		usuarioXML.setDni(u.getDni());
		usuarioXML.setUsuario(u.getUsuario());
		usuarioXML.setContrasenia(u.getContrasenia());

		users.put(usuarioXML.getNombre(), usuarioXML);

		return users.get(name);
	}

	public Usuario guardarUsuario(Usuario usuario) {
		// Guardo en la database
		UsuarioModel u = new UsuarioModel();
		u.setNombre(usuario.getNombre());
		u.setApellido(usuario.getApellido());
		u.setDni(usuario.getDni());
		u.setUsuario(usuario.getUsuario());
		u.setContrasenia(usuario.getContrasenia());

		UsuarioModel usuarioModel = new UsuarioModel();
		usuarioModel = usuarioRepository.save(u);

		// mapeo en el xml country
		Usuario usuariomap = new Usuario();
		usuariomap.setNombre(usuarioModel.getNombre());
		usuariomap.setApellido(usuarioModel.getApellido());
		usuariomap.setDni(usuarioModel.getDni());
		usuariomap.setUsuario(usuarioModel.getUsuario());
		usuariomap.setContrasenia(usuarioModel.getContrasenia());

		return usuariomap;

	}
}
