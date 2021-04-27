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


    public Bebida(String nombre, int precio, int tiempoProduccion, String tipo, int tamano) {
        super(nombre, precio, tiempoProduccion);
        this.tipo = tipo;
        this.tamano = tamano;
        this.clasificacion = 3;
        this.valor = 1;
    }
    
    public Bebida clonacion(){
        Bebida p = new Bebida(nombre, precio, tiempoProduccion, tipo, tamano);
        p.clasificacion = clasificacion;
        p.codigo = codigo;
        p.entregado = entregado;
        p.valor = valor;
        return p;
    }
}
  