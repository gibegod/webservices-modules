package com.example.producingwebservice.external.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TarjetaService {
	
	@Autowired
	private RestTemplate restTemplate;

	@Value("${rest.template.root.url}")
	private String rootUrl;
	
	public void validarTarjeta(Long idTarjeta, Long idUsuario) {
		Boolean valid = restTemplate.getForObject(rootUrl + "/validarPropietario?idComprador="+idUsuario+"&idTarjeta="+idTarjeta, Boolean.class);
		
		if(!valid) {
			throw new RuntimeException("Error validando tarjeta!");
		}
	}

}
