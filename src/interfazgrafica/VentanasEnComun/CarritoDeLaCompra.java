package interfazgrafica.VentanasEnComun;

import interfazgrafica.VentanasCliente.GenerarPedido;
import interfazgrafica.VentanasUsuario.RegistrarVentaMinorista;
import interfazgrafica.ClasesBase.Planta;
import java.util.Set;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Map;


public class CarritoDeLaCompra extends javax.swing.JFrame {
    /**
     * Mapa cuya clave es el codigo de las plantas seleccionadas y su valor es la cantidad requerida de cada planta
     */
    private Map <Integer,Integer> stockAux;
    /**
     *  Set con todas las plantas registradas.
     */
    private Set  setLocal;
    /**
     * Modelo para la tabla donde se muestran las plantas dentro del carro de compras
     */
    private DefaultTableModel model;
    /**
     * Valor tomado del jSpinner.
     */
    private int cantidad;
    /**
     *  jFrame para volver a la pantalla anterior.
     */
    private RegistrarVentaMinorista rvm;
    /**
     * jFrame para volver a la pantalla anterior.
     */
    private GenerarPedido gp;
    
    /**
     * Creates new form CarritoDeLaCompra
     */
    public CarritoDeLaCompra() {
        initComponents();
        this.cantidad=0;
    }
    /**
     * Carrito de la compra muestra las plantas seleccionadas previa a la compra y permite decrementar las cantidades.
     * @param externo
     * @param setPlantas
     * @param gp 
     */
    public CarritoDeLaCompra(Map externo, Set setPlantas,GenerarPedido gp){
        initComponents();
        this.gp = gp;
        this.cantidad=0;
        this.stockAux= externo;
        this.setLocal=setPlantas;
        model = (DefaultTableModel)tabla2.getModel();
        Iterator i;
        i= setLocal.iterator();// Itera el set de plantas recibido por parametro y lo muestra en jTable
        if(stockAux.isEmpty()){
            model.addRow(new Object[]{"","","","",""});//SI NO TIENE AVISO QUE NO TIENE
        }
        while(i.hasNext()){
           Planta aux = (Planta)i.next();
           if(stockAux.containsKey(aux.getCodigo())){
               model.addRow(new Object[]{aux.getDenominacionComun(),
               stockAux.get(aux.getCodigo()),aux.getPrecio(),
               (stockAux.get(aux.getCodigo())*aux.getPrecio()),aux.getCodigo()}); 
           }
        }
        this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                gp.setEnabled(true);
                gp.setVisible(true);
            }
        });
    }
    /**
     * Recibe un set de plantas en el cual la variable Stock es usasada para
     * saber la cantidad de items que se desan comprar de esa planta.
     * 
     * @param setExterno
     */
    public CarritoDeLaCompra(Map externo, Set setPlantas,RegistrarVentaMinorista rvm){
        initComponents();
        this.rvm = rvm;
        this.cantidad=0;
        this.stockAux= externo;
        this.setLocal=setPlantas;
        model = (DefaultTableModel)tabla2.getModel();
        Iterator i;
        i= setLocal.iterator();// Itera el set de plantas recibido por parametro y lo muestra en jTable
        if(stockAux.isEmpty()){
            model.addRow(new Object[]{"","","","",""});//SI NO TIENE AVISO QUE NO TIENE
        }
        while(i.hasNext()){
           Planta aux = (Planta)i.next();
           if(stockAux.containsKey(aux.getCodigo())){
               model.addRow(new Object[]{aux.getDenominacionComun(),
               stockAux.get(aux.getCodigo()),aux.getPrecio(),
               (stockAux.get(aux.getCodigo())*aux.getPrecio()),aux.getCodigo()}); 
           }
        }
        this.addWindowListener(new WindowAdapter(){
        @Override
        public void windowClosing(WindowEvent e){
            rvm.setEnabled(true);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla2 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        Eliminar = new javax.swing.JButton();
        jButtonEliminarTodos = new javax.swing.JButton();
        jButtonVolver = new javax.swing.JButton();
        jLabelCantidad = new javax.swing.JLabel();
        vaciarCarrito = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSpinner = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 204));
        setResizable(false);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("Carrito de la Compra"), this, org.jdesktop.beansbinding.BeanProperty.create("title"));
        bindingGroup.addBinding(binding);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));

        tabla2.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 12)); // NOI18N
        tabla2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre popular", "Cantidad", "Precio por Unidad", "Precio Total", "Codigo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Float.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla2.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabla2);

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));

        Eliminar.setBackground(new java.awt.Color(255, 255, 255));
        Eliminar.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); // NOI18N
        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });

        jButtonEliminarTodos.setBackground(new java.awt.Color(255, 255, 255));
        jButtonEliminarTodos.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); // NOI18N
        jButtonEliminarTodos.setText("Eliminar Todos");
        jButtonEliminarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarTodosActionPerformed(evt);
            }
        });

        jButtonVolver.setBackground(new java.awt.Color(255, 255, 255));
        jButtonVolver.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); // NOI18N
        jButtonVolver.setText("Volver");
        jButtonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverActionPerformed(evt);
            }
        });

        jLabelCantidad.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); // NOI18N
        jLabelCantidad.setText("Cantidad");

        vaciarCarrito.setBackground(new java.awt.Color(255, 255, 255));
        vaciarCarrito.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); // NOI18N
        vaciarCarrito.setText("Vaciar Carrito");
        vaciarCarrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vaciarCarritoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); // NOI18N
        jLabel1.setText("Eliminar una planta especifica");

        jLabel2.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); // NOI18N
        jLabel2.setText("-----------------------------------------------------------------------------------------------------------------");

        jSpinner.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 12)); // NOI18N
        jSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelCantidad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Eliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonEliminarTodos)
                .addGap(79, 79, 79))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addComponent(jLabel1))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(241, 241, 241)
                        .addComponent(jButtonVolver)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(vaciarCarrito)
                .addGap(43, 43, 43))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(vaciarCarrito)
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCantidad)
                    .addComponent(Eliminar)
                    .addComponent(jButtonEliminarTodos)
                    .addComponent(jSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonVolver)
                .addGap(0, 8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        try{
            String cod = String.valueOf(model.getValueAt(tabla2.getSelectedRow(),4));
            int codigo = Integer.parseInt(cod);
            cantidad=(int)jSpinner.getValue();
            if (cantidad>stockAux.get(codigo)){
                 JOptionPane.showMessageDialog(null,"No hay suficientes plantas de ese tipo","Advertencia",JOptionPane.WARNING_MESSAGE);    
            }
            else{
                int cantidadVieja= stockAux.get(codigo);
                if(cantidadVieja-cantidad ==0)
                    stockAux.remove(codigo);
                else
                  stockAux.replace(codigo, (cantidadVieja - cantidad));//ojo,puede fallar si no esta                 
                if(stockAux == null || stockAux.isEmpty() ){
                    JOptionPane.showMessageDialog(null,"El carro esta vacio"+ ", presione aceptar para volver al menu anterior","Información", JOptionPane.INFORMATION_MESSAGE);
                    try{
                        rvm.setEnabled(true);
                        rvm.setVisible(false);
                        rvm.setVisible(true);
                    }
                    catch(NullPointerException npe){
                        gp.setEnabled(true);
                        gp.setVisible(false);
                        gp.setVisible(true);
                    }
                    this.dispose();
                }
                else{
                    model.setRowCount(0);
                    Iterator i;
                    i= setLocal.iterator();
                    while(i.hasNext()){
                        Planta aux = (Planta)i.next();
                        Set <Integer> codigos = stockAux.keySet();
                        if(codigos.contains(aux.getCodigo())){
                           model.addRow(new Object[]{aux.getDenominacionComun(),stockAux.get(aux.getCodigo()),aux.getPrecio(),(stockAux.get(aux.getCodigo())*aux.getPrecio()),aux.getCodigo()}); 
                        }
                    }
                }   
            }
        }
        catch(ArrayIndexOutOfBoundsException npe){
            JOptionPane.showMessageDialog(null, "No hay nada seleccionado","Advertencia", JOptionPane.WARNING_MESSAGE);
        } 
    }//GEN-LAST:event_EliminarActionPerformed
        
    private void jButtonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverActionPerformed
         try{
             rvm.setEnabled(true);
             rvm.setVisible(false);
             rvm.setVisible(true);
         }
         catch(NullPointerException npe){
             gp.setEnabled(true);
             gp.setVisible(false);
             gp.setVisible(true);
         }
         this.dispose();
         
         
    }//GEN-LAST:event_jButtonVolverActionPerformed
