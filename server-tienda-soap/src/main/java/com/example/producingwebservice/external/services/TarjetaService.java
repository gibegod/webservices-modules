package com.example.producingwebservice.external.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.producingwebservice.external.model.Tarjeta;
import com.example.producingwebservice.model.TarjetaModel;
import com.example.producingwebservice.model.UsuarioModel;
import com.example.producingwebservice.repositories.TarjetaRepository;
import com.example.producingwebservice.repositories.UsuarioRepository;
import com.example.producingwebservice.utils.Estado;
import com.example.producingwebservice.utils.TipoTarjeta;

import io.spring.guides.gs_producing_web_service.AddTarjetaRequest;

@Service
public class TarjetaService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private TarjetaRepository tarjetaRepository;
	
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
	
	public List<Tarjeta> getTarjetasVinculadas(Long idUsuario) {
		Optional<UsuarioModel> usuario = usuarioRepository.findById(idUsuario);
		List<Tarjeta> tarjetas = new ArrayList<>();
		
		if(!usuario.isEmpty()) {
			List<TarjetaModel> tarjetasVinculadas = tarjetaRepository.findByComprador(usuario.get());
			getTarjeta(idUsuario).forEach(tarjeta -> {
				tarjetasVinculadas.forEach(tarjetaVinculada -> {
					if(tarjeta.getIdTarjeta() == tarjetaVinculada.getIdTarjeta()) {
						tarjetas.add(tarjeta);
					}
				});
			});
		}
		
		return tarjetas;		
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
	
	public String vincularTarjeta(AddTarjetaRequest request) {
		List<Tarjeta> tarjetas = getTarjeta(request.getTarjeta().getUsuario().getId());
		
		if(tarjetas.isEmpty()) {
			return "Error, el usuario no posee tarjetas en el servicio de banca!";
		}
		
		tarjetas = tarjetas.stream()
				.filter(t -> t.getNumero().equals(request.getTarjeta().getNumero()) && t.getCvc().equals(request.getTarjeta().getCvc()))
				.collect(Collectors.toList());
		
		if(tarjetas.isEmpty()) {
			return "Error, los datos ingresados no corresponden con alguna tarjeta registrada!";
		}
		
		if(tarjetaRepository.findByIdTarjeta(tarjetas.get(0).getIdTarjeta()).isPresent()) {
			return "Error, la tarjeta ya se encuentra vinculada!";
		}
		
		tarjetaRepository.save(TarjetaModel.builder()
				.idTarjeta(tarjetas.get(0).getIdTarjeta())
				.comprador(usuarioRepository.findById(request.getTarjeta().getUsuario().getId()).orElseThrow(() -> new RuntimeException("Usuario no encontrado!")))
				.build());
		
		return Estado.OK.name();
	}

}
