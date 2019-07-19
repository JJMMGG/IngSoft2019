/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BuySell;

import Controlador.CLogin;
import Controlador.IControlador;
import Modelo.IModelo;
import Modelo.ModeloLogin;
import producto.ListaProducto;
import usuario.ListaUsuarios;

/**
 *
 * @author DaCriPer
 */
public class BuySell {
    
    static ListaUsuarios Lusu;
    static ListaProducto Lpro;
    public static void main(String[] arg){
        
        // leo las bases de datos
        Lusu = ListaUsuarios.getListaUsuarios();
        Lpro = ListaProducto.getListaProductos();
        
        
        // comnienzo creando la vvista Login 
        IModelo modelo = new ModeloLogin();
        IControlador controlador;
        controlador = new CLogin(modelo);
        controlador.ejecutar();
        
    }
}
