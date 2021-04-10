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
    Random rand = new Random();
    public Menu(){
        principales = new ArrayList<PlatoFuerte>();
        bebidas = new ArrayList<Bebida>();
        acompanamientos = new ArrayList<Acompanamiento>();
        combos = new ArrayList<Combo>();
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
        int toAdd = rand.nextInt(principales.size());
        pf = principales.get(toAdd);
        
        toAdd = rand.nextInt(bebidas.size());
        beb = bebidas.get(toAdd);
        
        toAdd = rand.nextInt(principales.size());
        acomp = acompanamientos.get(toAdd);
        
        int precio = (pf.precio + beb.precio + acomp.precio);
        precio -= precio*0.1;
        
        Combo combo = new Combo(pf, beb, acomp, precio);
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
        
        System.out.println("Acompañamientos: ");
        for (int i = 0; i < acompanamientos.size(); i++) {
            System.out.println("Producto " + (i+1) + ":\n");
            acompanamientos.get(i).toString();
            
        }
    }
}
