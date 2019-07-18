/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.IModelo;
import Modelo.ModeloRegistrarse;

/**
 *
 * @author DaCriPer
 */
public class JUnitestControlador {

    
     static IModelo modelo = new ModeloRegistrarse();
    @SuppressWarnings("FieldMayBeFinal")
     static CRegistrarse registro = new CRegistrarse(modelo);
     static  String[] s = new String[6];
    
    public static void main(String[] args){
        iniciar();
        
    }
    
    private static void iniciar() {
        s[0] = "cris";
        s[1] = "pereyra";
        s[2] = "cris@yo.com";
        s[3] = "micasa 23";
        s[4] = "cristian";
        s[5] = "cris1234";
        
        registro.Aceptar(s);
    }
}



















