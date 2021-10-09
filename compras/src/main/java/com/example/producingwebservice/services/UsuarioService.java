package com.example.producingwebservice.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.example.producingwebservice.model.TipoUsuarioModel;
import com.example.producingwebservice.model.UsuarioModel;
import com.example.producingwebservice.repositories.TipoUsuarioRepository;
import com.example.producingwebservice.repositories.UsuarioRepository;

import io.spring.guides.gs_producing_web_service.TipoUsuario;
import io.spring.guides.gs_producing_web_service.Usuario;

@Service
@Component
public class UsuarioService {
	// private static final Map<String, Usuario> users = new HashMap<>();
	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	TipoUsuarioRepository tipoRepository;

	public Usuario findUsuario(String name) {
		Assert.notNull(name, "El nombre del usuario no tiene que ser nulo");
		// Busco el usuario en la database
		UsuarioModel u = new UsuarioModel();
		u = usuarioRepository.findByNombre(name);
		// mapeo en el XML usuario
		Usuario usuarioXML = new Usuario();
		TipoUsuario tipoXML = new TipoUsuario();
		tipoXML.setTipo(u.getTipo().getTipo());
		usuarioXML.setNombre(u.getNombre());
		usuarioXML.setApellido(u.getApellido());
		usuarioXML.setDni(u.getDni());
		usuarioXML.setUsuario(u.getUsuario());
		usuarioXML.setContrasenia(u.getContrasenia());
		usuarioXML.setTipoUsuario(tipoXML);
		// users.put(usuarioXML.getNombre(), usuarioXML);

		return usuarioXML;
	}

	public Usuario guardarUsuario(Usuario usuario) {
		// Mapeo el XML usuario en el modelo
		UsuarioModel u = new UsuarioModel();
		Optional<TipoUsuarioModel> t = Optional.empty();
		TipoUsuarioModel tModel = new TipoUsuarioModel();
		TipoUsuarioModel tSave = new TipoUsuarioModel();
		TipoUsuario tipoUsuarioXML = new TipoUsuario();
		try {
			t = tipoRepository.findByTipo(usuario.getTipoUsuario().getTipo());

		} catch (Exception e) {
			e.getMessage();
		}
		if (t.isPresent()) {
			tipoUsuarioXML.setTipo(t.get().getTipo());
			tSave = t.get();
		} else {
			tModel.setTipo(usuario.getTipoUsuario().getTipo());
			tSave = tipoRepository.save(tModel);
			tipoUsuarioXML.setTipo(tSave.getTipo());
		}
		
		u.setNombre(usuario.getNombre());
		u.setApellido(usuario.getApellido());
		u.setDni(usuario.getDni());
		u.setUsuario(usuario.getUsuario());
		u.setContrasenia(usuario.getContrasenia());
		u.setTipo(tSave);
		// Guardo el usuario en la database
		UsuarioModel usuarioModel = new UsuarioModel();
		usuarioModel = usuarioRepository.save(u);
		
		// mapeo en el XML usuario
		Usuario usuariomap = new Usuario();
		usuariomap.setNombre(usuarioModel.getNombre());
		usuariomap.setApellido(usuarioModel.getApellido());
		usuariomap.setDni(usuarioModel.getDni());
		usuariomap.setUsuario(usuarioModel.getUsuario());
		usuariomap.setContrasenia(usuarioModel.getContrasenia());
		usuariomap.setTipoUsuario(tipoUsuarioXML);

		return usuariomap;

	}
}
