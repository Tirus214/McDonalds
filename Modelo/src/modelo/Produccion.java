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
    public int contador;
    public LinkedList<Cliente> clientes; 
    public LinkedList<Cliente> enEspera;
    public LinkedList<Producto> productos;
    public ArrayList<Object> entregados;
    public LinkedList<Combo> combos;
    public ArrayList<Cliente> satisfechos;
    public Pantalla pantalla;
    
    public Produccion(LinkedList<Cliente> clientes, LinkedList<Cliente> enEspera,LinkedList<Producto> productos, LinkedList<Combo> combos, 
            ArrayList<Object> entregados, ArrayList<Cliente> satisfechos){
        this.clientes = clientes;
        this.enEspera = enEspera;
        this.productos = productos;
        this.entregados = entregados;
        this.satisfechos = satisfechos;
        this.combos = combos;
    }
    public void tick(){
        
        clientes.getFirst().contador--;
        if(clientes.getFirst().contador == 0)
                enEspera.addLast(clientes.removeFirst());
        
        for (int i = 0; i < enEspera.size(); i++)
            if(clientes.get(i).clienteEspecial){
                clientes.get(i).contadorPaciencia--;
                if(clientes.get(i).contadorPaciencia == 0){
                    removerProductos(i);
                }
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
        pantalla.imprimirElementos();
        if(!productos.isEmpty() || !combos.isEmpty())
            tick();
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
