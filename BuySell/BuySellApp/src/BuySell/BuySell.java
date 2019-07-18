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

/**
 *
 * @author DaCriPer
 */
public class BuySell {
    
    public static void main(String[] arg){
        
        IModelo modelo = new ModeloLogin();
        IControlador controlador;
        controlador = new CLogin(modelo);
        
        
    }
}
