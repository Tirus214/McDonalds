/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Mauricio
 */
public class Produccion {
    int contador;
    LinkedList<Cliente> clientes; 
    LinkedList<Producto> productos;
    public ArrayList<Object> entregados;
    public LinkedList<Combo> combos;
    public ArrayList<Cliente> satisfechos;
    
    public Produccion(LinkedList<Cliente> clientes, LinkedList<Producto> productos, LinkedList<Combo> combos, ArrayList<Object> entregados, ArrayList<Cliente> satisfechos){
        this.clientes = clientes;
        this.productos = productos;
        this.entregados = entregados;
        this.satisfechos = satisfechos;
        
    }
    public void tick(){
        for (int i = 0; i < clientes.size(); i++) {
            clientes.get(i).contadorPaciencia--;
            
        }
        for (int i = 0; i < productos.size(); i++) {
            productos.get(i).tiempoProduccion--;
            if (productos.get(i).tiempoProduccion == 0){
                productos.get(i).entregado = true;
                entregados.add(productos.get(i));
                
                productos.remove(i);
            }
            break;
            
        }
        for (int i = 0; i < combos.size(); i++) {
            combos.get(i).tiempoProduccion--;
            if (combos.get(i).tiempoProduccion == 0){
                combos.get(i).entregado = true;
                entregados.add(combos.get(i));
                
                combos.remove(i);
            }
            break;
        
        }
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).pedidoCombos.isEmpty() && clientes.get(i).pedidoProductos.isEmpty()){
                satisfechos.add(clientes.get(i));
                clientes.remove(i);
            }
            
        }
        
    }
    
}
