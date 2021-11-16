package com.example.consumingwebservice.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.consumingwebservice.VentasClient;
import com.example.consumingwebservice.dto.CuentaBancariaDTO;
import com.example.consumingwebservice.dto.DomicilioDTO;
import com.example.consumingwebservice.dto.UsuarioDomicilioCuentasBancariasDTO;
import com.example.consumingwebservice.dto.UsuarioLoginDTO;
import com.example.consumingwebservice.mapper.DomicilioMapper;
import com.example.consumingwebservice.mapper.UsuarioMapper;
import com.example.consumingwebservice.wsdl.AddCuentaBancariaResponse;
import com.example.consumingwebservice.wsdl.AddDomicilioResponse;
import com.example.consumingwebservice.wsdl.AddUsuarioResponse;
import com.example.consumingwebservice.wsdl.BilleteraVirtual;
import com.example.consumingwebservice.wsdl.BilleteraVirtualToCuentaBancariaRequest;
import com.example.consumingwebservice.wsdl.BilleteraVirtualToCuentaBancariaResponse;
import com.example.consumingwebservice.wsdl.CategoriaDenuncia;
import com.example.consumingwebservice.wsdl.DeleteCuentaBancariaResponse;
import com.example.consumingwebservice.wsdl.GetCategoriasDenunciaResponse;
import com.example.consumingwebservice.wsdl.GetCuentasBancariasResponse;
import com.example.consumingwebservice.wsdl.GetDomiciliosResponse;
import com.example.consumingwebservice.wsdl.GetUsuarioResponse;
import com.example.consumingwebservice.wsdl.LoginValResponse;
import com.example.consumingwebservice.wsdl.UpdateUsuarioResponse;
import com.example.consumingwebservice.wsdl.Usuario;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private VentasClient ventasClient;
	
	private UsuarioMapper usuariomap = new UsuarioMapper();

	@GetMapping(path = "/{user}")
	public UsuarioDomicilioCuentasBancariasDTO getUsuario(@PathVariable("user") String usuario) {
		GetUsuarioResponse user = ventasClient.getUser(usuario);
		
		UsuarioDomicilioCuentasBancariasDTO dto = new UsuarioDomicilioCuentasBancariasDTO();
		if (!Objects.isNull(user.getUsuario())) {
			GetDomiciliosResponse addresses = ventasClient.getAddresses(usuario);
			GetCuentasBancariasResponse bankAccounts = ventasClient.getBankAccounts(usuario);	
			
			dto = usuariomap.toUsuarioDTO(user.getUsuario(), addresses.getDomicilio(), bankAccounts.getCuentaBancaria());
		}
		
		return dto;
	}
	
	@PostMapping(path = "/login")
	public String validarUser(@RequestBody UsuarioLoginDTO usuario) {
		LoginValResponse response = ventasClient.validator(usuario.getUser(), usuario.getPass());
		return response.getEstado();
	}
	
	@PostMapping(path = "/update")
	public String modificarUser(@RequestBody Usuario usuario) {
		UpdateUsuarioResponse response = ventasClient.updateUser(usuario);
		return response.getEstado();
	}
	
	@PostMapping(path = "/register")
	public String registrarUser(@RequestBody Usuario usuario) {
		AddUsuarioResponse response = ventasClient.signInUser(usuario);
		return response.getEstado();
	}
	
	@PostMapping(path = "/domicilio")
	public String agregarDomicilio(@RequestBody DomicilioDTO domicilio) {
		AddDomicilioResponse response = ventasClient.addDomicilio(DomicilioMapper.dtoToXML(domicilio));
		return response.getEstado();
	}
	
	@PostMapping(path = "/cuentaBancaria")
	public String agregarCuentaBancaria(@RequestBody CuentaBancariaDTO cuentaBancariaDTO) {
		AddCuentaBancariaResponse response = ventasClient.addCuentaBancaria(cuentaBancariaDTO);
		return response.getEstado();
	}
	
	@GetMapping(path = "/{userId}/billeteraVirtual")
	public BilleteraVirtual getUsuario(@PathVariable("userId") Long userId) {		
		return ventasClient.getBilleteraVirtual(userId).getBilleteraVirtual();
	}
	
	@PostMapping(path = "/transferir")
	public String transferir(@RequestBody BilleteraVirtualToCuentaBancariaRequest request) {
		BilleteraVirtualToCuentaBancariaResponse response = ventasClient.transferir(request);
		return response.getEstado();
	}
	
	@PostMapping(path = "/deleteCuentaBancaria={id}")
	public String eliminarCuentaBancaria(@PathVariable("id") Long id) {
		DeleteCuentaBancariaResponse response = ventasClient.deleteCuentaBancaria(id);
		return response.getEstado();
	}
	
	@GetMapping(path="/categorias-denuncia")
	public List<CategoriaDenuncia> getCategoriasDenuncia(){
		GetCategoriasDenunciaResponse response = ventasClient.getCategoriasDenuncia();
		return response.getCategoriasDenuncia();
	}
}
