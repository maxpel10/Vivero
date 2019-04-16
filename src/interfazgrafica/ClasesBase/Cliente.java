package interfazgrafica.ClasesBase;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

public class Cliente {
    /**
    * Variable que almacena el codigo del cliente
    */
    private int codigo;
    /**
    * Variable que almacena el nombre del cliente
    */
    private String nombre;
    /**
    * Variable que almacena la dirección del cliente
    */
    private String direccion;
    /**
    * Variable que almacena el email del cliente
    */
    private String email;
    /**
    * Variable que almacena el cuil del cliente
    */
    private long cuil;
    /**
    * Variable que almacena el tipo del cliente. true = vivero.
    * false = floreria.
    */
    private boolean tipo;
    /**
    * Variable que almacena el usuario con el que el cliente
    * ingresa al sistema.
    */
    private String usuario;
    /**
    * Variable que almacena la contraseña con el que el cliente
    * ingresa al sistema.
    */
    private String contrasenia;
    /**
    * Variable que almacena la fecha en la que el cliente
    * se registró en el sistema
    */
    private String fechaDeIngreso;

    //Constructor
    /**
    * Crea un nuevo cliente con los atributos sin inicializar.
    */
    public Cliente(){
        this.nombre = "";
        this.direccion = "";
        this.email = "";
        this.cuil = 0;
        this.tipo = false;
        this.usuario = "";
        this.contrasenia = "";
        Calendar fecha = new GregorianCalendar();
        int dia = fecha.get(Calendar.DATE);
        int mes = fecha.get(Calendar.MONTH)+1;
        int anio = fecha.get(Calendar.YEAR);
        fechaDeIngreso = dia+"/"+mes+"/"+anio;
        Random random = new Random();
        codigo = random.nextInt(9999);
    }
    
    //Modificadores
    
        
    /**
    * Modifica el código del cliente por un nuevo código pasado por parámetro
    * @param codigo nuevo código que se le va a asignar al código del cliente
    */    
    public void setCodigo(int codigo){this.codigo = codigo;}
    /**
    * Modifica el nombre del cliente por un nuevo nombre pasado por parámetro
    * @param nombre nuevo nombre que se le va a asignar al nombre del cliente
    */    
    public void setNombre(String nombre){this.nombre = nombre;}
    
    /**
    * Modifica la dirección del cliente por una nueva dirección pasada por parámetro
    * @param direccion nueva direccion que se le va a asignar a la dirección del cliente
    */    
    public void setDireccion(String direccion){this.direccion = direccion;}
    
    /**
    * Modifica el email del cliente por un nuevo email pasado por parámetro
    * @param email nuevo email que se le va a asignar al email del cliente
    */    
    public void setEmail(String email){this.email = email;}
    
    /**
    * Modifica el cuil del cliente por un nuevo cuil pasado por parámetro
    * @param cuil nuevo cuil que se le va a asignar al cuil del cliente
    */    
    public void setCuil(long cuil){this.cuil = cuil;}
    
    /**
    * Modifica el tipo del cliente por un nuevo tipo pasado por parámetro
    * @param tipo tipo de cliente mayorista: Verdadero=Vivero, Falso=Florería
    */    
    public void setTipo(boolean tipo){this.tipo = tipo;}
    
    /**
    * Modifica el usuario del cliente por un nuevo usuario pasado por parámetro
    * @param usuario nuevo usuario del cliente mayorista 
    */       
    public void setUsuario(String usuario){this.usuario = usuario;}
    
    /**
    * Modifica la contrasenia del cliente por una nueva contraseña pasada por parámetro
    * @param contrasenia nueva contrasenia del cliente 
    */   
    public void setContrasenia(String contrasenia){this.contrasenia = contrasenia;}
    
    /**
    * Modifica la fecha de ingreso del cliente por una fecha de ingreso pasada por parámetro
    * @param fechaDeIngreso nueva fecha de ingreso del cliente 
    */   
    public void setFechaDeIngreso(String fechaDeIngreso){this.fechaDeIngreso = fechaDeIngreso;}

    //Observadores
    
    /**
    * Retorna el nombre del cliente.
    * @return nombre del cliente
    */ 
    public String getNombre(){return nombre;}
    
    /**
    * Retorna la dirección del cliente.
    * @return dirección del cliente
    */ 
    public String getDireccion(){return direccion;}
    
    /**
    * Retorna el email del cliente.
    * @return email del cliente
    */ 
    public String getEmail(){return email;}
    
    /**
    * Retorna el cuil del cliente.
    * @return cuil del cliente
    */ 
    public long getCuil(){return cuil;}
    
    /**
    * Retorna el tipo del cliente.
    * @return tipo del cliente: true = vivero, false = floreria
    */ 
    public boolean getTipo(){return tipo;}
    
    /**
    * Retorna el código del cliente.
    * @return código del cliente
    */ 
    public int getCodigo(){return codigo;}
    
    /**
    * Retorna la fecha de ingreso al sistema del cliente.
    * @return fecha de ingreso al sistema.
    */ 
    public String getFechaDeIngreso(){return fechaDeIngreso;}
    
    /**
    * Retorna el usuario con el cual el cliente entra al sistema.
    * @return usuario del cliente.
    */ 
    public String getUsuario(){return usuario;}
    
    /**
    * Retorna la contraseña con la cual el cliente entra al sistema.
    * @return contraseña del cliente.
    */ 
    public String getContrasenia(){return contrasenia;}
  
    //Otros métodos
    
    @Override
    /**
    * Retorna un string que contiene todos los datos del cliente
    * @return string con los datos del cliente
    */ 
    public String toString(){
        String nuevalinea = System.getProperty("line.separator");
        return "Codigo del cliente: "+codigo+nuevalinea+"Nombre: "+nombre+nuevalinea+"Direccion: "+direccion+nuevalinea+"E-mail: "+email+nuevalinea+"CUIL: "+cuil+nuevalinea+"Tipo: "+tipo+nuevalinea+"Fecha de ingreso: "+fechaDeIngreso+nuevalinea+"Usuario: "+usuario+nuevalinea+"Contrasena: "+contrasenia+nuevalinea;
    }
}


