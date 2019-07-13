package categoria;

import java.util.ArrayList;
import java.util.List;

import producto.Producto;
import usuario.Usuario;

public class Muebles implements ICategoria{

	String nombreCategoria = "MUEBLES";
	List<Producto> productos = new ArrayList<Producto>();
	Producto p = new Producto(); 
	private static Muebles mueble;
	
	private Muebles() {	} // en private estariamos frente a un SINGLETON
	
	// solo obtengo una unica instancia de Auto
	public static Muebles getMuebles() {
		if( mueble == null) { return new Muebles(); }
		return mueble;
	}
	
	@Override
	public void agregarProducto(Producto producto)throws ExceptionCategory {
		if(producto == null) { throw new ExceptionCategory(100);}
		else if(!(producto instanceof Producto)) {throw new ExceptionCategory(200);}
		else if(producto.getNombreCategoria() != getNombreCategoria() ){throw new ExceptionCategory(300);}// esto falta de ver
		this.productos.add(producto);
		p = producto;
		notificarNuevoProducto();
	}
	
	@Override
	public List<Producto> getListProducto(){
		return productos;
	}
		
	@Override
	public String getNombreCategoria() {
		return nombreCategoria;
	}
	
	private void notificarNuevoProducto() {
		p.getUsuarioProducto().getSujeto().setEstado();
	}
}

