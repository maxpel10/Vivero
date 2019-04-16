package interfazgrafica.VentanasUsuario;

import interfazgrafica.ClasesBase.Usuario;
import interfazgrafica.ClasesBase.Planta;
import interfazgrafica.ClasesBase.Dueño;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Set;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class CargarNuevaPlanta extends javax.swing.JFrame {
    /**
     * Set que almacena todas las plantas
     */
    private Set<Planta> setPlantas;
    /**
     * Usuario, usuario con el que se logeó
     */
    private Usuario usuario;
    /**
     * Jframe Padre
     */
    private MenuPrincipal padre;

    /**
     * Constructor de la clase, inicializa los sets y define la operación a realizarse cuando se oprime la x para cerrar la ventana 
     * @param plantas Set de Planta, contiene todas las plantas del sistema
     * @param usuario Usuario, el usuario que esta logueado
     * @param mp Menu Principal, jFrame padre de esta ventana
     */
    public CargarNuevaPlanta(Set plantas,Usuario usuario,MenuPrincipal mp) {
        initComponents();
        setPlantas = plantas;
        padre = mp;
        this.usuario = usuario;
        this.addWindowListener(new WindowAdapter(){
        @Override
            public void windowClosing(WindowEvent e){
                int reply = JOptionPane.showConfirmDialog(null,"Esta seguro que desea salir? Perdera los datos de la nueva planta a cargar","Atencion",JOptionPane.YES_NO_OPTION);
                if(reply == JOptionPane.YES_OPTION){
                    padre.setEnabled(true);
                    dispose();     
                }
            }
        });
    }
    
    public CargarNuevaPlanta() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabelNombreCientifico = new javax.swing.JLabel();
        jTextFieldNombreCientíifico = new javax.swing.JTextField();
        jLabelNombrePopular = new javax.swing.JLabel();
        jTextFieldNombrePopular = new javax.swing.JTextField();
        jLabelTamanio = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldPrecio = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jButtonConfirmarPlanta = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jTextFieldTamanio = new javax.swing.JTextField();
        jLabelStock = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSpinnerStock = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(400, 400));
        setResizable(false);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("Cargar nueva planta"), this, org.jdesktop.beansbinding.BeanProperty.create("title"));
        bindingGroup.addBinding(binding);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 300));

        jLabelNombreCientifico.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 12)); // NOI18N
        jLabelNombreCientifico.setText("Nombre científico");

        jLabelNombrePopular.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 12)); // NOI18N
        jLabelNombrePopular.setText("Nombre popular");

        jLabelTamanio.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 12)); // NOI18N
        jLabelTamanio.setText("Tamaño (m)");

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 12)); // NOI18N
        jLabel1.setText("Precio ($)");

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));

        jButtonConfirmarPlanta.setBackground(new java.awt.Color(255, 255, 255));
        jButtonConfirmarPlanta.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 12)); // NOI18N
        jButtonConfirmarPlanta.setText("Confirmar");
        jButtonConfirmarPlanta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarPlantaActionPerformed(evt);
            }
        });

        jButtonCancelar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonCancelar.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 12)); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jButtonConfirmarPlanta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(jButtonCancelar)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonConfirmarPlanta)
                    .addComponent(jButtonCancelar))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jTextFieldTamanio.setText(" ");

        jLabelStock.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 12)); // NOI18N
        jLabelStock.setText("Stock");

        jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 12)); // NOI18N
        jLabel2.setText("Ingrese los datos de la nueva planta a cargar:");

        jSpinnerStock.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelTamanio)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabelStock)
                                    .addComponent(jLabelNombrePopular)
                                    .addComponent(jLabelNombreCientifico, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldNombrePopular, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldNombreCientíifico, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldTamanio, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSpinnerStock, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 206, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombrePopular)
                    .addComponent(jTextFieldNombrePopular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNombreCientíifico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNombreCientifico))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldPrecio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTamanio)
                    .addComponent(jTextFieldTamanio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelStock)
                    .addComponent(jSpinnerStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(152, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonConfirmarPlantaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarPlantaActionPerformed
        boolean estaBien = true,found = false,reemplazada = false;
        String especie,nombre,planteada,precio,tamanio,stock;
        especie = jTextFieldNombreCientíifico.getText();//Tomo todos los datos ingresados
        nombre = jTextFieldNombrePopular.getText();
        precio = jTextFieldPrecio.getText();
        tamanio = jTextFieldTamanio.getText();
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

        
        Iterator i = setPlantas.iterator();
        while(i.hasNext()){//Controlo que ya no haya una planta con ese nombre cargada en el set
            Planta planta = (Planta) i.next();
            if(nombre.equalsIgnoreCase(planta.getDenominacionComun())&&especie.equalsIgnoreCase(planta.getEspecie())){
                if(planta.getBaja()){
                    planta.setPrecio(precioAux);
                    planta.setBaja(false);
                    planta.setTamanio(tamanioAux);
                    planta.setStock((int)jSpinnerStock.getValue());
                    JOptionPane.showMessageDialog(null,"Planta cargada con exito","Informacion",JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                    reemplazada = true;
                }
                else{
                    JOptionPane.showMessageDialog(null,"Ya existe una planta cargada con ese nombre popular y especie. Intente nuevamente","Advertencia",JOptionPane.WARNING_MESSAGE);
                    estaBien = false;
                    break;
                }
             }
        }
        
        if(estaBien&&!reemplazada){
            Planta nuevaPlanta = new Planta(nombre,especie,tamanioAux,precioAux,(int)jSpinnerStock.getValue());
            setPlantas.add(nuevaPlanta);
            Dueño dueño = (Dueño) usuario;
            dueño.actualizarEspeciesCreadas();
            dueño.nuevaEspecie();
            JOptionPane.showMessageDialog(null,"Planta cargada con exito","Informacion",JOptionPane.INFORMATION_MESSAGE);
            padre.setEnabled(true);
            this.dispose();
        }
    }//GEN-LAST:event_jButtonConfirmarPlantaActionPerformed
/*
    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarPlanta1ActionPerformed
        
    }//GEN-LAST:event_jButtonConfirmarPlanta1ActionPerformed
*/
    
    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        int reply = JOptionPane.showConfirmDialog(null,"Esta seguro que desea salir? Perdera los datos de la nueva planta a cargar","Atencion",JOptionPane.YES_NO_OPTION);
        if(reply == JOptionPane.YES_OPTION){
            padre.setEnabled(true);
            this.dispose();
        }
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
            java.util.logging.Logger.getLogger(CargarNuevaPlanta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CargarNuevaPlanta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CargarNuevaPlanta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CargarNuevaPlanta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CargarNuevaPlanta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonConfirmarPlanta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelNombreCientifico;
    private javax.swing.JLabel jLabelNombrePopular;
    private javax.swing.JLabel jLabelStock;
    private javax.swing.JLabel jLabelTamanio;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSpinner jSpinnerStock;
    private javax.swing.JTextField jTextFieldNombreCientíifico;
    private javax.swing.JTextField jTextFieldNombrePopular;
    private javax.swing.JTextField jTextFieldPrecio;
    private javax.swing.JTextField jTextFieldTamanio;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
