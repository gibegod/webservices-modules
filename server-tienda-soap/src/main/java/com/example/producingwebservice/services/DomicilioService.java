package com.example.producingwebservice.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.producingwebservice.model.DomicilioModel;
import com.example.producingwebservice.model.UsuarioModel;
import com.example.producingwebservice.repositories.DomicilioRepository;
import com.example.producingwebservice.repositories.UsuarioRepository;
import com.example.producingwebservice.utils.Estado;

import io.spring.guides.gs_producing_web_service.Domicilio;
import mapper.DomicilioMapper;

@Service
public class DomicilioService {
	
	@Autowired
	private DomicilioRepository domicilioRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	private DomicilioMapper domicilioMap = new DomicilioMapper();

	public String guardarDomicilio(Domicilio domicilio) {
		
		Optional<UsuarioModel> usuario = usuarioRepository.findById(domicilio.getUsuario().getId());
		if(!usuario.isPresent()) {
			return "Error, usuario no encontrado!";			
		}
		
		DomicilioModel domicilioModel = domicilioMap.toDomicilioModel(domicilio);
		domicilioModel.setComprador(usuario.get());
		domicilioRepository.save(domicilioModel);
		
		return Estado.OK.name();
	}
	
	public ArrayList<DomicilioModel> buscarDomicilio(String userName) {
		ArrayList<DomicilioModel> domicilios = new ArrayList<DomicilioModel>();		
		Optional<UsuarioModel> usuario = usuarioRepository.findByUsuario(userName);
		
		if (usuario.isPresent()) { 
			domicilios = (ArrayList<DomicilioModel>) domicilioRepository.findByComprador(usuario.get());
		} 
		
		return domicilios;
	}


}
