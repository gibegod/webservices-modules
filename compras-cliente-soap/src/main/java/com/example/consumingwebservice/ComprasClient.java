
package com.example.consumingwebservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.example.consumingwebservice.wsdl.AddDomicilioRequest;
import com.example.consumingwebservice.wsdl.AddDomicilioResponse;
import com.example.consumingwebservice.wsdl.AddTarjetaRequest;
import com.example.consumingwebservice.wsdl.AddTarjetaResponse;
import com.example.consumingwebservice.wsdl.AddUsuarioRequest;
import com.example.consumingwebservice.wsdl.AddUsuarioResponse;
import com.example.consumingwebservice.wsdl.Domicilio;
import com.example.consumingwebservice.wsdl.GetUsuarioRequest;
import com.example.consumingwebservice.wsdl.GetUsuarioResponse;
import com.example.consumingwebservice.wsdl.LoginValRequest;
import com.example.consumingwebservice.wsdl.LoginValResponse;
import com.example.consumingwebservice.wsdl.Tarjeta;
import com.example.consumingwebservice.wsdl.UpdateUsuarioRequest;
import com.example.consumingwebservice.wsdl.UpdateUsuarioResponse;
import com.example.consumingwebservice.wsdl.Usuario;

public class ComprasClient extends WebServiceGatewaySupport {

	private static final Logger log = LoggerFactory.getLogger(ComprasClient.class);

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
	
}
