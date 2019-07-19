/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import usuario.ListaUsuarios;
import usuario.Usuario;

/**
 *
 * @author DaCriPer
 */
public class ModeloMenuPrincipal implements IModelo{
    
    ListaUsuarios Lusu;
    Usuario usuarioActual;
            
    public ModeloMenuPrincipal(){
            Lusu = ListaUsuarios.getListaUsuarios();
            usuarioActual = Lusu.getUsuarioActual();
    }

    public Usuario getUsuarioActual() {
        return usuarioActual;
    }
    
    public Usuario setUsuarioActual() {
        return usuarioActual;
    }
    
    private ModeloMenuPrincipal getModeloMenuPricipal(){
        return this;
    }
    
    public String getNuevoProducto(){
        return usuarioActual.getNuevoProducto();
    }
    
    public String getIdUsuarioActual(){
        return usuarioActual.getIdUsuario();
    }

    @Override
    public IModelo getModelo() {
       return (IModelo) getModeloMenuPricipal();
    }
}
