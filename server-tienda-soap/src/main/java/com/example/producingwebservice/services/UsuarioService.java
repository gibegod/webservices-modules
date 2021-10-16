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

import io.spring.guides.gs_producing_web_service.Usuario;
import mapper.UsuarioMapper;

@Service
@Component
public class UsuarioService {
	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	TipoUsuarioRepository tipoRepository;
	UsuarioMapper usuarioMap = new UsuarioMapper();

	public Optional<UsuarioModel> buscarUsuario(String name) {
		Optional<UsuarioModel> foundUsuario = Optional.empty();
		try {
			foundUsuario = usuarioRepository.findByNombre(name);
		} catch (Exception e) {
			
		}
		return foundUsuario;
	}

	public String guardarUsuario(Usuario usuario) {
		Optional<TipoUsuarioModel> t = Optional.empty();
		Optional<UsuarioModel> foundDni = Optional.empty();
		Optional<UsuarioModel> foundUsuario = Optional.empty();
		TipoUsuarioModel tModel = new TipoUsuarioModel();
		TipoUsuarioModel tSave = new TipoUsuarioModel();
		String estado = "";
		try {
			t = tipoRepository.findByTipo(usuario.getTipoUsuario().getTipo());
			foundDni = usuarioRepository.findByDni(usuario.getDni());
			foundUsuario = usuarioRepository.findByUsuario(usuario.getUsuario());
		} catch (Exception e) {
			e.getMessage();
		}
		if (t.isPresent()) {
			tSave = t.get();
		} else {
			tModel.setTipo(usuario.getTipoUsuario().getTipo());
			tSave = tipoRepository.save(tModel);
		}

		if (foundDni.isPresent() || foundUsuario.isPresent()) {
			estado = "ERROR";
		} else {
			// Guardo el usuario en la database
			UsuarioModel usuarioModel = new UsuarioModel();
			usuarioModel = usuarioRepository.save(usuarioMap.toUsuarioModel(usuario, tSave));
			estado = "OK";
		}
		return estado;
	}

	public String validarUsuario(String usuario, String contrasenia) {
		Optional<UsuarioModel> foundusuario = Optional.empty();
		Optional<UsuarioModel> foundcontrasenia = Optional.empty();
		String estado = "";
		try {
			foundcontrasenia = usuarioRepository.findByContrasenia(contrasenia);
			foundusuario = usuarioRepository.findByUsuario(usuario);
		} catch (Exception e) {
			e.getMessage();
		}
		estado = (foundcontrasenia.isPresent() && foundusuario.isPresent()) ? "OK" : "ERROR";

		return estado;
	}
}
