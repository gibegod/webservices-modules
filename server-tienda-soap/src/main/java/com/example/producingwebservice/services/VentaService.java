package com.example.producingwebservice.services;


import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.producingwebservice.external.services.CorreoService;
import com.example.producingwebservice.external.services.TarjetaService;
import com.example.producingwebservice.model.BilleteraVirtualModel;
import com.example.producingwebservice.model.DomicilioModel;
import com.example.producingwebservice.model.ProductoModel;
import com.example.producingwebservice.model.TarjetaModel;
import com.example.producingwebservice.model.UsuarioModel;
import com.example.producingwebservice.model.VentaItemModel;
import com.example.producingwebservice.model.VentaModel;
import com.example.producingwebservice.repositories.BilleteraVirtualRepository;
import com.example.producingwebservice.repositories.DomicilioRepository;
import com.example.producingwebservice.repositories.ProductoRepository;
import com.example.producingwebservice.repositories.TarjetaRepository;
import com.example.producingwebservice.repositories.UsuarioRepository;
import com.example.producingwebservice.repositories.VentaItemRepository;
import com.example.producingwebservice.repositories.VentaRepository;
import com.example.producingwebservice.utils.Estado;

import io.spring.guides.gs_producing_web_service.AddVentaRequest;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class VentaService {
	
	@Autowired
	private DomicilioRepository domicilioRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private VentaRepository ventaRepository;	
	
	@Autowired
	private BilleteraVirtualRepository billeteraRepository;
	
	@Autowired
	private VentaItemRepository ventaItemRepository;
	
	@Autowired
	private ProductoRepository productoRepository;
	
	@Autowired
	private TarjetaRepository tarjetaRepository;
	
	@Autowired
	private TarjetaService tarjetaService;	
	
	@Autowired
	private CorreoService correoService;
	
	
	public String guardarVenta(AddVentaRequest request) {		
		DomicilioModel domicilio = domicilioRepository.findById(request.getIdDomicilio()).orElseThrow(()->new RuntimeException("Domicilio no encontrado!")); 
		UsuarioModel comprador = usuarioRepository.findById(request.getIdComprador()).orElseThrow(()->new RuntimeException("Comprador no encontrado!"));
		UsuarioModel vendedor = usuarioRepository.findById(request.getIdVendedor()).orElseThrow(()->new RuntimeException("Vendedor no encontrado!"));
		TarjetaModel tarjeta = tarjetaRepository.findById(request.getIdTarjeta()).orElseThrow(()->new RuntimeException("Tarjeta vinculada no encontrada!"));
		
		log.info("Se va a consultar servicio externo para validar tarjeta con id {} para comprador con id {}", request.getIdTarjeta(), request.getIdComprador());
		String estadoBanca = tarjetaService.validarTarjeta(request.getIdTarjeta(), request.getIdComprador());
		if(!estadoBanca.equals(Estado.OK.name())) {
			return estadoBanca;
		}
		log.info("Validación de propietario correcta.");
		
		VentaModel venta = VentaModel.builder()
				.precioTotal(request.getPrecioTotal().floatValue())
				.estado(Estado.EN_PREPARACION.getEstado())
				.fecha(new Date())
				.domicilio(domicilio)
				.comprador(comprador)
				.vendedor(vendedor)
				.tarjeta(tarjeta)
				.build();		
		venta = ventaRepository.save(venta);
		
		log.info("Se van a guardar los items del carrito.");
		final Long idVenta = venta.getId();
		request.getVentaitems().forEach((item) -> {
			ProductoModel productoModel = productoRepository.findById(item.getIdProducto()).orElseThrow(() -> new RuntimeException("Error, producto no encontrado!"));
			productoModel.setStockActual(productoModel.getStockActual() - (int) item.getCantidad());
			productoModel = productoRepository.save(productoModel);
			
			VentaItemModel ventaItemModel = new VentaItemModel();
			ventaItemModel.setCantidad((int) item.getCantidad());
			ventaItemModel.setProducto(productoModel);
			ventaItemModel.setVenta(ventaRepository.findById(idVenta).orElseThrow(() -> new RuntimeException("Error, venta no encontrada!")));
			ventaItemRepository.save(ventaItemModel);
		});
		
		log.info("Se va a enviar la venta al correo.");
		String idSeguimiento = correoService.enviarVenta(venta.getComprador().getDni(), venta.getId());
		venta.setIdSeguimiento(idSeguimiento);
		ventaRepository.save(venta);
		
		return Estado.OK.name();
	}
	
	public String finalizarVenta(long idVenta) {		
		VentaModel venta = ventaRepository.findById(idVenta).orElseThrow(()->new RuntimeException("Venta no encontrada!"));
		
		if(venta.getEstado().equals(Estado.FINALIZADO.name())){
			return "Error, la venta ya se encuentra cerrada!";			
		}
		
		log.info("Se va a actualizar la venta.");
		venta.setEstado(Estado.FINALIZADO.name());
		ventaRepository.save(venta);
		
		log.info("Se va a saldar la compra en el servicio de banca.");
		tarjetaService.saldarCompra(venta.getComprador().getId(), venta.getTarjeta().getIdTarjeta(), venta.getPrecioTotal());
		
		log.info("Se va a actualizar la billetera virtual.");
		billeteraRepository.findByVendedor(venta.getVendedor())
			.ifPresentOrElse(
					(billeteraVirtual) -> {
						billeteraVirtual.setSaldo(billeteraVirtual.getSaldo() + venta.getPrecioTotal());
						billeteraRepository.save(billeteraVirtual);
					},
					() -> {
						BilleteraVirtualModel billeteraVirtual = BilleteraVirtualModel.builder()
								.saldo(venta.getPrecioTotal())
								.vendedor(venta.getVendedor())
								.build();
						billeteraRepository.save(billeteraVirtual);
					}
			);		
		
		return Estado.OK.name();
	}
	
	public Iterable<VentaModel> traerVentasPorVendedor(long id){
		Iterable<VentaModel> lstVentas = new ArrayList<>();
		try {
			lstVentas = ventaRepository.findAllByIdVendedor(id);
		}catch(Exception e) {
			
		}
		return lstVentas;
	}

}
