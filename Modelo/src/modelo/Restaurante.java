/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.LinkedList;
import java.util.ArrayList;

/**
 *
 * @author Jean Paul
 */
public class Restaurante {
    public Menu menu;
    public LinkedList<Cliente> colaCliente;
    public LinkedList<Producto> colaPendientes;
    public LinkedList<Combo> combos;
    private jsonClass json;
    public int cantIdos;
    public int cantDesechados;
    public Produccion procesar;
    public int cantCorrectos;
    public ArrayList<Object> entregados;
    public ArrayList<Cliente> satisfechos;

    
    public Restaurante(){
        menu = new Menu();
        colaCliente = new LinkedList<Cliente>();
        colaPendientes = new LinkedList<Producto>();
        combos = new LinkedList<Combo>();
        satisfechos = new ArrayList<Cliente>();
        procesar = new Produccion(colaCliente, colaPendientes, combos,  entregados, satisfechos);
        cantDesechados = 0;
        cantIdos = 0;
        cantCorrectos = 0;
        json = new jsonClass();
        setMenu();
        crearClientes();
    }
    
    public void setMenu(){
        json.readJson();
        menu.principales = json.principales;
        menu.acompanamientos = json.acompanamientos;
        menu.bebidas = json.bebidas;
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
    
    
    
    
        
}
