package usuario;

public class ExceptionUser extends Exception{

	int codigoError;
	
	public ExceptionUser(int codigoError) { 
		super();
		this.codigoError = codigoError;
		}
	
	@Override
	public String getMessage() {
		String m="";
		
		switch(codigoError) {
			case 000:
				m= "000-Contrase�a fuera del intervalo permitido. Elija una que sea de 8 a 15 caracteres alafanum�ricos";
				break;
			case 001:
				m= "001-Contrase�a vacia. Asegurese de colocar una contrase�a  de 8 o m�s caracteres alafanum�ricos";
				break;
			case 002:
				m= "002-Contrase�a no aceptada. Elija una que sea de 8 a 15 caracteres alafanum�ricos";
				break;
			case 003:
				m= "003-Falta n�mero en su contrase�a";
				break;
			case 004:
				m= "004-Nombre usuario: vacio";
				break;
			case 005:
				m= "005-ID usuario: vacio";
				break;	
			case 006:
				m= "006-Direccion usuario: vacio";
				break;	
			case 007:
				m= "007-correo electronico usuario: vacio";
				break;
		}
		return m;
	}
}
