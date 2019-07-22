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
public abstract class PagoBancoAbst implements ICompras {
    
    @Override
    public boolean realizarPago(){
        verificarUsuario();
        verificarSaldo();
        notificarAdmin();
        return true;
    }

    abstract boolean verificarUsuario();
    abstract boolean verificarSaldo();
    abstract boolean notificarAdmin();

    
}
