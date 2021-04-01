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
public class Bebida extends Producto{
    
    public String tipo;     //frio o caliente  
    public int tamano;      //200ml, 250ml o 330ml

    public Bebida(String nombre, int precio, double tiempoProduccion, String tipo, int tamano) {
        super(nombre, precio, tiempoProduccion);
        this.tipo = tipo;
        this.tamano = tamano;
    }
}
  