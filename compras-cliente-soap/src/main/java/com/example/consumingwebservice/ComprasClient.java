
package com.example.consumingwebservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.example.consumingwebservice.wsdl.GetUsuarioRequest;
import com.example.consumingwebservice.wsdl.GetUsuarioResponse;
import com.example.consumingwebservice.wsdl.LoginValRequest;
import com.example.consumingwebservice.wsdl.LoginValResponse;
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
				.marshalSendAndReceive("http://localhost:8080/ws/compras", request,
						new SoapActionCallback(
								"http://spring.io/guides/gs-producing-web-service/GetCountryRequest"));
		return response;
	}
	
	public LoginValResponse validator(String user,String pass) {
		
		LoginValRequest request = new LoginValRequest();
		request.setContrasenia(pass);
		request.setUsuario(user);
		LoginValResponse response = (LoginValResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8080/ws/compras", request,
						new SoapActionCallback(
								"http://spring.io/guides/gs-producing-web-service/GetCountryRequest"));
		return response;
	}
	
	public UpdateUsuarioResponse updateUser(Usuario user) {
		UpdateUsuarioRequest request = new UpdateUsuarioRequest();
		request.setUsuario(user);
		UpdateUsuarioResponse response = (UpdateUsuarioResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8080/ws/compras", request,
						new SoapActionCallback(
								"http://spring.io/guides/gs-producing-web-service/GetCountryRequest"));
		return response;
	}
}
