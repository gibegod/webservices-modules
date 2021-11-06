package com.example.producingwebservice.external.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.producingwebservice.external.model.CuentaBancaria;
import com.example.producingwebservice.utils.Estado;

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
	
	public String transferirSaldo(Float saldo, Long idUsuario, Long idCuentaBancaria){
		List<CuentaBancaria> cuentasBancarias = getCuentasBancarias(idUsuario).stream()
				.filter(c -> c.getIdCuentaBancaria() == idCuentaBancaria)
				.collect(Collectors.toList());
		if(cuentasBancarias.isEmpty()) {
			return "Error actualizando saldo en servicio de banca! El usuario no posee cuentas!";			
		}		
		CuentaBancaria cuentaBancaria = cuentasBancarias.get(0);
		
		Float newSaldo = cuentaBancaria.getSaldo() + saldo;
		
		String url = rootUrl + "/transferir?idCuentaBancaria=" + idCuentaBancaria + "&saldo=" + newSaldo;
		
		if(!restTemplate.postForObject(url, null, Boolean.class)) {
			return "Error actualizando saldo en servicio de banca!";
		}
		
		return Estado.OK.name();
	}	

}
