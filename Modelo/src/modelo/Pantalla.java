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
public class Pantalla extends javax.swing.JFrame {

    public Restaurante restaurante;
    
    /**
     * Creates new form Pantalla
     */
    public Pantalla() {
        restaurante = new Restaurante();
        initComponents();
        imprimirElementos();
    }
    
    
    public void imprimirElementos(){
        lblCantDesechados.setText(restaurante.cantDesechados + "");
        lblCantIdos.setText(restaurante.cantIdos + "");
        lblCantCorrectos.setText(restaurante.cantCorrectos + "");
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
        
        for (int i = 0; i < restaurante.colaCliente.size(); i++)
            txfColaClientes.append("Cliente: " + restaurante.colaCliente.get(i).codigo +
                    "\tcontador: " + restaurante.colaCliente.get(i).contador + "\n");
    }
    
    public void imprimirColaClientesPendientes(){
        txfColaClientesPendientes.setText("");
        
        for (int i = 0; i < restaurante.colaCliente.size(); i++) {
            if(restaurante.colaCliente.get(i).clienteEspecial)
                txfColaClientesPendientes.append("Cliente: " + restaurante.colaCliente.get(i).codigo +
                    "\tcontador paciencia: " + restaurante.colaCliente.get(i).contadorPaciencia + "\n");
            else
                txfColaClientesPendientes.append("Cliente: " + restaurante.colaCliente.get(i).codigo +
                    "\tcontador paciencia: " + restaurante.colaCliente.get(i).contadorPaciencia + "\n");
        }
    }
    
    public void imprimirPedidosPendientes(){
        txfColaOrdenesPendientes.setText("");
        
        
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(jLabel14))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCantIdos)
                            .addComponent(lblCantDesechados)
                            .addComponent(lblCantCorrectos))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap(30, Short.MAX_VALUE)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(140, 140, 140)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(jLabel12)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addComponent(jLabel1)
                                .addGap(171, 171, 171)
                                .addComponent(jLabel7))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(35, 35, 35))
            .addGroup(layout.createSequentialGroup()
                .addGap(307, 307, 307)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(lblCantCorrectos))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(lblCantIdos))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(lblCantDesechados)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(87, 87, 87))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        imprimirElementos();
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblCantCorrectos;
    private javax.swing.JLabel lblCantDesechados;
    private javax.swing.JLabel lblCantIdos;
    private javax.swing.JTextArea txfColaClientes;
    private javax.swing.JTextArea txfColaClientesPendientes;
    private javax.swing.JTextArea txfColaOrdenesPendientes;
    private javax.swing.JTextArea txfMenu;
    // End of variables declaration//GEN-END:variables
}
