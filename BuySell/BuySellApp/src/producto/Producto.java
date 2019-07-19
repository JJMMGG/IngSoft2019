package producto;

import java.util.ArrayList;
import java.util.List;

import categoria.ICategoria;
import usuario.Usuario;

public final class Producto {

	private List<String> Lcat= new ArrayList<>();
	private Usuario usuario;
	private String nombreProducto;
	private String Descripcion;
	private String nombreCategoria;
	private ICategoria categoria;
	private int precio;
	int cantidad;
	private int vendido;			
	// la idea es poder setear su bandera de vendido para cuando tengamos que avisar al usuario vendedor
	
	
	public Producto() {
		Lcat.add("VEHICULO");
		Lcat.add("MUEBLES");
		Lcat.add("COMPUTACION");
	}
	
	public Producto(Usuario usuario, String nombreProducto, String descripcion, 
						ICategoria categoria, int precio, int cantidad)
	{
		Lcat.add("VEHICULO");
		Lcat.add("MUEBLES");
		Lcat.add("COMPUTACION");
		try {
                    setUsuarioProducto(usuario);
                    setNombreProducto(nombreProducto);
                    setDescripcionProducto(descripcion);
                    setICategoria(categoria);
                    setPrecioProducto(precio);
                    setNombreCategoria(categoria.getNombreCategoria());
                    setCantidadProducto(cantidad);
		}catch(ExceptionProducto p){
                    System.out.println(p.getMessage());
		}
	}
	
		// -----------  GET -----------------//
		public String getNombreProducto() { return nombreProducto; }
		public String getNombreCategoria() { return nombreCategoria; }
		public String getDescripcionProducto() { return Descripcion; }
		public ICategoria getICategoria() { return categoria;}
		public String getPrecioProductoString() { return "" + precio; }
                public int getPrecioProductoInt() { return  precio; }
		public Usuario getUsuarioProducto() { return usuario;}
		public int getCantidadProducto() {return cantidad;}
		// ------------ SET -----------------//
		public void setNombreProducto(String nombreProducto)throws ExceptionProducto { 
			
			if( nombreProducto == null ) { throw new ExceptionProducto(1001); }
			else if(nombreProducto.trim().isEmpty())  { throw new ExceptionProducto(1002); }
			this.nombreProducto = nombreProducto; 
		}
		
		public void setDescripcionProducto(String descripcion)throws ExceptionProducto {
			
			if( descripcion == null ) { throw new ExceptionProducto(1003); }
			else if(descripcion.trim().isEmpty())  { throw new ExceptionProducto(1004); }
			this.Descripcion = descripcion;
		}
		
		public void setICategoria(ICategoria categoria)throws ExceptionProducto { 
			if( categoria == null ) { throw new ExceptionProducto(1005); }
			if( !(categoria instanceof ICategoria) ) { throw new ExceptionProducto(1006); }
                        if( !Lcat.contains( categoria.getNombreCategoria() )){ throw new ExceptionProducto(1006);}
			this.categoria = categoria;
		}
		
		public void setPrecioProducto(int precio)throws ExceptionProducto {
			if( precio <= 0 ) { throw new ExceptionProducto(1007); }
			this.precio = precio; 
		}
		
		public void setUsuarioProducto(Usuario usuario)throws ExceptionProducto { 
			if(usuario == null ) { throw new ExceptionProducto(1008); }
			if(!(usuario instanceof Usuario)) { throw new ExceptionProducto(1009); }
			this.usuario = usuario;
		}
		
		public void setNombreCategoria(String nombreCategoria)throws ExceptionProducto { 
			if( nombreCategoria == null ) {  throw new ExceptionProducto(1010);}
			else if(nombreCategoria.trim().isEmpty())  { throw new ExceptionProducto(1011); }
			if( !(Lcat.contains(nombreCategoria.toUpperCase())) ) { throw new ExceptionProducto(1013);}
			
			this.nombreCategoria = nombreCategoria.toUpperCase();
			}
		
		public void setCantidadProducto(int cantidad)throws ExceptionProducto { 
			if(cantidad <= 0) { throw new ExceptionProducto(1012);}
			this.cantidad = cantidad;
		}
		
		@Override
		public String toString() {
			String palabra;
			palabra = "[Pro: " + getNombreProducto() + "]\n-Categoria: " + getNombreCategoria()+"\n";
			palabra = palabra + "-Usuuario: " +getUsuarioProducto().getNombreUsuario()+"\n" ;
			palabra = palabra + "-Precio U: $" + getPrecioProductoString() ;
			palabra = palabra + "\n-Cantidad: " + getCantidadProducto();
			palabra = palabra + "\n-Descripcion: " + getDescripcionProducto();
			return palabra;
		}
}
