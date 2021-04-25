/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.ComponentOrientation;

/**
 *
 * @author Jean Paul
 */
public class Pantalla extends javax.swing.JFrame {

    public Restaurante restaurante;
    
    /**
     * Creates new form Pantalla
     */
    public Pantalla() {
        restaurante = new Restaurante(this);
        initComponents();
    }
    
    public void imprimirElementos(){
        lblCantDesechados.setText(restaurante.cantDesechados + "");
        lblCantIdos.setText(restaurante.cantIdos + "");
        lblCantCorrectos.setText(restaurante.cantCorrectos + "");
        txfSuceso.setText(restaurante.suceso);
        labelTotal.setText("" + restaurante.ganancias);
        imprimirProductos();
        imprimirCombos();
        imprimirColaClientes();
        imprimirColaClientesPendientes();
        imprimirPedidosPendientes();
    }  
    
    public void imprimirProductos(){
        txfMenu.setText("");
        txfMenu.append("PLATOS FUERTES: \n\n");
        for (int i = 0; i < restaurante.menu.principales.size(); i++) {
            txfMenu.append("Nombre: " + restaurante.menu.principales.get(i).nombre + "\n");
            txfMenu.append("Precio: " + restaurante.menu.principales.get(i).precio + "\n");
            txfMenu.append("Tiempo de preparacion: " + restaurante.menu.principales.get(i).tiempoProduccion + "\n");
            txfMenu.append("Tamaño: " + restaurante.menu.principales.get(i).tamano + "\n\n");
        }
        txfMenu.append("ACOMPAÑAMIENTOS: \n\n");
        for (int i = 0; i < restaurante.menu.acompanamientos.size(); i++) {
            txfMenu.append("Nombre: " + restaurante.menu.acompanamientos.get(i).nombre + "\n");
            txfMenu.append("Precio: " + restaurante.menu.acompanamientos.get(i).precio + "\n");
            txfMenu.append("Tiempo de preparacion: " + restaurante.menu.acompanamientos.get(i).tiempoProduccion + "\n");
            txfMenu.append("Tipo: " + restaurante.menu.acompanamientos.get(i).tipo + "\n\n");
        }
        txfMenu.append("BEBIDAS: \n\n");
        for (int i = 0; i < restaurante.menu.bebidas.size(); i++) {
            txfMenu.append("Nombre: " + restaurante.menu.bebidas.get(i).nombre + "\n");
            txfMenu.append("Precio: " + restaurante.menu.bebidas.get(i).precio + "\n");
            txfMenu.append("Tiempo de preparacion: " + restaurante.menu.bebidas.get(i).tiempoProduccion + "\n");
            txfMenu.append("Tipo: " + restaurante.menu.bebidas.get(i).tipo + "\n");
            txfMenu.append("Tamaño: " + restaurante.menu.bebidas.get(i).tamano + "ml\n\n");
        }
    }
    
    public void imprimirCombos(){
        txfMenu.append("COMBOS: \n\n");
        
        for (int i = 0; i < restaurante.menu.combos.size(); i++) {
            Combo actual = restaurante.menu.combos.get(i);
            txfMenu.append("Numero: " + actual.numero + "\n");
            txfMenu.append("Plato fuerte: " + actual.principal.nombre + "\n");
            txfMenu.append("Acompañamiento: " + actual.acomp.nombre + "\n");
            txfMenu.append("Bebida: " + actual.bebida.nombre + "\n");
            txfMenu.append("Precio: " + actual.precio + "\n\n");
        }
    }

    
    public void imprimirColaClientes(){
        txfColaClientes.setText("");
        
        for (int i = 0; i < restaurante.colaCliente.size(); i++){
            txfColaClientes.append("Cliente: " + restaurante.colaCliente.get(i).codigo +
                    "\tcontador: " + restaurante.colaCliente.get(i).contador + "\n");
            //System.out.println(restaurante.colaCliente.get(i).codigo + " " + restaurante.colaCliente.get(i).contador);
        }
            
    }
    
    public void imprimirColaClientesPendientes(){
        txfColaClientesPendientes.setText("");
        
        for (int i = 0; i < restaurante.colaClientePendiente.size(); i++) {
            if(restaurante.colaClientePendiente.get(i).clienteEspecial)
                txfColaClientesPendientes.append("Cliente: " + restaurante.colaClientePendiente.get(i).codigo +
                    "\tcontador paciencia: " + restaurante.colaClientePendiente.get(i).contadorPaciencia + "\n");
            else
                txfColaClientesPendientes.append("Cliente: " + restaurante.colaClientePendiente.get(i).codigo +
                    "\tcontador paciencia: ∞\n");
        }
    }
    
