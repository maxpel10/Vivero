/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazgrafica.VentanasEnComun;

import interfazgrafica.VentanasUsuario.RegistrarVentaMayorista;
import interfazgrafica.VentanasUsuario.RegistrarVentaMinorista;
import interfazgrafica.ClasesBase.Cliente;
import interfazgrafica.ClasesBase.Pedido;
import interfazgrafica.ClasesBase.Planta;
import interfazgrafica.ClasesBase.Usuario;
import interfazgrafica.ClasesBase.Venta;
import interfazgrafica.VentanasUsuario.MenuPrincipal;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import static java.awt.image.ImageObserver.HEIGHT;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;


public class ValidarPago extends javax.swing.JFrame {
    /**
     *  Variable que indica cual fue la pantalla anterior, 0 para Registrarse, 1 para venta minorista y 2 para venta mayorista
     */
    private int pantallaAnterior;
    /**
     * Variable para sumar puntaje al usuario (Si es cliente o dueño ) que registre una venta 
    */
    private Usuario usuario;
    /**
     *  Cuando se accede a traves de Venta Mayorista, si el pago se valida el pedido pasa a estar como "Retirado"
     */
    private Pedido pedidoSeleccionado;
    /**
     * Variable para almacenar un cliente cuando se accede a traves de Regristrarse
     */
    private Cliente cliente;
    /**
     * JFrame usado para volver a la pantalla Login en caso de que no se valide el pago correctamente.
     */
    private Login login;
    /**
     *  jFrame usado para volver a la pantalla Registrarse en caso de que no se valide el pago correctamente.
     */
    private Registrarse anterior;
    /**
     *  jFrame usado para volver a la pantalla Registrar Venta Mayorista en caso de que no se valide el pago correctamente.
     */
    private RegistrarVentaMayorista rvm;
    /**
     *  jFrame usado para volver a la pantalla Registrar Venta Minorista en caso de que no se valide el pago correctamente.
     */
    private RegistrarVentaMinorista minorista;
    /**
     * Set con todos los clientes registrados.
     */
    private Set<Cliente> setClientes;
    /**
     * Set con todas las plantas registradas.
     */
    private Set <Planta> setPlantas;
    /**
     * Set con todos los pedidos registrados.
     */
    private Set <Pedido> setPedidos;
    /**
     * Set con todas las ventas registradas
     */
    private Set <Venta> setVentas;
   
    
    /**
     * Mapa cuya clave es el codigo de una planta y su valor es la cantidad de plantas requeridas.
     */
    private Map <Integer, Integer> mapVenta;
    /** 
     * Set utilizado en Registrar Venta Mayorista donde se guardan las plantas de un pedido.
     */
    private Set<Planta> plantasDelPedido;
    /**
     * jFrame de menu principal
     */
    private MenuPrincipal mp;
    
