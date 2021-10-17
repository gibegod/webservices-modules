package mapper;

import java.util.Date;

import com.example.producingwebservice.model.TarjetaModel;

import io.spring.guides.gs_producing_web_service.Tarjeta;

public class TarjetaMapper { //SIN setear DateTime
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

}
