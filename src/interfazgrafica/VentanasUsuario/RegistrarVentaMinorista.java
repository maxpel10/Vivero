/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazgrafica.VentanasUsuario;
import interfazgrafica.ClasesBase.Planta;
import interfazgrafica.ClasesBase.Usuario;
import interfazgrafica.ClasesBase.Venta;
import interfazgrafica.VentanasEnComun.CarritoDeLaCompra;
import interfazgrafica.VentanasEnComun.ValidarPago;
import java.util.Iterator;
import java.util.Set;
import javax.swing.table.DefaultTableModel;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Práctico de Máquina en Java<br>
 * Pantalla: Registrar Venta Minorista
 * @author Decena, Facundo
 * @author Pellegrino, Maximiliano
 * @author Perez, José
 */

public class RegistrarVentaMinorista extends javax.swing.JFrame {
    /**
     * Modelo para la tabla donde se muestran las plantas disponibles
     */
    private DefaultTableModel model;
    /** 
     * Set con todas las plantas recibidas por parametro
     */
    private Set<Planta> setPlantas;
    /**
     *  Set con todas las ventas recibidas por parametro
     */
    private Set<Venta> setVentas;
    /**
     * Variable que registra la cantidad ingresada en el Jspinner
     */
    private int cantidad;
    /**
     *  Variable que registra el codigo de la planta seleccionada en tabla
     */
    private int codigo;
    /**
     * Variable que registrar el monto total de la venta 
     */
    private double total;
    /**
     * Carro de la compra donde se muestran todas las plantas seleccionadas
     */
    private CarritoDeLaCompra carro;
    /**
     *  Mapa cuya clave es el codigo de una planta en el carro y el valor es la cantidad deseada de esa planta
     */
    private Map<Integer,Integer> mapPlantasYCantidades;
    /**
     * Variable para aumentar la puntuacion del usuario que realiza la venta
     */
    private Usuario usuario;
    /**
     * Variable booleana que registrar si hay o no stock de una planta seleccionada en la tabla
     */
    private boolean hay;
    /**
     * jFrame Padre
     */
    private MenuPrincipal padre;
    
