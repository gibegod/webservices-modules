package com.example.consumingwebservice.dto;

import java.math.BigDecimal;

import com.example.consumingwebservice.wsdl.AddVentaRequest;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class VentaDTO {
	
	@JsonProperty("precio_total")
	private float precioTotal;
	
	@JsonProperty("id_domicilio")
	private Long idDomicilio;
	
	@JsonProperty("id_comprador")
	private Long idComprador;
	
	@JsonProperty("id_vendedor")
	private Long idVendedor;
	
	@JsonProperty("id_tarjeta")
	private Long idTarjeta;
	
	public AddVentaRequest toSOAPRequest() {
		AddVentaRequest request = new AddVentaRequest();
		request.setPrecioTotal(BigDecimal.valueOf(precioTotal));
		request.setIdDomicilio(idDomicilio);
		request.setIdComprador(idComprador);
		request.setIdVendedor(idVendedor);
		request.setIdTarjeta(idTarjeta);
		
		return request;
	}

}
