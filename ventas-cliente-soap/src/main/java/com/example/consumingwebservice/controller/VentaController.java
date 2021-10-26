package com.example.consumingwebservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.consumingwebservice.VentasClient;
import com.example.consumingwebservice.dto.VentaDTO;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/venta")
public class VentaController {
	
	@Autowired
	private VentasClient ventasClient;
	
	@PostMapping
	public String addVenta(@RequestBody VentaDTO venta) {		
		return ventasClient.addVenta(venta).getEstado();
	}

}
