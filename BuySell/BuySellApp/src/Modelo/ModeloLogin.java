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
    
    private ListaUsuarios Lusu;
    private Usuario usu;
    
    public ModeloLogin(){
        Lusu = Lusu.getListaUsuarios();
        usu = new Usuario();
    }
    
    public boolean BuscarUsario(String nombre){
        usu = Lusu.getUsuario(nombre);
        return usu != null;
    }
    
    public boolean VerificarContrasenia(String contrasenia){
        return usu.getContraseniaUsuario().equals(contrasenia);
    }
    
    public Usuario getUsuario(){
        return usu;
    }
}