   public RegistrarVentaMinorista() {
       initComponents();
    }
   /** RegistrarVentaMinorista permite vender plantas a un cliente minorista.
    * Actualiza el stock de las plantas luego de una venta
    * Aumenta el puntaje del usuario que la utilize (si se confirma la venta)
    * Permite el pago con efectivo o tarjeta de credito
    * 
    * @param SetDePlantas set de Planta, contiene todas las plantas del programa
    * @param SetVentas set de Venta, contiene todas las ventas del programa
    * @param usuario Usuario, usuario con el que se logueó
    * @param mp Menu Principal, jFrame padre de esta ventana
    */
   public RegistrarVentaMinorista(Set SetDePlantas, Set SetVentas,Usuario usuario,MenuPrincipal mp) {
        initComponents();
        this.total = 0.0;
        this.setVentas= SetVentas;
        padre = mp;
        this.setPlantas= SetDePlantas;
        model = (DefaultTableModel)tabla.getModel();
        this.mapPlantasYCantidades=new HashMap<>();
        this.usuario = usuario;
        hay = true; 
        jButtonVerCarrito.setEnabled(false);
        this.addWindowListener(new WindowAdapter(){
        @Override
        public void windowClosing(WindowEvent e){
            int n = JOptionPane.showConfirmDialog(null,"Desea salir? Perdera los datos cargados","Advertencia",JOptionPane.YES_NO_OPTION);
            if(n==JOptionPane.YES_OPTION){
                padre.setEnabled(true);
                padre.setVisible(true);
                dispose();
            }
        }
        });
   }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jButtonAnadirAlCarro = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButtonVerCarrito = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldPrecioTotal = new javax.swing.JTextField();
        jButtonConfirmarVenta = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jRadioButtonEfectivo = new javax.swing.JRadioButton();
        jRadioButtonCredito = new javax.swing.JRadioButton();
        jSpinner = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldBuscar1 = new javax.swing.JTextField();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 204));
        setPreferredSize(new java.awt.Dimension(805, 425));
        setResizable(false);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("Registrar Venta Minorista"), this, org.jdesktop.beansbinding.BeanProperty.create("title"));
        bindingGroup.addBinding(binding);

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jButtonAnadirAlCarro.setBackground(new java.awt.Color(255, 255, 255));
        jButtonAnadirAlCarro.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 12)); // NOI18N
        jButtonAnadirAlCarro.setText("Añadir al carro");
        jButtonAnadirAlCarro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnadirAlCarroActionPerformed(evt);
            }
        });

        tabla.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 12)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre popular", "Especie", "Tamaño(m)", "Stock", "Código", "Precio unitario"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabla);

        jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 12)); // NOI18N
        jLabel2.setText("Cantidad");

        jButtonVerCarrito.setBackground(new java.awt.Color(255, 255, 255));
        jButtonVerCarrito.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 12)); // NOI18N
        jButtonVerCarrito.setText("Ver Carrito de la compra");
        jButtonVerCarrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerCarritoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 12)); // NOI18N
        jLabel3.setText("Total de la compra   $");

        jTextFieldPrecioTotal.setEditable(false);
        jTextFieldPrecioTotal.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 12)); // NOI18N

        jButtonConfirmarVenta.setBackground(new java.awt.Color(255, 255, 255));
        jButtonConfirmarVenta.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 12)); // NOI18N
        jButtonConfirmarVenta.setText("Confirmar venta");
        jButtonConfirmarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarVentaActionPerformed(evt);
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

        jLabel4.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 12)); // NOI18N
        jLabel4.setText("Seleccionar método de pago");

        jRadioButtonEfectivo.setBackground(new java.awt.Color(204, 255, 204));
        buttonGroup1.add(jRadioButtonEfectivo);
        jRadioButtonEfectivo.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 12)); // NOI18N
        jRadioButtonEfectivo.setSelected(true);
        jRadioButtonEfectivo.setText("Efectivo");

        jRadioButtonCredito.setBackground(new java.awt.Color(204, 255, 204));
        buttonGroup1.add(jRadioButtonCredito);
        jRadioButtonCredito.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 12)); // NOI18N
        jRadioButtonCredito.setText("Tarjeta de credito");

        jSpinner.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 12)); // NOI18N
        jSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        jLabel5.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 12)); // NOI18N
        jLabel5.setText("Ingrese el nombre popular de la planta a buscar:");

        jTextFieldBuscar1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldBuscar1KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButtonConfirmarVenta)
                                .addGap(66, 66, 66)
                                .addComponent(jButtonCancelar)
                                .addGap(50, 50, 50))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldPrecioTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonEfectivo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButtonCredito)
                        .addGap(12, 12, 12))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonAnadirAlCarro)
                        .addGap(87, 87, 87)
                        .addComponent(jButtonVerCarrito)
                        .addGap(24, 24, 24))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 775, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(20, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonVerCarrito, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonAnadirAlCarro)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButtonEfectivo)
                    .addComponent(jRadioButtonCredito)
                    .addComponent(jTextFieldPrecioTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonConfirmarVenta)
                    .addComponent(jButtonCancelar))
                .addGap(51, 51, 51))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    /**
     *  Muestra el carro con los items selecciados.
     * Si el carro esta vacio no permite verlo
     * @param evt 
     */

    private void jButtonVerCarritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerCarritoActionPerformed
        if(!mapPlantasYCantidades.isEmpty()){
           carro = new CarritoDeLaCompra(mapPlantasYCantidades,setPlantas,this);
           carro.setVisible(true);
           carro.setLocationRelativeTo(this);
           this.setEnabled(false);
        }
        else
            JOptionPane.showMessageDialog(null, "No hay nada cargado en el carrito","Advertencia", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_jButtonVerCarritoActionPerformed
   
    /**
     *  Confirma una venta y si el metodo de pago es "Efectivo" actualiza el stock, actualiza las ventas y aumenta el puntaje del usuario.
     *  De lo contrario si el metodo de pago es "Credito" invoca a Validar pago  con las variables (mapPlantasYCantidades,setVentas,setPlantas,usuario,this).
     * @param evt 
     */
    private void jButtonConfirmarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarVentaActionPerformed
        /* Si el cliente paga con credito, se invoca a validar pago, de lo 
        contrario directamente se guarda la venta
        */ 
        if(mapPlantasYCantidades.isEmpty())
               JOptionPane.showMessageDialog(null, "No hay nada cargado en el carrito","Advertencia", JOptionPane.WARNING_MESSAGE);  
        else{
            if(jRadioButtonCredito.isSelected()){
                ValidarPago vp;
                this.setEnabled(false);
                vp = new ValidarPago(mapPlantasYCantidades,setVentas,setPlantas,usuario,this,padre);
                vp.setPantallaAnterior(1);
                vp.setLocationRelativeTo(this);
                vp.setVisible(true); 
                
            }
            else{
                usuario.ventaMinorista();
                setVentas.add(new Venta(mapPlantasYCantidades));
                Iterator ite1 = setPlantas.iterator();
                while(ite1.hasNext()){
                    Planta planta = (Planta)ite1.next();
                    if (mapPlantasYCantidades.containsKey(planta.getCodigo())){
                       int cantidadAnterior = planta.getStock();
                       planta.setStock(cantidadAnterior-(mapPlantasYCantidades.get(planta.getCodigo())));
                    }
                }
                JOptionPane.showMessageDialog(null, "Venta realizada con exito.","Informacion", JOptionPane.INFORMATION_MESSAGE);  
                padre.setEnabled(true);
                padre.setVisible(true);
                this.dispose();
            }
        }
    }//GEN-LAST:event_jButtonConfirmarVentaActionPerformed
    /**
     * Cancela la venta
     * @param evt 
     */
    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        int n = JOptionPane.showConfirmDialog(null,"Desea salir? Perdera los datos cargados","Advertencia",JOptionPane.YES_NO_OPTION);
        if(n==JOptionPane.YES_OPTION){
            padre.setEnabled(true);
            padre.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jButtonCancelarActionPerformed
    /**
     *  Añade la planta que esta seleccioda en la tabla y con la cantidad seteada en Jspinner
     *  Habilita el boton "Ver carrito" si es la primera vez que se cargan elementos
     *  Aumenta el monto a mostrar de la compra
     * @param evt 
     */
    private void jButtonAnadirAlCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnadirAlCarroActionPerformed
        int cantidadVieja = 0;
        cantidad =(Integer)(jSpinner.getValue());
        hay = true;
        try{
          String cod = String.valueOf(model.getValueAt(tabla.getSelectedRow(),4));
          codigo = Integer.parseInt(cod);
          //Primer caso en el que el carro se encuentra vacio
            if(mapPlantasYCantidades.isEmpty()){
                Iterator j;
                j=setPlantas.iterator();
                while(j.hasNext()){
                    Planta p= (Planta) j.next();
                    if (p.getCodigo() == codigo){
                        if (p.getStock() >= cantidad){
                            mapPlantasYCantidades.put(codigo, cantidad);
                            model.setValueAt(p.getStock()-cantidad,tabla.getSelectedRow(), 3);
                            jButtonVerCarrito.setEnabled(true);
                        }
                        else{
                           JOptionPane.showMessageDialog(null, 
                            "No hay suficientes plantas de ese tipo",
                            "Advertencia", JOptionPane.WARNING_MESSAGE);
                            hay= false;
                            break;
                        }  
                    }
                }
            }
        
          else{
                //en este caso el carro de compra ya tiene items seleccionados
                Iterator j;
                j=setPlantas.iterator();
                while(j.hasNext()){
                  Planta p1= (Planta) j.next();
                  if(p1.getCodigo()==codigo){
                    int cantidadEnStockAux;
                    if((mapPlantasYCantidades.get(codigo)) != null)
                       cantidadEnStockAux = mapPlantasYCantidades.get(codigo); 
                    else
                        cantidadEnStockAux=0;
                    if((p1.getStock()- cantidadEnStockAux)>=cantidad){
                         mapPlantasYCantidades.put(codigo,(cantidadEnStockAux+cantidad));
                         model.setValueAt(p1.getStock()-cantidadEnStockAux-cantidad,tabla.getSelectedRow(), 3);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, 
                        "No hay suficientes plantas de ese tipo",
                        "Advertencia", JOptionPane.WARNING_MESSAGE);
                        hay = false;
                        break; 
                    }
                  }
                }
            }
            
          Set claves = mapPlantasYCantidades.keySet();
          Iterator ite1;
          ite1 = claves.iterator();
          while(ite1.hasNext()){
                int clave = (Integer) ite1.next();
                if(codigo == clave){
                    double unitario = (double) model.getValueAt(tabla.getSelectedRow(),5);
                    int cantI = (int) jSpinner.getValue();
                    double cantD = (double) cantI;
                    if(hay)
                        total = total + (unitario * cantD);
                    hay = true;
                    String totalS = String.valueOf(total);
                    jTextFieldPrecioTotal.setText(totalS);
                }
          }
        }
        catch(ArrayIndexOutOfBoundsException npe){
            JOptionPane.showMessageDialog(null, "No hay nada seleccionado",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAnadirAlCarroActionPerformed

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged
        total = 0.0;
        model.setRowCount(0);
        if (this.isEnabled()){
            Iterator i = setPlantas.iterator();// Itera el set de plantas recibido por parametro y lo muestra en jTable
            while(i.hasNext()){
               Planta aux = (Planta)i.next();
                model.addRow(new Object[]{aux.getEspecie(),aux.getDenominacionComun(),aux.getTamanio(),aux.getStock(),aux.getCodigo(),aux.getPrecio()}); 
        }
        jButtonVerCarrito.setEnabled(false);
      }
    }//GEN-LAST:event_formWindowStateChanged

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        model.setRowCount(0);
        jSpinner.setValue(1);
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
        Iterator i = setPlantas.iterator();
        // Itera el set de plantas recibido por parametro y lo muestra en jTable
        total = 0.0;
        Set claves = mapPlantasYCantidades.keySet();
        Iterator j,k;
        k = claves.iterator();
        while(k.hasNext()){
            int clave = (Integer) k.next();
            j= setPlantas.iterator();
            while(j.hasNext()){
                Planta plantaI = (Planta) j.next();
                if(clave == plantaI.getCodigo()){
                    total = total + (mapPlantasYCantidades.get(clave)*plantaI.getPrecio());
                }
            }
        }
        String totalS = String.valueOf(total);
        jTextFieldPrecioTotal.setText(totalS);
        while(i.hasNext()){
           Planta aux = (Planta)i.next();
           if(!aux.getBaja()){
                model.addRow(new Object[]{aux.getDenominacionComun(),aux.getEspecie(),aux.getTamanio(), aux.getStock(),aux.getCodigo(),aux.getPrecio()});
                k = claves.iterator();
                while(k.hasNext()){
                    int clave = (int)k.next();
                    if(clave == aux.getCodigo()){
                        int cantidade = aux.getStock() - mapPlantasYCantidades.get(clave);
                        int fila = model.getRowCount() - 1;
                        model.setValueAt(cantidade,  fila, 3);
                    }
                }
            }
        }
    }//GEN-LAST:event_formComponentShown

    private void jTextFieldBuscar1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscar1KeyTyped
        String plantaBuscada;
        model.setRowCount(0);
        plantaBuscada = jTextFieldBuscar1.getText();
        plantaBuscada = plantaBuscada.toUpperCase();
        String planteada;
        Iterator i = setPlantas.iterator();
        while(i.hasNext()){
            Planta plantaI = (Planta) i.next();
            if(!plantaI.getBaja()){
                planteada = plantaI.getDenominacionComun();
                planteada = planteada.toUpperCase();
                if(planteada.contains(plantaBuscada))
                    model.addRow(new Object[]{plantaI.getDenominacionComun(),plantaI.getEspecie(),plantaI.getTamanio(),plantaI.getStock(),plantaI.getCodigo(),plantaI.getPrecio()});
            }
        }
    }//GEN-LAST:event_jTextFieldBuscar1KeyTyped

    
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
            java.util.logging.Logger.getLogger(RegistrarVentaMinorista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarVentaMinorista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarVentaMinorista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarVentaMinorista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            new RegistrarVentaMinorista().setVisible(true);
            }
        });
}



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonAnadirAlCarro;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonConfirmarVenta;
    private javax.swing.JButton jButtonVerCarrito;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButtonCredito;
    private javax.swing.JRadioButton jRadioButtonEfectivo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextFieldBuscar1;
    private javax.swing.JTextField jTextFieldPrecioTotal;
    private javax.swing.JTable tabla;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
  

 

