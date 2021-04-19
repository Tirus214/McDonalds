/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mauricio
 */
public class Produccion {
    public int contador;
    public LinkedList<Cliente> clientes; 
    public LinkedList<Cliente> enEspera;
    public LinkedList<Producto> productos;
    public LinkedList<Combo> combos;
    public Pantalla pantalla;
    public int tamanoUsado = 0;
    
    public Produccion(LinkedList<Producto> productos, LinkedList<Combo> combos){
        this.productos = productos;
        this.combos = combos;
    }
    
    public void agregarOrden(Cliente clienteActual){
        for (int i = 0; i < clienteActual.pedidoProductos.size(); i++){
            productos.add(clienteActual.pedidoProductos.get(i)); 
        }
   
        for (int i = 0; i < clienteActual.pedidoCombos.size(); i++)
            combos.add(clienteActual.pedidoCombos.get(i));
    }
    
    public void eliminarOrden(Cliente clienteActual){
        for (int i = 0; i < productos.size(); i++)
            if(productos.get(i).codigo == clienteActual.codigo)
                productos.remove(i);
            
        for (int i = 0; i < combos.size(); i++)
            if(combos.get(i).codigo == clienteActual.codigo)
                combos.remove(i);
    }
    
    public void procesar(int num){
        if(!productos.isEmpty()){
            //System.out.println("productos: " + productos.size());
            
            tamanoUsado = 0;
            
            for (int i = 0; i < productos.size(); i++) {
                if(productos.get(i).codigo == num){
                    tamanoUsado += productos.get(i).valor;
                    if(productos.get(i).tiempoProduccion > 0 && tamanoUsado <= 10)
                        productos.get(i).tiempoProduccion--;
                    else if(productos.get(i).tiempoProduccion <= 0){
                        productos.get(i).entregado = true;
                        productos.remove(i);
                    }  
                }
            }
        }
        
        //System.out.println("combos: " + combos.size() + "\n");
        if(!combos.isEmpty() && tamanoUsado <= 4){

            if(combos.getFirst().tiempoProduccion > 0)
                combos.getFirst().tiempoProduccion--;
            else{
                combos.getFirst().entregado = true;
                combos.removeFirst();
            } 
        }
    }
    
    public void removerProductos(int codigo){
        for (int i = 0; i < combos.size(); i++)
            if(combos.get(i).codigo == codigo)
                combos.remove(i);
        
        for (int i = 0; i < productos.size(); i++)
            if(productos.get(i).codigo == codigo)
                productos.remove(i);
    }
}
