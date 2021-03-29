/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

/**
 *
 * @author Jean Paul
 */
public class Restaurante {
    public Menu menu;
    public Produccion produccion;
    public ArrayList<Cliente> colaCliente;
    
    public Restaurante(){
        menu = new Menu();
        produccion = new Produccion();
        colaCliente = new ArrayList<Cliente>();
    }
}
