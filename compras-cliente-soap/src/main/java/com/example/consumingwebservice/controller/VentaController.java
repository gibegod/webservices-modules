package com.example.consumingwebservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.consumingwebservice.wsdl.GetVentasPorIdCompradorResponse;
import com.example.consumingwebservice.wsdl.Venta;
import com.example.consumingwebservice.ComprasClient;

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

}
