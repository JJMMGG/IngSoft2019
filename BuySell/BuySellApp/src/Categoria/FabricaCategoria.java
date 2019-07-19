/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package categoria;


/**
 *
 * @author DaCriPer
 */
public class FabricaCategoria {

    public ICategoria getCategoria(String s){
        
        switch (s) {
            case "MUEBLES":
                return (ICategoria)Muebles.getMuebles();
            case "COMPUTACION":
                return (ICategoria)Computacion.getComputacion();
            case "VEHICULO":
                return (ICategoria)Vehiculo.getVehiculo();
        }
        
        return null;
    }
    
    
}
