/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import usuario.ExceptionUser;
import usuario.ListaUsuarios;
import usuario.Usuario;

/**
 *
 * @author DaCriPer
 */
public class ModeloRegistrarse implements IModelo{
    
    private final Usuario usu;
    private final ListaUsuarios Lusu;
    
    public ModeloRegistrarse(){
        Lusu = ListaUsuarios.getListaUsuarios();
        usu = new Usuario();
    }
 
    public boolean BuscarUsuario(String nombre){ 
        return Lusu.existe(nombre);
    }
    
    public boolean VerificarContrasenia(String contrasenia){
        Usuario usuAux = new Usuario();
        try{
            usuAux.setContraseniaUsuario(contrasenia);
        }catch(ExceptionUser e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean RegistrarUsuario(String[] s) {
        return Lusu.addUsuario(s);
    }
    
    
}
