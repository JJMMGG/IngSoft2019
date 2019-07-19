/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.IModelo;
import Modelo.ModeloLogin;
import Modelo.ModeloMenuPrincipal;
import Modelo.ModeloRegistrarse;
import Vistas.IVista;
import Vistas.VMenuCuadricula;
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
        Vistaregistro = (IVista) new VRegistrarse(this);
        //ejecutar();
    }
    
    @Override
    public void ejecutar() {
        Vistaregistro.hacerVisible();
    }

    public void Cancelar() {
        // volver a la ventana Login
        IModelo modelo = new ModeloLogin();
        IControlador controlador;
        
        Vistaregistro.noVisible();
        controlador = new CLogin(modelo);
    }

    public void Aceptar(String[] s) {
       if( !modeloRegistrarse.BuscarUsuario(s[4])){
           if(modeloRegistrarse.VerificarContrasenia(s[5])){
               if( !modeloRegistrarse.RegistrarUsuario(s)){
                   Vistaregistro.ErrorDatos();
                }else{
                    Vistaregistro.ConfirmarUsuario();
                    irMenuPrincipal();
                    }
            }else{
                Vistaregistro.ErrorContraseña();
                }
        }else{
            Vistaregistro.ErrorUsuario();
            }
       }

    private void irMenuPrincipal() {
        // crear objeto para menu principal
        IModelo modeloP = (IModelo) new ModeloMenuPrincipal();
        IControlador menuP = (IControlador) new CMenuPrincipal(modeloP);
        Vistaregistro.noVisible();
        menuP.ejecutar();
    }
}
   

