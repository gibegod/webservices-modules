package com.example.consumingwebservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.consumingwebservice.VentasClient;
import com.example.consumingwebservice.dto.VentaDTO;
import com.example.consumingwebservice.wsdl.GetVentasPorIdVendedorResponse;
import com.example.consumingwebservice.wsdl.Venta;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/venta")
public class VentaController {
	
	@Autowired
	private VentasClient ventasClient;
	
	@Value("${dias.reclamo.total}")
	private String diasReclamoTotal;
	
	@PostMapping
	public String addVenta(@RequestBody VentaDTO venta) {		
		return ventasClient.addVenta(venta).getEstado();
	}
	
	@GetMapping(path = "/vendedor={id}")
	public List<Venta> getVentasPorIdVendedor(@PathVariable ("id") Long id){
		GetVentasPorIdVendedorResponse response = ventasClient.getVentasPorIdVendedor(id);
		return response.getVenta();
	}
	
	@PostMapping(path = "/{id_venta}/actualizar/{estado}")
	public HttpStatus actualizarEstadoVenta(@PathVariable ("id_venta") Long idVenta, @PathVariable ("estado") String estado){
		ventasClient.actualizarEstadoVenta(idVenta, estado);
		
		return HttpStatus.OK;
	}
	
	@GetMapping(path = "/dias-reclamo-total")
	public String getDiasReclamoTotal(){
		return diasReclamoTotal;
	}
	
	@PostMapping(path = "/finalizar/{id_venta}")
	public String finalizarVenta(@PathVariable ("id_venta") Long idVenta){
		return ventasClient.finalizarVenta(idVenta);
	}

	@PostMapping(path = "/{id_venta}/cancelar/{id_comprador}")
	public String cancelarVenta(@PathVariable ("id_venta") Long idVenta, @PathVariable ("id_comprador") Long idComprador) {
		return ventasClient.cancelarVenta(idVenta, idComprador);
	}

}
