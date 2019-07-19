/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.IModelo;
import Modelo.ModeloMenuPrincipal;
import Modelo.ModeloPublicar;
import Vistas.IVista;
import Vistas.VPublicar;
import usuario.Usuario;

/**
 *
 * @author DaCriPer
 */
public class CPublicar implements IControlador{
    
    ModeloPublicar modeloPublicar;
    IVista vistaPublicar;        
    Usuario usuarioActual;
    
    public CPublicar( IModelo modelo){
        this.modeloPublicar = (ModeloPublicar) modelo;
        vistaPublicar = (IVista) new VPublicar(this);
        
    }
            
    public void Publicar(String[] s){
        if(modeloPublicar.Publicar(s)) vistaPublicar.ConfirmarUsuario();
        else vistaPublicar.ErrorDatos();
        Cancelar();
    }
    
    public void Cancelar(){
        vistaPublicar.noVisible();
    }

    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public void setUsuarioActual(Usuario usuarioActual) {
        this.usuarioActual = usuarioActual;
    }
    
    public void Vender(){
        // Crear ventana para publicar
        vistaPublicar.ConfirmarUsuario();
        
    }
    
    @Override
    public void ejecutar() {
       vistaPublicar.hacerVisible();
    }
}
