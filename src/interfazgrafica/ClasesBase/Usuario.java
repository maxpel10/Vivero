package interfazgrafica.ClasesBase;

public abstract class Usuario {
    /**
     * Variable que almacena el nombre del usuario
     */
    private String nombre;
    /**
     * Variable que almacena el apellido del usuario
     */
    private String apellido;
    /**
     * Variable que almacena el dni del usuario
     */
    private int dni;
    /**
     * Variable que almacena telefono movil del usuario
     */
    private long telefonoMovil;
    /**
     * Variable que almacena telefono fijo del usuario
     */
    private long telefonoFijo;
    /**
     * Variable que almacena la fecha de nacimiento del usuario
     */
    private String fechaDeNacimiento;
    /**
     * Variable que almacena el user con el que usuario el usuario ingresa al sistema
     */
    private String usuario;
    /**
     * Variable que almacena la contraseña con el que usuario el usuario ingresa al sistema
     */
    private String contrasenia;
    /**
     * Variable que almacena el puntaje que acumula el usuario. Sirve al momento de evaluar un usuario
     */
    private int puntaje;
    
    
    //Constructores
    
    /**
    * Crea un nuevo usuario con los atributos pasados por parámetro. Aunque la clase
    * Usuario es abstracta (no se puede instanciar), es necesario el constructor para
    * que lo utilicen las subclaes.
    * 
    * @param nombre nombre del usuario
    * @param apellido apellido del usuario
    * @param dni documento nacional de identidad del usuario
    * @param telefonoMovil telefono movil del usuario
    * @param telefonoFijo telefono fijo del usuario
    * @param fechaDeNacimiento fecha de nacimiento del usuario
    * @param usuario nombre con el que el usuario va a ingresar el sistema
    * @param contrasenia contraseña con la que el usuario va a ingresar el sistema
    */
    public Usuario(String nombre, String apellido,int dni, long telefonoMovil,long telefonoFijo,String fechaDeNacimiento,String usuario, String contrasenia){
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefonoMovil = telefonoMovil;
        this.telefonoFijo = telefonoFijo;
        this.usuario = usuario;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.contrasenia = contrasenia;
        puntaje = 0;
    }
    
    
    /**
    * Crea un nuevo usuario con los atributos sin inicializar. Aunque la clase
    * Usuario es abstracta (no se puede instanciar), es necesario el constructor para
    * que lo utilicen las subclases. 
    * 
    */
    public Usuario(){
        puntaje = 0;
    }
    
    
    //Modificadores
    
    /**
    * Modifica el nombre del usuario por un nuevo nombre pasado por parámetro
    * @param nombre nuevo nombre que se le va a asignar al nombre del usuario
    */
    public void setNombre(String nombre){this.nombre = nombre;}
    
    /**
    * Modifica el apellido del usuario por un nuevo apellido pasado por parámetro
    * @param apellido nuevo apellido que se le va a asignar al apellido del usuario
    */
    public void setApellido(String apellido){this.apellido = apellido;}
   
    /**
    * Modifica el dni del usuario por un nuevo dni pasado por parámetro
    * @param dni nuevo dni que se le va a asignar al dni del usuario
    */    
    public void setDni(int dni){this.dni = dni;}
    
    /**
    * Modifica el telefono movil del usuario por un nuevo telefono movil pasado por parámetro
    * @param telefonoMovil nuevo tm que se le va a asignar al tm del usuario
    */    
    public void setTelefonoMovil(long telefonoMovil){this.telefonoMovil = telefonoMovil;}
    
    /**
    * Modifica el telefono fijo del usuario por un nuevo telefono movil pasado por parámetro
    * @param telefonoFijo nuevo tf que se le va a asignar al tf del usuario
    */    
    public void setTelefonoFijo(long telefonoFijo){this.telefonoFijo = telefonoFijo;}
    
