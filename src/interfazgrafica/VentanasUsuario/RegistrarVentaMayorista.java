/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazgrafica.VentanasUsuario;

import interfazgrafica.ClasesBase.Cliente;
import interfazgrafica.ClasesBase.Pedido;
import interfazgrafica.ClasesBase.Planta;
import interfazgrafica.ClasesBase.Usuario;
import interfazgrafica.ClasesBase.Venta;
import interfazgrafica.VentanasEnComun.ValidarPago;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/**
 * Práctico de Máquina en Java<br>
 * Pantalla: Registrar Venta Mayorista
 * @author Decena, Facundo
 * @author Pellegrino, Maximiliano
 * @author Perez, José
 */
public class RegistrarVentaMayorista extends javax.swing.JFrame {
    
    /**
     * Set que contiene todos los pedidos realizados
     */
    private Set<Pedido> setPedidosAux;
    /** 
     * Set de Pedido, contiene solo los pedidos terminados sin retirar
     */
    private Set<Pedido>  setPedidos;
    /**
     * Set que contiene el registro de clientes
     */
    private Set<Cliente> setClientes;
    /**
     *  Set que contiene el registro con las ventas
     */
    private Set<Venta>  setVentas;
    /**
     *  Set que contiene el registro con las plantas, se lo envía al validar pago
     */
    private Set<Planta>  setPlantas;
    /**
     *  Set que almacena momentaneamente las plantas dentro de un pedido seleccionado
     */
    private Set<Planta> plantasDelPedido;
    /**
     *  model pedidos es el modelo para la tabla donde se muestran cada uno de los pedidos
     */
    private DefaultTableModel modelPedidos;
    /**
     * modelDetalles es el modelo para la tabla donde se muestran los detalles de un pedido seleccionado
     */
    private DefaultTableModel modelDetalles;
    /**
     * Variable para calcular el monto total de un pedido seleccionado
     */
    private double monto;
    /**
     *  Variable usada para saber si hay o no un pedido seleccionado de la tabla pedidos
     */
    private int flag;
    /**
     * Variable que almacena un pedido para confirmarlo con Validar Pago
     */
    private Pedido pedidoSeleccionado;
    /**
     *  Mapa cuya clave es el codigo de un pedido y el valor es el nombre del cliente
     */
    private Map<Integer,String> mapCodNom;
    /**
     *  Mapa cuya clave es el codigo de la planta y el valor es la cantidad de esa planta
     */
    private Map <Integer, Integer> mapVenta;
    /**
     * Variable para sumar punto al usuario logueado en el sistema
     */
    private Usuario usuario;
    /**
     * jFrame Padre
     */
    private MenuPrincipal padre;

