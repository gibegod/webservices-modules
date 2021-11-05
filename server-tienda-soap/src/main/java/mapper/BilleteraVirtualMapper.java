package mapper;

import java.math.BigDecimal;
import java.util.Objects;

import com.example.producingwebservice.model.BilleteraVirtualModel;

import io.spring.guides.gs_producing_web_service.BilleteraVirtual;
import lombok.experimental.UtilityClass;

@UtilityClass
public class BilleteraVirtualMapper {

	public BilleteraVirtual toXML(BilleteraVirtualModel billeteraVirtual) {
		BilleteraVirtual billeteraXML = new BilleteraVirtual();

		if(!Objects.isNull(billeteraVirtual)) {
			billeteraXML.setId(billeteraVirtual.getId());
			billeteraXML.setSaldo(BigDecimal.valueOf(billeteraVirtual.getSaldo()));			
		}

		return billeteraXML;
	}

}
