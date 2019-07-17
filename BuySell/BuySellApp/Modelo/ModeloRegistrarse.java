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
    
    private Usuario usu;
    private ListaUsuarios Lusu;
    
    public ModeloRegistrarse(){
        Lusu = new ListaUsuarios();
        usu = new Usuario();
    }
 
    public boolean BuscarUsuario(String nombre){
        usu = Lusu.getUsuario(nombre);
        return usu != null;
    }
    
    public boolean VerificarContrasenia(String contrasenia){
        try{
            usu.setContraseniaUsuario(contrasenia);
        }catch(ExceptionUser e){
            return false;
        }
        return true;
    }

    public void RegistrarUsuario(String[] s) {
        Lusu.addUsuario(s);
    }
    
    
}
