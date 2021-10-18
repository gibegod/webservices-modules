package mapper;

import java.math.BigDecimal;

import com.example.producingwebservice.model.TarjetaModel;

import io.spring.guides.gs_producing_web_service.Tarjeta;
import io.spring.guides.gs_producing_web_service.Usuario;

public class TarjetaMapper { //SIN setear DateTime
	UsuarioMapper usuarioMap = new UsuarioMapper();
	public TarjetaModel toTarjetaModel(Tarjeta tarjetaXML, Boolean setID) {
		TarjetaModel tm = new TarjetaModel();
		//Date date = new Date(); Mapear gregorian calendar a LocalDateTime
		//tm.setVencimiento();
		if(setID)	tm.setId(tarjetaXML.getId());
		tm.setCvc(tarjetaXML.getCvc());
		tm.setLimiteMensual(tarjetaXML.getLimiteMensual().floatValue());
		tm.setNombre(tarjetaXML.getNombre());
		tm.setNumero(tarjetaXML.getNumero());
		tm.setSaldo(tarjetaXML.getSaldo().floatValue());
		tm.setTipo(tarjetaXML.getTipo());
		
		return tm;
	}
	
	public Tarjeta toTarjetaXML(TarjetaModel tarjetaModel) {
		Tarjeta t = new Tarjeta();
		Usuario uXML = new Usuario();
		uXML = usuarioMap.toUsuarioXML(tarjetaModel.getComprador(), true);
		t.setComprador(uXML);
		t.setId(tarjetaModel.getId());
		t.setCvc(tarjetaModel.getCvc());
		t.setLimiteMensual(BigDecimal.valueOf(tarjetaModel.getLimiteMensual()) );
		t.setNombre(tarjetaModel.getNombre());
		t.setNumero(tarjetaModel.getNumero());
		t.setSaldo(BigDecimal.valueOf(tarjetaModel.getSaldo()));
		t.setTipo(tarjetaModel.getTipo());
		//t.setVencimiento(null);
		return t;
	}

}
