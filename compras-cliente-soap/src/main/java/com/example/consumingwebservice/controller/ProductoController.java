package com.example.consumingwebservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.consumingwebservice.ComprasClient;
import com.example.consumingwebservice.dto.DenunciaDTO;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	private ComprasClient comprasClient;
	
	@PostMapping(path = "/denunciar")
	public String addDenuncia(@RequestBody DenunciaDTO denunciaDTO){
		return comprasClient.addDenuncia(denunciaDTO);
	}

}
