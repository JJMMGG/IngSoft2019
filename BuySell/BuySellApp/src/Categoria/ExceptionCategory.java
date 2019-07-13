package categoria;

@SuppressWarnings("serial")
public class ExceptionCategory extends Exception{

	int codigoError;
	
	public ExceptionCategory(int codigoError) { 
		super();
		this.codigoError = codigoError;
		}
	
	@Override
	public String getMessage() {
		String m="";
		
		switch(codigoError) {
			case 100:
				m= "100-Argumento null";
				break;
			case 200:
				m= "200-Objeto no encontrado";
				break;	
			case 300:
				m= "300-Objeto no pertence a esta categoria";
				break;
		}
		return m;
	}
}
