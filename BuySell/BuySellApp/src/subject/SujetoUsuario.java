package subject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import observer.Observer;
import producto.Producto;
import usuario.Usuario;

public class SujetoUsuario {

	List<Observer> usuarios = new ArrayList<>();
        List<Usuario> usu  = new ArrayList<>();
	Usuario usuario;
        
	/*
	 * agreagamos los observadores
	 */
	public void agregarObservador(Observer observador) {
		if( (observador != null) && (observador instanceof Observer)) {
			this.usuarios.add(observador);
		}
		
	}
	
        public List<Usuario> getListUsuarios(){
            return usu;
        }
	public void agregarListObservador(List<Observer> observadores) {
		if(observadores != null) {
			if(usuarios == null) this.usuarios = observadores;
			else usuarios.addAll(observadores);
		}else { }	
	}
	/*
	 * paso intermedio para notificar a todos
	 * - esta por si se quiere setear una variable -
	 */
	public void setEstado() {
		notifyALL();
	}
	
	public int getSize() {
		return usuarios.size();
	}
	/*
	 * usa un for each para actualizar la bandera de nuevoProducto en todos los usuarios
	 */
	private void notifyALL() {
            System.out.println("OK");
		Usuario u;
		@SuppressWarnings("rawtypes")
		Iterator iterU = usuarios.iterator();
		while(iterU.hasNext()) {
			u = (Usuario)iterU.next();
			u.Actualizar();
			usu.add(u);
		}
	}
}
