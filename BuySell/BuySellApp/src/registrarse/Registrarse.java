package registrarse;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import usuario.ExceptionUser;
import usuario.Usuario;

/*
 * ver de poder leer una archivo donde estaran la lista de usuarios.
 */
public class Registrarse {

	private List<Usuario> Lusuarios;
	
	void Registrarse() { 
		Lusuarios = new ArrayList<>();
	}
		
	public boolean verificarUsuario(Usuario usuario) {
		Usuario u;
		@SuppressWarnings("rawtypes")
		Iterator iterU = Lusuarios.iterator();
		while(iterU.hasNext()) {
			u = (Usuario)iterU.next();
			if( u.getIdUsuario() == usuario.getIdUsuario() ) {return false;}
		}
		if( Lusuarios.contains(usuario) ) { return false;}
		
		return verificarContrasenia(usuario.getContraseniaUsuario());
		
	}
	
	
	private boolean verificarContrasenia(String contrasenia) {
		Usuario u = new Usuario();
		try {
			u.setContraseniaUsuario(contrasenia);
		}catch(ExceptionUser us) {
			System.out.println(us.getMessage());
			return false;
		}
		return true;
	}
	
	
}
