package com.example.producingwebservice.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.producingwebservice.model.TipoUsuarioModel;
import com.example.producingwebservice.model.UsuarioModel;
import com.example.producingwebservice.repositories.TipoUsuarioRepository;
import com.example.producingwebservice.repositories.UsuarioRepository;
import com.example.producingwebservice.utils.Estado;

import io.spring.guides.gs_producing_web_service.Usuario;
import mapper.UsuarioMapper;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private TipoUsuarioRepository tipoRepository;
	
	private UsuarioMapper usuarioMap = new UsuarioMapper();

	public Optional<UsuarioModel> buscarUsuario(String usuario) {		
		return usuarioRepository.findByUsuario(usuario);
	}

	public String guardarUsuario(Usuario usuario) {
		Optional<UsuarioModel> usr = usuarioRepository.findByUsuario(usuario.getUsuario());
		if(usr.isPresent()) {
			return "Error, usuario ya registrado";
		}
		
		usr = usuarioRepository.findByDni(usuario.getDni());		
		if(usr.isPresent()) {
			if(usr.get().getTipo().getTipo().equalsIgnoreCase(usuario.getTipoUsuario().getTipo())) {
				return "Error, DNI ya registrado";
			}			
		}	
		
		Optional<TipoUsuarioModel> tipoUsuario = tipoRepository.findByTipo(usuario.getTipoUsuario().getTipo());		
		TipoUsuarioModel newTipoUsuario = new TipoUsuarioModel();
		if(!tipoUsuario.isPresent()) {
			newTipoUsuario.setTipo(usuario.getTipoUsuario().getTipo());
			tipoRepository.save(newTipoUsuario);
		} else {
			newTipoUsuario = tipoUsuario.get();
		}
		
		usuarioRepository.save(usuarioMap.toUsuarioModel(usuario, newTipoUsuario));
		
		return Estado.OK.name();
	}

	public String modificarUsuario(Usuario usuario) { // Pre requisito: El usuario debe tener ID
		Optional<TipoUsuarioModel> t = Optional.empty();
		Optional<UsuarioModel> foundDni = Optional.empty();
		Optional<UsuarioModel> foundUsuario = Optional.empty();
		TipoUsuarioModel tModel = new TipoUsuarioModel();
		TipoUsuarioModel tSave = new TipoUsuarioModel();
		String estado = "";
		if (usuario.getId() == null) {
			estado = "ERROR";
		} else {
			if (usuarioRepository.findById(usuario.getId()).isPresent()) {
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
					usuarioModel = usuarioMap.toUsuarioModel(usuario, tSave);
					usuarioModel.setId(usuario.getId());
					usuarioModel.setTelefono(usuario.getTelefono());
					usuarioRepository.save(usuarioModel);
					estado = "OK";
				}
			} else
				estado = "ERROR";
		}
		return estado;
	}

	public String validarUsuario(String usuario, String contrasenia) {
		String estado = "";
		if ((usuario == null) && (contrasenia == null)) {
			estado = "ERROR";
		} else {
			if (usuarioRepository.findByUsuario(usuario).isPresent()) {
				UsuarioModel usuarioModel = usuarioRepository.findByUsuario(usuario).get();
				estado = usuarioModel.getContrasenia().equals(contrasenia) ? "OK" : "ERROR";

			} else
				estado = "ERROR";
		}
		return estado;
	}
}
