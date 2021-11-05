package mapper;

import com.example.producingwebservice.model.TipoUsuarioModel;
import com.example.producingwebservice.model.UsuarioModel;

import io.spring.guides.gs_producing_web_service.TipoUsuario;
import io.spring.guides.gs_producing_web_service.Usuario;

public class UsuarioMapper {
	//Se mapea el UsuarioXML al modelo acompañado por el TipoUsuario generado con ID  
	public UsuarioModel toUsuarioModel(Usuario usuarioXML, TipoUsuarioModel tipoUsuarioModel) {
		UsuarioModel uM = new UsuarioModel();
		
		uM.setApellido(usuarioXML.getApellido());
		uM.setContrasenia(usuarioXML.getContrasenia());
		uM.setDni(usuarioXML.getDni());
		uM.setNombre(usuarioXML.getNombre());
		uM.setTelefono(usuarioXML.getTelefono());
		uM.setUsuario(usuarioXML.getUsuario());
		uM.setTipo(tipoUsuarioModel);
		
		return uM;
	}
	
	//Se mapea con ID
	public UsuarioModel toUsuarioModel(Usuario usuarioXML) {
		UsuarioModel uM = new UsuarioModel();
		TipoUsuarioModel tUm = new TipoUsuarioModel();
		tUm.setTipo(usuarioXML.getTipoUsuario().getTipo());
		tUm.setId(usuarioXML.getTipoUsuario().getId());
		uM.setTipo(tUm);
		uM.setId(usuarioXML.getId());
		uM.setNombre(usuarioXML.getNombre());
		uM.setApellido(usuarioXML.getApellido());
		uM.setDni(usuarioXML.getDni());
		uM.setUsuario(usuarioXML.getUsuario());
		uM.setContrasenia(usuarioXML.getContrasenia());
		//uXml.setTelefono(usuarioModel.getTelefono());
		
		return uM;
	}
	
	public UsuarioModel toUsuarioModel(UsuarioModel usuario, TipoUsuarioModel tipoUsuario, Usuario usuarioXML) {		
		usuario.setApellido(usuarioXML.getApellido());
		usuario.setContrasenia(usuarioXML.getContrasenia());
		usuario.setDni(usuarioXML.getDni());
		usuario.setNombre(usuarioXML.getNombre());
		usuario.setTelefono(usuarioXML.getTelefono());
		usuario.setUsuario(usuarioXML.getUsuario());
		usuario.setTipo(tipoUsuario);
		
		return usuario;
	}
	
	public Usuario toUsuarioXML(UsuarioModel usuarioModel, Boolean setId) {
		Usuario uXML = new Usuario();
		
		if (setId) {
			uXML.setId(usuarioModel.getId());
		}
		uXML.setNombre(usuarioModel.getNombre());
		uXML.setApellido(usuarioModel.getApellido());
		uXML.setDni(usuarioModel.getDni());
		uXML.setUsuario(usuarioModel.getUsuario());
		uXML.setContrasenia(usuarioModel.getContrasenia());
		TipoUsuario tXML = new TipoUsuario();
		tXML.setId(usuarioModel.getTipo().getId());
		tXML.setTipo(usuarioModel.getTipo().getTipo());
		uXML.setTipoUsuario(tXML);
		
		return uXML;
	}
}
