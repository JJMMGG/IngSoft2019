/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.IModelo;
import Modelo.ModeloLogin;
import Modelo.ModeloMenuPrincipal;
import Modelo.ModeloPublicar;
import Vistas.IVista;
import Vistas.VMenuCuadricula;
import Vistas.VMenuLista;
import usuario.Usuario;

/**
 *
 * @author DaCriPer
 */
public final class CMenuPrincipal implements IControlador{
    ModeloMenuPrincipal modeloMenuPrincipal;
    IVista vistaMenuCuadricula;
    IVista vistaMenuLista;
    boolean i;
    Usuario usuarioActual;
    
    public CMenuPrincipal( IModelo modelo ){
        this.modeloMenuPrincipal = (ModeloMenuPrincipal)modelo;
        vistaMenuCuadricula = (IVista)new VMenuCuadricula(this);
        vistaMenuLista = (IVista)new VMenuLista(this);
        i=true;
        //ejecutar();
    }
    
    @Override
    public void ejecutar(){
        vistaMenuCuadricula.colocarNuevoProducto(modeloMenuPrincipal.getNuevoProducto());
        vistaMenuLista.colocarNuevoProducto(modeloMenuPrincipal.getNuevoProducto());
        usuarioActual = modeloMenuPrincipal.getUsuarioActual();
        if( i ) vistaMenuCuadricula.hacerVisible();
        else vistaMenuLista.hacerVisible();
    }

    public void NuevoProducto() {
         //preparar para la vista que pedirá los datos del nuevo producto
        vistaMenuCuadricula.ConfirmarUsuario();
        IModelo modeloPublicar = (IModelo)new ModeloPublicar();
        IControlador controladorPublicar = (IControlador)new CPublicar(modeloPublicar);
        controladorPublicar.ejecutar();
    }

    public void CambiarVistaLista() {
        if( i ) i = false;
        vistaMenuCuadricula.noVisible();
        vistaMenuLista.hacerVisible();
    }

    public void CambiarVistaCuadricula() {
        if(!i) i = true;
         vistaMenuLista.noVisible();
         vistaMenuCuadricula.hacerVisible();
    }

    public String getIDUsuarioActual(){
        return modeloMenuPrincipal.getIdUsuarioActual();
    }
    
}
