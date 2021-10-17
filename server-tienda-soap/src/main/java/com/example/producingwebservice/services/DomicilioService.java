package com.example.producingwebservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.producingwebservice.model.DomicilioModel;
import com.example.producingwebservice.model.UsuarioModel;
import com.example.producingwebservice.repositories.DomicilioRepository;
import com.example.producingwebservice.repositories.UsuarioRepository;

import io.spring.guides.gs_producing_web_service.Domicilio;
import mapper.DomicilioMapper;
import mapper.UsuarioMapper;

@Service
@Component
public class DomicilioService {
	@Autowired
	DomicilioRepository domicilioRepository;
	@Autowired
	UsuarioRepository usuarioRepository;
	DomicilioMapper domicilioMap = new DomicilioMapper();
	UsuarioMapper usuarioMap = new UsuarioMapper();

	public String guardarDomicilio(Domicilio domicilio) {
		String estado = "";
		Long idUser = domicilio.getComprador().getId();

		if (idUser == null) {
			estado = "ERROR";
		} else {
			if (usuarioRepository.findById(idUser).isPresent()) {
				UsuarioModel userModel = usuarioRepository.findById(idUser).get();
				DomicilioModel domicilioModel = new DomicilioModel();
				domicilioModel = domicilioMap.toDomicilioModel(domicilio);
				domicilioModel.setComprador(userModel);
				domicilioRepository.save(domicilioModel);
				estado="OK";
			} else
				estado = "ERROR";
		}
		return estado;
	}

}