    public ValidarPago(){
        initComponents();
    }
    /**
     * Valida el pago de un cliente que se registra por primera vez.
     * @param nuevo
     * @param anterior
     * @param setClientes
     * @param login 
     */
    public ValidarPago(Cliente nuevo,Registrarse anterior,Set<Cliente> setClientes, Login login) {
        initComponents();
        cliente = nuevo;
        this.login = login;
        this.setClientes = setClientes;
        this.anterior = anterior;
        this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                anterior.setVisible(true);
                dispose();            
            }
        });
        
        
    }

    /**
     * Valida el pago de una venta Mayorista
     * @param pedidoSeleccionado
     * @param mapVenta
     * @param plantasDelPedido
     * @param setVentas
     * @param usuario
     * @param rvm 
     * @param mp
     *  Actualiza el stock de las plantas, el registro de las ventas y el puntaje del usuario
     */
    public ValidarPago(Pedido pedidoSeleccionado, Map <Integer,Integer> mapVenta, Set<Planta> plantasDelPedido,Set<Venta> setVentas, Usuario usuario, RegistrarVentaMayorista rvm,MenuPrincipal mp){
        initComponents();
        this.plantasDelPedido = plantasDelPedido;
        this.usuario = usuario;
        this.mapVenta = mapVenta;
        this.setVentas = setVentas;
        this.rvm=rvm;
        this.mp = mp;
        this.pedidoSeleccionado = pedidoSeleccionado;
        this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                rvm.setEnabled(true);
                dispose();            
            }
        });
        
    }
    /**
     * Valida el pago de una venta minorista.
     * @param mapVenta
     * @param setVentas
     * @param setPlantas
     * @param usuario
     * @param minorista 
     * @param mp
     * Actualiza el stock de las plantas, el registro de las ventas y el puntaje del usuario
     */
    public ValidarPago(Map mapVenta,Set <Venta> setVentas ,Set<Planta> setPlantas, Usuario usuario,RegistrarVentaMinorista minorista,MenuPrincipal mp){
        initComponents();
        this.mp = mp;
        this.mapVenta = mapVenta;
        this.setVentas= setVentas;
        this.setPlantas = setPlantas;
        this.usuario = usuario;
        this.minorista = minorista;
        this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                minorista.setVisible(true);
                dispose();            
            }
        });    
    }

    public void setPantallaAnterior(int pantalla){
        pantallaAnterior = pantalla;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        buttonGroupTarjetas = new javax.swing.ButtonGroup();
        buttonGroupBanco = new javax.swing.ButtonGroup();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jRadioButtonVisa = new javax.swing.JRadioButton();
        jRadioButtonMastercard = new javax.swing.JRadioButton();
        jRadioButtonAmerican = new javax.swing.JRadioButton();
        jPanel6 = new javax.swing.JPanel();
        jRadioButtonBBN = new javax.swing.JRadioButton();
        jRadioButtonBHSBC = new javax.swing.JRadioButton();
        jRadioButtonBICBC = new javax.swing.JRadioButton();
        jRadioButtonBS = new javax.swing.JRadioButton();
        jRadioButtonBM = new javax.swing.JRadioButton();
        jRadioButtonBSR = new javax.swing.JRadioButton();
        jPanel7 = new javax.swing.JPanel();
        jLabelNumeroTarjeta = new javax.swing.JLabel();
        jTextFieldNumeroTarjeta = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldNombreTarjeta = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldDocumentoTarjeta = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldCodigoDeSeguridad = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jButtonAceptar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(460, 430));
        setResizable(false);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("Validar Pago"), this, org.jdesktop.beansbinding.BeanProperty.create("title"));
        bindingGroup.addBinding(binding);

        jPanel4.setBackground(new java.awt.Color(204, 255, 204));

        jPanel5.setBackground(new java.awt.Color(204, 255, 204));

        jRadioButtonVisa.setBackground(new java.awt.Color(204, 255, 204));
        buttonGroupTarjetas.add(jRadioButtonVisa);
        jRadioButtonVisa.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 12)); // NOI18N
        jRadioButtonVisa.setSelected(true);
        jRadioButtonVisa.setText("Visa");

        jRadioButtonMastercard.setBackground(new java.awt.Color(204, 255, 204));
        buttonGroupTarjetas.add(jRadioButtonMastercard);
        jRadioButtonMastercard.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 12)); // NOI18N
        jRadioButtonMastercard.setText("Mastercard");

        jRadioButtonAmerican.setBackground(new java.awt.Color(204, 255, 204));
        buttonGroupTarjetas.add(jRadioButtonAmerican);
        jRadioButtonAmerican.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 12)); // NOI18N
        jRadioButtonAmerican.setText("American Express");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButtonVisa)
                    .addComponent(jRadioButtonMastercard)
                    .addComponent(jRadioButtonAmerican))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButtonVisa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonMastercard)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonAmerican)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(204, 255, 204));

        jRadioButtonBBN.setBackground(new java.awt.Color(204, 255, 204));
        buttonGroupBanco.add(jRadioButtonBBN);
        jRadioButtonBBN.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 12)); // NOI18N
        jRadioButtonBBN.setSelected(true);
        jRadioButtonBBN.setText("Banco Nación");

        jRadioButtonBHSBC.setBackground(new java.awt.Color(204, 255, 204));
        buttonGroupBanco.add(jRadioButtonBHSBC);
        jRadioButtonBHSBC.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 12)); // NOI18N
        jRadioButtonBHSBC.setText("HSBC");

        jRadioButtonBICBC.setBackground(new java.awt.Color(204, 255, 204));
        buttonGroupBanco.add(jRadioButtonBICBC);
        jRadioButtonBICBC.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 12)); // NOI18N
        jRadioButtonBICBC.setText("ICBC");

        jRadioButtonBS.setBackground(new java.awt.Color(204, 255, 204));
        buttonGroupBanco.add(jRadioButtonBS);
        jRadioButtonBS.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 12)); // NOI18N
        jRadioButtonBS.setText("Supervielle");

        jRadioButtonBM.setBackground(new java.awt.Color(204, 255, 204));
        buttonGroupBanco.add(jRadioButtonBM);
        jRadioButtonBM.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 12)); // NOI18N
        jRadioButtonBM.setText("Macro");

        jRadioButtonBSR.setBackground(new java.awt.Color(204, 255, 204));
        buttonGroupBanco.add(jRadioButtonBSR);
        jRadioButtonBSR.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 12)); // NOI18N
        jRadioButtonBSR.setText("Santander Rio");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButtonBBN)
                    .addComponent(jRadioButtonBHSBC)
                    .addComponent(jRadioButtonBICBC)
                    .addComponent(jRadioButtonBS)
                    .addComponent(jRadioButtonBM)
                    .addComponent(jRadioButtonBSR))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jRadioButtonBBN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonBHSBC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonBICBC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonBS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonBM)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonBSR))
        );

        jPanel7.setBackground(new java.awt.Color(204, 255, 204));

        jLabelNumeroTarjeta.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 12)); // NOI18N
        jLabelNumeroTarjeta.setText("Número");

        jLabel4.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 12)); // NOI18N
        jLabel4.setText("Nombre y apellido impreso en la tarjeta:");

        jLabel5.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 12)); // NOI18N
        jLabel5.setText("Número de Documento del titular");

        jLabel6.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 12)); // NOI18N
        jLabel6.setText("Código de Seguridad:");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabelNumeroTarjeta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldNumeroTarjeta))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextFieldCodigoDeSeguridad, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextFieldNombreTarjeta)
                            .addComponent(jTextFieldDocumentoTarjeta)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNumeroTarjeta)
                    .addComponent(jTextFieldNumeroTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldNombreTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addGap(1, 1, 1)
                .addComponent(jTextFieldDocumentoTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldCodigoDeSeguridad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));
        jPanel3.setAlignmentY(getAlignmentX());

        jButtonAceptar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonAceptar.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); // NOI18N
        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });

        jButtonCancelar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonCancelar.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addComponent(jButtonAceptar)
                .addGap(41, 41, 41)
                .addComponent(jButtonCancelar)
                .addGap(36, 36, 36))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 22, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAceptar)
                    .addComponent(jButtonCancelar)))
        );

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 12)); // NOI18N
        jLabel1.setText("Ingrese los datos de la tarjeta de debito/credito:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 70, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 127, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:
        switch(pantallaAnterior){
            case 0:{
                anterior.setEnabled(true);
                this.dispose();
                break;
            }
            case 1:{
                minorista.setEnabled(true);
                this.dispose();
                break;
            }
            case 2:{
                rvm.setEnabled(true);
                this.dispose();
                break;
            }
        }
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
        boolean estaBien = true;
        String numeroTarjeta = jTextFieldNumeroTarjeta.getText();
        long numero = 0;
        String  nombreTarjeta = jTextFieldNombreTarjeta.getText();
        String nroDocumento = jTextFieldDocumentoTarjeta.getText();
        int dni = 0;
        String codigoDeSeguridad = jTextFieldCodigoDeSeguridad.getText();
        int codigo = 0;
        
        
        if(numeroTarjeta.equals("")||nombreTarjeta.equals("")||nroDocumento.equals("")||codigoDeSeguridad.equals("")){
            JOptionPane.showMessageDialog(null,"Algunos campos no se han completado. Intente nuevamente.","Advertencia",JOptionPane.WARNING_MESSAGE);
            estaBien = false;
        }
        
        if (estaBien){
            try{
                numero = Long.parseLong(numeroTarjeta);
            }
            catch(NumberFormatException nfe){
                JOptionPane.showMessageDialog(null,"El numero de tarjeta debe contener solo numeros. Intente nuevamente.","Advertencia",JOptionPane.WARNING_MESSAGE);
                estaBien = false;
            }
        }
        
        if(estaBien){
            if(numero>9999999999999999L || numero<1000000000000000L){
                JOptionPane.showMessageDialog(null,"El numero de tarjeta debe tener 16 digitos. Intente nuevamente.","Advertencia",JOptionPane.WARNING_MESSAGE);
                estaBien = false;
            }
        }
        
        if(estaBien){
            String regex = "^[a-zA-Z][a-zA-Z\\s]*$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(nombreTarjeta);
            if (!matcher.matches()){
                JOptionPane.showMessageDialog(null,"El formato del nombre es incorrecto. No puede comenzar con un espacio, contener numeros ni caracteres especiales (incluye tildes). Intente nuevamente","Advertencia",JOptionPane.WARNING_MESSAGE);
                estaBien = false;  
            }
        }
        
        if(estaBien){
            try{
                dni = Integer.parseInt(nroDocumento);
            }
            catch(NumberFormatException nfe){
                JOptionPane.showMessageDialog(null,"El DNI debe contener solo numeros. Intente nuevamente.","Advertencia",JOptionPane.WARNING_MESSAGE);
                estaBien = false;
            }
        }
        
        if(estaBien){
            if(dni>99999999||dni<1000000){
                JOptionPane.showMessageDialog(null,"El DNI ingresado no existe. Intente nuevamente","Advertencia",JOptionPane.WARNING_MESSAGE);
                estaBien=false;
            }
        }
        
        if(estaBien){
            try{
                codigo = Integer.parseInt(codigoDeSeguridad);
            }
            catch(NumberFormatException nfe){
                JOptionPane.showMessageDialog(null,"El codigo de seguridad debe contener solo numeros. Intente nuevamente.","Advertencia",JOptionPane.WARNING_MESSAGE);
                estaBien = false;
            }
        }
        
        if(estaBien){
            if(codigo<1000||codigo>9999){
                JOptionPane.showMessageDialog(null,"El codigo de seguridad debe contener 4 digitos. Intente nuevamente.","Advertencia",JOptionPane.WARNING_MESSAGE);
                estaBien = false;
            }
        }
        
        if(estaBien){
            switch(pantallaAnterior){
            case 0:{
                setClientes.add(cliente);
                JOptionPane.showMessageDialog(null,"Validacion correcta. El registro fue completado con exito.","Info",JOptionPane.INFORMATION_MESSAGE);
                anterior.dispose();
                login.setEnabled(true);
                this.dispose();
                break;
            }
            case 1:{
                usuario.ventaMinorista();//Le sumo el puntaje al usuario que realizo la venta
                setVentas.add(new Venta(mapVenta));//Agrego la venta a las ventas realizadas
                Iterator ite1 = setPlantas.iterator();
                while(ite1.hasNext()){
                    Planta planta = (Planta)ite1.next();
                    if (mapVenta.containsKey(planta.getCodigo())){
                       int cantidadAnterior = planta.getStock();
                       planta.setStock(cantidadAnterior-(mapVenta.get(planta.getCodigo())));
                    }
                }
                JOptionPane.showMessageDialog(null,"Venta realizada con exito.","Información",JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                minorista.dispose();
                mp.setVisible(true);
                mp.setEnabled(true);
                break;
            }
            case 2:{
                pedidoSeleccionado.setRetirado(true);//Registro el pedido como terminado
                usuario.ventaMayorista();//Le sumo el puntaje al usuario que realizo la venta
                setVentas.add(new Venta(mapVenta));//Agrego el pedido a las ventas realizadas
                Iterator i = plantasDelPedido.iterator();
                while(i.hasNext()){
                    Planta planta = (Planta) i.next();
                    int stockViejo= planta.getStock();
                    int plantasVendidas = (mapVenta.get(planta.getCodigo()));
                    if (stockViejo<plantasVendidas)
                        JOptionPane.showMessageDialog(null, "Algunos stocks quedaran negativos debido a que se vendio mas stock del disponible.","Advertencia", JOptionPane.WARNING_MESSAGE);
                    planta.setStock(stockViejo-plantasVendidas);//Decremento el stock
                }
                JOptionPane.showMessageDialog(null,"Venta realizada con exito.","Información",JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                rvm.dispose();
                mp.setVisible(true);
                mp.setEnabled(true);
                break;
            }
         }
        
        }
    }//GEN-LAST:event_jButtonAceptarActionPerformed

    
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
            java.util.logging.Logger.getLogger(ValidarPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ValidarPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ValidarPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ValidarPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ValidarPago().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupBanco;
    private javax.swing.ButtonGroup buttonGroupTarjetas;
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelNumeroTarjeta;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JRadioButton jRadioButtonAmerican;
    private javax.swing.JRadioButton jRadioButtonBBN;
    private javax.swing.JRadioButton jRadioButtonBHSBC;
    private javax.swing.JRadioButton jRadioButtonBICBC;
    private javax.swing.JRadioButton jRadioButtonBM;
    private javax.swing.JRadioButton jRadioButtonBS;
    private javax.swing.JRadioButton jRadioButtonBSR;
    private javax.swing.JRadioButton jRadioButtonMastercard;
    private javax.swing.JRadioButton jRadioButtonVisa;
    private javax.swing.JTextField jTextFieldCodigoDeSeguridad;
    private javax.swing.JTextField jTextFieldDocumentoTarjeta;
    private javax.swing.JTextField jTextFieldNombreTarjeta;
    private javax.swing.JTextField jTextFieldNumeroTarjeta;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
