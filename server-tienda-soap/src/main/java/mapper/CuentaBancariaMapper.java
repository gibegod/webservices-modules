package mapper;

import com.example.producingwebservice.model.CuentaBancariaModel;

import io.spring.guides.gs_producing_web_service.CuentaBancaria;

public class CuentaBancariaMapper {
	public CuentaBancariaModel toCuentaBancariaModel(CuentaBancaria cuentaBancariaXML,Boolean setID) {
		CuentaBancariaModel cbm = new CuentaBancariaModel();
		if(setID) cbm.setId(cuentaBancariaXML.getId());
		cbm.setAlias(cuentaBancariaXML.getAlias());
		cbm.setBanco(cuentaBancariaXML.getBanco());
		cbm.setCvu(cuentaBancariaXML.getCvu());
		cbm.setDni(cuentaBancariaXML.getDni());
		cbm.setMovimientos(cuentaBancariaXML.getMovimientos());
		
		return cbm;
	}

}
