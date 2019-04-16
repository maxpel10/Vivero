package interfazgrafica.VentanasCliente;

import interfazgrafica.VentanasEnComun.Login;
import interfazgrafica.ClasesBase.Cliente;
import interfazgrafica.ClasesBase.Pedido;
import interfazgrafica.ClasesBase.Planta;
import interfazgrafica.ClasesBase.Usuario;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.swing.JOptionPane;

public class MenuClientes extends javax.swing.JFrame {
    /**
     * jFrame de GenerarPedido
     */
    private GenerarPedido gp;
    /**
     * jFrame de ConsultarMisPedidos
     */
    private ConsultarMisPedidos cmp;
    /**
     * jFrame de ModificarMisDatos
     */
    private ModificarMisDatos mmd;
    /**
     * Cliente, cliente con el que se logueó
     */
    private Cliente cliente;
    /**
     * Set de Pedido, contiene a todos los pedidos del programa
     */
    private Set<Pedido> setPedidos;
    /**
     * Set de Planta, contiene a todas las plantas del programa
     */
    private Set<Planta> setPlantas;
    /**
     * Set de Cliente, contiene a todos los cimentes del programa
     */
    private Set<Cliente> setClientes;
    /**
     * Set de Usuarios, contiene a todos los usuarios del programa
     */
    private Set<Usuario> setUsuarios;
    /**
     * Creates new form MenuClientes
     */
    public MenuClientes() {
        initComponents();
        gp = new GenerarPedido();
    }

