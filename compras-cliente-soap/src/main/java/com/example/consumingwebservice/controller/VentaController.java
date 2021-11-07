package com.example.consumingwebservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.consumingwebservice.ComprasClient;
import com.example.consumingwebservice.dto.ReclamoDTO;
import com.example.consumingwebservice.wsdl.GetVentasPorIdCompradorResponse;
import com.example.consumingwebservice.wsdl.Venta;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/venta")
public class VentaController {
	
	@Autowired
	private ComprasClient comprasClient;
	
	@GetMapping(path = "/comprador={id}")
	public List<Venta> getVentasPorIdComprador(@PathVariable ("id") Long id){
		GetVentasPorIdCompradorResponse response = comprasClient.getVentasPorIdComprador(id);
		return response.getVenta();
	}	
	
	@PostMapping(path = "/reclamar")
	public String addReclamo(@RequestBody ReclamoDTO reclamoDTO){
		return comprasClient.addReclamo(reclamoDTO);
	}
}
