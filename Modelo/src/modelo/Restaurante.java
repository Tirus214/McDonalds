/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import static java.lang.Thread.sleep;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jean Paul
 */
public class Restaurante {
    public Menu menu;
    public LinkedList<Cliente> colaCliente;
    public LinkedList<Cliente> colaClientePendiente;
    public LinkedList<Producto> colaOrdenesPendientes;
    public LinkedList<Combo> combos;
    private jsonClass json;
    public int cantIdos;
    public int cantDesechados;
    public Produccion procesar;
    public int cantCorrectos;
    public ArrayList<Object> entregados;
    public ArrayList<Cliente> satisfechos;
    public Pantalla pantalla;
    
    public Produccion produccion;

    
    public Restaurante(Pantalla pantalla){
        menu = new Menu();
        colaCliente = new LinkedList<Cliente>();
        colaClientePendiente = new LinkedList<Cliente>();
        colaOrdenesPendientes = new LinkedList<Producto>();
        combos = new LinkedList<Combo>();
        satisfechos = new ArrayList<Cliente>();
        this.pantalla = pantalla;
        procesar = new Produccion(colaCliente, colaClientePendiente, colaOrdenesPendientes, combos,  entregados, satisfechos);
        procesar.pantalla = this.pantalla;
        cantDesechados = 0;
        cantIdos = 0;
        cantCorrectos = 0;
        
        produccion = new Produccion(colaOrdenesPendientes, combos);
        
        json = new jsonClass();
        setMenu();
        crearClientes();
        
    }
    
    public void setMenu(){
        json.readJson();
        menu.principales = json.principales;
        menu.acompanamientos = json.acompanamientos;
        menu.bebidas = json.bebidas;
        for (int i = 0; i < 6; i++) {
            menu.CrearCombo();
        }
    }
    
    public void crearClientes(){
        int cantClientes = getRandom(5,20);
        for (int i = 0; i < cantClientes; i++) {
            colaCliente.addLast(new Cliente());
            colaCliente.getLast().codigo = i;
        }
    }
    
     
    
    public static int getRandom(int menor, int mayor){
        return (int)Math.floor(Math.random()*(mayor - menor + 1) + menor);
    }
    
    
    public void tick(){
        if(!colaCliente.isEmpty()){
            
            while (colaCliente.getFirst().contador > 0){
                esperar();
                colaCliente.getFirst().contador--;
                pantalla.imprimirElementos();
                System.out.println("contador > 0 es true siempre, linea 86 de restaurante");
            }   
            
            colaClientePendiente.addLast(colaCliente.removeFirst());
            colaClientePendiente.getFirst().ordenarProductos(menu);
            produccion.agregarOrden(colaClientePendiente.getFirst());
            pantalla.imprimirElementos();
        }
        
        if(!colaClientePendiente.isEmpty()){
            
            while (!colaClientePendiente.getFirst().finalizado){
                esperar();
                //si es cliente especial...
                if(colaClientePendiente.getFirst().clienteEspecial){
                    colaClientePendiente.getFirst().contador--;
                    if(colaClientePendiente.getFirst().contador <= 0){
                        colaClientePendiente.getFirst().finalizado = true;
                        produccion.eliminarOrden(colaClientePendiente.getFirst());
                        colaClientePendiente.removeFirst();
                        cantIdos++;
                        return;
                    }
                }
                
                produccion.procesar();
                if(colaClientePendiente.getFirst().revisarPedidos()){
                    colaClientePendiente.getFirst().finalizado = true;
                    produccion.eliminarOrden(colaClientePendiente.getFirst());
                    cantCorrectos++;
                }                  
                
                pantalla.imprimirElementos();
            }
        }
    }
    
    
    
    public static void esperar(){
        try {
            sleep(100);
        } catch (InterruptedException ex) {
        }
    }
}