/** Elimina el setAuxiliar donde estan todas las compras precargadas
 * 
 * 
 */
    private void vaciarCarritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vaciarCarritoActionPerformed
        //setLocal.clear();
        if(stockAux.isEmpty()){
            JOptionPane.showMessageDialog(null, "No hay nada en el carro","Advertencia", JOptionPane.WARNING_MESSAGE);
        }
        else{
            int reply = JOptionPane.showConfirmDialog(null,"Esta seguro que desea vaciar el carrito?","Advertencia",JOptionPane.YES_NO_OPTION);
            if( reply == JOptionPane.YES_OPTION){
                stockAux.clear();
                model.setRowCount(0);
                JOptionPane.showMessageDialog(null,"El carro esta vacio"+ ", presione aceptar para volver al menu anterior", "Información", JOptionPane.INFORMATION_MESSAGE);
                try{
                    rvm.setEnabled(true);
                    rvm.setVisible(false);
                    rvm.setVisible(true);
                }
                catch(NullPointerException npe){
                    gp.setEnabled(true);
                    gp.setVisible(false);
                    gp.setVisible(true);
                }
                this.dispose();
            }
        }
    }//GEN-LAST:event_vaciarCarritoActionPerformed
//model.setRowCount(0);
    private void jButtonEliminarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarTodosActionPerformed
        try{
            String cod = String.valueOf(model.getValueAt(tabla2.getSelectedRow(),4));
            int codigo = Integer.parseInt(cod);
            stockAux.remove(codigo);
            model.removeRow(tabla2.getSelectedRow());
            if(stockAux.isEmpty()){
                JOptionPane.showMessageDialog(null,"El carro esta vacio"+ ", presione aceptar para volver al menu anterior","Información", JOptionPane.INFORMATION_MESSAGE);
                try{
                    rvm.setEnabled(true);
                    rvm.setVisible(false);
                    rvm.setVisible(true);
                }
                catch(NullPointerException npe){
                    gp.setVisible(false);
                    gp.setVisible(true);
                    gp.setEnabled(true);
                }
                this.dispose();
            }   
        }
        catch(ArrayIndexOutOfBoundsException npe){
            JOptionPane.showMessageDialog(null, "No hay nada seleccionado","Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonEliminarTodosActionPerformed

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
            java.util.logging.Logger.getLogger(CarritoDeLaCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CarritoDeLaCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CarritoDeLaCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CarritoDeLaCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CarritoDeLaCompra().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Eliminar;
    private javax.swing.JButton jButtonEliminarTodos;
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelCantidad;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner;
    private javax.swing.JTable tabla2;
    private javax.swing.JButton vaciarCarrito;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
