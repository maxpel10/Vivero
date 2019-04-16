package interfazgrafica.VentanasUsuario;

import interfazgrafica.ClasesBase.Pedido;
import interfazgrafica.ClasesBase.Cliente;
import interfazgrafica.ClasesBase.Planta;
import java.util.Set;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class ConsultarPedidos extends javax.swing.JFrame {
    /**
     * Set de Pedido, contiene todos los pedidos del programa
     */
    private Set<Pedido> setPedidos;
    /**
     * Set de Cliente, contiene a todos los clientes del programa
     */
    private Set<Cliente> setClientes;
    /**
     * model de la tabla jTablePedidos
     */
    private DefaultTableModel modelPedidos;
    /**
     * model de la tabla jTableDetalles
     */
    private DefaultTableModel modelDetalles;
    /**
     * Mapa, Integer codigo del cliente. <br>String nombre del cliente.
     */
    private Map<Integer,String> mapCodNom;
    /**
     * Jframe Padre
     */
    private MenuPrincipal padre;
    
    /**
     * Creates new form ConsultarPedidos
     */
    public ConsultarPedidos() {
        initComponents();
    }
    /**
     * Constructor de la clase, inicializa los sets y define la operación a realizarse cuando se oprime la x para cerrar la ventana  
     * @param pedidos Set de Pedido, contiene todos los pedidos del programa
     * @param clientes Set de Cliente, contiene todos los clientes del programa
     * @param mp Menu Principal, jFrame padre de esta ventana
     */
    public ConsultarPedidos(Set<Pedido> pedidos, Set<Cliente> clientes,MenuPrincipal mp) {
        initComponents();
        this.setPedidos = pedidos;
        this.setClientes = clientes;
        this.padre = mp;
        this.mapCodNom = new HashMap<>();
        modelPedidos = (DefaultTableModel) jTablePedidos.getModel();
        modelDetalles = (DefaultTableModel) jTableDetalles.getModel();
        this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                    padre.setEnabled(true);
                    dispose();
                }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jPanel2 = new javax.swing.JPanel();
        jButtonVolver = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableDetalles = new javax.swing.JTable();
        jTextFieldBuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTablePedidos = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabelTerminado = new javax.swing.JLabel();
        jLabelRetirado = new javax.swing.JLabel();
        jLabelMonto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(590, 580));
        setResizable(false);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("Consultar pedidos"), this, org.jdesktop.beansbinding.BeanProperty.create("title"));
        bindingGroup.addBinding(binding);

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));

        jButtonVolver.setBackground(new java.awt.Color(255, 255, 255));
        jButtonVolver.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 12)); // NOI18N
        jButtonVolver.setText("Volver");
        jButtonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverActionPerformed(evt);
            }
        });

        jTableDetalles.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); // NOI18N
        jTableDetalles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre popular", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableDetalles.setEnabled(false);
        jTableDetalles.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTableDetalles);

        jTextFieldBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldBuscarKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); // NOI18N
        jLabel1.setText("Pedidos");

        jLabel2.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); // NOI18N
        jLabel2.setText("Detalles del Pedido");

        jTablePedidos.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); // NOI18N
        jTablePedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cliente", "Número de pedido"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablePedidos.getTableHeader().setReorderingAllowed(false);
        jTablePedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePedidosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTablePedidos);

        jLabel3.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); // NOI18N
        jLabel3.setText("Ingrese nombre de la empresa:");

        jLabelTerminado.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); // NOI18N
        jLabelTerminado.setText(" ");

        jLabelRetirado.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); // NOI18N
        jLabelRetirado.setText(" ");

        jLabelMonto.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonVolver)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelRetirado, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                            .addComponent(jLabelTerminado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelMonto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(187, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jButtonVolver))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabelTerminado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelRetirado, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(108, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverActionPerformed
        padre.setEnabled(true);
        this.dispose();
    }//GEN-LAST:event_jButtonVolverActionPerformed

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void jComboBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox5ActionPerformed

    private void jTablePedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePedidosMouseClicked
        modelDetalles.setRowCount(0);//Borro todas las filas de la tabla con los datos
        jLabelRetirado.setText("");
        jLabelTerminado.setText("");
        jLabelMonto.setText("");
        String codPedidoS, estado,retirado;
        int codPedidoI, codeado;
        Iterator i,j,k;
        Planta p;
        try{
            codPedidoS = String.valueOf(modelPedidos.getValueAt(jTablePedidos.getSelectedRow(),1));//Tomo el codigo de pedido encontrado anteriormente
            codPedidoI = Integer.parseInt(codPedidoS);
            i = setPedidos.iterator();
            while(i.hasNext()){
                Pedido pedidoI = (Pedido) i.next();
                codeado = pedidoI.getCodigo();
                if(codPedidoI == codeado){//Si el codigo del pedido i, coincide con el obtenido de la tabla
                    Map<Planta, Integer> planta;//creo un mapa para almacenar las plantas del pedido
                    planta = pedidoI.getPedido();
                    k = planta.keySet().iterator();
                    while(k.hasNext()){//Ahora itero sobre el mapa de las plantas
                        p = (Planta) k.next();
                        if(pedidoI.getEstado())//Si el pedido esta terminado
                            jLabelTerminado.setText("Terminado");
                        else
                            jLabelTerminado.setText("No terminado");
                        if(pedidoI.getRetirado())//Si el pedido esta retirado
                            jLabelRetirado.setText("Retirado");
                        else
                            jLabelRetirado.setText("No retirado");
                        jLabelMonto.setText("$ "+String.valueOf(pedidoI.getMonto()));
                        modelDetalles.addRow(new Object[]{p.getDenominacionComun(),planta.get(p)});//Agrego la planta y la cantidad a la tabla
                    }
                }
            }
        }
        catch(ArrayIndexOutOfBoundsException aioobe){//Si no puede es porque no tenia nada seleccionado
            JOptionPane.showMessageDialog(null,"Debe tener un pedido seleccionado","Advertencia",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jTablePedidosMouseClicked

    private void jTextFieldBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscarKeyTyped
        String nombreBuscado;
        modelPedidos.setRowCount(0);
        mapCodNom.clear();
        nombreBuscado = jTextFieldBuscar.getText();//Primero busco por los nombres de los clientes
        nombreBuscado = nombreBuscado.toUpperCase();
        String clienteado;
        int codeado;
        int codi;
        Iterator i;
        i = setClientes.iterator();
        while(i.hasNext()){//Itero sobre los clientes
            Cliente clienteI = (Cliente) i.next();
            clienteado = clienteI.getNombre();
            clienteado = clienteado.toUpperCase();
            if(clienteado.contains(nombreBuscado)){//Si el nombre del clienti i contiene lo que se busca
                codi = clienteI.getCodigo();//Obtengo el codigo del cliente
                mapCodNom.put(codi, clienteI.getNombre());//y guardo en un mapa el codigo con el nombre para usarlo despues
            }
        }
        Set<Integer> claves = mapCodNom.keySet();
        i = setPedidos.iterator();
        while(i.hasNext()){//Itero sobre los pedidos
            Pedido pedidoI = (Pedido) i.next();
            codeado = pedidoI.getCodigoCliente();
            Iterator j;
            j = claves.iterator();
            while(j.hasNext()){//Itero sobre el mapa
                codi = (Integer) j.next();
                if(codi == codeado){//Si encuentro al cliente(s) cargados en el mapa, muestro el nombre del cliente y el codigo del pedido
                    modelPedidos.addRow(new Object[]{mapCodNom.get(codi),pedidoI.getCodigo()});
                }
            }
        }
    }//GEN-LAST:event_jTextFieldBuscarKeyTyped

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        modelPedidos.setRowCount(0);
        mapCodNom.clear();
        int codeado;
        int codi;
        Iterator i;
        i = setClientes.iterator();
        while(i.hasNext()){//Itero sobre los clientes
            Cliente clienteI = (Cliente) i.next();
                codi = clienteI.getCodigo();//Obtengo el codigo del cliente
                mapCodNom.put(codi, clienteI.getNombre());//y guardo en un mapa el codigo con el nombre para usarlo despues
        }
        Set<Integer> claves = mapCodNom.keySet();
        i = setPedidos.iterator();
        while(i.hasNext()){//Itero sobre los pedidos
            Pedido pedidoI = (Pedido) i.next();
            codeado = pedidoI.getCodigoCliente();
            Iterator j;
            j = claves.iterator();
            while(j.hasNext()){//Itero sobre el mapa
                codi = (Integer) j.next();
                if(codi == codeado){//Si encuentro al cliente(s) cargados en el mapa, muestro el nombre del cliente y el codigo del pedido
                    modelPedidos.addRow(new Object[]{mapCodNom.get(codi),pedidoI.getCodigo()});
                }
            }
        }
        if(modelPedidos.getRowCount() == 0){
            JOptionPane.showMessageDialog(null,"No hay registro de pedidos","Informacion",JOptionPane.INFORMATION_MESSAGE);
            padre.setEnabled(true);
            this.dispose();
        }
    }//GEN-LAST:event_formComponentShown

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
            java.util.logging.Logger.getLogger(ConsultarPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultarPedidos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelMonto;
    private javax.swing.JLabel jLabelRetirado;
    private javax.swing.JLabel jLabelTerminado;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableDetalles;
    private javax.swing.JTable jTablePedidos;
    private javax.swing.JTextField jTextFieldBuscar;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
