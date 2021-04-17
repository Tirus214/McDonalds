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
    public ArrayList<Object> entregados;
    public LinkedList<Combo> combos;
    public ArrayList<Cliente> satisfechos;
    public Pantalla pantalla;
    public int tamanoUsado = 0;
    
    public Produccion(LinkedList<Cliente> clientes, LinkedList<Cliente> enEspera,LinkedList<Producto> productos, LinkedList<Combo> combos, 
            ArrayList<Object> entregados, ArrayList<Cliente> satisfechos){
        this.clientes = clientes;
        this.enEspera = enEspera;
        this.productos = productos;
        this.entregados = entregados;
        this.satisfechos = satisfechos;
        this.combos = combos;
    }
    
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
    
    public void procesar(){
        
        if(!productos.isEmpty()){
            System.out.println("productos: " + productos.size());
            for (int i = 0; i < productos.size(); i++) {
                tamanoUsado += productos.get(i).valor;
                if(productos.get(i).tiempoProduccion > 0 && tamanoUsado <= 10)
                    productos.get(i).tiempoProduccion--;
                else if(productos.get(i).tiempoProduccion <= 0){
                    productos.get(i).entregado = true;
                    productos.remove(i);
                }   
            }
            tamanoUsado = 0;
        }
        
        System.out.println("combos: " + combos.size());
        if(!combos.isEmpty() && productos.isEmpty()){
            System.out.println("Numero" + combos.getFirst().numero);
            if(combos.getFirst().tiempoProduccion > 0)
                combos.getFirst().tiempoProduccion--;
            else{
                combos.getFirst().entregado = true;
                combos.removeFirst();
            }
            
        }
    }
    
    
    public void tick(){
        if(!clientes.isEmpty()){
            clientes.getFirst().contador--;
            if(clientes.getFirst().contador == 0){
                enEspera.addLast(clientes.removeFirst());
                addOrden(enEspera.getFirst());
            }
        }
        
        for (int i = 0; i < enEspera.size(); i++){
            if(enEspera.get(i).clienteEspecial){
                enEspera.get(i).contadorPaciencia--;
                if(enEspera.get(i).contadorPaciencia == 0){
                    enEspera.remove(i);
                    removerProductos(i);
                }
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
        
        try {
            sleep(1000);
        } catch (InterruptedException ex) {}
        
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
    
    public void addOrden(Cliente cliente){
        for (int i = 0; i < cliente.pedidoProductos.size(); i++)
            productos.add(cliente.pedidoProductos.get(i));
        
        for (int i = 0; i < cliente.pedidoCombos.size(); i++)
            combos.add(cliente.pedidoCombos.get(i));
    }
}
