
package com.example.consumingwebservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.example.consumingwebservice.dto.TarjetaDTO;
import com.example.consumingwebservice.wsdl.AddDomicilioRequest;
import com.example.consumingwebservice.wsdl.AddDomicilioResponse;
import com.example.consumingwebservice.wsdl.AddTarjetaRequest;
import com.example.consumingwebservice.wsdl.AddTarjetaResponse;
import com.example.consumingwebservice.wsdl.AddUsuarioRequest;
import com.example.consumingwebservice.wsdl.AddUsuarioResponse;
import com.example.consumingwebservice.wsdl.Domicilio;
import com.example.consumingwebservice.wsdl.GetDomiciliosRequest;
import com.example.consumingwebservice.wsdl.GetDomiciliosResponse;
import com.example.consumingwebservice.wsdl.GetTarjetasRequest;
import com.example.consumingwebservice.wsdl.GetTarjetasResponse;
import com.example.consumingwebservice.wsdl.GetUsuarioRequest;
import com.example.consumingwebservice.wsdl.GetUsuarioResponse;
import com.example.consumingwebservice.wsdl.GetVentasPorIdCompradorRequest;
import com.example.consumingwebservice.wsdl.GetVentasPorIdCompradorResponse;
import com.example.consumingwebservice.wsdl.LoginValRequest;
import com.example.consumingwebservice.wsdl.LoginValResponse;
import com.example.consumingwebservice.wsdl.Tarjeta;
import com.example.consumingwebservice.wsdl.UpdateUsuarioRequest;
import com.example.consumingwebservice.wsdl.UpdateUsuarioResponse;
import com.example.consumingwebservice.wsdl.Usuario;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ComprasClient extends WebServiceGatewaySupport {
	
	@Value("${ws.server.dir}")
	private String wsServerDir;
	
	@Value("${soap.action.callback}")
	private String soapActionCallback;

	public GetUsuarioResponse getUser(String name) {
		GetUsuarioRequest request = new GetUsuarioRequest();
		request.setName(name);
		log.info("Searching user : " + name);
		GetUsuarioResponse response = (GetUsuarioResponse) getWebServiceTemplate().marshalSendAndReceive(
				wsServerDir, request,
				new SoapActionCallback(soapActionCallback));
		return response;
	}

	public GetDomiciliosResponse getAddresses(String usuario) {
		GetDomiciliosRequest request = new GetDomiciliosRequest();
		request.setUsuario(usuario);
		log.info("Searching address : user: " + usuario);
		GetDomiciliosResponse response = (GetDomiciliosResponse) getWebServiceTemplate().marshalSendAndReceive(
				wsServerDir, request,
				new SoapActionCallback(soapActionCallback));
		return response;
	}

	public GetTarjetasResponse getCards(String usuario) {
		GetTarjetasRequest request = new GetTarjetasRequest();
		request.setUsuario(usuario);
		log.info("Searching cards : user : " + usuario);
		GetTarjetasResponse response = (GetTarjetasResponse) getWebServiceTemplate().marshalSendAndReceive(
				wsServerDir, request,
				new SoapActionCallback(soapActionCallback));
		return response;
	}

	public LoginValResponse validator(String user, String pass) {
		LoginValRequest request = new LoginValRequest();
		request.setContrasenia(pass);
		request.setUsuario(user);
		LoginValResponse response = (LoginValResponse) getWebServiceTemplate().marshalSendAndReceive(
				wsServerDir, request,
				new SoapActionCallback(soapActionCallback));
		return response;
	}

	public UpdateUsuarioResponse updateUser(Usuario user) {
		UpdateUsuarioRequest request = new UpdateUsuarioRequest();
		request.setUsuario(user);
		UpdateUsuarioResponse response = (UpdateUsuarioResponse) getWebServiceTemplate().marshalSendAndReceive(
				wsServerDir, request,
				new SoapActionCallback(soapActionCallback));
		return response;
	}

	public AddUsuarioResponse signInUser(Usuario user) {
		AddUsuarioRequest request = new AddUsuarioRequest();
		request.setUsuario(user);
		AddUsuarioResponse response = (AddUsuarioResponse) getWebServiceTemplate().marshalSendAndReceive(
				wsServerDir, request,
				new SoapActionCallback(soapActionCallback));
		return response;
	}

	public AddDomicilioResponse addDomicilio(Domicilio domicilio) {
		AddDomicilioRequest request = new AddDomicilioRequest();
		request.setDomicilio(domicilio);
		AddDomicilioResponse response = (AddDomicilioResponse) getWebServiceTemplate().marshalSendAndReceive(
				wsServerDir, request,
				new SoapActionCallback(soapActionCallback));
		return response;
	}

	public AddTarjetaResponse addTarjeta(TarjetaDTO tarjetaDTO) {
		AddTarjetaRequest request = new AddTarjetaRequest();
		Tarjeta tarjeta = new Tarjeta();
		tarjeta.setNumero(tarjetaDTO.getNumero());
		tarjeta.setCvc(tarjetaDTO.getCvc());
		Usuario usuario = new Usuario();
		usuario.setId(tarjetaDTO.getIdComprador());
		tarjeta.setUsuario(usuario);
		request.setTarjeta(tarjeta);
		
		AddTarjetaResponse response = (AddTarjetaResponse) getWebServiceTemplate().marshalSendAndReceive(
				wsServerDir, request,
				new SoapActionCallback(soapActionCallback));
		
		return response;
	}
	
	public GetVentasPorIdCompradorResponse getVentasPorIdComprador(Long idComprador) {
		GetVentasPorIdCompradorRequest request = new GetVentasPorIdCompradorRequest();
		request.setId(idComprador);
		GetVentasPorIdCompradorResponse response = (GetVentasPorIdCompradorResponse) getWebServiceTemplate().marshalSendAndReceive(
				wsServerDir, request,
				new SoapActionCallback(soapActionCallback));
		return response;
	}

}
