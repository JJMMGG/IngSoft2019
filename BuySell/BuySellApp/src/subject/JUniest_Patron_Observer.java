package subject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import categoria.Computacion;
import categoria.ExceptionCategory;
import categoria.Muebles;
import categoria.Vehiculo;
import producto.Producto;
import usuario.Usuario;

class JUniest_Patron_Observer {

	private static Usuario usuario1;
	private static Usuario usuario2;
	private static Usuario usuario3;
	private static Usuario usuario4;
	private static Usuario usuario5;
	private static Usuario usuario6;
	
	private static Producto producto;
	private static Producto producto2;
	private static Producto producto3;
	private static Producto producto4;
	private static Producto producto5;
	private static Producto producto6;
	
	private static List<Producto> prodM = new ArrayList<>();
	private static final List<Producto> prodV = new ArrayList<>();
	private static final List<Producto> prodC = new ArrayList<>();

	private static final List<Usuario> Lusu = new ArrayList<>();
	private static Vehiculo vehiculo;
	private static Muebles muebles;
	private static Computacion comp;
	
	static SujetoUsuario suj;
	
	public static void main(String[] args) {
	
		suj = new SujetoUsuario();
		
		//Creo usuarios
		usuario1 = new Usuario("Cristian","CrisIngSW","MiCasa 23", "pass1234");
		usuario2 = new Usuario("David","DaDa","MiBarrio 323", "asdda12wws");
		usuario3 = new Usuario("Benjamin","Benja_44","MiDpto 243", "41654654as");
		usuario4 = new Usuario("Juan","Juan_g","Mirancho 758", "jjjj1111");
		usuario5 = new Usuario("Manuel","Manu10","Miedificio 65", "mmmm1111");
		usuario6 = new Usuario("UsuXll","Xll","Micampo 645", "xxxx1111");
		//Creamos Categorias -- Aplicamos Singleon --
		comp = Computacion.getComputacion();
		muebles = Muebles.getMuebles();
		vehiculo = Vehiculo.getVehiculo();
				
		//Creamos productos
		crearProductosMueb();
		crearProductosComp();
		crearProductosVehi();	
		//enlistar
		enlistarObservadores();
		System.out.println("cantidad Observadore: " + suj.getSize());
                
		list_usuarios();
                System.out.println("cantidad Usuarios: " + Lusu.size());
                comprobar_notificacion();
                
		prueba_postiva();
		
		comprobar_notificacion();
	}
	
	private static void list_usuarios() {
		Lusu.add(usuario1);
		Lusu.add(usuario2);
		Lusu.add(usuario3);
		Lusu.add(usuario4);
		Lusu.add(usuario5);
	}

	private static void comprobar_notificacion() {
		Usuario u;
		@SuppressWarnings("rawtypes")
		Iterator iterU = Lusu.iterator();
		while(iterU.hasNext()) {
			u = (Usuario)iterU.next();
			System.out.println(u.getNuevoProducto());
			
		}
	}

	private static void prueba_postiva() {
		try {
			comp.agregarProducto(producto);
		}catch(ExceptionCategory e) {
			System.out.println(e.getMessage());
		}
	}

	private static void enlistarObservadores() {
		usuario1.setSubjectUsuario(suj);
		usuario2.setSubjectUsuario(suj);
		usuario3.setSubjectUsuario(suj);
		usuario4.setSubjectUsuario(suj);
		usuario5.setSubjectUsuario(suj);
	}

	private static void crearProductosMueb() {
		producto3 = new Producto(usuario1,"Heladera Columbia - usada","Hace falta cambiar su automatico",
				 Muebles.getMuebles(),100,1);
		producto4 = new Producto(usuario2,"Comoda de Pino","medida: 0.5x2 mts",
				 Muebles.getMuebles(),6000,3);
		
	}

	private static void crearProductosVehi() {
		producto5 = new Producto(usuario3,"Bicicleta Ferrer","solo fantan colocar cambios",
				Vehiculo.getVehiculo(),1200,1);
		producto6 = new Producto(usuario4,"Auto Ford fiesta","peque�a abolladura. a�o 2010. ",
				Vehiculo.getVehiculo(),30000,1);
	}

	private static void crearProductosComp() {
		producto = new Producto(usuario5,"paquete Office 2019","incluye: Word,Excel,PowerPoint,etc",
				Computacion.getComputacion(),500,100);
		producto2 = new Producto(usuario6,"monitor LG","en buen funcionamiento y muy buena resolucion",
				Computacion.getComputacion(),300,1);

	}
	
}
