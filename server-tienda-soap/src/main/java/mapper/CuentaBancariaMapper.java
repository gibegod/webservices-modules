package mapper;

import com.example.producingwebservice.model.CuentaBancariaModel;

import io.spring.guides.gs_producing_web_service.CuentaBancaria;
import io.spring.guides.gs_producing_web_service.Usuario;

public class CuentaBancariaMapper {
	UsuarioMapper usuarioMap = new UsuarioMapper();
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
	
	public CuentaBancaria toCuentaBancariaXML(CuentaBancariaModel cuentaBancariaModel) {
		CuentaBancaria cbXML = new CuentaBancaria();
		Usuario uXML = new Usuario();
		uXML = usuarioMap.toUsuarioXML(cuentaBancariaModel.getVendedor(), true);
		cbXML.setVendedor(uXML);
		cbXML.setId(cuentaBancariaModel.getId());
		cbXML.setAlias(cuentaBancariaModel.getAlias());
		cbXML.setBanco(cuentaBancariaModel.getBanco());
		cbXML.setCvu(cuentaBancariaModel.getCvu());
		cbXML.setDni(cuentaBancariaModel.getDni());
		cbXML.setMovimientos(cuentaBancariaModel.getMovimientos());
		return cbXML;
	}

}
