package interfazgrafica.VentanasCliente;

import interfazgrafica.ClasesBase.Cliente;
import interfazgrafica.ClasesBase.Usuario;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class ModificarMisDatos extends javax.swing.JFrame {
    /**
     * Set de Cliente, contiene a todos los clientes del programa
     */
    private Set<Cliente> setClientes;
    /** 
    * Set de Usuarios, contiene a todos los usuarios del programa
    */
    private Set<Usuario> setUsuarios;
    /**
     * Cliente, cliente con el que se logueó
     */
    private Cliente cliente;
    /**
     * jFrame padre
     */
    private MenuClientes padre;
    /**
     * Crea un nuevo jFrame de ModificarMisDatos
     * @param setClientes conjunto de los clientes ya registrados
     * @param cliente cliente registrado en el sistema
     * @param mc Menu clientes, jFrame padre de esta ventana
     * @param setUsuarios contiene a todos los usuarios del sistema
     */
    public ModificarMisDatos(Set<Cliente> setClientes, Cliente cliente, MenuClientes mc,Set<Usuario> setUsuarios) {
        initComponents();
        this.cliente = cliente;
        this.setClientes = setClientes;
        this.setUsuarios = setUsuarios;
        padre = mc;
        this.addWindowListener(new WindowAdapter(){
        @Override
            public void windowClosing(WindowEvent e){
                int reply = JOptionPane.showConfirmDialog(null,"Esta seguro que desea salir? Perdera todas las modificaciones","Atencion",JOptionPane.YES_NO_OPTION);
                if(reply == JOptionPane.YES_OPTION){
                    padre.setEnabled(true);
                    dispose();  
                }
            }
        });
    }
    
    public ModificarMisDatos() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabelDireccionEmpresa = new javax.swing.JLabel();
        jTextFiedDireccionEmpresa = new javax.swing.JTextField();
        jLabelCorreoRegsitro = new javax.swing.JLabel();
        jLabelContraRegistrarse = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPasswordFieldContrasena = new javax.swing.JPasswordField();
        jPasswordFieldConfiContrasena = new javax.swing.JPasswordField();
        jLabelCUIL = new javax.swing.JLabel();
        jTextFieldCUIL = new javax.swing.JTextField();
        jLabelNombreUsuario = new javax.swing.JLabel();
        jTextFieldUsuario = new javax.swing.JTextField();
        jLabelTipoDeEmpresa = new javax.swing.JLabel();
        jComboBoxTipo = new javax.swing.JComboBox<>();
        jLabelNombreyApellido = new javax.swing.JLabel();
        jTextFieldNombreEmpresa = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jButtonConfirmar = new javax.swing.JButton();
        jButtonCancelarRegistro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(420, 470));
        setResizable(false);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("Modificar mis datos"), this, org.jdesktop.beansbinding.BeanProperty.create("title"));
        bindingGroup.addBinding(binding);

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 625, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 399, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));

        jLabelDireccionEmpresa.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); // NOI18N
        jLabelDireccionEmpresa.setText("Dirección");

        jLabelCorreoRegsitro.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); // NOI18N
        jLabelCorreoRegsitro.setText("Nueva Contraseña ");

        jLabelContraRegistrarse.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); // NOI18N
        jLabelContraRegistrarse.setText("Confirmar Contraseña");

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); // NOI18N
        jLabel1.setText("Email");

        jLabelCUIL.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); // NOI18N
        jLabelCUIL.setText("C.U.I.L.");

        jLabelNombreUsuario.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); // NOI18N
        jLabelNombreUsuario.setText("Usuario");

        jLabelTipoDeEmpresa.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); // NOI18N
        jLabelTipoDeEmpresa.setText("Tipo de Empresa");

        jComboBoxTipo.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); // NOI18N
        jComboBoxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Floreria", "Vivero" }));

        jLabelNombreyApellido.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); // NOI18N
        jLabelNombreyApellido.setText("Nombre de la Empresa");

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
                .addGap(20, 20, 20)
                .addComponent(jButtonConfirmar)
                .addGap(40, 40, 40)
                .addComponent(jButtonCancelarRegistro)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonConfirmar)
                    .addComponent(jButtonCancelarRegistro))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDireccionEmpresa)
                    .addComponent(jLabelCUIL)
                    .addComponent(jLabelTipoDeEmpresa)
                    .addComponent(jLabelNombreUsuario)
                    .addComponent(jLabelNombreyApellido)
                    .addComponent(jLabelCorreoRegsitro, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabelContraRegistrarse))))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                            .addComponent(jPasswordFieldConfiContrasena)
                            .addComponent(jPasswordFieldContrasena)
                            .addComponent(jTextFieldUsuario))
                        .addGap(0, 143, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldNombreEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldCUIL, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFiedDireccionEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombreyApellido)
                    .addComponent(jTextFieldNombreEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordFieldContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCorreoRegsitro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordFieldConfiContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelContraRegistrarse))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(119, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarRegistroActionPerformed
        
        int reply = JOptionPane.showConfirmDialog(null,"Esta seguro que desea salir? Perdera todas las modificaciones","Atencion",JOptionPane.YES_NO_OPTION);
        if(reply == JOptionPane.YES_OPTION){
            padre.setEnabled(true);
            this.dispose();  
        }
    }//GEN-LAST:event_jButtonCancelarRegistroActionPerformed

    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed
        String nombre = "";
        boolean estaBien = true;
        String contrasenia = new String(jPasswordFieldContrasena.getPassword());
        String conficontra = new String(jPasswordFieldConfiContrasena.getPassword());
        long cuitFinal = 0;
        String cuit = "";
        String email = "";
        
        
        if(jTextFieldNombreEmpresa.getText().equals("")||jTextFieldEmail.getText().equals("")||jTextFieldCUIL.getText().equals("")||jTextFieldUsuario.getText().equals("")||jTextFiedDireccionEmpresa.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Algunos campos no se han completado. Intente nuevamente.","Advertencia",JOptionPane.WARNING_MESSAGE);
            estaBien = false;
        }
        
        
        if(estaBien){
            nombre = jTextFieldNombreEmpresa.getText();
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

        
        if(estaBien && !jTextFieldCUIL.getText().equals(String.valueOf(cliente.getCuil()))){
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
                if(c.getUsuario().equals(jTextFieldUsuario.getText()) && !cliente.getUsuario().equals(jTextFieldUsuario.getText())){
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
            email = jTextFieldEmail.getText();
            String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(email);
            if (!matcher.matches()){
                JOptionPane.showMessageDialog(null,"Email incorrecto. Intente nuevamente","Advertencia",JOptionPane.WARNING_MESSAGE);
                estaBien = false;  
            }
        }
        
        Boolean tipo = jComboBoxTipo.getSelectedItem().equals("Vivero");
        if(estaBien){
            if(email.equals(cliente.getEmail()) && contrasenia.equals(cliente.getContrasenia()) && jTextFieldUsuario.getText().equals(cliente.getUsuario())  && nombre.equals(cliente.getNombre()) && jTextFiedDireccionEmpresa.getText().equals(cliente.getDireccion()) && cuitFinal == cliente.getCuil() && tipo.equals(cliente.getTipo())){
                JOptionPane.showMessageDialog(null,"No modifico ningun dato. Intente nuevamente","Advertencia",JOptionPane.WARNING_MESSAGE);
                estaBien=false;
            }
        }
        if(estaBien){
            //Si esta bien actualizo los datos del cliente
            cliente.setNombre(nombre);
            cliente.setCuil(cuitFinal);
            cliente.setDireccion(jTextFiedDireccionEmpresa.getText());
            cliente.setEmail(email);
            cliente.setTipo(tipo);
            cliente.setUsuario(jTextFieldUsuario.getText());
            cliente.setContrasenia(contrasenia);
            JOptionPane.showMessageDialog(null,"Datos actualizados correctamente","Información",JOptionPane.INFORMATION_MESSAGE);
            padre.setVisible(false);
            padre.setVisible(true);
            padre.setEnabled(true);
            this.dispose();
        }
    }//GEN-LAST:event_jButtonConfirmarActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        jTextFiedDireccionEmpresa.setText(cliente.getDireccion());
        jTextFieldCUIL.setText(String.valueOf(cliente.getCuil()));
        jTextFieldEmail.setText(cliente.getEmail());
        jTextFieldNombreEmpresa.setText(cliente.getNombre());
        jTextFieldUsuario.setText(cliente.getUsuario());
        jPasswordFieldContrasena.setText(cliente.getContrasenia());
        jPasswordFieldConfiContrasena.setText(cliente.getContrasenia());
        if(cliente.getTipo())
            jComboBoxTipo.setSelectedIndex(1);
        else
            jComboBoxTipo.setSelectedIndex(0);
        
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
            java.util.logging.Logger.getLogger(ModificarMisDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarMisDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarMisDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarMisDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarMisDatos().setVisible(true);
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordFieldConfiContrasena;
    private javax.swing.JPasswordField jPasswordFieldContrasena;
    private javax.swing.JTextField jTextFiedDireccionEmpresa;
    private javax.swing.JTextField jTextFieldCUIL;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldNombreEmpresa;
    private javax.swing.JTextField jTextFieldUsuario;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
