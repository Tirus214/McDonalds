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
}
