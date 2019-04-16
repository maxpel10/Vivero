/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazgrafica.VentanasEnComun;

import interfazgrafica.ClasesBase.Cliente;
import interfazgrafica.ClasesBase.Usuario;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;


public class Registrarse extends javax.swing.JFrame {
    /**
     * Set con todos los clientes registrados.
     */
    Set<Cliente> setClientes;
    /**
     * Set con todos los usuarios registrados
     */
    Set<Usuario> setUsuarios;
    /**
    * jFrame para volver a la pantalla Login.
    */
    Login login;
    /**
     * Registra un cliente nuevo.
     * @param setClientes conjunto de los clientes ya registrados
     * @param login Login del que se llamo a la ventana registrarse
     */
    public Registrarse(Set<Cliente> setClientes, Login login,Set<Usuario> setUsuarios) {
        initComponents();
        this.login = login;
        this.setClientes = setClientes;
        this.setUsuarios = setUsuarios;
        this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                int reply = JOptionPane.showConfirmDialog(null,"Esta seguro que desea cancelar? Perdera los datos del registro","Atencion",JOptionPane.YES_NO_OPTION);
                if(reply == JOptionPane.YES_OPTION){
                    login.setVisible(true);
                    dispose();    
                }                    
            }
        });
    }
    
    public Registrarse() {
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

        jPanel2 = new javax.swing.JPanel();
        jLabelDireccionEmpresa = new javax.swing.JLabel();
        jTextFiedDireccionEmpresa = new javax.swing.JTextField();
        jLabelCorreoRegsitro = new javax.swing.JLabel();
        jLabelContraRegistrarse = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPasswordFieldContraRegistro = new javax.swing.JPasswordField();
        jPasswordFieldConfiContraRegistro = new javax.swing.JPasswordField();
        jLabelCUIL = new javax.swing.JLabel();
        jTextFieldCUIL = new javax.swing.JTextField();
        jLabelNombreUsuario = new javax.swing.JLabel();
        jTextFieldUsuario = new javax.swing.JTextField();
        jLabelTipoDeEmpresa = new javax.swing.JLabel();
        jComboBoxTipo = new javax.swing.JComboBox<>();
        jLabelNombreyApellido = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldEmailRegistro = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jButtonConfirmar = new javax.swing.JButton();
        jButtonCancelarRegistro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(420, 450));
        setResizable(false);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("Registrarse"), this, org.jdesktop.beansbinding.BeanProperty.create("title"));
        bindingGroup.addBinding(binding);

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setMinimumSize(new java.awt.Dimension(420, 450));
        jPanel2.setPreferredSize(new java.awt.Dimension(420, 420));

        jLabelDireccionEmpresa.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 12)); // NOI18N
        jLabelDireccionEmpresa.setText("Dirección");

        jLabelCorreoRegsitro.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 12)); // NOI18N
        jLabelCorreoRegsitro.setText("Contraseña");

        jLabelContraRegistrarse.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 12)); // NOI18N
        jLabelContraRegistrarse.setText("Confirmar Contraseña");

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 12)); // NOI18N
        jLabel1.setText("Email");

        jPasswordFieldContraRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordFieldContraRegistroActionPerformed(evt);
            }
        });

        jLabelCUIL.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 12)); // NOI18N
        jLabelCUIL.setText("C.U.I.T.");

        jLabelNombreUsuario.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 12)); // NOI18N
        jLabelNombreUsuario.setText("Usuario");

        jLabelTipoDeEmpresa.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 12)); // NOI18N
        jLabelTipoDeEmpresa.setText("Tipo de Empresa");

        jComboBoxTipo.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 12)); // NOI18N
        jComboBoxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Floreria", "Vivero" }));

        jLabelNombreyApellido.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 12)); // NOI18N
        jLabelNombreyApellido.setText("Nombre de la Empresa");

        jTextFieldEmailRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEmailRegistroActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));

        jButtonConfirmar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonConfirmar.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); // NOI18N
        jButtonConfirmar.setText("Confirmar");
        jButtonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarActionPerformed(evt);
            }
        });

        jButtonCancelarRegistro.setBackground(new java.awt.Color(255, 255, 255));
        jButtonCancelarRegistro.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); // NOI18N
        jButtonCancelarRegistro.setText("Cancelar");
        jButtonCancelarRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarRegistroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(jButtonConfirmar)
                .addGap(57, 57, 57)
                .addComponent(jButtonCancelarRegistro)
                .addGap(28, 28, 28))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonConfirmar)
                    .addComponent(jButtonCancelarRegistro)))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelDireccionEmpresa)
                            .addComponent(jLabelCUIL)
                            .addComponent(jLabelNombreUsuario)
                            .addComponent(jLabelCorreoRegsitro, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelContraRegistrarse)
                            .addComponent(jLabel1)
                            .addComponent(jLabelTipoDeEmpresa)
                            .addComponent(jLabelNombreyApellido))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldEmailRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPasswordFieldConfiContraRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPasswordFieldContraRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldCUIL, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFiedDireccionEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombreyApellido)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTipoDeEmpresa)
                    .addComponent(jComboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDireccionEmpresa)
                    .addComponent(jTextFiedDireccionEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCUIL)
                    .addComponent(jTextFieldCUIL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombreUsuario)
                    .addComponent(jTextFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCorreoRegsitro)
                    .addComponent(jPasswordFieldContraRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelContraRegistrarse)
                    .addComponent(jPasswordFieldConfiContraRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldEmailRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(128, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarRegistroActionPerformed
        int reply = JOptionPane.showConfirmDialog(null,"Esta seguro que desea cancelar? Perdera los datos del registro","Atencion",JOptionPane.YES_NO_OPTION);
        if(reply == JOptionPane.YES_OPTION){
            login.setEnabled(true);
            this.dispose();    
        }      
    }//GEN-LAST:event_jButtonCancelarRegistroActionPerformed

    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed
        
        String nombre = "";
        boolean estaBien = true;
        String contrasenia = new String(jPasswordFieldContraRegistro.getPassword());
        String conficontra = new String(jPasswordFieldConfiContraRegistro.getPassword());
        long cuitFinal = 0;
        String cuit = "";
        String email = "";
        
        
        if(contrasenia.equals("")||conficontra.equals("")||jTextFieldNombre.getText().equals("")||jTextFieldEmailRegistro.getText().equals("")||jTextFieldCUIL.getText().equals("")||jTextFieldUsuario.getText().equals("")||jTextFiedDireccionEmpresa.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Algunos campos no se han completado. Intente nuevamente.","Advertencia",JOptionPane.WARNING_MESSAGE);
            estaBien = false;
        }
        
        
        if(estaBien){
            nombre = jTextFieldNombre.getText();
            String regex = "^[a-zA-Z][a-zA-Z\\s]*$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(nombre);
            if (!matcher.matches()){
                JOptionPane.showMessageDialog(null,"El formato del nombre de la empresa es incorrecto. No puede comenzar con un espacio, contener numeros ni caracteres especiales (incluye tildes). Intente nuevamente","Advertencia",JOptionPane.WARNING_MESSAGE);
                estaBien = false;  
            }
        }
        
        if(estaBien){
            cuit = jTextFieldCUIL.getText();
            //Eliminamos todos los caracteres que no son números
            cuit = cuit.replaceAll("[^\\d]", "");
            //Controlamos si son 11 números los que quedaron, si no es el caso, ya devuelve falso
            if (cuit.length() != 11){
                JOptionPane.showMessageDialog(null,"La longitud del CUIT es incorrecta. Intente nuevamente.","Advertencia",JOptionPane.WARNING_MESSAGE);
                estaBien = false;
            }
        }
        
        if (estaBien){//Validacion del Cuil
            //Convertimos la cadena que quedó en una matriz de caracteres
            char[] cuitArray = cuit.toCharArray();
            //Inicializamos una matriz por la cual se multiplicarán cada uno de los dígitos
            int[] serie = {5, 4, 3, 2, 7, 6, 5, 4, 3, 2};
            //Creamos una variable auxiliar donde guardaremos los resultados del cálculo del número validador
            int aux = 0;
            //Recorremos las matrices de forma simultanea, sumando los productos de la serie por el número en la misma posición
            for (int i=0; i<10; i++){
                aux += Character.getNumericValue(cuitArray[i]) * serie[i];
            }
            //Hacemos como se especifica: 11 menos el resto de de la división de la suma de productos anterior por 11
            aux = 11 - (aux % 11);
            //Si el resultado anterior es 11 el código es 0
            if (aux == 11){
                aux = 0;
            }
            //Si el resultado anterior es 10 el código no tiene que validar, cosa que de todas formas pasa
            //en la siguiente comparación.
            //Devuelve verdadero si son iguales, falso si no lo son
            //(Esta forma esta dada para prevenir errores, en java 6 se puede usar: return aux.equals(Character.getNumericValue(cuitArray[10]));)
            if(!(Character.getNumericValue(cuitArray[10]) == aux)){
                JOptionPane.showMessageDialog(null,"El CUIT no es valido. Intente nuevamente.","Advertencia",JOptionPane.WARNING_MESSAGE);
                estaBien = false;
            }
            else
                cuitFinal = Long.parseLong(cuit);//No realizo try porque la validacion ya le quita los  caracteres
        }

        
        if(estaBien){
            Iterator i = setClientes.iterator();
            while(i.hasNext()){
                Cliente c = (Cliente) i.next();
                if(c.getCuil() == cuitFinal){
                    JOptionPane.showMessageDialog(null,"Ya existe un cliente registrado con ese CUIT. Intente nuevamente","Advertencia",JOptionPane.WARNING_MESSAGE);
                    estaBien=false;
                    break;
                }
            }
        }
        
        if(estaBien){
            Iterator i = setClientes.iterator();
            while(i.hasNext()){
                Cliente c = (Cliente) i.next();
                if(c.getUsuario().equals(jTextFieldUsuario.getText())){
                    JOptionPane.showMessageDialog(null,"El nombre de usuario ingresado ya esta en uso. Intente nuevamente","Advertencia",JOptionPane.WARNING_MESSAGE);
                    estaBien=false;
                    break;
                }
            }
        }
        
        if(estaBien){
            Iterator i = setUsuarios.iterator();
            while(i.hasNext()){
                Usuario u = (Usuario) i.next();
                if(u.getUsuario().equals(jTextFieldUsuario.getText())){
                    JOptionPane.showMessageDialog(null,"El nombre de usuario ingresado ya esta en uso. Intente nuevamente","Advertencia",JOptionPane.WARNING_MESSAGE);
                    estaBien=false;
                    break;
                }
            }
        
        
        }
        
        if(estaBien){
            if(jTextFieldUsuario.getText().length()<6){
                JOptionPane.showMessageDialog(null,"El nombre de usuario debe tener al menos 6 caracteres. Intente nuevamente","Advertencia",JOptionPane.WARNING_MESSAGE);
                estaBien=false;
            }
        }
        
        if(estaBien){
            if(contrasenia.length()<6){
                JOptionPane.showMessageDialog(null,"La contraseña debe tener al menos 6 caracteres. Intente nuevamente","Advertencia",JOptionPane.WARNING_MESSAGE);
                estaBien=false;
            }
        }
        
        if(estaBien){
            if(!contrasenia.equals(conficontra)){
                JOptionPane.showMessageDialog(null,"Las contraseñas ingresadas no coinciden. Intente nuevamente","Advertencia",JOptionPane.WARNING_MESSAGE);
                estaBien = false;
            }
        }
        
        if(estaBien){//Valida un correo
            email = jTextFieldEmailRegistro.getText();
            String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(email);
            if (!matcher.matches()){
                JOptionPane.showMessageDialog(null,"Email incorrecto. Intente nuevamente","Advertencia",JOptionPane.WARNING_MESSAGE);
                estaBien = false;  
            }
        }
        
        if(estaBien){
            Cliente nuevo = new Cliente();
            nuevo.setNombre(nombre);
            nuevo.setCuil(cuitFinal);
            nuevo.setDireccion(jTextFiedDireccionEmpresa.getText());
            nuevo.setEmail(email);
            nuevo.setTipo(jComboBoxTipo.getSelectedItem().equals("Vivero"));
            nuevo.setUsuario(jTextFieldUsuario.getText());
            nuevo.setContrasenia(contrasenia);
            int reply = JOptionPane.showConfirmDialog(null,"Para efectuar el registro en el sistema es necesario abonar por unica vez $250. Desea continuar?","Atencion",JOptionPane.YES_NO_OPTION);
            if(reply == JOptionPane.YES_OPTION){
                this.setEnabled(false);
                ValidarPago vp = new ValidarPago(nuevo,this,setClientes,login);
                vp.setVisible(true);
                vp.setLocationRelativeTo(this);
                vp.setPantallaAnterior(0);
            }
        }
        
    }//GEN-LAST:event_jButtonConfirmarActionPerformed

    private void jTextFieldEmailRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEmailRegistroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEmailRegistroActionPerformed

    private void jPasswordFieldContraRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordFieldContraRegistroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordFieldContraRegistroActionPerformed

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
            java.util.logging.Logger.getLogger(Registrarse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registrarse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registrarse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registrarse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registrarse().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelarRegistro;
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JComboBox<String> jComboBoxTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelCUIL;
    private javax.swing.JLabel jLabelContraRegistrarse;
    private javax.swing.JLabel jLabelCorreoRegsitro;
    private javax.swing.JLabel jLabelDireccionEmpresa;
    private javax.swing.JLabel jLabelNombreUsuario;
    private javax.swing.JLabel jLabelNombreyApellido;
    private javax.swing.JLabel jLabelTipoDeEmpresa;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordFieldConfiContraRegistro;
    private javax.swing.JPasswordField jPasswordFieldContraRegistro;
    private javax.swing.JTextField jTextFiedDireccionEmpresa;
    private javax.swing.JTextField jTextFieldCUIL;
    private javax.swing.JTextField jTextFieldEmailRegistro;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldUsuario;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}