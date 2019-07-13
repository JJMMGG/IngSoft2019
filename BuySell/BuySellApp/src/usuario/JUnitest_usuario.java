package usuario;

class JUnitest_usuario {
	static int contador = 0;
	static Usuario u1 = new Usuario();
	
	public static void main(String[] args) {
		/*
		 * se irá probando metodos por metodos
		 */
		prueba_positiva_registro();
		if(contador == 4 ) { System.out.println("Prueba positiva Registro: passed"); }
		else {  System.out.println("Prueba positiva Registro: No passed"); }
		
		contador=0;
		prueba_negativa_registro();
		if(contador == 6 ) { System.out.println("Prueba negativa Registro: passed"); }
		else {  System.out.println("Prueba negativa Registro: No passed"); }
		
	}

	private static void prueba_negativa_registro() {
		// TODO Auto-generated method stub
		try {u1.setNombreUsuario(null); }
		catch(ExceptionUser e) {
			System.out.println(e.getMessage());
			contador++; }
		
		// no logro hacer que me considere mal esto ("   ")...
		try {u1.setIdUsuario("      ");}
		catch(ExceptionUser e) {
			System.out.println(e.getMessage());
			contador++; }
		
		try {u1.setDireccionUsuario("");}
		catch(ExceptionUser e) {
			System.out.println(e.getMessage());
			contador++; }
		
		try {u1.setContraseniaUsuario("holasdsd");}
		catch(ExceptionUser e) {
			System.out.println(e.getMessage());
			contador++; }
		
		try {u1.setContraseniaUsuario("hola");}
		catch(ExceptionUser e) {
			System.out.println(e.getMessage());
			contador++; }
		
		try {u1.setContraseniaUsuario("asdadsdholaada84848");}
		catch(ExceptionUser e) {
			System.out.println(e.getMessage());
			contador++; }
}

	private static void prueba_positiva_registro() {
		// TODO Auto-generated method stub
		try {
			u1.setNombreUsuario("cris32");
			contador++;
			u1.setIdUsuario("2121");
			contador++;
			u1.setDireccionUsuario("Abel Chaneton 603");
			contador++;
			u1.setContraseniaUsuario("hola1234");
			contador++;
		}catch(ExceptionUser e) {
			System.out.println(e.getMessage());
		
	}
  }
}