    /**
    * Modifica la fecha de nacimiento del usuario por un nueva fecha pasada por parámetro
    * @param fechaDeNacimiento nueva fecha de nacimiento que se le va a asignar a la fecha de nacimiento del usuario
    */    
    public void setFechaDeNacimiento(String fechaDeNacimiento){this.fechaDeNacimiento = fechaDeNacimiento;}
    
    /**
    * Modifica el nombre de usuario por un nuevo nombre de usuario pasado por parámetro
    * @param usuario nuevo nombre de usuario que se le va a asignar al nombre de usuario del usuario
    */    
    public void setUsuario(String usuario){this.usuario = usuario;}
    
    /**
    * Modifica la contraseña del usuario por una nueva contraseña pasada por parámetro
    * @param contrasenia nueva contraseña que se le va a asignar a la contraseña del usuario
    */   
    public void setContrasenia(String contrasenia){this.contrasenia = contrasenia;}
    
    /**
    * Modifica el puntaje del usuario por un nuevo puntaje por parámetro
    * @param puntaje puntaje que se le va a asignar al puntaje del usuario
    */   
    public void setPuntaje(int puntaje){this.puntaje = puntaje;}
    
    

    //Observadores
    
    /**
    * Retorna el nombre del usuario.
    * @return nombre del usuario
    */   
    public String getNombre(){return nombre;}
    
    /**
    * Retorna el apellido del usuario.
    * @return apellido del usuario
    */   
    public String getApellido(){return apellido;}
    
    /**
    * Retorna el dni del usuario.
    * @return dni del usuario
    */       
    public int getDni(){return dni;}
    
    /**
    * Retorna el telefono movil del usuario.
    * @return teléfono movil del usuario
    */ 
    public long getTelefonoMovil(){return telefonoMovil;}
    
    /**
    * Retorna el telefono fijo del usuario.
    * @return teléfono fijo del usuario
    */ 
    public long getTelefonoFijo(){return telefonoFijo;}
    
    /**
    * Retorna la fecha de nacimiento del usuario.
    * @return fecha de nacimiento del usuario
    */           
    public String getFechaDeNacimiento(){return fechaDeNacimiento;}
    
    /**
    * Retorna el nombre de usuario con el que se va a ingresar al sistema.
    * @return nombre de usuario
    */        
    public String getUsuario(){return usuario;}
    
    /**
    * Retorna la contraseña del usuario con la que se va a ingresar al sistema.
    * @return contraseña del usuario
    */        
    public String getContrasenia(){return contrasenia;}
    
    /**
    * Retorna el puntaje del usuario.
    * @return puntaje del usuario
    */ 
    public int getPuntaje(){return puntaje;}
    
    
    //Métodos abstractos
    
    /**
    * Evalua el desempeño del usuario. Es un procedimiento: 
    * no retorna valores ni tiene parámetros. 
    */
    public abstract void evaluacionDeUsuario();
    
    
    //Otros métodos
    /**
    * Incrementa en 1 (una) unidad el puntaje del usuario al realizar una venta minorista.  
    * Es un procedimiento: no retorna valores ni tiene parámetros.
    */
    public void ventaMinorista(){puntaje++;}
    
    
    /**
    * Incrementa en 3 (tres) unidades el puntaje del usuario al realizar una venta mayorista.  
    * Es un procedimiento: no retorna valores ni tiene parámetros.
    */
    public void ventaMayorista(){puntaje+=3;}
    
    
    @Override
    /**
    * Retorna un string que contiene todos los datos del usuario
    * @return string con los datos del usuario
    */ 
    public String toString(){
        String nuevalinea = System.getProperty("line.separator");
        return "Nombre: "+nombre+nuevalinea+"Apellido: "+apellido+nuevalinea+"DNI: "+dni+nuevalinea+"Telefono Movil: "+telefonoMovil+nuevalinea+"Telefono Fijo: "+telefonoFijo+nuevalinea+"Fecha de nacimiento: "+fechaDeNacimiento+nuevalinea+"Usuario: "+usuario+nuevalinea+"Contrasena: "+contrasenia+nuevalinea+"Puntaje: "+puntaje+nuevalinea;
    }
    
}
