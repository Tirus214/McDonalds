/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


/**
 *
 * @author Jean Paul
 */
public class Combo {
    
    protected PlatoFuerte principal;
    protected Bebida bebida;
    protected Acompanamiento acomp;
    protected int precio;

    public Combo() {
    }
    @Override
    public String toString(){
        return("Plato fuerte: " + principal + "\nBebida: " + bebida + "\nAcompañamiento: " + acomp + "\nPrecio: " + precio);
    }
}
