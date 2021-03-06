package interfazgrafica.VentanasCliente;

import interfazgrafica.ClasesBase.Pedido;
import interfazgrafica.ClasesBase.Cliente;
import interfazgrafica.ClasesBase.Usuario;
import interfazgrafica.ClasesBase.Planta;
import interfazgrafica.VentanasEnComun.CarritoDeLaCompra;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GenerarPedido extends javax.swing.JFrame {
    /**
     * model de la tabla jTableCaracteristicas
     */  
    private DefaultTableModel model;
    /**
     * Set de Planta, contiene todas las plantas del programa
     */
      private Set<Planta> setPlantas;
      /**
       * Set de Pedido, contiene todos los pedidos del programa
       */
      private Set<Pedido> setPedidos;
      /**
       * Double, total de la compra
       */
      private double total;
      /**
       * jFrame de CarritoDeLaCompra
       */
      private CarritoDeLaCompra carro;
      /**
       * Mapa que se usa como carro de la compra<br> Integer codigo de la planta, Integer cantidad
       */
      private Map<Integer,Integer> mapStockAux;
      /**
       * Boolean, certifica que haya suficiente cantidad en stock para hacer el pedido
       */
      private boolean hay;
      /**
       * Cliente, cliente con el que se logueo
       */
      private Cliente cliente;
      /**
       * jFrame padre
       */
      private MenuClientes padre;
      
      /**
       * Creates new form GenerarPedido
       */
    public GenerarPedido() {
        initComponents();
    }
    /**
     * Constructor de la clase, inicializa los sets y define la operación a realizarse cuando se oprime la x para cerrar la ventana
     * @param plantas set de Planta, contiene todas las plantas del programa
     * @param pedidos set de Pedido, contiene todas los pedidos del programa
     * @param c Cliente, cliente con el que se logueó
     * @param mc Menu clientes, jFrame padre de esta ventana
     */
    public GenerarPedido(Set<Planta> plantas,Set<Pedido> pedidos,Cliente c,MenuClientes mc) {
        initComponents();
        this.total = 0.0;
        cliente = c;
        padre = mc;
        mapStockAux = new HashMap();
        setPlantas = plantas;
        setPedidos = pedidos;
        hay = true;
        model = (DefaultTableModel) jTableCaracteristicas.getModel();
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        buttonGroupHayStock = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabelPlanta = new javax.swing.JLabel();
        jTextFieldPlanta = new javax.swing.JTextField();
        jLabelCaracteristicas = new javax.swing.JLabel();
        jLabelCantidad = new javax.swing.JLabel();
        jButtonAnadir = new javax.swing.JButton();
        jLabelTotal = new javax.swing.JLabel();
        jLabelPrecioTotal = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableCaracteristicas = new javax.swing.JTable();
        jButtonVerCarrito = new javax.swing.JButton();
        jSpinnerCantidad = new javax.swing.JSpinner();
        jPanel3 = new javax.swing.JPanel();
        jButtonConfirmar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("Generar Pedido"), this, org.jdesktop.beansbinding.BeanProperty.create("title"));
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
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));

        jLabelPlanta.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); // NOI18N
        jLabelPlanta.setText("Ingrese el nombre popular de la planta a buscar:");

        jTextFieldPlanta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldPlantaKeyTyped(evt);
            }
        });

        jLabelCaracteristicas.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); // NOI18N
        jLabelCaracteristicas.setText("Plantas");

        jLabelCantidad.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); // NOI18N
        jLabelCantidad.setText("Cantidad");

        jButtonAnadir.setBackground(new java.awt.Color(255, 255, 255));
        jButtonAnadir.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); // NOI18N
        jButtonAnadir.setText("Añadir al carro");
        jButtonAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnadirActionPerformed(evt);
            }
        });

        jLabelTotal.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); // NOI18N
        jLabelTotal.setText("Total de la compra: $");

        jTableCaracteristicas.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); // NOI18N
        jTableCaracteristicas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Especie", "Tamaño", "Stock", "Precio", "Codigo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCaracteristicas.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTableCaracteristicas);

        jButtonVerCarrito.setBackground(new java.awt.Color(255, 255, 255));
        jButtonVerCarrito.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); // NOI18N
        jButtonVerCarrito.setText("Ver carro de compras");
        jButtonVerCarrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerCarritoActionPerformed(evt);
            }
        });

        jSpinnerCantidad.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); // NOI18N
        jSpinnerCantidad.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));

        jButtonConfirmar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonConfirmar.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); // NOI18N
        jButtonConfirmar.setText("Generar");
        jButtonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarActionPerformed(evt);
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonConfirmar)
                .addGap(53, 53, 53)
                .addComponent(jButtonCancelar)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButtonConfirmar)
                .addComponent(jButtonCancelar))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabelTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelPrecioTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelCaracteristicas)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabelCantidad)
                                    .addGap(18, 18, 18)
                                    .addComponent(jSpinnerCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonAnadir)
                                    .addGap(69, 69, 69)
                                    .addComponent(jButtonVerCarrito))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextFieldPlanta, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPlanta)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabelPlanta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldPlanta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelCaracteristicas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCantidad)
                    .addComponent(jSpinnerCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAnadir)
                    .addComponent(jButtonVerCarrito))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTotal)
                    .addComponent(jLabelPrecioTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents
/*
    private void jButtoncerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtoncerrarSesionActionPerformed
        
    }//GEN-LAST:event_jButtoncerrarSesionActionPerformed
*/
    private void jButtonVerCarritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerCarritoActionPerformed
        if(!mapStockAux.isEmpty()){
           carro = new CarritoDeLaCompra(mapStockAux, setPlantas,this);
           carro.setVisible(true);
           carro.setLocationRelativeTo(this);
           this.setEnabled(false);
        }
        else{
            JOptionPane.showMessageDialog(null, "No hay nada cargado en el carrito","Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonVerCarritoActionPerformed

    private void jTextFieldPlantaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPlantaKeyTyped
        String plantaBuscada;
        model.setRowCount(0);//Borro las filas de la tabla
        plantaBuscada = jTextFieldPlanta.getText();//Leo el nombre de la planta que se esta buscando
        plantaBuscada = plantaBuscada.toUpperCase();//Paso todo a mayusculas para que sea mas facil comparar
        String planteada;
        Iterator i;
        i = setPlantas.iterator();
        while (i.hasNext()){
            Planta plantaI = (Planta) i.next();
            planteada = plantaI.getDenominacionComun();
            planteada = planteada.toUpperCase();//Al nombre de la planta i, lo paso a mayusculas
            if(planteada.contains(plantaBuscada)&&!plantaI.getBaja()){//Si el nombre de la planta i contiene al nombre que se esta buscado lo agrego a la tabla
                model.addRow(new Object[]{plantaI.getDenominacionComun(),plantaI.getEspecie(),plantaI.getTamanio(),plantaI.getStock(),plantaI.getPrecio(),plantaI.getCodigo()});
            }  
        }
    }//GEN-LAST:event_jTextFieldPlantaKeyTyped

    private void jButtonAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnadirActionPerformed
        /*Captura la planta seleccionada y la cantidad de la misma para agregarla 
        al set auxiliar con el cual invocamos a la pantalla carrito.*/
        /*Uso la variable Stock para guardar la cantidad de plantas que el cliente compra*/
        //int cantidadVieja=0;
        int cantidad =(int)(jSpinnerCantidad.getValue());
        int codigo;
        hay=true;
        try{
            String cod = String.valueOf(model.getValueAt(jTableCaracteristicas.getSelectedRow(),5));
            codigo = Integer.parseInt(cod);
            if(mapStockAux.isEmpty()){
                Iterator j;
                j=setPlantas.iterator();
                while(j.hasNext()){
                    Planta p= (Planta) j.next();
                    if (p.getCodigo() == codigo){
                        if (p.getStock() >= cantidad){
                            mapStockAux.put(codigo, cantidad);
                            jButtonVerCarrito.setEnabled(true);
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"No hay suficientes plantas de ese tipo","Advertencia", JOptionPane.WARNING_MESSAGE);
                            hay=false;
                            break;
                        }
                    }
                }
            }
            else{
                Iterator j;
                j=setPlantas.iterator();
                while(j.hasNext()){
                    Planta p1= (Planta) j.next();
                    if(p1.getCodigo()==codigo){
                        int cantidadEnStockAux;
                        if((mapStockAux.get(codigo)) != null){
                            cantidadEnStockAux=mapStockAux.get(codigo); 
                        }
                        else{
                            cantidadEnStockAux=0;
                        }
                        if((p1.getStock()- cantidadEnStockAux)>=cantidad){
                            mapStockAux.put(codigo,(cantidadEnStockAux+cantidad));
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"No hay suficientes plantas de ese tipo","Advertencia", JOptionPane.WARNING_MESSAGE);
                            hay = false;
                            break; 
                        }
                    }
                }
            }
            Set claves = mapStockAux.keySet();
            Iterator i;
            i = claves.iterator();
            while(i.hasNext()){
                int clave = (Integer) i.next();
                if(codigo == clave){
                    double unitario = (double) model.getValueAt(jTableCaracteristicas.getSelectedRow(), 4);
                    int cantI = (int) jSpinnerCantidad.getValue();
                    double cantD = (double) cantI;
                    if(hay)
                        total = total + (unitario * cantD);
                    hay = true;
                    String totalS = String.valueOf(total);
                    jLabelPrecioTotal.setText(totalS);
                }
            }
        }
        catch(ArrayIndexOutOfBoundsException npe){
            JOptionPane.showMessageDialog(null, "No hay nada seleccionado","Advertencia", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_jButtonAnadirActionPerformed

    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed
        Set claves = mapStockAux.keySet();
        Map<Planta,Integer> mapPedido = new HashMap();
        if(!mapStockAux.isEmpty()){
            Iterator i,j;
            Pedido pedido = new Pedido();
            i = setPlantas.iterator();
            while(i.hasNext()){
                Planta plantaI = (Planta) i.next();
                j = claves.iterator();
                while(j.hasNext()){
                    int llave = (int) j.next();
                    if(llave == plantaI.getCodigo()){
                        mapPedido.put(plantaI, mapStockAux.get(llave));
                    }
                }
            }
            pedido.addAllPlanta(mapPedido);
            pedido.setCodigoCliente(cliente.getCodigo());
            setPedidos.add(pedido);
            JOptionPane.showMessageDialog(null, "El pedido se ha generado con exito.","Informacion", JOptionPane.INFORMATION_MESSAGE);
            padre.setEnabled(true);
            this.dispose();
        }
        else{
            JOptionPane.showMessageDialog(null, "El carro está vacio.","Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonConfirmarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        int n = JOptionPane.showConfirmDialog(null,"Desea salir? Perdera los datos cargados","Advertencia",JOptionPane.YES_NO_OPTION);
        if(n==JOptionPane.YES_OPTION){
            padre.setEnabled(true);
            padre.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jButtonCancelarActionPerformed

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
            this.dispose();
            padre.setEnabled(true);
            padre.setVisible(true);
        }
        model.setRowCount(0);
        Iterator i;
        i = setPlantas.iterator();
        while (i.hasNext()){
            Planta plantaI = (Planta) i.next();
            if(!plantaI.getBaja())
                model.addRow(new Object[]{plantaI.getDenominacionComun(),plantaI.getEspecie(),plantaI.getTamanio(),plantaI.getStock(),plantaI.getPrecio(),plantaI.getCodigo()});
        }
        total = 0.0;
        Set claves = mapStockAux.keySet();
        Iterator j,k;
        k = claves.iterator();
        while(k.hasNext()){
            int clave = (Integer) k.next();
            j= setPlantas.iterator();
            while(j.hasNext()){
                Planta plantaI = (Planta) j.next();
                if(clave == plantaI.getCodigo()){
                    total = total + (mapStockAux.get(clave)*plantaI.getPrecio());
                }
            }
        }
        String totalS = String.valueOf(total);
        jLabelPrecioTotal.setText(totalS);
    }//GEN-LAST:event_formComponentShown

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged
        
    }//GEN-LAST:event_formWindowStateChanged

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
            java.util.logging.Logger.getLogger(GenerarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GenerarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GenerarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GenerarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GenerarPedido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupHayStock;
    private javax.swing.JButton jButtonAnadir;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JButton jButtonVerCarrito;
    private javax.swing.JLabel jLabelCantidad;
    private javax.swing.JLabel jLabelCaracteristicas;
    private javax.swing.JLabel jLabelPlanta;
    private javax.swing.JLabel jLabelPrecioTotal;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinnerCantidad;
    private javax.swing.JTable jTableCaracteristicas;
    private javax.swing.JTextField jTextFieldPlanta;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