    public RegistrarVentaMayorista() {
        initComponents();
    }
    /**
     * Crea una nueva instancia de Registrar Venta Mayorista.
     * Recibe los siguientes parametros:
     * @param pedidos Todos los pedidos realizados
     * @param clientes Todos los clientes registrados
     * @param setVentas Registro de todas las ventas
     * @param setPlantas Registro de todas las plantas
     * @param usuario Todos los usuarios registrados
     * @param mp Menu Principal, jFrame padre de esta ventana
     */
    public RegistrarVentaMayorista(Set<Pedido> pedidos, Set<Cliente> clientes, Set<Venta> setVentas, Set setPlantas ,Usuario usuario,MenuPrincipal mp){
        initComponents();
        this.flag=0;
        this.setPedidosAux = pedidos;
        this.setVentas = setVentas;
        this.setPedidos= new HashSet();
        this.setClientes = clientes;
        this.setPlantas = setPlantas;
        this.mapCodNom = new HashMap<>();
        this.mapVenta = new HashMap<>();
        this.plantasDelPedido = new HashSet();
        this.usuario = usuario;
        padre = mp;
        pedidoSeleccionado = null;
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabelPedido = new javax.swing.JLabel();
        jLabelMonto = new javax.swing.JLabel();
        jTextFieldMonto = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableDetalles = new javax.swing.JTable();
        jButtonConfirmar = new javax.swing.JButton();
        jButtonVolver = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTablePedidos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabelPedidosTerminados = new javax.swing.JLabel();
        jTextFieldBuscar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(590, 610));
        setResizable(false);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("Registrar Venta Mayorista"), this, org.jdesktop.beansbinding.BeanProperty.create("title"));
        bindingGroup.addBinding(binding);

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));

        jLabelPedido.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); // NOI18N
        jLabelPedido.setText("Detalles del Pedido");

        jLabelMonto.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); // NOI18N
        jLabelMonto.setText("Monto total: $");

        jTextFieldMonto.setEditable(false);
        jTextFieldMonto.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); // NOI18N

        jTableDetalles.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); // NOI18N
        jTableDetalles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre popular", "Cantidad", "Precio unitario", "Precio total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableDetalles.setEnabled(false);
        jTableDetalles.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTableDetalles);

        jButtonConfirmar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonConfirmar.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); // NOI18N
        jButtonConfirmar.setText("Confirmar venta");
        jButtonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarActionPerformed(evt);
            }
        });

        jButtonVolver.setBackground(new java.awt.Color(255, 255, 255));
        jButtonVolver.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); // NOI18N
        jButtonVolver.setText("Cancelar");
        jButtonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelPedido)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButtonConfirmar)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabelMonto)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(66, 66, 66)
                                .addComponent(jButtonVolver)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelPedido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMonto)
                    .addComponent(jTextFieldMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonConfirmar)
                    .addComponent(jButtonVolver))
                .addGap(69, 69, 69))
        );

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

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); // NOI18N
        jLabel1.setText("Clientes");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabelPedidosTerminados.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); // NOI18N
        jLabelPedidosTerminados.setText("Ingrese el nombre del cliente cuyo pedido desea buscar:");

        jTextFieldBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldBuscarKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(107, 107, 107))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabelPedidosTerminados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldBuscar))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabelPedidosTerminados, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverActionPerformed
        padre.setEnabled(true);
        this.dispose();
    }//GEN-LAST:event_jButtonVolverActionPerformed
    /**
     * Invoca a Validar Pago con pedidoSeleccionado,mapVenta,plantasDelPedido,setVentas,usuario,this.
     * Reinicia modelDetalles, modelPedidos, jTextFieldBuscar y jTextFieldMonto
     * @param evt 
     */
    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed
          if(plantasDelPedido.isEmpty()){
              JOptionPane.showMessageDialog(rootPane,"No selecciono ningún pedido",
                      "Advertencia", HEIGHT);
          }
          else{
                ValidarPago vp;
                this.setEnabled(false);
                vp = new ValidarPago(pedidoSeleccionado,mapVenta,plantasDelPedido,setVentas,usuario,this,padre);
                vp.setLocationRelativeTo(this);
                vp.setPantallaAnterior(2);
                vp.setVisible(true);   
          }
    }//GEN-LAST:event_jButtonConfirmarActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        Iterator i;
        i= setPedidosAux.iterator();
        while(i.hasNext()){
            Pedido pedidoI= (Pedido) i.next();
            if(!pedidoI.getRetirado()&&pedidoI.getEstado())
                setPedidos.add(pedidoI);
        }
        flag = 0;
        if(setPedidos.isEmpty()){
            JOptionPane.showMessageDialog(null, "No hay ningun pedido terminado"
                    ,"Información", JOptionPane.INFORMATION_MESSAGE);
            padre.setEnabled(true);
            this.dispose();
        }
        else{
            String nombreBuscado;
            modelPedidos.setRowCount(0);
            mapCodNom.clear();
            nombreBuscado = jTextFieldBuscar.getText();
            String clienteado;
            int codeado;
            int codi=0;
            i = setClientes.iterator();
            while(i.hasNext()){
                Cliente clienteI = (Cliente) i.next();
                clienteado = clienteI.getNombre();
                clienteado = clienteado.toUpperCase();
                if(clienteado.contains(nombreBuscado)){
                    codi = clienteI.getCodigo();
                    mapCodNom.put(codi, clienteI.getNombre());
                    flag = 1;
                }
            }
            if(flag==0){
                JOptionPane.showMessageDialog(rootPane,"No hay ningun cliente"
                + " que coincida con la busqueda",
                "Informacion", JOptionPane.INFORMATION_MESSAGE);
            }

            Set<Integer> claves = mapCodNom.keySet();
            i = setPedidos.iterator();
            while(i.hasNext()){
                Pedido pedidoI = (Pedido) i.next();
                codeado = pedidoI.getCodigoCliente();
                Iterator j;
                j = claves.iterator();
                while(j.hasNext()){
                    codi = (Integer) j.next();
                    if(codi == codeado){
                        modelPedidos.addRow(new Object[]{mapCodNom.get(codi),
                            pedidoI.getCodigo()});
                    }
                }
            }
        }
    }//GEN-LAST:event_formComponentShown

    private void jTextFieldBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscarKeyTyped
        flag =0;
        if(setPedidos.isEmpty()){
            JOptionPane.showMessageDialog(null, "No hay ningun pedido terminado","Información", JOptionPane.INFORMATION_MESSAGE);
        }
        String nombreBuscado;
        modelPedidos.setRowCount(0);
        mapCodNom.clear();
        nombreBuscado = jTextFieldBuscar.getText();
        nombreBuscado = nombreBuscado.toUpperCase();
        String clienteado;
        int codeado;
        int codi;
        Iterator i;
        i = setClientes.iterator();
        while(i.hasNext()){
            Cliente clienteI = (Cliente) i.next();
            clienteado = clienteI.getNombre();
            clienteado = clienteado.toUpperCase();
            if(clienteado.contains(nombreBuscado)){
                codi = clienteI.getCodigo();
                mapCodNom.put(codi, clienteI.getNombre());
                flag = 1;
            }
        } 
        Set<Integer> claves = mapCodNom.keySet();
        i = setPedidos.iterator();
        while(i.hasNext()){
            Pedido pedidoI = (Pedido) i.next();
            codeado = pedidoI.getCodigoCliente();
            Iterator j;
            j = claves.iterator();
            while(j.hasNext()){
                codi = (Integer) j.next();
                if(codi == codeado){
                    modelPedidos.addRow(new Object[]{mapCodNom.get(codi),pedidoI.getCodigo()});
                }
            }
        }
    }//GEN-LAST:event_jTextFieldBuscarKeyTyped

    private void jTablePedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePedidosMouseClicked
        monto=0.0;
        modelDetalles.setRowCount(0);
        jTextFieldMonto.setText("");
        String codPedidoS;
        int codeado;
        Iterator i,j,k;
        Planta planta;
        int codPedidoI;
        try{
            codPedidoS=String.valueOf(modelPedidos.getValueAt
                (jTablePedidos.getSelectedRow(),1));
            codPedidoI = Integer.parseInt(codPedidoS);
            i = setPedidos.iterator();
            while(i.hasNext()){
                Pedido pedidoI = (Pedido) i.next();
                codeado = pedidoI.getCodigo();
                if(codPedidoI == codeado){
                    pedidoSeleccionado = pedidoI;
                    k =  pedidoI.getPedido().keySet().iterator();
                    while(k.hasNext()){
                        planta = (Planta) k.next();
                        monto = monto +(planta.getPrecio()*pedidoI.getPedido().get(planta));
                        modelDetalles.addRow(new Object[]{planta.getDenominacionComun(),pedidoI.getPedido().get(planta),planta.getPrecio(),planta.getPrecio()*pedidoI.getPedido().get(planta)});
                        mapVenta.put(planta.getCodigo(),pedidoI.getPedido().get(planta));
                        plantasDelPedido.add(planta);
                    }
                }
            }
            String textoAux = String.valueOf(monto);
            jTextFieldMonto.setText(textoAux);
        }
        catch(ArrayIndexOutOfBoundsException aioobe){
            JOptionPane.showMessageDialog(null,"Debe tener un pedido seleccionado","Advertencia",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jTablePedidosMouseClicked

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
            java.util.logging.Logger.getLogger(RegistrarVentaMayorista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarVentaMayorista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarVentaMayorista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarVentaMayorista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarVentaMayorista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelMonto;
    private javax.swing.JLabel jLabelPedido;
    private javax.swing.JLabel jLabelPedidosTerminados;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableDetalles;
    private javax.swing.JTable jTablePedidos;
    private javax.swing.JTextField jTextFieldBuscar;
    private javax.swing.JTextField jTextFieldMonto;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
