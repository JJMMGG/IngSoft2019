package categoria;

import java.util.ArrayList;
import java.util.List;

import producto.Producto;

public class Computacion implements ICategoria{

	String nombreCategoria = "COMPUTACION";
	List<Producto> productos = new ArrayList<Producto>();
	private Producto p;
	private static Computacion comp;
	
	private Computacion() {	} // en private estariamos frente a un SINGLETON
	
	// solo obtengo una unica instancia de Auto
	public static Computacion getComputacion() {
		if( comp == null) { return new Computacion(); }
		return comp;
	}
	
	@Override
	public void agregarProducto(Producto producto)throws ExceptionCategory {
		if(producto == null) { throw new ExceptionCategory(100);}
		else if(!(producto instanceof Producto)) {throw new ExceptionCategory(200);}
		else if(producto.getNombreCategoria() != getNombreCategoria() ){throw new ExceptionCategory(300);}
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
