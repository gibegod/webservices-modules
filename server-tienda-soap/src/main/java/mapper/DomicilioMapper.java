package mapper;

import com.example.producingwebservice.model.DomicilioModel;

import io.spring.guides.gs_producing_web_service.Domicilio;
import io.spring.guides.gs_producing_web_service.Usuario;

public class DomicilioMapper {
	UsuarioMapper usuarioMap = new UsuarioMapper();
	public DomicilioModel toDomicilioModel(Domicilio domicilioXML){ // toModel con un boolean ID
		DomicilioModel dm = new DomicilioModel();
		dm.setCalle(domicilioXML.getCalle());
		dm.setDepartamento(domicilioXML.getDepartamento());
		dm.setLocalidad(domicilioXML.getLocalidad());
		dm.setNumero(Integer.valueOf(domicilioXML.getNumero()));
		dm.setPais(domicilioXML.getPais());
		dm.setPiso(domicilioXML.getPiso());
		dm.setProvincia(domicilioXML.getProvincia());
		
		return dm;
	}
	
	public Domicilio toDomicilioXML(DomicilioModel domicilioModel) { // toXML con ID
		Domicilio dXML = new Domicilio();
		Usuario uXML = new Usuario();
		uXML = usuarioMap.toUsuarioXML(domicilioModel.getComprador(), true);
		dXML.setComprador(uXML);
		dXML.setId(domicilioModel.getId());
		dXML.setCalle(domicilioModel.getCalle());
		dXML.setDepartamento(domicilioModel.getDepartamento());
		dXML.setDepartamento(domicilioModel.getDepartamento());
		dXML.setLocalidad(domicilioModel.getLocalidad());
		dXML.setNumero(domicilioModel.getNumero().toString());
		dXML.setPais(domicilioModel.getPais());
		dXML.setPiso(domicilioModel.getPiso());
		dXML.setProvincia(domicilioModel.getProvincia());
		
		return dXML;
	}

}
