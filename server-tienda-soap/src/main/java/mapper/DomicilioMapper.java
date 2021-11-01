package mapper;

import com.example.producingwebservice.model.DomicilioModel;

import io.spring.guides.gs_producing_web_service.Domicilio;

public class DomicilioMapper {
	
	public DomicilioModel toDomicilioModel(Domicilio domicilioXML){
		DomicilioModel dm = new DomicilioModel();
		
		dm.setCalle(domicilioXML.getCalle());
		dm.setDepartamento(domicilioXML.getDepartamento());
		dm.setLocalidad(domicilioXML.getLocalidad());
		dm.setNumero(domicilioXML.getNumero());
		dm.setPais(domicilioXML.getPais());
		dm.setPiso(domicilioXML.getPiso());
		dm.setProvincia(domicilioXML.getProvincia());
		
		return dm;
	}
	
	public Domicilio toDomicilioXML(DomicilioModel domicilioModel) {
		Domicilio dXML = new Domicilio();
		
		dXML.setId(domicilioModel.getId());
		dXML.setCalle(domicilioModel.getCalle());
		dXML.setDepartamento(domicilioModel.getDepartamento());
		dXML.setDepartamento(domicilioModel.getDepartamento());
		dXML.setLocalidad(domicilioModel.getLocalidad());
		dXML.setNumero(domicilioModel.getNumero());
		dXML.setPais(domicilioModel.getPais());
		dXML.setPiso(domicilioModel.getPiso());
		dXML.setProvincia(domicilioModel.getProvincia());
		
		return dXML;
	}
}
