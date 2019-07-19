package categoria;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import producto.Producto;
import usuario.Usuario;

class JUnitest_Categoria {
	
	private static Producto producto;
	private static Producto producto2;
	private static Producto producto3;
	private static Producto producto4;
	
	private static Producto producto5;
	private static Producto producto6;
	private static Producto producto7;
	private static Producto producto8;
	private static Producto producto9;
	
	private static Producto producto10;
	private static Producto producto11;
	private static Producto producto12;
	
	private static List<Producto> prodM = new ArrayList<Producto>();
	private static List<Producto> prodV = new ArrayList<Producto>();
	private static List<Producto> prodC = new ArrayList<Producto>();
	
	private static Vehiculo vehiculo;
	private static Muebles muebles;
	private static Computacion comp;
	
	private static Usuario usuario;
	private static Usuario usuario2;
	private static Usuario usuario3;
	
	private static int conta_postivo = 0;
	private static int conta_negativo = 0;
	
	public static void main(String[] args) {
			
		//Creamos Usuarios
		usuario = new Usuario("Cristian","CrisIngSW","MiCasa 23", "pass1234");
		usuario2 = new Usuario("David","DaDa","MiBarrio 323", "asdda12wws");
		usuario3 = new Usuario("Benjamin","Benja_44","MiDpto 243", "41654654as");
		 	
		//Creamos Categorias -- Aplicamos Singleon --
		comp = Computacion.getComputacion();
		muebles = Muebles.getMuebles();
		vehiculo = Vehiculo.getVehiculo();
		//Creamos productos
		crearProductosMueb();
		crearProductosComp();
		crearProductosVehi();
		 
		prueba_positiva_categoria();
		System.out.println( "#########################################");
		prueba_negativa_categoria();
		System.out.println( "#########################################");
		
		imprimirResultado();
                
                System.out.println( "\n----prueba fabrica----");
                FabricaCategoria fabrica = new FabricaCategoria();
                
                ICategoria cat = fabrica.getCategoria("MUEBLES");
                System.out.println(cat.getNombreCategoria());
	}

	private static void crearProductosMueb() {
		producto10 = new Producto(usuario,"Heladera Columbia - usada","Hace falta cambiar su automatico",
				 Muebles.getMuebles(),1000,1);
		producto11 = new Producto(usuario2,"Comoda de Pino","medida: 0.5x2 mts",
				 Muebles.getMuebles(),6000,3);
		producto12 = new Producto(usuario3,"Cama de 2 plazas - alabarrobo","Excelent estado",
				 Muebles.getMuebles(),4000,1);
		
	}

	private static void crearProductosVehi() {
		producto5 = new Producto(usuario,"Bicicleta Ferrer","solo fantan colocar cambios",
				Vehiculo.getVehiculo(),1200,1);
		producto6 = new Producto(usuario2,"Auto Ford fiesta","peque�a abolladura. a�o 2010. ",
				Vehiculo.getVehiculo(),300000,1);
		producto7 = new Producto(usuario3,"Accesorios","Entre ellos portavasos- luneras- cargadores para celulares- etc",
				Vehiculo.getVehiculo(),1,500);
		producto8 = new Producto(usuario,"Parachoque Citroen C3 ","en muy buen estado",
				Vehiculo.getVehiculo(),3000,4);
		producto9 = new Producto(usuario2,"Cubiertas Michelin _ nuevas "," a�o 2016/2017",
				Vehiculo.getVehiculo(),1500,20);
	}

	private static void crearProductosComp() {
		producto = new Producto(usuario3,"paquete Office 2019","incluye: Word,Excel,PowerPoint,etc",
				Computacion.getComputacion(),500,100);
		producto2 = new Producto(usuario,"monitor LG","en buen funcionamiento y muy buena resolucion",
				Computacion.getComputacion(),300,1);
		producto3 = new Producto(usuario2,"Memorias RAM USADAS ","Entre ellas DDR1 DDR2 DDR3",
				Computacion.getComputacion(),1,1);
		producto4 = new Producto(usuario3,"notebook kanji","8 GB ram, 500 GB HDD.",
				Computacion.getComputacion(),6500,3);

	}
	
