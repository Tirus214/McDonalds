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

    public Combo(PlatoFuerte principal, Bebida bebida, Acompanamiento acomp, int precio) {
        this.principal = principal;
        this.bebida = bebida;
        this.acomp = acomp;
        this.precio = precio;
    }
    @Override
    public String toString(){
        return("Plato fuerte: " + principal + "\nBebida: " + bebida + "\nAcompañamiento: " + acomp + "\nPrecio: " + precio);
    }
}