    /**
     * Constructor de la clase, inicializa los sets, el usuario y setea los botones<br> Define la operación a realizarse cuando se oprime la x para cerrar la ventana
     * @param setClientes set con todos los clientes del programa
     * @param c cliente con el que se logueó
     * @param setUsuarios set con los usuarios del programa
     */
    public MenuClientes(Set<Cliente> setClientes,Cliente c,Set<Usuario> setUsuarios) {
        initComponents();
        setPedidos = new HashSet();
        setPlantas = new HashSet();
        this.setClientes = setClientes;
        this.setUsuarios = setUsuarios;
        try{
            this.inPlantas();
        }
        catch(IOException ioe){
            JOptionPane.showMessageDialog(null,"No se pudo abrir el archivo \"Plantas\". Contacte a los desarolladores" ,"ERROR" , JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null,"El programa se cerrará de forma segura","Information",JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        try{
            this.inPedidos();
        }
        catch(IOException ioe){
            JOptionPane.showMessageDialog(null,"No se pudo abrir el archivo \"Pedidos\". Contacte a los desarolladores" ,"ERROR" , JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null,"El programa se cerrará de forma segura","Information",JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        cliente = c;
        jLabelCliente.setText("Usuario: " + cliente.getNombre());
        this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                int reply = JOptionPane.showConfirmDialog(null,"Esta seguro que desea salir del programa?","Atencion",JOptionPane.YES_NO_OPTION);
                if(reply == JOptionPane.YES_OPTION){
                    try {
                        outClientes();
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null,"No se pudo escribir el archivo Clientes.txt. Contacte a sus desarrolladores","Error",JOptionPane.ERROR_MESSAGE);
                        JOptionPane.showMessageDialog(null,"El programa se cerrara de forma segura","Info",JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                    }
                    try {
                        outPedidos();
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null,"No se pudo escribir el archivo Pedidos.txt. Contacte a sus desarrolladores","Error",JOptionPane.ERROR_MESSAGE);
                        JOptionPane.showMessageDialog(null,"El programa se cerrara de forma segura","Info",JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                    }
                    dispose();
                    System.exit(0);
                }  
            }
            
        });
        jButtonCerrarSesion.setToolTipText("Cierra su sesion en el sistema");
        jButtonGenerarNuevoPedido.setToolTipText("Permite crear un nuevo pedido de plantas");
        jButtonModificarDatos.setToolTipText("Permite modificar los datos con los que esta registrado en el sistema");
        jButtonRevisarPedidos.setToolTipText("Permite ver el estado de los pedidos generados");
        
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    //@SuppressWarnings("unchecked");
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelFondo = new javax.swing.JPanel();
        jPanelMenu = new javax.swing.JPanel();
        jPanelPantallas = new javax.swing.JPanel();
        jButtonGenerarNuevoPedido = new javax.swing.JButton();
        jButtonRevisarPedidos = new javax.swing.JButton();
        jButtonModificarDatos = new javax.swing.JButton();
        jButtonCerrarSesion = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanelGestionDeCuenta = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabelCliente = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Menu Cliente");
        setBackground(new java.awt.Color(204, 255, 204));
        setMinimumSize(new java.awt.Dimension(600, 400));
        setPreferredSize(new java.awt.Dimension(600, 400));
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanelFondo.setBackground(new java.awt.Color(204, 255, 204));

        javax.swing.GroupLayout jPanelMenuLayout = new javax.swing.GroupLayout(jPanelMenu);
        jPanelMenu.setLayout(jPanelMenuLayout);
        jPanelMenuLayout.setHorizontalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelMenuLayout.setVerticalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanelPantallas.setBackground(new java.awt.Color(204, 255, 204));

        jButtonGenerarNuevoPedido.setBackground(new java.awt.Color(255, 255, 255));
        jButtonGenerarNuevoPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazgrafica/Iconos/Generar Pedido.png"))); // NOI18N
        jButtonGenerarNuevoPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGenerarNuevoPedidoActionPerformed(evt);
            }
        });

        jButtonRevisarPedidos.setBackground(new java.awt.Color(255, 255, 255));
        jButtonRevisarPedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazgrafica/Iconos/Revisar Pedidos.png"))); // NOI18N
        jButtonRevisarPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRevisarPedidosActionPerformed(evt);
            }
        });

        jButtonModificarDatos.setBackground(new java.awt.Color(255, 255, 255));
        jButtonModificarDatos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazgrafica/Iconos/Modificar mis datos.png"))); // NOI18N
        jButtonModificarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarDatosActionPerformed(evt);
            }
        });

        jButtonCerrarSesion.setBackground(new java.awt.Color(255, 255, 255));
        jButtonCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazgrafica/Iconos/Cerrar sesion.png"))); // NOI18N
        jButtonCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarSesionActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 14)); // NOI18N
        jLabel3.setText("Generar Pedido");

        jLabel4.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 14)); // NOI18N
        jLabel4.setText("Revisar mis pedidos");

        jLabel5.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 14)); // NOI18N
        jLabel5.setText("Modificar mis datos");

        jLabel6.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 14)); // NOI18N
        jLabel6.setText("Salir");

        javax.swing.GroupLayout jPanelPantallasLayout = new javax.swing.GroupLayout(jPanelPantallas);
        jPanelPantallas.setLayout(jPanelPantallasLayout);
        jPanelPantallasLayout.setHorizontalGroup(
            jPanelPantallasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPantallasLayout.createSequentialGroup()
                .addGroup(jPanelPantallasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPantallasLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(47, 47, 47)
                        .addComponent(jLabel6)
                        .addGap(0, 37, Short.MAX_VALUE))
                    .addGroup(jPanelPantallasLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jButtonGenerarNuevoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonRevisarPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(jButtonModificarDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(jButtonCerrarSesion)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanelPantallasLayout.setVerticalGroup(
            jPanelPantallasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPantallasLayout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(jPanelPantallasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPantallasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButtonRevisarPedidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonGenerarNuevoPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButtonModificarDatos)
                    .addComponent(jButtonCerrarSesion))
                .addGap(9, 9, 9)
                .addGroup(jPanelPantallasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addContainerGap(187, Short.MAX_VALUE))
        );

        jPanelGestionDeCuenta.setBackground(new java.awt.Color(204, 255, 204));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazgrafica/Iconos/Vivero.png"))); // NOI18N

        jLabelCliente.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 12)); // NOI18N
        jLabelCliente.setForeground(new java.awt.Color(0, 102, 102));

        javax.swing.GroupLayout jPanelGestionDeCuentaLayout = new javax.swing.GroupLayout(jPanelGestionDeCuenta);
        jPanelGestionDeCuenta.setLayout(jPanelGestionDeCuentaLayout);
        jPanelGestionDeCuentaLayout.setHorizontalGroup(
            jPanelGestionDeCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGestionDeCuentaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
            .addGroup(jPanelGestionDeCuentaLayout.createSequentialGroup()
                .addGap(206, 206, 206)
                .addComponent(jLabel2)
                .addContainerGap(343, Short.MAX_VALUE))
        );
        jPanelGestionDeCuentaLayout.setVerticalGroup(
            jPanelGestionDeCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGestionDeCuentaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelFondoLayout = new javax.swing.GroupLayout(jPanelFondo);
        jPanelFondo.setLayout(jPanelFondoLayout);
        jPanelFondoLayout.setHorizontalGroup(
            jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelPantallas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelGestionDeCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelFondoLayout.setVerticalGroup(
            jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFondoLayout.createSequentialGroup()
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelGestionDeCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelPantallas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGenerarNuevoPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenerarNuevoPedidoActionPerformed
        gp = new GenerarPedido(setPlantas,setPedidos,cliente,this);
        gp.setLocationRelativeTo(this);
        gp.setVisible(true);
        this.setEnabled(false);
    }//GEN-LAST:event_jButtonGenerarNuevoPedidoActionPerformed

    private void jButtonRevisarPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRevisarPedidosActionPerformed
        cmp = new ConsultarMisPedidos(setPedidos, cliente,this);
        cmp.setLocationRelativeTo(this);
        cmp.setVisible(true);
        this.setEnabled(false);
    }//GEN-LAST:event_jButtonRevisarPedidosActionPerformed

    private void jButtonModificarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarDatosActionPerformed
        mmd = new ModificarMisDatos(setClientes, cliente,this,setUsuarios);
        mmd.setLocationRelativeTo(this);
        mmd.setVisible(true);
        this.setEnabled(false);
    }//GEN-LAST:event_jButtonModificarDatosActionPerformed

    /**
     * Método que sobreescribe el archivo Clientes.txt con las plantas almacenadas en setPlantas
     * @throws IOException cuando una operacion de lectura es interrumpida o falla
     */
    public void outClientes() throws IOException{
        File f = new File("Clientes.txt");
        FileWriter escribo = new FileWriter(f);
        BufferedWriter escribir = new BufferedWriter(escribo);
        Iterator i = this.setClientes.iterator();
        while(i.hasNext()){
            Cliente c = (Cliente)i.next();
            escribir.write(c.toString());
            escribir.newLine();
        }
        escribir.close();
    }
     
    /**
     * Método que sobreescribe el archivo Pedidos.txt con las plantas almacenadas en setPlantas
     * @throws IOException cuando una operacion de lectura es interrumpida o falla
     */
        public void outPedidos() throws IOException{
        File f = new File("Pedidos.txt");
        FileWriter escribo = new FileWriter(f);
        BufferedWriter escribir = new BufferedWriter(escribo);
        Iterator i = setPedidos.iterator();
        while(i.hasNext()){
            Pedido p = (Pedido) i.next();
            escribir.write(p.toString());
            escribir.newLine();
        }
        escribir.close();
    }
    
    private void jButtonCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarSesionActionPerformed
        int reply = JOptionPane.showConfirmDialog(null,"Esta seguro que desea cerrar sesion?","Atencion",JOptionPane.YES_NO_OPTION);
        if(reply == JOptionPane.YES_OPTION){
            try {
                this.outClientes();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null,"No se pudo escribir el archivo Plantas.txt. Contacte a sus desarrolladores","Error",JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(null,"El programa se cerrara de forma segura","Info",JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
            try {
                this.outPedidos();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null,"No se pudo escribir el archivo Pedidos.txt. Contacte a sus desarrolladores","Error",JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(null,"El programa se cerrara de forma segura","Info",JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
            this.dispose();
            Login l = new Login();
            l.setVisible(true);
        }
    }//GEN-LAST:event_jButtonCerrarSesionActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        jLabelCliente.setText("Usuario: " + cliente.getNombre());
    }//GEN-LAST:event_formComponentShown

    /**
     * Método que carga setPlantas con los pedidos almacenados en el archivo Plantas.txt
     * @throws IOException cuando una operacion de lectura es interrumpida o falla
     */
    
        public void inPlantas() throws FileNotFoundException, IOException{
       File f = new File("Plantas.txt");
       FileReader leo = new FileReader(f);
       BufferedReader leer = new BufferedReader(leo);
       String auxParse;
       while((auxParse = leer.readLine()) != null){
            Planta planta = new Planta();
            planta.setCodigo(Integer.parseInt(auxParse.substring(8)));
            planta.setDenominacionComun(leer.readLine().substring(20));
            planta.setEspecie(leer.readLine().substring(9));
            auxParse = leer.readLine();
            planta.setTamanio(Double.parseDouble(auxParse.substring(8)));
            auxParse=leer.readLine();
            planta.setPrecio(Double.parseDouble(auxParse.substring(8)));
            auxParse = leer.readLine();
            planta.setStock(Integer.parseInt(auxParse.substring(7)));
            auxParse = leer.readLine();
            planta.setBaja(Boolean.parseBoolean(auxParse.substring(6)));
            leer.readLine();
            setPlantas.add(planta);
        }
        leer.close();
    }
    
    /**
     * Método que carga setPedidos con los pedidos almacenados en el archivo Pedidos.txt
     * @throws IOException cuando una operacion de lectura es interrumpida o falla
     */
    public void inPedidos() throws IOException{
        File f = new File("Pedidos.txt");
        FileReader leo = new FileReader(f);
        BufferedReader leer = new BufferedReader(leo);
        String auxParse;
        while((auxParse = leer.readLine()) != null){
            Pedido pedido = new Pedido();
            pedido.setCodigo(Integer.parseInt(auxParse.substring(19)));
            auxParse = leer.readLine();
            pedido.setCodigoCliente(Integer.parseInt(auxParse.substring(20)));
            auxParse = leer.readLine();
            pedido.setEstado(Boolean.parseBoolean(auxParse.substring(19)));
            auxParse = leer.readLine();
            pedido.setRetirado(Boolean.parseBoolean(auxParse.substring(10)));
            leer.readLine();
            while(true){
                auxParse = leer.readLine();
                if(auxParse.equals("-"))
                    break;
                Planta planta = buscarPlantaPorCodigo(Integer.parseInt(auxParse.substring(19)));
                auxParse = leer.readLine();
                int cantidad = Integer.parseInt(auxParse.substring(11));
                pedido.addPlanta(planta,cantidad);
            }
            leer.readLine();
            setPedidos.add(pedido);
        }
        
        leer.readLine();
    }
    
    /**
     * Encuentra y devuelve el nombre de una planta usando el código de la misma
     * @param codigo código de la planta cuyo nombre se desea saber
     * @return El nombre de la planta
     */
    public Planta buscarPlantaPorCodigo(int codigo){
        Iterator i = setPlantas.iterator();
        Planta aux = null;
        while(i.hasNext()){
            aux = (Planta)i.next();
            if(aux.getCodigo() == codigo){
                return aux;
            }
        }
        return aux;
    }
    
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
            java.util.logging.Logger.getLogger(MenuClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCerrarSesion;
    private javax.swing.JButton jButtonGenerarNuevoPedido;
    private javax.swing.JButton jButtonModificarDatos;
    private javax.swing.JButton jButtonRevisarPedidos;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelCliente;
    private javax.swing.JPanel jPanelFondo;
    private javax.swing.JPanel jPanelGestionDeCuenta;
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JPanel jPanelPantallas;
    // End of variables declaration//GEN-END:variables
}
