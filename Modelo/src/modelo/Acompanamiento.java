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
public class Acompanamiento extends Producto{
    
    public String tipo;     //salado o dulce
    public int valor = 2;


    public Acompanamiento(String nombre, int precio, int tiempoProduccion, String tipo) {
        super(nombre, precio, tiempoProduccion);
        this.tipo = tipo;
        this.clasificacion = 2;
    }
    
    public Acompanamiento clonacion(){
        Acompanamiento p = new Acompanamiento(nombre, precio, tiempoProduccion, tipo);
        p.clasificacion = clasificacion;
        p.codigo = codigo;
        p.entregado = entregado;
        p.valor = valor;
        return p;
    }
}
