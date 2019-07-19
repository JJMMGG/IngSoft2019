package producto;

import categoria.Computacion;
import categoria.ICategoria;
import categoria.Muebles;
import categoria.Vehiculo;
import usuario.Usuario;

class JUnitest_Producto {
	private static Producto producto;
	private static Vehiculo vehiculo;
	private static Muebles muebles;
	private static Computacion comp;
	private static Usuario usuario;
	private static int conta_postivo = 0;
	private static int conta_negativo = 0;
	
	public static void main(String[] args) {
	
		producto = new Producto();
		vehiculo = Vehiculo.getVehiculo();
		comp = Computacion.getComputacion();
		muebles = Muebles.getMuebles();
		
		usuario = new Usuario("Cristian","CrisIngSW","MiCasa,23", "pass1234");
		
		
		prueba_positiva_producto(producto,vehiculo,comp,muebles,usuario);
		System.out.println( "#########################################");
		prueba_negativa_producto( new Producto(),vehiculo,comp,muebles,usuario);
		System.out.println( "#########################################");
		
		imprimirResultado();
	}

	private static void prueba_positiva_producto(Producto producto,ICategoria v, ICategoria c,
													ICategoria m, Usuario usuario) {
		// ------ prueba SET ------------
		// .............. VEHICULO .....................
		try {producto.setNombreProducto("Articulos para Autos"); 
			conta_postivo++;}
		catch(ExceptionProducto p){ System.out.println(p.getMessage());}
		
		try {producto.setDescripcionProducto("Desde portavasos hasta equipo de herramienta");
			conta_postivo++;}
		catch(ExceptionProducto p){ System.out.println(p.getMessage());}
		
		try {producto.setNombreCategoria(v.getNombreCategoria());; 
			conta_postivo++;}
		catch(ExceptionProducto p){ System.out.println(p.getMessage());}
		
		try {producto.setICategoria(v); 
			conta_postivo++;}
		catch(ExceptionProducto p){ System.out.println(p.getMessage());}
		
		try {producto.setPrecioProducto(2000); 
			conta_postivo++;}
		catch(ExceptionProducto p){ System.out.println(p.getMessage());}
		
		try {producto.setUsuarioProducto(usuario); 
			conta_postivo++;}
		catch(ExceptionProducto p){ System.out.println(p.getMessage());}
		
		try {producto.setCantidadProducto(50); 
			conta_postivo++;}
		catch(ExceptionProducto p){ System.out.println(p.getMessage());}
		
		//-----------------INFORMACION-----------------------------
		System.out.println( producto.toString() );
		System.out.println( "#########################################");
		//----------------------------------------------
		
		//........................... COMPUTACION ............................
		try {producto.setNombreProducto("Monitor LG-Flatron T10B"); 
			conta_postivo++;}
		catch(ExceptionProducto p){ System.out.println(p.getMessage());}
	
		try {producto.setDescripcionProducto("En buen funcionamiento y alta resolucion");
			conta_postivo++;}
		catch(ExceptionProducto p){ System.out.println(p.getMessage());}
	
		try {producto.setNombreCategoria(c.getNombreCategoria());; 
			conta_postivo++;}
		catch(ExceptionProducto p){ System.out.println(p.getMessage());}
	
		try {producto.setICategoria(c); 
			conta_postivo++;}
		catch(ExceptionProducto p){ System.out.println(p.getMessage());}
	
		try {producto.setPrecioProducto(500); 
			conta_postivo++;}
		catch(ExceptionProducto p){ System.out.println(p.getMessage());}
	
		try {producto.setUsuarioProducto(usuario); 
			conta_postivo++;}
		catch(ExceptionProducto p){ System.out.println(p.getMessage());}
	
		try {producto.setCantidadProducto(1); 
			conta_postivo++;}
		catch(ExceptionProducto p){ System.out.println(p.getMessage());}
		
		//------------------INFORMACION ----------------------------
		System.out.println( producto.toString() );
		System.out.println( "#########################################");
		//----------------------------------------------
		
		//........................... MUEBLES ............................
				try {producto.setNombreProducto("Heladera COLUMBIA- CL1025"); 
					conta_postivo++;}
				catch(ExceptionProducto p){ System.out.println(p.getMessage());}
			
				try {producto.setDescripcionProducto("funciona aunque tiene varios a�os");
					conta_postivo++;}
				catch(ExceptionProducto p){ System.out.println(p.getMessage());}
			
				try {producto.setNombreCategoria(m.getNombreCategoria());; 
					conta_postivo++;}
				catch(ExceptionProducto p){ System.out.println(p.getMessage());}
			
				try {producto.setICategoria(m); 
					conta_postivo++;}
				catch(ExceptionProducto p){ System.out.println(p.getMessage());}
			
				try {producto.setPrecioProducto(1100); 
					conta_postivo++;}
				catch(ExceptionProducto p){ System.out.println(p.getMessage());}
			
				try {producto.setUsuarioProducto(usuario); 
					conta_postivo++;}
				catch(ExceptionProducto p){ System.out.println(p.getMessage());}
			
				try {producto.setCantidadProducto(3); 
					conta_postivo++;}
				catch(ExceptionProducto p){ System.out.println(p.getMessage());}
				
				//------------------INFORMACION ----------------------------
				System.out.println( producto.toString() );
				System.out.println( "#########################################");
				//----------------------------------------------
		//-------------------------------------------------------------------------//
		
	}

	private static void prueba_negativa_producto(Producto producto,ICategoria v, ICategoria c,
													ICategoria m, Usuario usuario) {
		try {producto.setNombreProducto("");  }
		catch(ExceptionProducto p){ System.out.println(p.getMessage());
		conta_negativo++;}
	
		try {producto.setDescripcionProducto("        "); }
		catch(ExceptionProducto p){ System.out.println(p.getMessage());
			conta_negativo++; }
	
		//verifiar si el nombre coincide con alguna categoria
		try {producto.setNombreCategoria("ARRIVEDERCHI"); }
		catch(ExceptionProducto p){ System.out.println(p.getMessage());
			conta_negativo++; }
	
		// se puede colar en cualquier categoria sin ser detectado.
		// prueba de un ibjeto string
		try {producto.setICategoria(v); conta_negativo++; } 
		catch(ExceptionProducto p){ System.out.println(p.getMessage()); }
	
		try {producto.setPrecioProducto(-200); }
		catch(ExceptionProducto p){ System.out.println(p.getMessage());
			conta_negativo++; }
	
		try {producto.setUsuarioProducto(null); }
		catch(ExceptionProducto p){ System.out.println(p.getMessage()); conta_negativo++;}
	    finally{
	    	try {producto.setUsuarioProducto(usuario); }
			catch(ExceptionProducto p){ System.out.println(p.getMessage());
				 }
	    }
		
		try {producto.setCantidadProducto(0); }
		catch(ExceptionProducto p){ System.out.println(p.getMessage());
		conta_negativo++; }
	
	//-----------------INFORMACION-----------------------------
	System.out.println( "\n"+producto.toString() );
	System.out.println( "#########################################");
	//----------------------------------------------
	
	}
	
	private static void imprimirResultado() {
		System.out.println("---------------------------------------------------");
		System.out.print("prueba positiva: " + conta_postivo +"/21");
		if(conta_postivo == 21) {System.out.println("---- PASEED"); }
		else { System.out.println("---- NO PASEED");  }
		System.out.print("pruebas negativas: " + conta_negativo +"/7");
		if(conta_negativo == 7) {System.out.println("---- PASEED"); }
		else { System.out.println("---- NO PASEED");  }
		System.out.println("---------------------------------------------------\n");
	}

}
