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

import com.example.producingwebservice.external.model.CuentaBancaria;
import com.example.producingwebservice.model.CuentaBancariaModel;
import com.example.producingwebservice.model.UsuarioModel;
import com.example.producingwebservice.repositories.CuentaBancariaRepository;
import com.example.producingwebservice.repositories.UsuarioRepository;
import com.example.producingwebservice.utils.Estado;

import io.spring.guides.gs_producing_web_service.AddCuentaBancariaRequest;

@Service
public class CuentaBancariaService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private CuentaBancariaRepository cuentaBancariaRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

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
	
	public List<CuentaBancaria> getCuentasBancariasVinculadas(Long idUsuario){
		Optional<UsuarioModel> usuario = usuarioRepository.findById(idUsuario);
		List<CuentaBancaria> cuentasBancarias = new ArrayList<>();
		
		if(!usuario.isEmpty()) {
			List<CuentaBancariaModel> cuentasBancariasVinculadas = cuentaBancariaRepository.findByVendedor(usuario.get());
			getCuentasBancarias(idUsuario).forEach(cuenta -> {
				cuentasBancariasVinculadas.forEach(cuentaVinculada -> {
					if(cuenta.getIdCuentaBancaria() == cuentaVinculada.getIdCuentaBancaria()) {
						cuentasBancarias.add(cuenta);
					}
				});
			});
		}
		
		return cuentasBancarias;
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
	
	public String vincularCuentaBancaria(AddCuentaBancariaRequest request) {
		List<CuentaBancaria> cuentasBancarias = getCuentasBancarias(request.getIdUsuario());
		
		if(cuentasBancarias.isEmpty()) {
			return "Error, el usuario no posee cuentas en el servicio de banca!";
		}
		
		cuentasBancarias = cuentasBancarias.stream()
				.filter(c -> c.getCbu().equals(request.getCbu()))
				.collect(Collectors.toList());
		
		if(cuentasBancarias.isEmpty()) {
			return "Error, la cuenta con el CBU proporcionado no se encuentra en el servicio de banca!";
		}
		
		if(cuentaBancariaRepository.findByIdCuentaBancaria(cuentasBancarias.get(0).getIdCuentaBancaria()).isPresent()) {
			return "Error, la cuenta ya se encuentra vinculada!";
		}
		
		cuentaBancariaRepository.save(CuentaBancariaModel.builder()
				.idCuentaBancaria(cuentasBancarias.get(0).getIdCuentaBancaria())
				.vendedor(usuarioRepository.findById(request.getIdUsuario()).orElseThrow(() -> new RuntimeException("Usuario no encontrado!")))
				.build());
		
		return Estado.OK.name();
	}

}
