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
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Restaurante res = new Restaurante(new Pantalla());
        res.pantalla.setVisible(true);
        res.pantalla.imprimirElementos();
        
    }
    
}