	/*
	 * no logro resolver el intercambio cruzado de infomacion
	 */
	private static void prueba_negativa_categoria() {
		System.out.println("\n\n##########################################################");
		System.out.println("##########################################################");
		System.out.println("-- Agregando cada producto a su no respectiva lista (-) ----");
		try {
				vehiculo.agregarProducto(producto);
			}catch(ExceptionCategory c) {
				conta_negativo++;
			}
		try {
				vehiculo.agregarProducto(producto10);
			}catch(ExceptionCategory c) {
				conta_negativo++;
			}
		try {
				vehiculo.agregarProducto(producto7); 	
				conta_negativo++;
			}catch(ExceptionCategory c) {}
		
		try {
				muebles.agregarProducto(producto2); 	
			}catch(ExceptionCategory c) {
				conta_negativo++;
			}
			
		try {
			muebles.agregarProducto(producto4); 	
		}catch(ExceptionCategory c) {
			conta_negativo++;
		}
		
		try {
			muebles.agregarProducto(producto10);
			conta_negativo++; 	
		}catch(ExceptionCategory c) { }
		
		try {
			muebles.agregarProducto(producto10); 	
		}catch(ExceptionCategory c) {
			conta_negativo++;
		}
		
		try {
			muebles.agregarProducto(producto8); 	
		}catch(ExceptionCategory c) {
			conta_negativo++;
		}
		try {
			muebles.agregarProducto(producto4);
			conta_negativo++; 	
		}catch(ExceptionCategory c) { }
	
		System.out.println("-- finalizado con exito el enlistado de los productos ----");
		// obtener lista de los productos
		imprimirListas();
	}

	private static void prueba_positiva_categoria() {
		
		System.out.println("-- Agregando cada producto a su respectiva lista (+) ----");
		try {
			vehiculo.agregarProducto(producto9);
			vehiculo.agregarProducto(producto8);
			vehiculo.agregarProducto(producto7);
			vehiculo.agregarProducto(producto6);
			vehiculo.agregarProducto(producto5);
			System.out.println(vehiculo.getListProducto().size());
			conta_postivo += 5;
			muebles.agregarProducto(producto10);
			muebles.agregarProducto(producto11);
			muebles.agregarProducto(producto12);
			System.out.println(muebles.getListProducto().size());
			conta_postivo += 3; 
			comp.agregarProducto(producto);
			comp.agregarProducto(producto2);
			comp.agregarProducto(producto3);
			comp.agregarProducto(producto4);
			conta_postivo += 4;
			System.out.println(comp.getListProducto().size());
		}catch(ExceptionCategory c) {
			System.out.println(c.getMessage());
			}
		System.out.println("-- finalizado con exito el enlistado de los productos ----");
		// obtener lista de los productos
		imprimirListas();
			
	}
		
	
	
	private static void imprimirListas() {
		if( muebles.getListProducto()  == null) {System.out.println("No hay elementos en -MUEBLES-"); }
		else{
			System.out.println("-- lsita de elementos ----");
			prodM = muebles.getListProducto();
			
			Producto p;
			@SuppressWarnings("rawtypes")
			Iterator iterM = prodM.iterator();
			while(iterM.hasNext()) {
				p = (Producto)iterM.next();
				System.out.println(p.toString());
				System.out.println("-------------------------");
				}
			}
		
		if( comp.getListProducto()  == null) {System.out.println("No hay elementos en -COMPUTACION-"); }
		else{
			System.out.println("-- lsita de elementos ----");
			prodC = comp.getListProducto();
			
			Producto p;
			@SuppressWarnings("rawtypes")
			Iterator iter = prodC.iterator();
			while(iter.hasNext()) {
				p = (Producto)iter.next();
				System.out.println(p.toString());
				System.out.println("-------------------------");
			}
		}
		if( vehiculo.getListProducto()  == null) {System.out.println("No hay elementos en -VEHICULO-"); }
		else{
			prodV = vehiculo.getListProducto();
			System.out.println(prodV.size() + "-- lsita de elementos ----");
			
			Producto p;
			@SuppressWarnings("rawtypes")
			Iterator iterV = prodV.iterator();
			while(iterV.hasNext()) {
				p = (Producto)iterV.next();
				System.out.println(p.toString());
				System.out.println("-------------------------");
			}
		}
	}
	
	
	private static void imprimirResultado() {
		// TODO Auto-generated method stub
		
	}


}
