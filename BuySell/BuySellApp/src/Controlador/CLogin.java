/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.IModelo;
import Modelo.ModeloLogin;
import Modelo.ModeloRegistrarse;
//import Modelo.ModeloLogin;
//import Modelo.ModeloValidar;
import Vistas.IVista;
import Vistas.VLogin;
import Vistas.VMenuCuadricula;
import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author DaCriPer
 */
public final class CLogin implements IControlador{
    
    ModeloLogin modeloLogin;
    IVista vistaLogin;
    
    /**
     *
     * @param modelo
     */
    public CLogin( IModelo modelo){
        this.modeloLogin =  (ModeloLogin) modelo;
        vistaLogin = (IVista)new VLogin(this, modeloLogin);
        ejecutar();
    }
    
    @Override
    public void ejecutar(){
        vistaLogin.hacerVisible(); 
    }
    
    public void Ingresar(String nombre, String contrasenia){
        // a travez de modeloLogin
       if( modeloLogin.BuscarUsario(nombre) ){
           if( modeloLogin.VerificarContrasenia(contrasenia)){
               IModelo modeloP = (IModelo) new VMenuCuadricula();
               CMenuPrincipal menuP = new CMenuPrincipal(modeloP);
           }else{
               vistaLogin.ErrorContraseña();
           }
       }else{
           vistaLogin.ErrorUsuario();
       }  
        
    }
    
    public void Registrarse(){
        vistaLogin.noVisible();
        IModelo modeloR = (IModelo)new ModeloRegistrarse();
        IControlador registroC =(IControlador) new CRegistrarse(modeloR); 
        
    }
}
