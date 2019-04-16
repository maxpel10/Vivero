package interfazgrafica.VentanasUsuario;

import interfazgrafica.ClasesBase.Dueño;
import interfazgrafica.ClasesBase.Planta;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ModificarPlanta extends javax.swing.JFrame {
    /**
     * Set con todas las plantas registradas
     */
    private Set<Planta> setPlantas;
    /**
     * Modelo  para la tabla donde se muestran las plantas registradas
     */
    private DefaultTableModel model;
    /**
     *  Variable donde se modifican cada uno de los campos de una planta
     */
    private Planta laPlanta;
    /**
     * Creates new form ModificarPlanta
     */
    private MenuPrincipal padre;
    
    public ModificarPlanta() {
        initComponents();
    }
    /**
     * Modifica una planta del registro de plantas
     * Carga las plantas disponibles en la tabla para mostrarlas
     * @param setPlantas set de Planta, contiene todas las plantas del programa
     * @param mp Menu Principal, jFrame padre de esta ventana
     */
    ModificarPlanta(Set<Planta> setPlantas, MenuPrincipal mp) {
        initComponents();
        this.setPlantas = setPlantas;
        padre = mp;
        model = (DefaultTableModel) jTablePlantas.getModel();
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePlantas = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldTamano = new javax.swing.JTextField();
        jTextFieldPrecio = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldEspecie = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButtonModificar = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modificar planta");
        setMinimumSize(new java.awt.Dimension(590, 580));
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 12)); // NOI18N
        jLabel1.setText("Ingrese el nombre popular de la planta a buscar:");

        jTextFieldBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldBuscarKeyPressed(evt);
            }
        });

        jTablePlantas.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 12)); // NOI18N
        jTablePlantas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre popular", "Especie", "Tamaño (m)", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablePlantas.getTableHeader().setReorderingAllowed(false);
        jTablePlantas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePlantasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTablePlantas);

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));

        jTextFieldNombre.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 12)); // NOI18N
        jLabel5.setText("Tamaño");

        jLabel6.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 12)); // NOI18N
        jLabel6.setText("Precio ($)");

        jLabel3.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 12)); // NOI18N
        jLabel3.setText("Nombre cientifico");

        jLabel4.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 12)); // NOI18N
        jLabel4.setText("Nombre popular");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldTamano, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldTamano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jButtonModificar.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 12)); // NOI18N
        jButtonModificar.setText("Modificar");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });

        jButtonEliminar.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 12)); // NOI18N
        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });

        jButtonCancelar.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 12)); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 12)); // NOI18N
        jLabel2.setText("Plantas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(jButtonModificar)
                        .addGap(57, 57, 57)
                        .addComponent(jButtonEliminar)
                        .addGap(62, 62, 62)
                        .addComponent(jButtonCancelar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonModificar)
                    .addComponent(jButtonEliminar)
                    .addComponent(jButtonCancelar))
                .addGap(55, 55, 55))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        while(i.hasNext()){
            Planta plantaI = (Planta) i.next();
            if(!plantaI.getBaja())
                model.addRow(new Object []{plantaI.getDenominacionComun(),plantaI.getEspecie(),String.valueOf(plantaI.getTamanio()),String.valueOf(plantaI.getPrecio())});
        }
        jTextFieldEspecie.setText("");
        jTextFieldNombre.setText("");
        jTextFieldPrecio.setText("");
        jTextFieldTamano.setText("");
    }//GEN-LAST:event_formComponentShown

    private void jTablePlantasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePlantasMouseClicked
        Iterator i;
        String nombre = String.valueOf(model.getValueAt(jTablePlantas.getSelectedRow(),0));
        i = setPlantas.iterator();
        while(i.hasNext()){
            Planta plantaI = (Planta) i.next();
            if(nombre.equals(plantaI.getDenominacionComun())){
                jTextFieldEspecie.setText(plantaI.getEspecie());
                jTextFieldNombre.setText(plantaI.getDenominacionComun());
                jTextFieldPrecio.setText(String.valueOf(plantaI.getPrecio()));
                jTextFieldTamano.setText(String.valueOf(plantaI.getTamanio()));
                laPlanta = plantaI;
                break;
            }
        }
    }//GEN-LAST:event_jTablePlantasMouseClicked

    private void jTextFieldBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscarKeyPressed
        model.setRowCount(0);
        String buscado;
        buscado = jTextFieldBuscar.getText();
        buscado = buscado.toUpperCase();
        Iterator i;
        i = setPlantas.iterator();
        while(i.hasNext()){
            Planta plantaI = (Planta) i.next();
            String planteado = plantaI.getDenominacionComun();
            planteado = planteado.toUpperCase();
            if(planteado.contains(buscado)){
                model.addRow(new Object []{plantaI.getDenominacionComun(),plantaI.getEspecie(),String.valueOf(plantaI.getTamanio()),String.valueOf(plantaI.getPrecio())});
            }
        }
    }//GEN-LAST:event_jTextFieldBuscarKeyPressed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        try{
            laPlanta.getDenominacionComun();//Fuerzo la excepcion
            boolean estaBien = true,found = false;
            String especie,nombre,planteada,precio,tamanio,stock;
            especie = jTextFieldEspecie.getText();//Tomo todos los datos ingresados
            nombre = jTextFieldNombre.getText();
            precio = jTextFieldPrecio.getText();
            tamanio = jTextFieldTamano.getText();
            double precioAux = 0, tamanioAux = 0;

            if(nombre.equals("") || especie.equals("") || precio.equals("") || tamanio.equals("")){//Si no ingresó el nombre ni la especie, no esta completo
                JOptionPane.showMessageDialog(null,"Algunos campos no se han completado. Intente nuevamente.","Advertencia",JOptionPane.WARNING_MESSAGE);
                estaBien = false;
            }

            if(estaBien){
                String regex = "^[a-zA-Z][a-zA-Z\\s]*$";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(especie);
                if (!matcher.matches()){
                    JOptionPane.showMessageDialog(null,"El formato del nombre cientifico es incorrecto. No puede comenzar con un espacio, contener numeros ni caracteres especiales (incluye tildes). Intente nuevamente","Advertencia",JOptionPane.WARNING_MESSAGE);
                    estaBien = false;  
                }
            }
            
            
            if(estaBien){
                String regex = "^[a-zA-Z][a-zA-Z\\s]*$";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(nombre);
                if (!matcher.matches()){
                    JOptionPane.showMessageDialog(null,"El formato del nombre popular es incorrecto. No puede comenzar con un espacio, contener numeros ni caracteres especiales (incluye tildes). Intente nuevamente","Advertencia",JOptionPane.WARNING_MESSAGE);
                    estaBien = false;  
                }
            }

            

            if(estaBien){
                try{
                    precioAux = Double.parseDouble(precio);
                }
                catch(NumberFormatException nfe){
                    JOptionPane.showMessageDialog(null,"El precio puede contener solo numeros y un punto. Intente nuevamente.","Advertencia",JOptionPane.WARNING_MESSAGE);
                    estaBien = false;
                }
            }

            if(estaBien){
                if(precioAux<=0){
                    JOptionPane.showMessageDialog(null,"El precio debe ser positivo. Intente nuevamente","Advertencia",JOptionPane.WARNING_MESSAGE);
                    estaBien = false;
                }
            }

            if(estaBien){
                try{
                    tamanioAux = Double.parseDouble(tamanio);
                }
                catch(NumberFormatException nfe){
                    JOptionPane.showMessageDialog(null,"El tamano puede contener solo numeros y un punto. Intente nuevamente.","Advertencia",JOptionPane.WARNING_MESSAGE);
                    estaBien = false;
                }
            }
        
            if(estaBien){
                if(tamanioAux<=0){
                    JOptionPane.showMessageDialog(null,"El tamanio debe ser positivo. Intente nuevamente","Advertencia",JOptionPane.WARNING_MESSAGE);
                    estaBien = false;
                }
            }

            if(estaBien){
                Iterator i = setPlantas.iterator();
                while(i.hasNext()){//Controlo que ya no haya una planta con ese nombre cargada en el set
                    Planta planta = (Planta) i.next();
                    if(nombre.equalsIgnoreCase(planta.getDenominacionComun()) && planta != laPlanta){
                        JOptionPane.showMessageDialog(null,"Ya existe una planta cargada con ese nombre popular. Intente nuevamente","Advertencia",JOptionPane.WARNING_MESSAGE);
                        estaBien = false;
                        break;
                     }
                }
            }
            
            if(estaBien){
                if(nombre.equals(laPlanta.getDenominacionComun())&&especie.equals(laPlanta.getEspecie())&& tamanioAux == laPlanta.getTamanio()&& precioAux == laPlanta.getPrecio()){
                    JOptionPane.showMessageDialog(null,"No modifico ningun dato. Intente nuevamente","Advertencia",JOptionPane.WARNING_MESSAGE);
                    estaBien = false;
                }
            }

            if(estaBien){
                laPlanta.setDenominacionComun(nombre);
                laPlanta.setEspecie(especie);
                laPlanta.setTamanio(tamanioAux);
                laPlanta.setPrecio(precioAux);
                JOptionPane.showMessageDialog(null,"Planta modificada con exito","Informacion",JOptionPane.INFORMATION_MESSAGE);
                this.setVisible(false);
                padre.setVisible(true);
                this.setVisible(true);
                laPlanta = null;
            }
            
        }
        catch(NullPointerException npe){
            JOptionPane.showMessageDialog(null,"Debe haber una planta seleccionada","Advertencia",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        try{
            laPlanta.getBaja();//Fuerzo la excepcion
            int reply = JOptionPane.showConfirmDialog(null, "¿Está seguro que quiere eliminar la planta?","Confirmar",JOptionPane.YES_NO_OPTION);
            if(reply==JOptionPane.YES_OPTION){
                laPlanta.setBaja(true);
                Iterator i;
                i = setPlantas.iterator();
                JOptionPane.showMessageDialog(null, "Se eliminó correctamente","Información",JOptionPane.INFORMATION_MESSAGE);
                this.setVisible(false);
                padre.setVisible(true);
                this.setVisible(true);
                laPlanta=null;
            }
        }
        catch(NullPointerException npe){
            JOptionPane.showMessageDialog(null,"Debe haber una planta seleccionada","Advertencia",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        padre.setEnabled(true);
        this.dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(ModificarPlanta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarPlanta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarPlanta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarPlanta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarPlanta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePlantas;
    private javax.swing.JTextField jTextFieldBuscar;
    private javax.swing.JTextField jTextFieldEspecie;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldPrecio;
    private javax.swing.JTextField jTextFieldTamano;
    // End of variables declaration//GEN-END:variables
}
