/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.IModelo;
import Modelo.ModeloMenuPrincipal;
import Vistas.IVista;
import Vistas.VMenuCuadricula;
import Vistas.VMenuLista;
import usuario.ListaUsuarios;
import usuario.Usuario;

/**
 *
 * @author DaCriPer
 */
public final class CMenuPrincipal implements IControlador{
    ModeloMenuPrincipal modeloMenuPrincipal;
    IVista vistaMenuCuadricula;
    IVista vistaMenuLista;
    ListaUsuarios Lusu;
    Usuario usuarioActual ;
    
    public CMenuPrincipal( IModelo modelo ){
        this.modeloMenuPrincipal = (ModeloMenuPrincipal)modelo;
        vistaMenuCuadricula = (IVista)new VMenuCuadricula(this);
        vistaMenuLista = (IVista)new VMenuLista(this);
        Lusu = ListaUsuarios.getListaUsuarios();
        usuarioActual = Lusu.getUsuarioActual();
        //ejecutar();
    }
    
    @Override
    public void ejecutar(){
        vistaMenuCuadricula.colocarNuevoProducto(usuarioActual.getNuevoProducto());
        vistaMenuCuadricula.hacerVisible();
    }

    public void NuevoProducto() {
         //preparar para la vista que pedirá los datos del nuevo producto
        vistaMenuCuadricula.ConfirmarUsuario();
    }

    public void CambiarVistaLista() {
        vistaMenuCuadricula.noVisible();
        vistaMenuLista.hacerVisible();
        vistaMenuLista.colocarNuevoProducto(usuarioActual.getNuevoProducto());
    }

    public void CambiarVistaCuadricula() {
         vistaMenuLista.noVisible();
         vistaMenuCuadricula.hacerVisible();
    }

    public Usuario getUsuarioActual(){
        return usuarioActual;
    }
    
}
