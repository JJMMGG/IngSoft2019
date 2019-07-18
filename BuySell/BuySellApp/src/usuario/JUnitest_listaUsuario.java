/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuario;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DaCriPer
 */
public class JUnitest_listaUsuario {
 
    static ListaUsuarios Lusu;
    static List<Usuario> usu ;
    static Usuario u1;
    static Usuario u2;
    static Usuario u3;
    static Usuario u4;
    private  static FileReader lector;
    private static BufferedReader bufer;
    private  static PrintWriter print;
    
    public static void main(String[] args){
        
        u1 = new Usuario("crisitna", "dacriper", "micasa", "1234cris");
        u2 = new Usuario("cris", "dacri", "micasa 12", "1234cris");
        u3 = new Usuario("tina", "per", "micasa 15", "1234cris");
        u4 = new Usuario("david", "criper", "micasa 28", "1234cris");
                
        Lusu = ListaUsuarios.getListaUsuarios();
        usu = Lusu.getList();
        
        Usuario u ;
        Iterator Iter = usu.iterator();
        while(Iter.hasNext()){
            u = (Usuario)Iter.next();
            System.out.println(u.toString());
        }
        
        System.out.println("-------------------");
        Lusu.addUsuario(u1);
        Lusu.addUsuario(u2);
        
        
        Iter = usu.iterator();
        while(Iter.hasNext()){
            u = (Usuario)Iter.next();
            System.out.println(u.toString());
        }
     }
}
