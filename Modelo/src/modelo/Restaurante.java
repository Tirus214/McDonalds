/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.LinkedList;
import java.io.FileReader;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Jean Paul
 */
public class Restaurante {
    public Menu menu;
    public LinkedList<Cliente> colaCliente;
    public LinkedList<Cliente> colaPendientes;
    private jsonClass json;
    public int cantIdos;
    public int cantDesechados;
    public Tick procesar;
    
    public Restaurante(){
        menu = new Menu();
        procesar = new Tick();
        colaCliente = new LinkedList<Cliente>();
        colaPendientes = new LinkedList<Cliente>();
        cantDesechados = 0;
        cantIdos = 0;
        
        json = new jsonClass();
        json.productos = menu.productos;
        json.readJson();
        crearClientes();
    }
    
    public void crearClientes(){
        int cantClientes = getRandom(20, 5);
        for (int i = 0; i < cantClientes; i++) {
            colaCliente.addLast(new Cliente());
            colaCliente.getLast().codigo = i;
        }
    }
    
     
    
    public static int getRandom(int menor, int mayor){
        return (int)Math.floor(Math.random()*(mayor - menor + 1) + menor);
    }
    
    
    
    
    
    public void thick(){// pasar a procesar.seguir()
        if(colaCliente.getFirst().contador == 0){
            colaPendientes.addLast(colaCliente.removeFirst());
            colaPendientes.getFirst().decrementarContadorPaciencia();
        }else
            colaCliente.getFirst().decrementarContador();
        
        if(!colaPendientes.isEmpty()){
            
            colaPendientes.getFirst().ordenarProductos(menu);
            colaPendientes.getFirst().compararCombos(menu);
        
            //produccion.producir(colaPendientes.getFirst());
            colaPendientes.getFirst().decrementarContadorPaciencia();
            
            colaPendientes.removeFirst();
            
        }
        
    }
}
