/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.IModelo;
import Modelo.ModeloMenuPrincipal;
import Vistas.VMenuCuadricula;
import Vistas.VMenuLista;

/**
 *
 * @author DaCriPer
 */
public class CMenuPrincipal implements IControlador{
    ModeloMenuPrincipal modeloMenuPrincipal;
    VMenuCuadricula vistaMenuCuadricula;
    VMenuLista vistaMenuLista;
    
    public CMenuPrincipal( IModelo modelo ){
        this.modeloMenuPrincipal = (ModeloMenuPrincipal)modelo;
        vistaMenuCuadricula = new VMenuCuadricula();
        vistaMenuLista = new VMenuLista();
    }
    
    @Override
    public void ejecutar(){
        vistaMenuCuadricula.hacerVisible();
    }
}
