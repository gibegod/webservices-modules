package com.example.producingwebservice.external.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TarjetaService {
	
	@Autowired
	private RestTemplate restTemplate;

	@Value("${banca.root.url}")
	private String rootUrl;
	
	public void validarTarjeta(Long idTarjeta, Long idUsuario) {
		String url = rootUrl + "/validarPropietario?idComprador="+idUsuario+"&idTarjeta="+idTarjeta;
		Boolean valid = restTemplate.getForObject(url, Boolean.class);
		
		if(!valid) {
			throw new RuntimeException("Error validando tarjeta!");
		}
	}

}
