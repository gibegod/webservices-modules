package mapper;

import com.example.producingwebservice.model.MedioPagoModel;
import com.example.producingwebservice.model.ProductoMedioPagoModel;
import com.example.producingwebservice.model.ProductoModel;

import io.spring.guides.gs_producing_web_service.ProductoMedioPago;

public class ProductoMedioPagoMapper {
	
	public ProductoMedioPagoModel toProductoMedioPagoModel (ProductoModel productoModel, MedioPagoModel mpModel ) {
		ProductoMedioPagoModel pMP = new ProductoMedioPagoModel();
		
		pMP.setProducto(productoModel);
		pMP.setMediopago(mpModel);
		
		return pMP;
	}
	
	public ProductoMedioPago toProductoMedioPagoXML(ProductoMedioPagoModel pMP) {
		ProductoMedioPago pXML = new ProductoMedioPago();
		return pXML;
	}

}
