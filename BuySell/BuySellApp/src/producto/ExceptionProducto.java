package producto;

@SuppressWarnings("serial")
public class ExceptionProducto extends Exception {
	
	int codigoError;
	
	public ExceptionProducto(int codigoError) { 
		super();
		this.codigoError = codigoError;
		}
	
	@Override
	public String getMessage() {
		String m="";
		
		switch(codigoError) {
			case 1000:
			case 1002:
				m= "1002-Nombre del producto: no acpetado";
				break;
			case 1003:
			case 1004:
				m= "1003-Descripcion del producto: no aceptado";
				break;
			case 1005:
			case 1006:
				m= "1005-Categoria del producto: no aceptado";
				break;	
			case 1007:
				m= "1007-Precio: no aceptado";
				break;	
			case 1008:
				m= "1008-Usuario null no aceptado";
				break;
			case 1009:
				m= "1009-Error Usuario";
				break;
			case 1010:
				m= "1010-Nombre de la categoria no aceptado";
				break;
			case 1011:
				m= "1011-Nombre de la categoria: vacio";
				break;
			case 1012:
				m= "1012-Cantidad de productos: negativa o cero";
				break;
			case 1013:
				m= "1013-Categoria: No aceptada - [VEHICULO; MUEBLES; COMPUTACION]";
				break;
		}
		return m;
	}

}
