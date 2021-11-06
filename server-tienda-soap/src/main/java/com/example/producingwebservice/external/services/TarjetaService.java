package com.example.producingwebservice.external.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.producingwebservice.external.model.Tarjeta;
import com.example.producingwebservice.utils.Estado;
import com.example.producingwebservice.utils.TipoTarjeta;

@Service
public class TarjetaService {
	
	@Autowired
	private RestTemplate restTemplate;

	@Value("${banca.root.url}")
	private String rootUrl;
	
	public String validarTarjeta(Long idTarjeta, Long idUsuario, Float monto) {
		String url = rootUrl + "/validarPropietario?idComprador="+idUsuario+"&idTarjeta="+idTarjeta;
		Boolean valid = restTemplate.getForObject(url, Boolean.class);
		
		if(!valid) {
			return "Error validando tarjeta en servicio de banca!";
		}
		
		Tarjeta tarjeta = getTarjeta(idUsuario).stream()
				.filter(t -> t.getIdTarjeta() == idTarjeta)
				.collect(Collectors.toList()).get(0);
		if(tarjeta.getTipo().equals(TipoTarjeta.DEBITO.name()) && tarjeta.getSaldo() < monto) {
			return "Error, saldo insuficiente!";
		}
		if(tarjeta.getTipo().equals(TipoTarjeta.CREDITO.name()) && tarjeta.getLimiteMensual() < tarjeta.getSaldo() + monto) {
			return "Error, límite insuficiente!";
		}
		
		return Estado.OK.name();
	}
	
	public List<Tarjeta> getTarjeta(Long idUsuario) {
		String url = rootUrl + "/getTarjetas?idComprador=" + idUsuario;

		try {
			return Arrays.asList(restTemplate.getForObject(url, Tarjeta[].class));
		} catch (Exception e) {
			return new ArrayList<>();
		}
	}
	
	public void saldarCompra(Long idComprador, Long idTarjeta, Float precioTotal) {		
		Tarjeta tarjeta = getTarjeta(idComprador).stream()
				.filter(t -> t.getIdTarjeta() == idTarjeta)
				.collect(Collectors.toList()).get(0);
		
		float saldo = 0;
		if(tarjeta.getTipo().equals(TipoTarjeta.DEBITO.name())) {
			saldo = tarjeta.getSaldo() - precioTotal;			
		}
		else {
			saldo = tarjeta.getSaldo() + precioTotal;
		}
		
		String url = rootUrl + "/saldar?saldo=" + saldo + "&idTarjeta=" + idTarjeta;
		restTemplate.postForObject(url, null, Boolean.class);
	}

}
