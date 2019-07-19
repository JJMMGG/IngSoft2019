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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import observer.Observer;
import subject.SujetoUsuario;

/**
 *
 * @author DaCriPer
 */
public class ListaUsuarios extends Observer{

    private List<Usuario> usuarios = new ArrayList<>();
    private static ListaUsuarios Lusu;
    private  static FileReader lector;
    private  static FileWriter escritor;
    private  static BufferedReader buffer;
    private  static PrintWriter print;
    private  static Usuario usuarioActual;
    private   SujetoUsuario sujetoUsuario;
    
    private ListaUsuarios(){
        sujetoUsuario = new SujetoUsuario();
    }
    
    public static ListaUsuarios getListaUsuarios(){
        if( Lusu == null){
            Lusu = new ListaUsuarios();
            leerBDD();
        }
        
        return Lusu;
    }
    
    public boolean existe(String Id){
        Usuario u;
        @SuppressWarnings("rawtypes")
        Iterator iterU = usuarios.iterator();
        while( iterU.hasNext() ){
           u = (Usuario)iterU.next();
                if( u.getIdUsuario().equals(Id) ){
                    usuarioActual = u;
                    return true;
                }
            }
        return false;
    }
    
    public Usuario getUsuarioActual(){
        System.out.println(usuarioActual.getIdUsuario());
        return usuarioActual;
    }
    
    public Usuario getUsuario(String nombre){
        Usuario u  = null;
        @SuppressWarnings("rawtypes")
        Iterator iterU = usuarios.iterator();
        while( iterU.hasNext() ){
           u = (Usuario)iterU.next();
                if( u.getIdUsuario().equals(nombre) ){
                    return  u;
                }
            }
        return u;
    }
    
    public List<Usuario> getList(){
        return usuarios;
    }

    public void setList(List<Usuario> Lusuarios){
        this.usuarios = Lusuarios;
    } 
    
    public void addUsuario(Usuario usuario){
        this.usuarios.add(usuario);
        usuarioActual = usuario;
        actualizarBDD();
        actualizarSuejto(usuario);
    }
    
    public boolean addUsuario(String s[]){
        Usuario usu = new Usuario();
        try{
            usu.setNombreUsuario(s[0]);
            usu.setApellido(s[1]);
            usu.setEmail(s[2]);
            usu.setDireccion(s[3]);
            usu.setIdUsuario(s[4]);
            usu.setContraseniaUsuario(s[5]);
        }catch(ExceptionUser e){
            return false;
        }
        addUsuario(usu);
        return true;
    }
    
    private void actualizarBDD() {
        // sobreescribir el archivo
        String linea = "";
        int i=0;
        Usuario u;
        try {
            print = new PrintWriter("BDD_USER.txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ListaUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //print.print("");
        Iterator Iter = usuarios.iterator();
        while(Iter.hasNext()){
            u = (Usuario)Iter.next();
            print.println(u.getNombreUsuario());
            print.println(u.getApellido());
            print.println(u.getEmail());
            print.println(u.getDireccion());
            print.println(u.getIdUsuario());
            print.println(u.getContraseniaUsuario());
            print.println(u.getNuevoProducto());
            print.println(u.getProductoVendido());
            print.println(" ");
        }
        print.close();
        
    } 
    
    
    private static  void leerBDD(){
        String linea = "";
        String[] s = new String[8];
        int i=0;
        
        // abrimos para leer
        try {
            lector = new FileReader("BDD_USER.txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ListaUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        // guardamos el archivo en el buffer
        buffer = new BufferedReader(lector);
        // leemos el buffer para crear los usuarios
        while(linea != null){
            try {
                linea = buffer.readLine();          // leo linea
            } catch (IOException ex) {
                Logger.getLogger(ListaUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if( i==8 ){
                    Lusu.addUsuario(s);
                    i=0;
            }else{
                s[i] = linea;                   // guardo la linea
                i++;
            }
        }
        // cerramos archivo    
        try {
                lector.close();
            } catch (IOException ex) {
                Logger.getLogger(ListaUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    private void actualizarSuejto(Usuario usuario) {
        usuario.setSubjectUsuario(sujetoUsuario);
    }
       
    public void ActualizarBaseDeDatos(){
        Actualizar();
    }

    @Override
    public void Actualizar() {
        
        actualizarBDD();
    }
}
