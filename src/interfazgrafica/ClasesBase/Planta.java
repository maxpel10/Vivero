
package interfazgrafica.ClasesBase;

import java.util.Random;

public class Planta {
    /**
    * Variable que almacena el codigo de la planta
    */
    private int codigo;
    /**
    * Variable que almacena la denominacion comun de la planta
    */
    private String denominacionComun;
    /**
    * Variable que almacena la especie de la planta
    */
    private String especie;
    /**
    * Variable que almacena el tamaño alcanzable de la planta
    */
    private double tamanio;
    /**
    * Variable que almacena el precio de la planta
    */
    private double precio;
    /**
    * Variable que almacena el stock de la planta
    */
    private int stock;
    /**
    * Variable que el estado de baja de la planta.VERDADERO= La planta fue dada de baja.FALSO = La planta no está dada de baja
    */
    private boolean baja;
    
    
    //Constructor
    
    /**
    * Crea una nueva planta con los atributos pasados por parámetro. 
    * @param denominacionComun nombre popular de la planta
    * @param especie denominacion científica de la planta
    * @param tamanio tamaño alcanzable por la planta
    * @param precio precio de la planta
    * @param stock stock de la planta
    */    
    public Planta(String denominacionComun,String especie,double tamanio,double precio, int stock){
        this.denominacionComun = denominacionComun;
        this.especie = especie;
        this.tamanio = tamanio;
        this.precio = precio;
        this.stock = stock;
        baja = false;
        Random random = new Random();
        codigo = random.nextInt(9999);
    }
    
    /**
    * Crea una nueva planta con los atributos pasados sin inicializar. 
    */
    public Planta() {
        Random random = new Random();
        codigo = random.nextInt(9999);
    }
    
    //Modificadores
    
    /**
    * Modifica el código de la planta por una nuev código pasado por parámetro
    * @param codigo nuevo código que se le va a asignar al código de la planta
    */  
    public void setCodigo(int codigo){this.codigo = codigo;}
    
    /**
    * Modifica la denominación comun de la planta por una nueva denominación común pasada por parámetro
    * @param denominacionComun nueva denominación común que se le va a asignar a la denominación común de la planta
    */    
    public void setDenominacionComun(String denominacionComun){this.denominacionComun = denominacionComun;}
    
    /**
    * Modifica la denominación científica de la planta por una nueva denominación científica pasada por parámetro
    * @param especie nueva denominación científica que se le va a asignar a la denominación científica de la planta
    */    
    public void setEspecie(String especie){this.especie = especie;}
     
    /**
    * Modifica el tamaño alcanzable de la planta por una nuevo tamaño pasado por parámetro
    * @param tamanio nuevo tamaño que se le va a asignar al tamaño alcanzable de la planta
    */    
    public void setTamanio(double tamanio){this.tamanio = tamanio;}
    
    /**
    * Modifica el precio de la planta por una nuevo precio pasado por parámetro
    * @param precio nuevo precio que se le va a asignar al precio de la planta
    */   
    public void setPrecio(double precio){this.precio = precio;}

    /**
    * Modifica el estado de baja de la planta por una nuevo estado de baja pasado por parámetro
    * @param baja nuevo estado de baja que se le va a asignar al estado de baja de la planta
    */       
    public void setBaja(boolean baja){this.baja = baja;}
    
    /**
    * Modifica el stock disponible de la planta por una nuevo stock pasado por parámetro
    * @param stock nuevo estado de baja que se le va a asignar al estado de baja de la planta
    */        
    public void setStock(int stock){this.stock = stock;}
    
    //Observadores
    
    /**
    * Retorna la denominación común de la planta.
    * @return denominación común de la planta
    */ 
    public String getDenominacionComun(){return denominacionComun;}
    
    /**
    * Retorna la denominación científica de la planta.
    * @return denominación científica de la planta.
    */ 
    public String getEspecie(){return especie;}
    
    /**
    * Retorna el tamaño alcanzable de la planta.
    * @return tamaño alcanzable de la planta
    */ 
    public double getTamanio(){return tamanio;}
    
    /**
    * Retorna el precio de la planta.
    * @return precio de la planta
    */ 
    public double getPrecio(){return precio;}
    
    /**
    * Retorna el código de la planta.
    * @return código de la planta.
    */ 
    public int getCodigo(){return codigo;}
    
    /**
    * Retorna el estado de baja de la planta.
    * @return estado de baja de la planta.
    */ 
    public boolean getBaja(){return baja;}
    
    
    /**
    * Retorna el stock de una planta.
    * @return stock de la planta.
    */ 
    public int getStock(){return stock;}
    
    //Otros métodos
    
    @Override
    /**
    * Retorna un string que contiene todos los datos de la planta
    * @return string con los datos de la planta
    */ 
    public String toString(){
        String nuevalinea = System.getProperty("line.separator");
        return "Codigo: "+codigo+nuevalinea+"Denominacion Comun: "+denominacionComun+nuevalinea+"Especie: "+especie+nuevalinea+"Tamaño: "+tamanio+nuevalinea+"Precio: "+precio+nuevalinea+"Stock: "+stock+nuevalinea+"Baja: "+baja+nuevalinea;
    }
}
