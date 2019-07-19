/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import usuario.*;

/**
 *
 * @author DaCriPer
 */
public class ModeloLogin implements IModelo{
    
    private final ListaUsuarios Lusu;
    private Usuario usu;
    
    public ModeloLogin(){
        Lusu = ListaUsuarios.getListaUsuarios();
        usu = new Usuario();
    }
    
    public boolean BuscarUsario(String nombre){
        if(Lusu.existe(nombre) ) { 
            usu = Lusu.getUsuario(nombre); 
            return true;
        }
        return false;
    }
    
    public boolean VerificarContrasenia(String contrasenia){
        return usu.getContraseniaUsuario().equals(contrasenia);
    }
    
    public Usuario getUsuario(){
        return usu;
    }
}

