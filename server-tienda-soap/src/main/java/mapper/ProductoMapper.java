package mapper;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import com.example.producingwebservice.model.CategoriaProductoModel;
import com.example.producingwebservice.model.ProductoModel;
import com.example.producingwebservice.model.UsuarioModel;

import io.spring.guides.gs_producing_web_service.CategoriaProducto;
import io.spring.guides.gs_producing_web_service.Producto;
import io.spring.guides.gs_producing_web_service.TipoUsuario;
import io.spring.guides.gs_producing_web_service.Usuario;

public class ProductoMapper {
	
	public ProductoModel toProductoModel (Producto productoXML, CategoriaProductoModel categoriaProdModel,
			UsuarioModel vendedorModel ) {
		ProductoModel pM = new ProductoModel();
		
		pM.setCategoria(categoriaProdModel);
		pM.setVendedor(vendedorModel);
		pM.setNombre(productoXML.getNombre());
		pM.setDescripcion(productoXML.getDescripcion());
		pM.setImagen(productoXML.getImagen());
		pM.setPrecio(productoXML.getPrecio().floatValue());
		pM.setStockInicial(productoXML.getStockInicial().intValue());
		pM.setStockActual(productoXML.getStockActual().intValue());
		pM.setActivo(productoXML.isActivo());
		pM.setDebito(productoXML.isDebito());
		pM.setCredito(productoXML.isCredito());
		
		return pM;
	}
	
	public Producto toProductoXML (ProductoModel productoModel, Boolean setId ) {
		Producto pXML = new Producto();
		CategoriaProducto cXML = new CategoriaProducto();
		Usuario uXML = new Usuario();
		TipoUsuario tXML = new TipoUsuario();
		
		if (setId) {
			cXML.setId(productoModel.getCategoria().getId());
			uXML.setId(productoModel.getVendedor().getId());
			pXML.setId(productoModel.getId());
			tXML.setId(productoModel.getVendedor().getTipo().getId());
		}
		
		cXML.setNombre(productoModel.getNombre());
		tXML.setTipo(productoModel.getVendedor().getTipo().getTipo());
		uXML.setNombre(productoModel.getVendedor().getNombre());
		uXML.setApellido(productoModel.getVendedor().getApellido());
		uXML.setDni(productoModel.getVendedor().getDni());
		uXML.setUsuario(productoModel.getVendedor().getUsuario());
		uXML.setContrasenia(productoModel.getVendedor().getContrasenia());
		uXML.setTipoUsuario(tXML);
		pXML.setNombre(productoModel.getNombre());
		pXML.setDescripcion(productoModel.getDescripcion());
		pXML.setImagen(productoModel.getImagen());
		pXML.setPrecio(BigDecimal.valueOf(productoModel.getPrecio()));
		pXML.setStockInicial(BigInteger.valueOf(productoModel.getStockInicial()));
		pXML.setStockActual(BigInteger.valueOf(productoModel.getStockActual()));
		pXML.setActivo(productoModel.getActivo());
		pXML.setDebito(productoModel.getDebito());
		pXML.setCredito(productoModel.getCredito());
		pXML.setCategoria(cXML);
		pXML.setVendedor(uXML);
		
		return pXML;
	}

}
