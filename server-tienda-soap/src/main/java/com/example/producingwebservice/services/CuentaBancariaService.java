package com.example.producingwebservice.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.producingwebservice.model.CuentaBancariaModel;
import com.example.producingwebservice.model.DomicilioModel;
import com.example.producingwebservice.model.UsuarioModel;
import com.example.producingwebservice.repositories.CuentaBancariaRepository;
import com.example.producingwebservice.repositories.UsuarioRepository;

import io.spring.guides.gs_producing_web_service.CuentaBancaria;
import mapper.CuentaBancariaMapper;

@Service
@Component
public class CuentaBancariaService { //No distingue si es comprador o vendedor , falta definir el tipo ya que el banco solo va el vendedor
	@Autowired
	CuentaBancariaRepository cuentaBancariaRepository ;
	@Autowired
	UsuarioRepository usuarioRepository;
	CuentaBancariaMapper cuentaBancariaMapper = new CuentaBancariaMapper();
	
	public String guardarCuentaBancaria(CuentaBancaria cuentaBancaria) {
		String estado="";
		Long idUser = cuentaBancaria.getVendedor().getId();
		if ( idUser==null  ){
			estado="ERROR";
		}else {
			if( usuarioRepository.findById(idUser).isPresent()  ) {
				UsuarioModel userModel = usuarioRepository.findById(idUser).get();
				CuentaBancariaModel cuentaBancariaModel = new CuentaBancariaModel();
				cuentaBancariaModel = cuentaBancariaMapper.toCuentaBancariaModel(cuentaBancaria, false);
				cuentaBancariaModel.setVendedor(userModel);
				cuentaBancariaRepository.save(cuentaBancariaModel);
				estado="OK";
				
			}else estado="ERROR";
		}
		
		return estado;
	}
	
	public ArrayList<CuentaBancariaModel> buscarCuentaBancaria(String userName){
		ArrayList<CuentaBancariaModel> cuentaBancariaModels = new ArrayList<CuentaBancariaModel>();
		UsuarioModel usuarioModel = new UsuarioModel();
		if (usuarioRepository.findByUsuario(userName).isPresent()) { 
			usuarioModel = usuarioRepository.findByUsuario(userName).get();
			cuentaBancariaModels = (ArrayList<CuentaBancariaModel>) cuentaBancariaRepository.findByVendedor(usuarioModel);
		} 
		return cuentaBancariaModels;
	}
	
}
