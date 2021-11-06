package mapper;

import io.spring.guides.gs_producing_web_service.CuentaBancaria;

public class CuentaBancariaMapper {
	
	public CuentaBancaria toCuentaBancariaXML(com.example.producingwebservice.external.model.CuentaBancaria cuentaBancaria) {
		CuentaBancaria cuentaBancariaXML = new CuentaBancaria();
		
		cuentaBancariaXML.setId(cuentaBancaria.getIdCuentaBancaria());
		cuentaBancariaXML.setBanco(cuentaBancaria.getBanco());
		cuentaBancariaXML.setAlias(cuentaBancaria.getAlias());
		cuentaBancariaXML.setCbu(cuentaBancaria.getCbu());
		cuentaBancariaXML.setDni(cuentaBancaria.getDni());
		
		return cuentaBancariaXML;
	}

}
