package mapper;

import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import com.example.producingwebservice.model.DomicilioModel;
import com.example.producingwebservice.model.UsuarioModel;
import com.example.producingwebservice.model.VentaModel;

import io.spring.guides.gs_producing_web_service.Domicilio;
import io.spring.guides.gs_producing_web_service.Usuario;
import io.spring.guides.gs_producing_web_service.Venta;

public class VentaMapper {
	
	public VentaModel toVentaModel(Venta ventaXML, DomicilioModel domicilioModel, UsuarioModel compradorModel, UsuarioModel vendedorModel) {
		VentaModel vM = new VentaModel();
		
		vM.setEstado(ventaXML.getEstado());
		vM.setFecha(ventaXML.getFecha().toGregorianCalendar().getTime());
		vM.setDomicilio(domicilioModel);
		vM.setComprador(compradorModel);
		vM.setVendedor(vendedorModel);
		
		return vM;
	}
	
	public Venta toVentaXML(VentaModel ventaModel, Boolean setId) {
		Venta ventaXML = new Venta();
		Domicilio domicilioXML = new Domicilio();
		Usuario compradorXML = new Usuario();
		Usuario vendedorXML = new Usuario();
		
		if(setId) {
			ventaXML.setId(ventaModel.getId());
			domicilioXML.setId(ventaModel.getDomicilio().getId());
			compradorXML.setId(ventaModel.getComprador().getId());
			vendedorXML.setId(ventaModel.getVendedor().getId());
		}
		
		ventaXML.setEstado(ventaModel.getEstado());
		
		try {
			GregorianCalendar calendar = new GregorianCalendar();
			calendar.setTime(ventaModel.getFecha());
			ventaXML.setFecha(DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar));
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ventaXML.setDomicilio(domicilioXML);
		ventaXML.setComprador(compradorXML);
		ventaXML.setVendedor(vendedorXML);

		return ventaXML;
	}

}
