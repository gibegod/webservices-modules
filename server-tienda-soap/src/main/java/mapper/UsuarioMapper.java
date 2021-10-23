package mapper;

import com.example.producingwebservice.model.TipoUsuarioModel;
import com.example.producingwebservice.model.UsuarioModel;

import io.spring.guides.gs_producing_web_service.TipoUsuario;
import io.spring.guides.gs_producing_web_service.Usuario;

public class UsuarioMapper {
	//Se mapea el UsuarioXML al modelo acompañado por el TipoUsuario generado con ID  
	public UsuarioModel toUsuarioModel(Usuario usuarioXML, TipoUsuarioModel tipoUsuarioModel) {
		UsuarioModel uM = new UsuarioModel();
		
		uM.setTipo(tipoUsuarioModel);
		uM.setNombre(usuarioXML.getNombre());
		uM.setApellido(usuarioXML.getApellido());
		uM.setDni(usuarioXML.getDni());
		uM.setUsuario(usuarioXML.getUsuario());
		uM.setContrasenia(usuarioXML.getContrasenia());
		//uM.setTelefono(usuarioXML.getTelefono());
		
		return uM;
	}
	
//	public UsuarioModel toUsuarioModel(Usuario usuarioXML, TipoUsuario tipoUsuarioXML) {
//		UsuarioModel uM = new UsuarioModel();
//		TipoUsuarioModel tUm = new TipoUsuarioModel();
//		tUm.setTipo(tipoUsuarioXML.getTipo());
//		uM.setNombre(usuarioXML.getNombre());
//		uM.setApellido(usuarioXML.getApellido());
//		uM.setDni(usuarioXML.getDni());
//		uM.setUsuario(usuarioXML.getUsuario());
//		uM.setContrasenia(usuarioXML.getContrasenia());
//		
//		return uM;
//	}
	
	public Usuario toUsuarioXML(UsuarioModel usuarioModel,Boolean setId) {
		Usuario uXml = new Usuario();
		TipoUsuario tXml = new TipoUsuario();
		if (setId) {
			tXml.setId(usuarioModel.getTipo().getId());
			uXml.setId(usuarioModel.getId());
		}
		tXml.setTipo(usuarioModel.getTipo().getTipo());
		uXml.setNombre(usuarioModel.getNombre());
		uXml.setApellido(usuarioModel.getApellido());
		uXml.setDni(usuarioModel.getDni());
		uXml.setUsuario(usuarioModel.getUsuario());
		uXml.setContrasenia(usuarioModel.getContrasenia());
		//uXml.setTelefono(usuarioModel.getTelefono());
		uXml.setTipoUsuario(tXml);
		
		return uXml;
	}
}
