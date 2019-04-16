package interfazgrafica.VentanasUsuario;

import interfazgrafica.ClasesBase.Pedido;
import interfazgrafica.ClasesBase.Venta;
import interfazgrafica.ClasesBase.Empleado;
import interfazgrafica.ClasesBase.Cliente;
import interfazgrafica.ClasesBase.Usuario;
import interfazgrafica.ClasesBase.Planta;
import interfazgrafica.VentanasEnComun.Login;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import javax.swing.JOptionPane;


public class MenuPrincipal extends javax.swing.JFrame {
    /**
     * Set de Planta, contiene todas las plantas del programa
     */
    private Set<Planta> setPlantas;
    /**
     * Set de Venta, contiene todas las ventas del programa
     */
    private Set<Venta> setVentas;
    /**
     * Set de Pedido, contiene todos los pedidos del programa
     */
    private Set<Pedido> setPedidos;
    /**
     * Set de Cliente, contiene a todos los clientes del programa
     */
    private Set<Cliente> setClientes;
    /**
     * Set de Usuario, contiene a todos los usuarios del programa
     */
    private Set<Usuario> setUsuarios;
    /**
     * Usuario, usuario con el cual se loguearon
     */
    private Usuario usuario;
    /**
     * jFrame de ConsultarStock
     */
    private ConsultarStock cs;
    /**
     * jFrame de ConsultarStock
     */
    private IncrementarStock is;
    /**
     * jFrame de CargarNuevaPlanta
     */
    private CargarNuevaPlanta cnp;
    /**
     * jFrame de RegistrarComoTerminado
     */
    private RegistrarComoTerminado rct;
    /**
     * jFrame de ConsultarPedidos
     */
    private ConsultarPedidos cp;
    /**
     * jFrame de RegistrarVentaMayorista
     */
    private RegistrarVentaMayorista rvM;
    /**
     * jFrame de RegistrarVentaMinorista
     */
    private RegistrarVentaMinorista rvm;
    /**
     * jFrame de ConsultarRanking
     */
    private ConsultarRanking cr;
    /**
     * jFrame de CargarEmpleado
     */
    private CargarEmpleado ce;
    /**
     * jFrame de CargarDueño
     */
    private CargarDueño cd;
    /**
     * jFrame de ModificarPlanta
     */
    private ModificarPlanta mp;
    /**
     * jFrame de ConsultarUsuarios
     */
    private ConsultarUsuarios cu;
    /**
     * jFrame de ModificarUsuario
     */
    private ModificarUsuario mu;
    /**
     * jFrame de ListadoDeClientes
     */
    private ListadoDeClientes lc;
    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
        initComponents();
    }
    /**
     * Constructor de la clase, inicializa los sets, el usuario y setea los botones<br> Define la operación a realizarse cuando se oprime la x para cerrar la ventana
     * @param usuarios set de Usuario, contiene a todos los usuarios del programa
     * @param clientes set de Cliente, contiene a todos los clientes del programa
     * @param u Usuario, usuario con el que se logueó
     */
    public MenuPrincipal(Set<Usuario> usuarios,Set<Cliente> clientes, Usuario u) {
        initComponents();
        setPlantas = new HashSet();
        setVentas = new HashSet();
        setPedidos = new HashSet();
        setClientes = clientes;
        setUsuarios = usuarios;
        usuario = u;
        try{
            this.inPlantas();
        }
        catch(IOException ioe){
            JOptionPane.showMessageDialog(null,"No se pudo abrir el archivo \"Plantas\". Contacte a los desarolladores" ,"ERROR" , JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null,"El programa se cerrará de forma segura","Information",JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        try{
            this.inVentas();
        }
        catch(IOException ioe){
            JOptionPane.showMessageDialog(null,"No se pudo abrir el archivo \"Ventas\". Contacte a los desarolladores" ,"ERROR" , JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null,"El programa se cerrará de forma segura","Information",JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);;
        }
        try{
            this.inPedidos();
        }
        catch(IOException ioe){
            JOptionPane.showMessageDialog(null,"No se pudo abrir el archivo \"Pedidos\". Contacte a los desarolladores" ,"ERROR" , JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null,"El programa se cerrará de forma segura","Information",JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);;
        }
        if(usuario instanceof Empleado){//Si no es un dueño no puede usar las pantallas que tienen /**/ , por lo tanto se le deshabilitan los botones
            jButtonIncrementarStock.setEnabled(false);
            jButtonCargarEmpleado.setEnabled(false);
            jButtonNuevaPlanta.setEnabled(false);
            jButtonConsultarRanking.setEnabled(false);
            jButtonCargarDueno.setEnabled(false);
            jButtonConsultarUsuarios.setEnabled(false);
            jButtonModificarPlanta.setEnabled(false);
            jButtonModificarUsuario.setEnabled(false);
            jButtonListadoDeClientes.setEnabled(false);
            jLabelAdministracion.setEnabled(false);
        }
        
        this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                int reply = JOptionPane.showConfirmDialog(null,"Esta seguro que desea salir del programa?","Atencion",JOptionPane.YES_NO_OPTION);
                if(reply == JOptionPane.YES_OPTION){
                    try {
                        outUsuarios();
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null,"No se pudo escribir el archivo Usuarios.txt. Contacte a sus desarrolladores","Error",JOptionPane.ERROR_MESSAGE);
                        JOptionPane.showMessageDialog(null,"El programa se cerrara de forma segura","Info",JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                    }
                    try{
                        outClientes();
                    }
                    catch(IOException ex){
                        JOptionPane.showMessageDialog(null,"No se pudo escribir el archivo Clientes.txt. Contacte a sus desarrolladores","Error",JOptionPane.ERROR_MESSAGE);
                        JOptionPane.showMessageDialog(null,"El programa se cerrara de forma segura","Info",JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                    }

                    try {
                        outPlantas();
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null,"No se pudo escribir el archivo Plantas.txt. Contacte a sus desarrolladores","Error",JOptionPane.ERROR_MESSAGE);
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
                    try {
                        outVentas();
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null,"No se pudo escribir el archivo Plantas.txt. Contacte a sus desarrolladores","Error",JOptionPane.ERROR_MESSAGE);
                        JOptionPane.showMessageDialog(null,"El programa se cerrara de forma segura","Info",JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                    }
                    dispose();
                    System.exit(0);
                }
            }
        });
        jButtonCargarDueno.setToolTipText("Permite generar un nuevo usuario con permisos de dueño");
        jButtonCargarEmpleado.setToolTipText("Permite generar un nuevo usuario con permisos de empleado");
        jButtonConsultarPedidos.setToolTipText("Permite ver el estado de los pedidos cargados en el sistema");
        jButtonConsultarRanking.setToolTipText("Permite ver las plantas mas vendidas en un rango de fecha");
        jButtonConsultarStock.setToolTipText("Permite ver las plantas cargadas en el sistema");
        jButtonConsultarUsuarios.setToolTipText("Permite ver los usuarios registrados en el sistema y sus datos");
        jButtonIncrementarStock.setToolTipText("Permite incrementar el stock de las plantas registradas en el sistema");
        jButtonListadoDeClientes.setToolTipText("Permite ver los clientes registrados en el sistema y sus datos");
        jButtonLogOut.setToolTipText("Permite cerrar sesion en el sistema");
        jButtonModificarPlanta.setToolTipText("Permite modificar los datos de las plantas cargadas en el sistema");
        jButtonModificarUsuario.setToolTipText("Permite modificar los datos de los usuarios registrados en el sistema");
        jButtonNuevaPlanta.setToolTipText("Permite cargar una nueva planta en el sistema");
        jButtonRegistarVentaMinorista.setToolTipText("Permite cargar en el sistema una venta a un cliente minorista");
        jButtonRegistraVentaMayorista.setToolTipText("Permite cargar en el sistema una venta a un cliente mayorista");
        jButtonRegistrarComoTerminado.setToolTipText("Permite cambiar el estado de un pedidono terminado a terminado");
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
        jPanelPedido = new javax.swing.JPanel();
        jButtonRegistrarComoTerminado = new javax.swing.JButton();
        jButtonConsultarPedidos = new javax.swing.JButton();
        jLabelStock3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButtonRegistraVentaMayorista = new javax.swing.JButton();
        jButtonRegistarVentaMinorista = new javax.swing.JButton();
        jButtonConsultarRanking = new javax.swing.JButton();
        jLabelStock1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabelStock = new javax.swing.JLabel();
        jButtonConsultarStock = new javax.swing.JButton();
        jButtonNuevaPlanta = new javax.swing.JButton();
        jButtonIncrementarStock = new javax.swing.JButton();
        jButtonModificarPlanta = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jButtonCargarEmpleado = new javax.swing.JButton();
        jButtonCargarDueno = new javax.swing.JButton();
        jButtonConsultarUsuarios = new javax.swing.JButton();
        jButtonModificarUsuario = new javax.swing.JButton();
        jButtonListadoDeClientes = new javax.swing.JButton();
        jLabelAdministracion = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelUsuario = new javax.swing.JLabel();
        jButtonLogOut = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(830, 397));
        setMinimumSize(new java.awt.Dimension(830, 397));
        setPreferredSize(new java.awt.Dimension(830, 397));
        setResizable(false);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("Menú Principal"), this, org.jdesktop.beansbinding.BeanProperty.create("title"));
        bindingGroup.addBinding(binding);

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));

        jPanelPedido.setBackground(new java.awt.Color(153, 255, 153));
        jPanelPedido.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButtonRegistrarComoTerminado.setBackground(new java.awt.Color(255, 255, 255));
        jButtonRegistrarComoTerminado.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); // NOI18N
        jButtonRegistrarComoTerminado.setText("Registrar como terminado");
        jButtonRegistrarComoTerminado.setMinimumSize(new java.awt.Dimension(119, 23));
        jButtonRegistrarComoTerminado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarComoTerminadoActionPerformed(evt);
            }
        });

        jButtonConsultarPedidos.setBackground(new java.awt.Color(255, 255, 255));
        jButtonConsultarPedidos.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); // NOI18N
        jButtonConsultarPedidos.setText("Consultar pedidos");
        jButtonConsultarPedidos.setMaximumSize(new java.awt.Dimension(173, 28));
        jButtonConsultarPedidos.setMinimumSize(new java.awt.Dimension(130, 23));
        jButtonConsultarPedidos.setPreferredSize(new java.awt.Dimension(173, 23));
        jButtonConsultarPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultarPedidosActionPerformed(evt);
            }
        });

        jLabelStock3.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 16)); // NOI18N
        jLabelStock3.setForeground(new java.awt.Color(0, 102, 102));
        jLabelStock3.setText("Pedidos");

        javax.swing.GroupLayout jPanelPedidoLayout = new javax.swing.GroupLayout(jPanelPedido);
        jPanelPedido.setLayout(jPanelPedidoLayout);
        jPanelPedidoLayout.setHorizontalGroup(
            jPanelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButtonRegistrarComoTerminado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelPedidoLayout.createSequentialGroup()
                .addComponent(jButtonConsultarPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanelPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelStock3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelPedidoLayout.setVerticalGroup(
            jPanelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPedidoLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabelStock3)
                .addGap(11, 11, 11)
                .addComponent(jButtonConsultarPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonRegistrarComoTerminado, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButtonRegistraVentaMayorista.setBackground(new java.awt.Color(255, 255, 255));
        jButtonRegistraVentaMayorista.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); // NOI18N
        jButtonRegistraVentaMayorista.setText("Registrar venta mayorista");
        jButtonRegistraVentaMayorista.setMaximumSize(new java.awt.Dimension(173, 23));
        jButtonRegistraVentaMayorista.setMinimumSize(new java.awt.Dimension(173, 23));
        jButtonRegistraVentaMayorista.setPreferredSize(new java.awt.Dimension(155, 23));
        jButtonRegistraVentaMayorista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistraVentaMayoristaActionPerformed(evt);
            }
        });

        jButtonRegistarVentaMinorista.setBackground(new java.awt.Color(255, 255, 255));
        jButtonRegistarVentaMinorista.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); // NOI18N
        jButtonRegistarVentaMinorista.setText("Registrar venta minorista");
        jButtonRegistarVentaMinorista.setMinimumSize(new java.awt.Dimension(119, 23));
        jButtonRegistarVentaMinorista.setPreferredSize(new java.awt.Dimension(155, 23));
        jButtonRegistarVentaMinorista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistarVentaMinoristaActionPerformed(evt);
            }
        });

        jButtonConsultarRanking.setBackground(new java.awt.Color(255, 255, 255));
        jButtonConsultarRanking.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); // NOI18N
        jButtonConsultarRanking.setText("Consultar ranking");
        jButtonConsultarRanking.setPreferredSize(new java.awt.Dimension(155, 23));
        jButtonConsultarRanking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultarRankingActionPerformed(evt);
            }
        });

        jLabelStock1.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 16)); // NOI18N
        jLabelStock1.setForeground(new java.awt.Color(0, 102, 102));
        jLabelStock1.setText("Ventas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButtonRegistraVentaMayorista, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelStock1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonConsultarRanking, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonRegistarVentaMinorista, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabelStock1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonRegistraVentaMayorista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonRegistarVentaMinorista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonConsultarRanking, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(153, 255, 153));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelStock.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 16)); // NOI18N
        jLabelStock.setForeground(new java.awt.Color(0, 102, 102));
        jLabelStock.setText("Stock");

        jButtonConsultarStock.setBackground(new java.awt.Color(255, 255, 255));
        jButtonConsultarStock.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); // NOI18N
        jButtonConsultarStock.setText("Consultar stock");
        jButtonConsultarStock.setMaximumSize(new java.awt.Dimension(173, 23));
        jButtonConsultarStock.setMinimumSize(new java.awt.Dimension(173, 23));
        jButtonConsultarStock.setPreferredSize(new java.awt.Dimension(173, 23));
        jButtonConsultarStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultarStockActionPerformed(evt);
            }
        });

        jButtonNuevaPlanta.setBackground(new java.awt.Color(255, 255, 255));
        jButtonNuevaPlanta.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); // NOI18N
        jButtonNuevaPlanta.setText("Cargar nueva planta");
        jButtonNuevaPlanta.setMaximumSize(new java.awt.Dimension(173, 23));
        jButtonNuevaPlanta.setMinimumSize(new java.awt.Dimension(173, 23));
        jButtonNuevaPlanta.setPreferredSize(new java.awt.Dimension(173, 23));
        jButtonNuevaPlanta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNuevaPlantaActionPerformed(evt);
            }
        });

        jButtonIncrementarStock.setBackground(new java.awt.Color(255, 255, 255));
        jButtonIncrementarStock.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); // NOI18N
        jButtonIncrementarStock.setText("Incrementar stock");
        jButtonIncrementarStock.setMaximumSize(new java.awt.Dimension(173, 23));
        jButtonIncrementarStock.setMinimumSize(new java.awt.Dimension(173, 23));
        jButtonIncrementarStock.setPreferredSize(new java.awt.Dimension(173, 23));
        jButtonIncrementarStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncrementarStockActionPerformed(evt);
            }
        });

        jButtonModificarPlanta.setBackground(new java.awt.Color(255, 255, 255));
        jButtonModificarPlanta.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); // NOI18N
        jButtonModificarPlanta.setText("Modificar/Eliminar planta");
        jButtonModificarPlanta.setMaximumSize(new java.awt.Dimension(173, 23));
        jButtonModificarPlanta.setMinimumSize(new java.awt.Dimension(173, 23));
        jButtonModificarPlanta.setPreferredSize(new java.awt.Dimension(173, 23));
        jButtonModificarPlanta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarPlantaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButtonNuevaPlanta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButtonIncrementarStock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButtonModificarPlanta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jButtonConsultarStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelStock, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelStock)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonConsultarStock, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonNuevaPlanta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonIncrementarStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonModificarPlanta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(153, 255, 153));
        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButtonCargarEmpleado.setBackground(new java.awt.Color(255, 255, 255));
        jButtonCargarEmpleado.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); // NOI18N
        jButtonCargarEmpleado.setText("Cargar empleado");
        jButtonCargarEmpleado.setMaximumSize(new java.awt.Dimension(173, 23));
        jButtonCargarEmpleado.setMinimumSize(new java.awt.Dimension(173, 23));
        jButtonCargarEmpleado.setPreferredSize(new java.awt.Dimension(173, 23));
        jButtonCargarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCargarEmpleadoActionPerformed(evt);
            }
        });

        jButtonCargarDueno.setBackground(new java.awt.Color(255, 255, 255));
        jButtonCargarDueno.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); // NOI18N
        jButtonCargarDueno.setText("Cargar dueño");
        jButtonCargarDueno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCargarDuenoActionPerformed(evt);
            }
        });

        jButtonConsultarUsuarios.setBackground(new java.awt.Color(255, 255, 255));
        jButtonConsultarUsuarios.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); // NOI18N
        jButtonConsultarUsuarios.setText("Consultar usuarios");
        jButtonConsultarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultarUsuariosActionPerformed(evt);
            }
        });

        jButtonModificarUsuario.setBackground(new java.awt.Color(255, 255, 255));
        jButtonModificarUsuario.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); // NOI18N
        jButtonModificarUsuario.setText("Modificar/Eliminar usuario");
        jButtonModificarUsuario.setPreferredSize(new java.awt.Dimension(173, 23));
        jButtonModificarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarUsuarioActionPerformed(evt);
            }
        });

        jButtonListadoDeClientes.setBackground(new java.awt.Color(255, 255, 255));
        jButtonListadoDeClientes.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); // NOI18N
        jButtonListadoDeClientes.setText("Listado de clientes");
        jButtonListadoDeClientes.setMaximumSize(new java.awt.Dimension(132, 23));
        jButtonListadoDeClientes.setMinimumSize(new java.awt.Dimension(132, 23));
        jButtonListadoDeClientes.setPreferredSize(new java.awt.Dimension(135, 23));
        jButtonListadoDeClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListadoDeClientesActionPerformed(evt);
            }
        });

        jLabelAdministracion.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 16)); // NOI18N
        jLabelAdministracion.setForeground(new java.awt.Color(0, 102, 102));
        jLabelAdministracion.setText("Administracion");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButtonCargarEmpleado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonCargarDueno, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonConsultarUsuarios, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButtonModificarUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonListadoDeClientes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelAdministracion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabelAdministracion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonCargarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jButtonCargarDueno, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonConsultarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jButtonModificarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonListadoDeClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazgrafica/Iconos/Vivero.png"))); // NOI18N

        jLabelUsuario.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 12)); // NOI18N
        jLabelUsuario.setForeground(new java.awt.Color(0, 102, 102));
        jLabelUsuario.setText("Usuario: Facundo Decena");

        jButtonLogOut.setBackground(new java.awt.Color(255, 255, 255));
        jButtonLogOut.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); // NOI18N
        jButtonLogOut.setText("Cerrar sesión");
        jButtonLogOut.setToolTipText("");
        jButtonLogOut.setPreferredSize(new java.awt.Dimension(155, 23));
        jButtonLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jButtonLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(143, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabelUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabelUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jPanelPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(115, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(81, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCargarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCargarEmpleadoActionPerformed
        ce = new CargarEmpleado(setUsuarios,setClientes,this);
        ce.setLocationRelativeTo(this);
        ce.setVisible(true);
        this.setEnabled(false);
    }//GEN-LAST:event_jButtonCargarEmpleadoActionPerformed

    private void jButtonConsultarRankingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultarRankingActionPerformed
        cr = new ConsultarRanking(setVentas,setPlantas,this);
        cr.setLocationRelativeTo(this);
        cr.setVisible(true);
        this.setEnabled(false);
    }//GEN-LAST:event_jButtonConsultarRankingActionPerformed

    private void jButtonRegistarVentaMinoristaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistarVentaMinoristaActionPerformed
        rvm = new RegistrarVentaMinorista(setPlantas, setVentas,usuario,this);
        rvm.setLocationRelativeTo(this);
        rvm.setVisible(true);
        this.setEnabled(false);
    }//GEN-LAST:event_jButtonRegistarVentaMinoristaActionPerformed

    private void jButtonRegistraVentaMayoristaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistraVentaMayoristaActionPerformed
        rvM = new RegistrarVentaMayorista(setPedidos,setClientes,setVentas,setPlantas,usuario,this);
        rvM.setLocationRelativeTo(this);
        rvM.setVisible(true);
        this.setEnabled(false);
    }//GEN-LAST:event_jButtonRegistraVentaMayoristaActionPerformed

    private void jButtonConsultarPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultarPedidosActionPerformed
        cp = new ConsultarPedidos(setPedidos,setClientes,this);
        cp.setLocationRelativeTo(this);
        cp.setVisible(true);
        this.setEnabled(false);
    }//GEN-LAST:event_jButtonConsultarPedidosActionPerformed

    private void jButtonRegistrarComoTerminadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarComoTerminadoActionPerformed
        rct = new RegistrarComoTerminado(setPedidos, setClientes,this);
        rct.setLocationRelativeTo(this);
        rct.setVisible(true);
        this.setEnabled(false);
    }//GEN-LAST:event_jButtonRegistrarComoTerminadoActionPerformed

    private void jButtonNuevaPlantaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNuevaPlantaActionPerformed
        cnp = new CargarNuevaPlanta(setPlantas,usuario,this);
        cnp.setLocationRelativeTo(this);
        cnp.setVisible(true);
        this.setEnabled(false);
    }//GEN-LAST:event_jButtonNuevaPlantaActionPerformed

    private void jButtonIncrementarStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncrementarStockActionPerformed
        is = new IncrementarStock(setPlantas,this);
        is.setLocationRelativeTo(this);
        is.setVisible(true);
        this.setEnabled(false);
    }//GEN-LAST:event_jButtonIncrementarStockActionPerformed

    private void jButtonConsultarStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultarStockActionPerformed
        cs = new ConsultarStock(setPlantas,this);
        cs.setLocationRelativeTo(this);
        cs.setVisible(true);
        this.setEnabled(false);
    }//GEN-LAST:event_jButtonConsultarStockActionPerformed

    private void jButtonLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogOutActionPerformed
        int reply = JOptionPane.showConfirmDialog(null,"Esta seguro que desea cerrar sesion?","Atencion",JOptionPane.YES_NO_OPTION);
        if(reply == JOptionPane.YES_OPTION){
            try {
                this.outUsuarios();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null,"No se pudo escribir el archivo Usuarios.txt. Contacte a sus desarrolladores","Error",JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(null,"El programa se cerrara de forma segura","Info",JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
            try{
                outClientes();
            }
            catch(IOException ex){
                JOptionPane.showMessageDialog(null,"No se pudo escribir el archivo Clientes.txt. Contacte a sus desarrolladores","Error",JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(null,"El programa se cerrara de forma segura","Info",JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
            
            try {
                this.outPlantas();
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
            try {
                this.outVentas();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null,"No se pudo escribir el archivo Plantas.txt. Contacte a sus desarrolladores","Error",JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(null,"El programa se cerrara de forma segura","Info",JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
            this.dispose();
            Login l = new Login();
            l.setVisible(true);
        }
    }//GEN-LAST:event_jButtonLogOutActionPerformed

    private void jButtonCargarDuenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCargarDuenoActionPerformed
        cd = new CargarDueño(setUsuarios,setClientes,this);
        cd.setLocationRelativeTo(this);
        cd.setVisible(true);
        this.setEnabled(false);
    }//GEN-LAST:event_jButtonCargarDuenoActionPerformed

    private void jButtonListadoDeClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListadoDeClientesActionPerformed
        lc = new ListadoDeClientes(setClientes,setPedidos,this);
        lc.setLocationRelativeTo(this);
        lc.setVisible(true);
        this.setEnabled(false);
    }//GEN-LAST:event_jButtonListadoDeClientesActionPerformed

    private void jButtonModificarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarUsuarioActionPerformed
        mu = new ModificarUsuario(setUsuarios,setClientes,usuario,this);
        mu.setLocationRelativeTo(this);
        mu.setVisible(true);
        this.setEnabled(false);
    }//GEN-LAST:event_jButtonModificarUsuarioActionPerformed

    private void jButtonConsultarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultarUsuariosActionPerformed
        cu = new ConsultarUsuarios(setUsuarios,this);
        cu.setLocationRelativeTo(this);
        cu.setVisible(true);
        this.setEnabled(false);
    }//GEN-LAST:event_jButtonConsultarUsuariosActionPerformed

    private void jButtonModificarPlantaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarPlantaActionPerformed
        mp = new ModificarPlanta(setPlantas,this);
        mp.setLocationRelativeTo(this);
        mp.setVisible(true);
        this.setEnabled(false);
    }//GEN-LAST:event_jButtonModificarPlantaActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        jLabelUsuario.setText("Usuario: " + usuario.getNombre() + " " + usuario.getApellido());
    }//GEN-LAST:event_formComponentShown

    /**
     * Método que carga setVentas con las ventas guardadas en el archivo Ventas.txt
     * @throws FileNotFoundException cuando no encuentra el archivo en la posicion especificada
     * @throws IOException cuando una operacion de lectura es interrumpida o falla
     */
    public void inVentas() throws FileNotFoundException, IOException{
        File f = new File("Ventas.txt");
        FileReader leo = new FileReader(f);
        BufferedReader leer = new BufferedReader(leo);
        String auxParse;
        while((auxParse = leer.readLine()) != null){
            Venta venta = new Venta();
            int dia = Integer.parseInt(auxParse.substring(5));
            int mes = Integer.parseInt(leer.readLine().substring(5));
            int anio = Integer.parseInt(leer.readLine().substring(5));
            venta.setFecha(dia,mes-1,anio);
            leer.readLine();
            while(true){
                Planta planta;
                auxParse = leer.readLine();
                if(auxParse.equals("-"))
                    break;
                int codigo = Integer.parseInt(auxParse.substring(19));
                auxParse = leer.readLine();
                int cantidad = Integer.parseInt(auxParse.substring(11));
                venta.addPlanta(codigo,cantidad);
            }
            leer.readLine();
            setVentas.add(venta);
        }
          leer.close();
    }
    
    /**
     * Método que carga setPlantas con las plantas almacenadas en el archivo Plantas.txt
     * @throws FileNotFoundException cuando no encuentra el archivo en la posicion especificada
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
     * Método que sobreescribe el archivo Plantas.txt con las plantas almacenadas en setPlantas
     * @throws IOException cuando una operacion de lectura es interrumpida o falla
     */
    public void outPlantas() throws IOException{
        File f = new File("Plantas.txt");
        FileWriter escribo = new FileWriter(f);
        BufferedWriter escribir = new BufferedWriter(escribo);
        if(f.exists()){
            Iterator i = this.setPlantas.iterator();
            while(i.hasNext()){
                Planta p = (Planta)i.next();
                escribir.write(p.toString());
                escribir.newLine();
            }
            escribir.close();
        }
    }
    
    /**
     * Método que sobreescribe el archivo Usuarios.txt con los usuarios almacenados en setUsuarios
     * @throws IOException cuando una operacion de lectura es interrumpida o falla 
     */
    public void outUsuarios() throws IOException{
       File f = new File("Usuarios.txt");
       FileWriter escribo = new FileWriter(f);
       BufferedWriter escribir  = new BufferedWriter(escribo);
       Iterator i = this.setUsuarios.iterator();
       while(i.hasNext()){
            Usuario u = (Usuario) i.next();
            escribir.write(u.toString());
            escribir.newLine();
       }
       escribir.close();
    }
    
    /**
     * Método que sobreescribe el archivo Ventas.txt con las ventas almacenadas en setVentas
     * @throws IOException cuando una operacion de lectura es interrumpida o falla
     */
    public void outVentas() throws IOException{
        File f = new File("Ventas.txt");
        FileWriter escribo = new FileWriter(f);
        BufferedWriter escribir = new BufferedWriter(escribo);
        Iterator i = setVentas.iterator();
        while(i.hasNext()){
            Venta v = (Venta) i.next();
            escribir.write(v.toString());
            escribir.newLine();
        }
        escribir.close();
    }
    
    /**
     * Método que sobreescribe el archivo Clientes.txt con los datos almacenados en setClientes
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
     * Método que sobreescribe el archivo Pedidos.txt con los datos almacenados en setPedidos
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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCargarDueno;
    private javax.swing.JButton jButtonCargarEmpleado;
    private javax.swing.JButton jButtonConsultarPedidos;
    private javax.swing.JButton jButtonConsultarRanking;
    private javax.swing.JButton jButtonConsultarStock;
    private javax.swing.JButton jButtonConsultarUsuarios;
    private javax.swing.JButton jButtonIncrementarStock;
    private javax.swing.JButton jButtonListadoDeClientes;
    private javax.swing.JButton jButtonLogOut;
    private javax.swing.JButton jButtonModificarPlanta;
    private javax.swing.JButton jButtonModificarUsuario;
    private javax.swing.JButton jButtonNuevaPlanta;
    private javax.swing.JButton jButtonRegistarVentaMinorista;
    private javax.swing.JButton jButtonRegistraVentaMayorista;
    private javax.swing.JButton jButtonRegistrarComoTerminado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelAdministracion;
    private javax.swing.JLabel jLabelStock;
    private javax.swing.JLabel jLabelStock1;
    private javax.swing.JLabel jLabelStock3;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelPedido;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