    public void imprimirPedidosPendientes(){
        txfColaOrdenesPendientes.setText("");
        if(restaurante.colaOrdenesPendientes.isEmpty())
            return;
        for (int i = 0; i < restaurante.colaOrdenesPendientes.size(); i++) {
            Producto p = restaurante.colaOrdenesPendientes.get(i);
            if (p.entregado)
                return;
            //txfColaOrdenesPendientes.append(p.);
            txfColaOrdenesPendientes.append("Orden: " + p.codigo + "\n");
            txfColaOrdenesPendientes.append("Nombre: " + p.nombre + "\n");
            txfColaOrdenesPendientes.append("Tiempo: " + p.tiempoProduccion + "\n\n");
            
        }
        /*for (int j = 0; j < restaurante.colaClientePendiente.size(); j++) {
            Cliente c = restaurante.colaClientePendiente.get(j);
            txfColaOrdenesPendientes.append("Orden " +c.codigo+ ":\n" );
            System.out.println("Combos de Cliente actual: " + c.pedidoCombos.size());
            
            for (int i = 0; i < c.pedidoProductos.size(); i++) {
                if(!c.pedidoProductos.get(i).entregado){
                    txfColaOrdenesPendientes.append("Orden: " + c.codigo + "\n");
                    txfColaOrdenesPendientes.append("Nombre: " + c.pedidoProductos.get(i).nombre + "\n");
                    txfColaOrdenesPendientes.append("Tiempo: " + c.pedidoProductos.get(i).tiempoProduccion + "\n\n");  
                }
            }  */
            
            //for (int k = 0; k < c.pedidoCombos.size(); k++) {
                //if(!c.pedidoCombos.get(k).entregado){
                   // txfColaOrdenesPendientes.append("Orden: " + c.pedidoCombos.get(k).codigo + "\n");
                    //txfColaOrdenesPendientes.append("Combo: " + c.pedidoCombos.get(k).numero + "\n");
                    //txfColaOrdenesPendientes.append("Tiempo: " + c.pedidoCombos.get(k).tiempoProduccion + "\n\n");
               // }
            //}
        //}
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txfColaClientesPendientes = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txfColaOrdenesPendientes = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lblCantIdos = new javax.swing.JLabel();
        lblCantDesechados = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txfColaClientes = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txfMenu = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblCantCorrectos = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txfSuceso = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        labelTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txfColaClientesPendientes.setColumns(20);
        txfColaClientesPendientes.setRows(5);
        jScrollPane1.setViewportView(txfColaClientesPendientes);

        jLabel1.setText("Cola de Clientes Pendientes");

        txfColaOrdenesPendientes.setColumns(20);
        txfColaOrdenesPendientes.setRows(5);
        jScrollPane2.setViewportView(txfColaOrdenesPendientes);

        jLabel7.setText("Ordenes Pendientes");

        jButton1.setText("Siguiente Tick");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblCantIdos.setText("0");

        lblCantDesechados.setText("0");

        jLabel10.setText("Cantidad de productos desechados:");

        jLabel11.setText("Cantidad de clientes que se fueron: ");

        txfColaClientes.setColumns(20);
        txfColaClientes.setRows(5);
        jScrollPane3.setViewportView(txfColaClientes);

        jLabel12.setText("Cola de Clientes");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Restaurante de Comida Rapida");

        txfMenu.setColumns(20);
        txfMenu.setRows(5);
        jScrollPane4.setViewportView(txfMenu);

        jLabel13.setText("Menu");

        jLabel14.setText("Cantidad de clientes atendidos correctamente:");

        lblCantCorrectos.setText("0");

        jLabel3.setText("Bitácora");

        txfSuceso.setColumns(20);
        txfSuceso.setRows(5);
        jScrollPane5.setViewportView(txfSuceso);

        jLabel4.setText("Ganancias totales:");

        labelTotal.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(450, 450, 450)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jLabel13)
                        .addGap(199, 199, 199)
                        .addComponent(jLabel12)
                        .addGap(149, 149, 149)
                        .addComponent(jLabel1)
                        .addGap(152, 152, 152)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(jLabel11))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel4))))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCantCorrectos)
                            .addComponent(lblCantIdos)
                            .addComponent(lblCantDesechados)
                            .addComponent(labelTotal))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(194, 194, 194)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(109, 109, 109)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(147, 147, 147)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel2)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel14)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel11)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(lblCantCorrectos)
                        .addGap(4, 4, 4)
                        .addComponent(lblCantIdos)
                        .addGap(4, 4, 4)
                        .addComponent(lblCantDesechados)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelTotal))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //while(!restaurante.colaCliente.getFirst().finalizado){
            
            restaurante.tick();
            restaurante.tick();
            restaurante.tick();
            restaurante.tick();
            imprimirElementos();
        
        //}
        //restaurante.colaCliente.removeFirst();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pantalla().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JLabel lblCantCorrectos;
    private javax.swing.JLabel lblCantDesechados;
    private javax.swing.JLabel lblCantIdos;
    private javax.swing.JTextArea txfColaClientes;
    private javax.swing.JTextArea txfColaClientesPendientes;
    private javax.swing.JTextArea txfColaOrdenesPendientes;
    private javax.swing.JTextArea txfMenu;
    private javax.swing.JTextArea txfSuceso;
    // End of variables declaration//GEN-END:variables
}
