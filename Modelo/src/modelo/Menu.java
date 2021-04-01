/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Jean Paul
 */
public class Menu {
    
    public ArrayList<Producto> productos;
    public ArrayList<Combo> combos;
    
    public Menu(){
        productos = new ArrayList<Producto>();
        combos = new ArrayList<Combo>();
    }
    
    void anadirProd(Producto p){
        productos.add(p);
    }
    void anadirComb(Combo b){
        combos.add(b);
    }
    
    void printMenu(){
        System.out.println("Combos: ");
        for (int i = 0; i < combos.size(); i++) {
            System.out.println("Combo" + (i+1) + ": ");
            
        }
    }
}
