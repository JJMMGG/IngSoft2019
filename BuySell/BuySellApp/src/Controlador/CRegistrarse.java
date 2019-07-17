/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.IModelo;
import Modelo.ModeloRegistrarse;
import Vistas.IVista;
import Vistas.VRegistrarse;
import java.awt.Component;
import javax.swing.JOptionPane;
import usuario.ListaUsuarios;
import usuario.Usuario;

/**
 *
 * @author DaCriPer
 */
public final class CRegistrarse implements IControlador {

    IVista Vistaregistro;
    ModeloRegistrarse modeloRegistrarse;
    
    Usuario usu;
    
    public CRegistrarse( IModelo modelo){
        this.modeloRegistrarse = (ModeloRegistrarse) modelo;
        Vistaregistro = (IVista) new VRegistrarse(this, modelo);
        ejecutar();
    }
    
    @Override
    public void ejecutar() {
        Vistaregistro.hacerVisible();
    }

    public void Cancelar() {
         
    }

    public void Aceptar(String[] s) {
       if(  modeloRegistrarse.BuscarUsuario(s[4])){
           if(modeloRegistrarse.VerificarContrasenia(s[5])){
               modeloRegistrarse.RegistrarUsuario(s);
           }
           Vistaregistro.ErrorUsuario();
       }
       Vistaregistro.ErrorContraseña();
    }
    
    
}
