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

/**
 *
 * @author DaCriPer
 */
public final class CMenuPrincipal implements IControlador{
    ModeloMenuPrincipal modeloMenuPrincipal;
    IVista vistaMenuCuadricula;
    IVista vistaMenuLista;
    
    public CMenuPrincipal( IModelo modelo ){
        this.modeloMenuPrincipal = (ModeloMenuPrincipal)modelo;
        vistaMenuCuadricula = (IVista)new VMenuCuadricula();
        vistaMenuLista = (IVista)new VMenuLista();
        //ejecutar();
    }
    
    @Override
    public void ejecutar(){
        vistaMenuCuadricula.hacerVisible();
    }
}
