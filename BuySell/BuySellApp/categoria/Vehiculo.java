package categoria;

import java.util.ArrayList;
import java.util.List;

import producto.Producto;

public class Vehiculo implements ICategoria {
	
	String nombreCategoria = "VEHICULO";
	List<Producto> productos = new ArrayList<Producto>();
	private Producto p;
	private static Vehiculo vhei;
	
	private Vehiculo() { } // en private estariamos frente a un SINGLETON
	
	// solo obtengo una unica instancia de Auto
	public static Vehiculo getVehiculo() {
		if( vhei == null) { return new Vehiculo(); }
		return vhei;
	}
	
	@Override
	public void agregarProducto(Producto producto)throws ExceptionCategory {
		if(producto == null) { throw new ExceptionCategory(300);}
		else if(!(producto instanceof Producto)) {throw new ExceptionCategory(400);}
		else if( !(producto.getNombreCategoria() == getNombreCategoria()) ){throw new ExceptionCategory(300);}
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
