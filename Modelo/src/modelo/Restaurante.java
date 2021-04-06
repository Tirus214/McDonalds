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
    public Produccion produccion;
    public LinkedList<Cliente> colaCliente;
    public LinkedList<Cliente> colaPendientes;
    private jsonClass json;
    
    public Restaurante(){
        menu = new Menu();
        produccion = new Produccion();
        colaCliente = new LinkedList<Cliente>();
        colaPendientes = new LinkedList<Cliente>();
        json = new jsonClass();
        json.productos = menu.productos;
        json.readJson();
        crearClientes();
    }
    
    public void crearClientes(){
        int cantClientes = getRandom(20, 5);
        for (int i = 0; i < cantClientes; i++) {
            colaCliente.addLast(new Cliente());
        }
    }
    
     
    
    public static int getRandom(int menor, int mayor){
        return (int)Math.floor(Math.random()*(mayor - menor + 1) + menor);
    }
    
    public void ordenarProductos(Cliente cliente){
        int rand = getRandom(menu.productos.size(), 1);
        for (int i = 0; i < rand; i++) {
            int rand2 = getRandom(menu.productos.size(), 1);
            cliente.pedidoProductos.add(menu.productos.get(rand2));
        }
    }
    
    public void checkearCombos(Cliente cliente){
        
    }
    
    public void thick(){
        if(colaCliente.getFirst().contador == 0){
            colaPendientes.addLast(colaCliente.removeFirst());
        }else
            colaCliente.getFirst().decrementarContador();
        
        if(!colaPendientes.isEmpty()){
            ordenarProductos(colaPendientes.getFirst());
            checkearCombos(colaPendientes.getFirst());
        
            produccion.producir(colaPendientes.getFirst());
            colaPendientes.getFirst().decrementarContadorPaciencia();
            
            colaPendientes.removeFirst();
        }
        
    }
}
