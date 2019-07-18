package usuario;

import observer.Observer;
import subject.SujetoUsuario;

public class Usuario extends Observer{

	private String nombre;
        private String apellido;
        private String email;
        private String direccion;
	private String Id;
	private String contrasenia;
	private boolean nuevoProducto;			// me permite cambiar de estado cuando hay un nuevo producto
	private int soldProducto;			// me permite cambiar de estado cuando se compro un producto de este usuario
							// el int hace referencia a si se le compro en varias publicaciones.

	
	public Usuario() { nuevoProducto = false; soldProducto = 0; }
	
	public Usuario( String nombre, String Id, String direccion, String contrasenia){
		try {
			setContraseniaUsuario(contrasenia);
			setNombreUsuario(nombre);
			setDireccionUsuario(direccion);
			setIdUsuario(Id);
		}catch(ExceptionUser e) {
			System.out.println(e.getMessage());                                                                                                                                                  
		}
		
		this.nuevoProducto = false;
		this.soldProducto = 0;
	}
	
	// -----------  GET -----------------//
	public String getNombreUsuario() { return nombre; }
	public String getIdUsuario() { return Id; }
	public String getDireccionUsuario() { return direccion;}
	public String getContraseniaUsuario() { return contrasenia; }
	//public boolean getNuevoProducto() { return nuevoProducto;}
	public String getNuevoProducto() { if(nuevoProducto) return "SI"; return "NO";} 
        public String getProductoVendido() { return ("" + soldProducto); }
	// ------------ SET -----------------//
	public void setNombreUsuario(String nombre)throws ExceptionUser {
		if((nombre == null) || (nombre.trim().isEmpty()) ) { throw new ExceptionUser(004); }
		this.nombre = nombre; 
		}
	
	public void setIdUsuario(String Id)throws ExceptionUser {
		if( (nombre == null ) || (Id.trim().isEmpty()) ) { throw new ExceptionUser(005); }
		this.Id = Id; 
		}
	
	public void setDireccionUsuario(String direccion)throws ExceptionUser { 
		if( (nombre == null) || ((direccion.trim().isEmpty())) ) { throw new ExceptionUser(006); }
		this.direccion = direccion;
		}
		
	public void setContraseniaUsuario(String contrasenia)throws ExceptionUser{
		if(contrasenia == null) { throw new ExceptionUser(002); }
		else if( contrasenia.length()>15 || contrasenia.length()<8 ) { throw new ExceptionUser(000); }
		if( contrasenia.trim().isEmpty() ) { throw new ExceptionUser(001); }
		else if( !contieneNumero(contrasenia) ) { throw new ExceptionUser(003); }
		
		this.contrasenia = contrasenia; 
		}
	
	public void setSubjectUsuario(SujetoUsuario sujeto) {
		
		this.sujeto = sujeto;
		this.sujeto.agregarObservador(this);
	}
	
	//-------------------------------------------------			
	private void SetSujeto(SujetoUsuario suj) { 
		this.sujeto = suj;
		this.sujeto.agregarObservador(this);
	}
	
	public SujetoUsuario getSujeto() { return this.sujeto; }
	//-------------------------------------------------
	private void setNuevoProducto() { this.nuevoProducto = true; }
	
        public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
	@Override
	public void Actualizar() {
		setNuevoProducto();
	}
	
    private boolean contieneNumero(String pass) {
	char arr[] = pass.toCharArray();
	char num[] = "0123456789".toCharArray();
	for(int i=0; i< pass.length(); i++) {
            for(int j=0; j<pass.length(); j++) {
		if(num[j] == arr[i]) return true;
            }
	}
	return false; 
    }
    
    @Override
    public String toString(){
        String info = "";
        info = info + getNombreUsuario() + "\n" + getApellido() + "\n";
        info = info + getEmail() + "\n" + getDireccion() + "\n";
        info = info + getIdUsuario() + "\n" + getContraseniaUsuario() + "\n";
        info = info + getNuevoProducto() + "\n" + getProductoVendido();
        return info;
    }
}
