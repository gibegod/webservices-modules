package com.example.producingwebservice.external.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.producingwebservice.external.model.CuentaBancaria;

@Service
public class CuentaBancariaService {
	
	@Autowired
	private RestTemplate restTemplate;

	@Value("${banca.root.url}")
	private String rootUrl;
	
	public List<CuentaBancaria> getCuentasBancarias(Long idUsuario){
		String url = rootUrl + "/getCuentasBancarias?idVendedor=" + idUsuario;

		try {
			return Arrays.asList(restTemplate.getForObject(url, CuentaBancaria[].class));
		} catch (Exception e) {
			return new ArrayList<>();
		}
	}

}
