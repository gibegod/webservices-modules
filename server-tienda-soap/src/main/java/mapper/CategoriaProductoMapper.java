package mapper;

import com.example.producingwebservice.model.CategoriaProductoModel;

import io.spring.guides.gs_producing_web_service.CategoriaProducto;

public class CategoriaProductoMapper {
	
	public CategoriaProductoModel toCategoriaProductoModel(CategoriaProducto categoriaXML, Boolean setID) {
		CategoriaProductoModel cpM = new CategoriaProductoModel();
		if (setID) cpM.setId(categoriaXML.getId());
		cpM.setNombre(categoriaXML.getNombre());
		return cpM;
	}
	
	public CategoriaProducto toCategoriaProductoXML(CategoriaProductoModel categoriaModel) {
		CategoriaProducto categoriaXML = new CategoriaProducto();
		categoriaXML.setId(categoriaModel.getId());
		categoriaXML.setNombre(categoriaModel.getNombre());
		return categoriaXML;
	}

}
