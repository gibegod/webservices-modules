package com.example.producingwebservice.external.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CorreoService {
	
	@Autowired
	private RestTemplate restTemplate;

	@Value("${correo.root.url}")
	private String rootUrl;
	
	public String enviarVenta(String dniUsuario, Long idVenta) {
		String url = rootUrl + "/envio?id_venta=" + idVenta + "&dni_destinatario=" + dniUsuario;
		
		return restTemplate.postForObject(url, null, String.class);		
	}

}
