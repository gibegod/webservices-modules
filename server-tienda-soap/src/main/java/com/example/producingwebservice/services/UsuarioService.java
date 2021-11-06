package com.example.producingwebservice.services;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.producingwebservice.external.services.CuentaBancariaService;
import com.example.producingwebservice.model.BilleteraVirtualModel;
import com.example.producingwebservice.model.TipoUsuarioModel;
import com.example.producingwebservice.model.UsuarioModel;
import com.example.producingwebservice.repositories.BilleteraVirtualRepository;
import com.example.producingwebservice.repositories.TipoUsuarioRepository;
import com.example.producingwebservice.repositories.UsuarioRepository;
import com.example.producingwebservice.utils.Estado;

import io.spring.guides.gs_producing_web_service.BilleteraVirtual;
import io.spring.guides.gs_producing_web_service.BilleteraVirtualToCuentaBancariaRequest;
import io.spring.guides.gs_producing_web_service.Usuario;
import mapper.BilleteraVirtualMapper;
import mapper.UsuarioMapper;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private TipoUsuarioRepository tipoRepository;
	
	@Autowired
	private BilleteraVirtualRepository billeteraVirtualRepository;
	
	@Autowired
	private CuentaBancariaService cuentaBancariaService;
	
	private UsuarioMapper usuarioMap = new UsuarioMapper();

	public Optional<UsuarioModel> buscarUsuario(String usuario) {		
		return usuarioRepository.findByUsuario(usuario);
	}

	public String guardarUsuario(Usuario usuario) {
		Optional<UsuarioModel> usr = usuarioRepository.findByUsuario(usuario.getUsuario());
		if(usr.isPresent() && usr.get().getId() != usuario.getId()) {
			return "Error, usuario ya registrado";
		}
		
		if(!usuarioRepository.findByDni(usuario.getDni())
				.stream().filter(u -> u.getTipo().getTipo().equals(usuario.getTipoUsuario().getTipo()) && u.getId() != usuario.getId())
				.collect(Collectors.toList())
				.isEmpty()) {
			return "Error, DNI ya registrado para ese tipo de usuario";
		}
		
		Optional<TipoUsuarioModel> tipoUsuario = tipoRepository.findByTipo(usuario.getTipoUsuario().getTipo());		
		TipoUsuarioModel newTipoUsuario = new TipoUsuarioModel();
		if(!tipoUsuario.isPresent()) {
			newTipoUsuario.setTipo(usuario.getTipoUsuario().getTipo());
			tipoRepository.save(newTipoUsuario);
		} else {
			newTipoUsuario = tipoUsuario.get();
		}
		
		usuarioRepository.save(usuarioMap.toUsuarioModel(usuario, newTipoUsuario));
		
		return Estado.OK.name();
	}

	public String modificarUsuario(Usuario usr) {		
		Optional<UsuarioModel> usuario = usuarioRepository.findById(usr.getId());		
		if(!usuario.isPresent()) {
			return "Error, usuario no encontrado!";
		}
		
		usuario = usuarioRepository.findByUsuario(usr.getUsuario());
		if(usuario.isPresent() && usuario.get().getId() != usr.getId()) {
			return "Error, nombre de usuario ya existente!";
		}
		
		if(!usuarioRepository.findByDni(usr.getDni())
				.stream().filter(u -> u.getTipo().getTipo().equals(usr.getTipoUsuario().getTipo()) && u.getId() != usr.getId())
				.collect(Collectors.toList())
				.isEmpty()) {
			return "Error, DNI ya registrado para ese tipo de usuario";
		}
		
		Optional<TipoUsuarioModel> tipoUsuario = tipoRepository.findByTipo(usr.getTipoUsuario().getTipo());		
		TipoUsuarioModel newTipoUsuario = new TipoUsuarioModel();
		if(!tipoUsuario.isPresent()) {
			newTipoUsuario.setTipo(usr.getTipoUsuario().getTipo());
			tipoRepository.save(newTipoUsuario);
		} else {
			newTipoUsuario = tipoUsuario.get();
		}
		
		usuarioRepository.save(
				usuarioMap.toUsuarioModel(
						usuarioRepository.findById(usr.getId()).get(), newTipoUsuario, usr)
				);
		
		return Estado.OK.name();
	}

	public String validarUsuario(String usuario, String contrasenia) {
		String estado = "";
		if ((usuario == null) && (contrasenia == null)) {
			estado = "ERROR";
		} else {
			if (usuarioRepository.findByUsuario(usuario).isPresent()) {
				UsuarioModel usuarioModel = usuarioRepository.findByUsuario(usuario).get();
				estado = usuarioModel.getContrasenia().equals(contrasenia) ? "OK" : "ERROR";

			} else
				estado = "ERROR";
		}
		return estado;
	}
	
	public BilleteraVirtual getBilleteraVirtual(Long idVendedor) {	
		BilleteraVirtualModel billeteraVirtual = billeteraVirtualRepository.findByVendedor(
				usuarioRepository.findById(idVendedor).orElseThrow(()->new RuntimeException("Vendedor no encontrado!")))
				.orElse(null);
		
		return BilleteraVirtualMapper.toXML(billeteraVirtual);
	}
	
	public String billeteraVirtualToCuentaBancaria(BilleteraVirtualToCuentaBancariaRequest request) {	
		UsuarioModel vendedor = usuarioRepository.findById(request.getIdVendedor()).orElseThrow(()->new RuntimeException("Vendedor no encontrado!"));
		BilleteraVirtualModel billeteraVirtual = billeteraVirtualRepository.findByVendedor(vendedor).orElseThrow(()->new RuntimeException("Billetera no encontrada!"));
		
		if(billeteraVirtual.getSaldo() < request.getMonto().floatValue()) {
			return "Error, saldo insuficiente!";
		}
		
		String estadoBanca = cuentaBancariaService.transferirSaldo(request.getMonto().floatValue(), request.getIdVendedor(), request.getIdCuentaBancaria());
		
		if(estadoBanca.equals(Estado.OK.name())) {
			billeteraVirtual.setSaldo(billeteraVirtual.getSaldo() - request.getMonto().floatValue());
			billeteraVirtualRepository.save(billeteraVirtual);
		}				
		
		return estadoBanca;
	}
}
