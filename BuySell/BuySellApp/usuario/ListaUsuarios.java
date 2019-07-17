/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuario;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author DaCriPer
 */
public class ListaUsuarios {
    
    private List<Usuario> usuarios = new ArrayList<Usuario>();
    
    public boolean existe(String Id){
        Usuario u;
        @SuppressWarnings("rawtypes")
        Iterator iterU = usuarios.iterator();
        while( iterU.hasNext() ){
           u = (Usuario)iterU.next();
                if( u.getIdUsuario().equals(Id) ){
                    return true;
                }
            }
        return false;
    }
    
    public Usuario getUsuario(String Id){
        Usuario u;
        @SuppressWarnings("rawtypes")
        Iterator iterU = usuarios.iterator();
        while( iterU.hasNext() ){
           u = (Usuario)iterU.next();
                if( u.getIdUsuario().equals(Id) ){
                    return u;
                }
            }
        return null;
    }
    
    public List<Usuario> getList(){
        return usuarios;
    }

    public void setList(List<Usuario> Lusuarios){
        this.usuarios = Lusuarios;
    } 
    
    public void addUsuario(Usuario usuario){
        usuarios.add(usuario);
    }
    
    public void addUsuario(String s[]){
        Usuario usu = new Usuario();
        try{
            usu.setNombreUsuario(s[0]);
            usu.setApellido(s[1]);
            usu.setEmail(s[2]);
            usu.setDireccion(s[3]);
            usu.setIdUsuario(s[4]);
            usu.setContraseniaUsuario(s[5]);
        }catch(ExceptionUser e){
            
        }
        addUsuario(usu);
    }
}
