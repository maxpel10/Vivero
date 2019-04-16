package interfazgrafica.VentanasUsuario;

import interfazgrafica.ClasesBase.Planta;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Set;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ConsultarStock extends javax.swing.JFrame {
    /**
     * set de Planta, contiene todos las plantas del programa
     */
    private Set<Planta> setPlantas;
    /**
     * model de la tabla jTablePlantas
     */
    private DefaultTableModel model;
    /**
     * jFrame padre
     */
    private MenuPrincipal padre;
    
    /**
     * Constructor de la clase, inicializa los sets y define la operación a realizarse cuando se oprime la x para cerrar la ventana
     * @param plantas set de Planta, contiene todas las plantas del programa
     * @param mp Menu Principal, jFrame padre de esta ventana
     */
    public ConsultarStock(Set plantas,MenuPrincipal mp) {
        initComponents();
        setPlantas = plantas;//Apunto al set de plantas
        model = (DefaultTableModel)jTablePlantas.getModel();
        padre = mp;
        this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                padre.setEnabled(true);
                dispose();
            }
        });
    }
    public ConsultarStock() {
        initComponents();
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
        jLabel1 = new javax.swing.JLabel();
        jTextFieldPlantaABuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePlantas = new javax.swing.JTable();
        jButtonVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(590, 580));
        setResizable(false);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("Consultar stock"), this, org.jdesktop.beansbinding.BeanProperty.create("title"));
        bindingGroup.addBinding(binding);

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 12)); // NOI18N
        jLabel1.setText("Ingrese el nombre popular de la planta a buscar:");

        jTextFieldPlantaABuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldPlantaABuscarKeyTyped(evt);
            }
        });

        jTablePlantas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTablePlantas.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 12)); // NOI18N
        jTablePlantas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre popular ", "Especie", "Tamaño(m)", "Stock", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablePlantas.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTablePlantas);

        jButtonVolver.setBackground(new java.awt.Color(255, 255, 255));
        jButtonVolver.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 12)); // NOI18N
        jButtonVolver.setText("Volver");
        jButtonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldPlantaABuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(jButtonVolver)))
                .addContainerGap(128, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldPlantaABuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonVolver)
                .addContainerGap(119, Short.MAX_VALUE))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverActionPerformed
        padre.setEnabled(true);
        this.dispose();
    }//GEN-LAST:event_jButtonVolverActionPerformed

    private void jTextFieldPlantaABuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPlantaABuscarKeyTyped
        String plantaBuscada;
        model.setRowCount(0);//Borro las filas de la tabla
        plantaBuscada = jTextFieldPlantaABuscar.getText();//Leo el nombre de la planta que se esta buscando
        plantaBuscada = plantaBuscada.toUpperCase();//Paso todo a mayusculas para que sea mas facil comparar
        String planteada;
        Iterator i;
        i = setPlantas.iterator();
        while (i.hasNext()){
            Planta plantaI = (Planta) i.next();
            planteada = plantaI.getDenominacionComun();
            planteada = planteada.toUpperCase();//Al nombre de la planta i, lo paso a mayusculas
            if(planteada.contains(plantaBuscada)&&!plantaI.getBaja()){//Si el nombre de la planta i contiene al nombre que se esta buscado lo agrego a la tabla
                model.addRow(new Object[]{plantaI.getDenominacionComun(),plantaI.getEspecie(),plantaI.getTamanio(),plantaI.getStock(),plantaI.getPrecio()});
            }  
        }    
    }//GEN-LAST:event_jTextFieldPlantaABuscarKeyTyped

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        boolean hayPlantas = false;
        Iterator m = setPlantas.iterator();
        while(m.hasNext()){
            Planta planta = (Planta) m.next();
            if(!planta.getBaja())
                hayPlantas = true; 
        }
        if(!hayPlantas){
            JOptionPane.showMessageDialog(null, "No hay plantas cargadas.","Informacion",JOptionPane.INFORMATION_MESSAGE);
            padre.setEnabled(true);
            this.dispose();
        }
        model.setRowCount(0);
        Iterator i;
        i = setPlantas.iterator();
        while (i.hasNext()){//Muestro todas las plantas en la tabla
            Planta plantaI = (Planta) i.next();
            if(!plantaI.getBaja())
                model.addRow(new Object[]{plantaI.getDenominacionComun(),plantaI.getEspecie(),plantaI.getTamanio(),plantaI.getStock(),plantaI.getPrecio()});
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
            java.util.logging.Logger.getLogger(ConsultarStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultarStock().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePlantas;
    private javax.swing.JTextField jTextFieldPlantaABuscar;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}