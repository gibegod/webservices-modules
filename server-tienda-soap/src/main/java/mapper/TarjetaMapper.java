package mapper;

import java.math.BigDecimal;

import io.spring.guides.gs_producing_web_service.Tarjeta;

public class TarjetaMapper {
	
	public Tarjeta toTarjetaXML(com.example.producingwebservice.external.model.Tarjeta tarjeta) {
		Tarjeta tarjetaXML = new Tarjeta();
		
		tarjetaXML.setId(tarjeta.getIdTarjeta());
		tarjetaXML.setLimiteMensual(BigDecimal.valueOf(tarjeta.getLimiteMensual()));
		tarjetaXML.setSaldo(BigDecimal.valueOf(tarjeta.getSaldo()));
		tarjetaXML.setNumero(tarjeta.getNumero());
		tarjetaXML.setCvc(tarjeta.getCvc());
		tarjetaXML.setTipo(tarjeta.getTipo());
		tarjetaXML.setNombre(tarjeta.getNombre());
		tarjetaXML.setVencimiento(tarjeta.getVencimiento().toString());
		
		return tarjetaXML;		
	}
	
	
	/*public TarjetaModel toTarjetaModel(Tarjeta tarjetaXML, Boolean setID) {
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
	}*/
}
