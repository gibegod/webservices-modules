package com.example.consumingwebservice.dto;

import java.math.BigDecimal;
import java.util.List;

import com.example.consumingwebservice.wsdl.AddVentaRequest;
import com.example.consumingwebservice.wsdl.Ventaitem;
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
	
	@JsonProperty("total")
	private float precioTotal;
	
	@JsonProperty("domicilio")
	private Long idDomicilio;
	
	@JsonProperty("comprador")
	private Long idComprador;
	
	@JsonProperty("idvendedor")
	private Long idVendedor;
	
	@JsonProperty("mediopago")
	private Long idTarjeta;
	
	@JsonProperty("productos")
	private List<Ventaitem> productos;
	
	public AddVentaRequest toSOAPRequest() {
		AddVentaRequest request = new AddVentaRequest();
		request.setPrecioTotal(BigDecimal.valueOf(precioTotal));
		request.setIdDomicilio(idDomicilio);
		request.setIdComprador(idComprador);
		request.setIdVendedor(idVendedor);
		request.setIdTarjeta(idTarjeta);
		request.getVentaitems().addAll(productos);
		
		return request;
	}

}
