
package com.example.consumingwebservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.example.consumingwebservice.wsdl.AddCuentaBancariaRequest;
import com.example.consumingwebservice.wsdl.AddCuentaBancariaResponse;
import com.example.consumingwebservice.wsdl.AddDomicilioRequest;
import com.example.consumingwebservice.wsdl.AddDomicilioResponse;
import com.example.consumingwebservice.wsdl.AddProductoRequest;
import com.example.consumingwebservice.wsdl.AddProductoResponse;
import com.example.consumingwebservice.wsdl.AddTarjetaRequest;
import com.example.consumingwebservice.wsdl.AddTarjetaResponse;
import com.example.consumingwebservice.wsdl.AddUsuarioRequest;
import com.example.consumingwebservice.wsdl.AddUsuarioResponse;
import com.example.consumingwebservice.wsdl.CuentaBancaria;
import com.example.consumingwebservice.wsdl.Domicilio;
import com.example.consumingwebservice.wsdl.GetProductoPorIdRequest;
import com.example.consumingwebservice.wsdl.GetProductoPorIdResponse;
import com.example.consumingwebservice.wsdl.GetProductoRequest;
import com.example.consumingwebservice.wsdl.GetProductoResponse;
import com.example.consumingwebservice.wsdl.GetProductosRequest;
import com.example.consumingwebservice.wsdl.GetProductosResponse;
import com.example.consumingwebservice.wsdl.GetUsuarioRequest;
import com.example.consumingwebservice.wsdl.GetUsuarioResponse;
import com.example.consumingwebservice.wsdl.LoginValRequest;
import com.example.consumingwebservice.wsdl.LoginValResponse;
import com.example.consumingwebservice.wsdl.Producto;
import com.example.consumingwebservice.wsdl.Tarjeta;
import com.example.consumingwebservice.wsdl.UpdateProductoRequest;
import com.example.consumingwebservice.wsdl.UpdateProductoResponse;
import com.example.consumingwebservice.wsdl.UpdateUsuarioRequest;
import com.example.consumingwebservice.wsdl.UpdateUsuarioResponse;
import com.example.consumingwebservice.wsdl.Usuario;

public class VentasClient extends WebServiceGatewaySupport {

	private static final Logger log = LoggerFactory.getLogger(VentasClient.class);

	public GetUsuarioResponse getUser(String name) {
		GetUsuarioRequest request = new GetUsuarioRequest();
		request.setName(name);
		log.info("Searching user : " + name);
		GetUsuarioResponse response = (GetUsuarioResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8080/ws/server", request,
						new SoapActionCallback(
								"http://spring.io/guides/gs-producing-web-service"));
		return response;
	}
	
	public LoginValResponse validator(String user,String pass) {
		
		LoginValRequest request = new LoginValRequest();
		request.setContrasenia(pass);
		request.setUsuario(user);
		LoginValResponse response = (LoginValResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8080/ws/server", request,
						new SoapActionCallback(
								"http://spring.io/guides/gs-producing-web-service"));
		return response;
	}
	
	public UpdateUsuarioResponse updateUser(Usuario user) {
		UpdateUsuarioRequest request = new UpdateUsuarioRequest();
		request.setUsuario(user);
		UpdateUsuarioResponse response = (UpdateUsuarioResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8080/ws/server", request,
						new SoapActionCallback(
								"http://spring.io/guides/gs-producing-web-service"));
		return response;
	}
	
	public AddUsuarioResponse signInUser(Usuario user) {
		AddUsuarioRequest request = new AddUsuarioRequest();
		request.setUsuario(user);
		AddUsuarioResponse response = (AddUsuarioResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8080/ws/server", request,
						new SoapActionCallback(
								"http://spring.io/guides/gs-producing-web-service"));
		return response;
	}
	
	public AddProductoResponse addProducto(Producto producto) {
		AddProductoRequest request = new AddProductoRequest();
		request.setProducto(producto);
		AddProductoResponse response = (AddProductoResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8080/ws/server", request,
						new SoapActionCallback(
								"http://spring.io/guides/gs-producing-web-service"));
		return response;
	}
	
	public UpdateProductoResponse updateProducto(Producto producto) {
		UpdateProductoRequest request = new UpdateProductoRequest();
		request.setProducto(producto);
		UpdateProductoResponse response = (UpdateProductoResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8080/ws/server", request,
						new SoapActionCallback(
								"http://spring.io/guides/gs-producing-web-service"));
		return response;
	}
	
	public AddDomicilioResponse addDomicilio(Domicilio domicilio) {
		AddDomicilioRequest request = new AddDomicilioRequest();
		request.setDomicilio(domicilio);
		AddDomicilioResponse response = (AddDomicilioResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8080/ws/server", request,
						new SoapActionCallback(
								"http://spring.io/guides/gs-producing-web-service"));
		return response;
	}
	
	public AddTarjetaResponse addTarjeta(Tarjeta tarjeta) {
		AddTarjetaRequest request = new AddTarjetaRequest();
		request.setTarjeta(tarjeta);
		AddTarjetaResponse response = (AddTarjetaResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8080/ws/server", request,
						new SoapActionCallback(
								"http://spring.io/guides/gs-producing-web-service"));
		return response;
	}
	
	public AddCuentaBancariaResponse addCuentaBancaria(CuentaBancaria cuentaBancaria) {
		AddCuentaBancariaRequest request = new AddCuentaBancariaRequest();
		request.setCuentaBancaria(cuentaBancaria);
		AddCuentaBancariaResponse response = (AddCuentaBancariaResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8080/ws/server", request,
						new SoapActionCallback(
								"http://spring.io/guides/gs-producing-web-service"));
		return response;
	}
	
	public GetProductoResponse getProducto(String name) {		
		GetProductoRequest request = new GetProductoRequest();
		request.setName(name);
		log.info("Searching product : " + name);
		GetProductoResponse response = (GetProductoResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8080/ws/server", request,
						new SoapActionCallback(
								"http://spring.io/guides/gs-producing-web-service"));
		return response;
	}
	
	public GetProductoPorIdResponse getProductoPorId(long id) {		
		GetProductoPorIdRequest request = new GetProductoPorIdRequest();
		request.setId(id);
		log.info("Searching product : " + id);
		GetProductoPorIdResponse response = (GetProductoPorIdResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8080/ws/server", request,
						new SoapActionCallback(
								"http://spring.io/guides/gs-producing-web-service"));
		return response;
	}
	
	public GetProductosResponse getProductos() {		
		GetProductosRequest request = new GetProductosRequest();
		log.info("Searching products : ");
		GetProductosResponse response = (GetProductosResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8080/ws/server", request,
						new SoapActionCallback(
								"http://spring.io/guides/gs-producing-web-service"));
		return response;
	}
}
