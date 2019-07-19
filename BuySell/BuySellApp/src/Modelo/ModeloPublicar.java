/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import producto.ListaProducto;
import usuario.ListaUsuarios;
import usuario.Usuario;

/**
 *
 * @author DaCriPer
 */
public class ModeloPublicar implements IModelo{
    
    private final ListaProducto Lpro;
    private final ListaUsuarios Lusu;
    Usuario usuarioActual;
    
    public ModeloPublicar(){
        Lpro = ListaProducto.getListaProductos();
        Lusu = ListaUsuarios.getListaUsuarios();
        usuarioActual = Lusu.getUsuarioActual();
    }
    
    private ModeloPublicar getModeloInicio(){
        return this;
    }

    public Usuario getUsuarioActual() {
        return usuarioActual;
    }
    
    public boolean Publicar(String []s){
        // agreagar el producto nuevo
        return Lpro.addProducto(s, usuarioActual);
    }

    @Override
    public IModelo getModelo() {
       return getModeloInicio();
    }
}
