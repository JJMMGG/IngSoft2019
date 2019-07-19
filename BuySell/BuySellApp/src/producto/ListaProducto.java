/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producto;

import java.io.BufferedReader;
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
import usuario.ListaUsuarios;
import usuario.Usuario;

/**
 *
 * @author DaCriPer
 */
public class ListaProducto {
    
    private List<Producto> producto = new ArrayList<>();
    private static ListaProducto Lpro;
    private static ListaUsuarios Lusu;
    private  static FileReader lector;
    private  static FileWriter escritor;
    private  static BufferedReader buffer;
    private  static PrintWriter print;
    private  static Producto productoActual;
    private  static Usuario usuarioActual;
    
    private ListaProducto(){
        productoActual = null;
        usuarioActual = null;
        Lusu = ListaUsuarios.getListaUsuarios();
    }
    
    public static ListaProducto getListaProductos(){
        if( Lpro == null){
            Lpro = new ListaProducto();
            leerBDD();
        }
        
        return Lpro;
    }
    
    public boolean existe(String nombreProducto){
        Producto u ;
        @SuppressWarnings("rawtypes")
        Iterator iterU = producto.iterator();
        while( iterU.hasNext() ){
           u = (Producto)iterU.next();
                if( u.getNombreProducto().equals(nombreProducto) ){
                    return true;
                }
            }
        return false;
    }
    
    public Producto getProducto(String nombreProducto){
        Producto u ;
        @SuppressWarnings("rawtypes")
        Iterator iterU = producto.iterator();
        while( iterU.hasNext() ){
           u = (Producto)iterU.next();
                if( u.getNombreProducto().equals(nombreProducto) ){
                    productoActual = u;
                }
            }
        return productoActual;
    }
    
    
    public List<Producto> getList(){
        return producto;
    }

    public void setList(List<Producto> Lusuarios){
        this.producto = Lusuarios;
        actualizarBDD();
    } 
    
    public void addProducto(Producto productos){
        producto.add(productos);
        
    }
    
    public boolean addProducto(String s[], Usuario u){
        Producto pro = new Producto();
        try{
            pro.setNombreProducto(s[0]);
            pro.setNombreCategoria(s[1]);
            pro.setUsuarioProducto(u);
            pro.setPrecioProducto( Integer.parseInt(s[3]) );
            pro.setCantidadProducto( Integer.parseInt(s[4]));
            pro.setDescripcionProducto(s[5]);
            
        }catch(ExceptionProducto e){
            return false;
        }
        addProducto(pro);
        return true;
    }
    
    private void actualizarBDD() {
        // sobreescribir el archivo
        String linea = "";
        int i=0;
        Producto p;
        try {
            print = new PrintWriter("BDD_PRODUCTO.txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ListaProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //print.print("");
        Iterator Iter = producto.iterator();
        while(Iter.hasNext()){
            p = (Producto)Iter.next();
            print.println(p.getNombreProducto());
            print.println(p.getNombreCategoria());
            print.println(p.getUsuarioProducto().getIdUsuario());
            print.println(p.getCantidadProducto());
            print.println(p.getPrecioProductoString());
            print.println(p.getDescripcionProducto());
            print.println(" ");
        }
        print.close();
        
    } 
    
    
    private static  void leerBDD(){
        String linea = "";
        String[] s = new String[6];
        int i=0;
        // abrimos para leer
        try {
            lector = new FileReader("BDD_PRODUCTO.txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ListaProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        // guardamos el archivo en el buffer
        buffer = new BufferedReader(lector);
        // leemos el buffer para crear los producto
        while(linea != null){
            try {
                linea = buffer.readLine();          // leo linea
            } catch (IOException ex) {
                Logger.getLogger(ListaProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if( i==6 ){
                    Usuario usuAux = Lusu.getUsuario(s[2]);
                    Lpro.addProducto(s, usuAux);
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
                Logger.getLogger(ListaProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
       
   
}
