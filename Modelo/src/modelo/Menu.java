/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author Jean Paul
 */
public class Menu {
    
    public ArrayList<PlatoFuerte> principales;
    public ArrayList<Bebida> bebidas;
    public ArrayList<Acompanamiento> acompanamientos;
    public ArrayList<Combo> combos;
    public int numCombo;
    
    public Menu(){
        principales = new ArrayList<PlatoFuerte>();
        bebidas = new ArrayList<Bebida>();
        acompanamientos = new ArrayList<Acompanamiento>();
        combos = new ArrayList<Combo>();
        numCombo = 0;
    }
    
    void anadirPrin(PlatoFuerte p){
        principales.add(p);
    }
    
    void anadirBeb(Bebida b){
        bebidas.add(b);
    }
    void anadirAcomp(Acompanamiento a){
        acompanamientos.add(a);
    }
    
    void CrearCombo(){
        PlatoFuerte pf;
        Bebida beb;
        Acompanamiento acomp;
        int toAdd = Restaurante.getRandom(0, principales.size()-1);
        pf = principales.get(toAdd);
        
        toAdd = Restaurante.getRandom(0, bebidas.size()-1);
        beb = bebidas.get(toAdd);
        
        toAdd = Restaurante.getRandom(0, acompanamientos.size()-1);
        acomp = acompanamientos.get(toAdd);
        
        int precio = (int) ((pf.precio + beb.precio + acomp.precio)*0.9);
        
        int tiempoProduccion = ( pf.tiempoProduccion + beb.tiempoProduccion + acomp.tiempoProduccion );
        
        Combo combo = new Combo(pf, beb, acomp, precio, tiempoProduccion);
        combo.numero = numCombo;
        numCombo++;
        combos.add(combo);
    }
    
    void printMenu(){
        System.out.println("Combos: ");
        for (int i = 0; i < combos.size(); i++) {
            System.out.println("Combo " + (i+1) + ":\n");
            combos.get(i).toString();
        }
        System.out.println("Platos fuertes: ");
        for (int i = 0; i < principales.size(); i++) {
            System.out.println("Producto " + (i+1) + ":\n");
            principales.get(i).toString();
            
        }
        
        System.out.println("Bebidas: ");
        for (int i = 0; i < bebidas.size(); i++) {
            System.out.println("Producto " + (i+1) + ":\n");
            bebidas.get(i).toString();
            
        }
        
        System.out.println("Acompa??amientos: ");
        for (int i = 0; i < acompanamientos.size(); i++) {
            System.out.println("Producto " + (i+1) + ":\n");
            acompanamientos.get(i).toString();
            
        }
    }
}
