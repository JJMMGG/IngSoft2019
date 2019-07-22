/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Compras;

/**
 *
 * @author DaCriPer
 */
public abstract class PagoCodigoAbst implements ICompras{
    
    @Override
    public boolean realizarPago(){
        verificarCodigo();
        notificarAdmin();
        return true;
    }
    abstract boolean notificarAdmin();
    abstract boolean verificarCodigo();
}
