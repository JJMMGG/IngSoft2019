/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author DaCriPer
 */
public class ModeloMenuPrincipal implements IModelo{
    
    private ModeloMenuPrincipal modeloInicio;
    
    public ModeloMenuPrincipal(){
        
    }
    
    ModeloMenuPrincipal getModeloInicio(){
        if(modeloInicio == null){ 
            modeloInicio = new ModeloMenuPrincipal();
        }
        return modeloInicio;
    }
    
}
