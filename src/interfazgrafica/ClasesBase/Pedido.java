package interfazgrafica.ClasesBase;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;


public class Pedido {
    /**
    * Variable que almacena el codigo del pedido
    */ 
    private int codigo;
    /**
    * Variable que almacena el estado del pedido. true = terminado,
    * false = no terminado.
    */ 
    private boolean estado;
    /**
    * Mapa que contiene como clave una planta y como valor la cantidad de ese tipo de planta
    * incluidas en el pedido.
    */ 
    private Map<Planta,Integer> pedido;//La clave del mapa es la planta y el valor es la cantidad.
    /**
    * Variable que almacena el monto del pedido.
    */ 
    private double monto;
    /**
    * Variable que almacena el codigo del cliente que realizo el pedido.
    */ 
    private int codigoCliente;
    /**
    * Variable que indica si el pedido fue retirado o no. True = retirado. False = no retirado
    */ 
    private boolean retirado;
    
    /**
    * Crea un nuevo pedido con los atributos pasados por parámetro. 
    * @param pedido mapa de <Planta,Cantidad>
    * @param codigoCliente codigo del cliente que realiza el pedido
    */
    public Pedido(Map<Planta,Integer> pedido, int codigoCliente){
        this.pedido = new HashMap<>();
        this.pedido.putAll(pedido);
        estado = false;
        Random random = new Random();
        codigo = random.nextInt(9999);
        monto = 0.0;
        this.codigoCliente = codigoCliente;
        retirado = false;
        Iterator i = this.pedido.keySet().iterator();
        while(i.hasNext()){//Recorro el mapa para calcular el monto total del pedido
            Planta aux = (Planta)i.next();
            monto+=aux.getPrecio()*this.pedido.get(aux); 
        }
    }
    
    /**
    * Crea un nuevo pedido con los atributos sin inicializar
    */
    public Pedido(){
        this.pedido = new HashMap<>();
        estado = false;
        retirado = false;
        codigoCliente = 0;
        Random random = new Random();
        codigo = random.nextInt(9999);
        monto = 0.0;
    }
    
    
    //Modificadores
    
    /**
    * Modifica el estado del pedido por un nuevo estado pasado por parámetro. 
    * @param estado nuevo estado que se le va a asignar al estado del pedido 
    */
    public void setEstado(boolean estado){this.estado = estado;}
    
    /**
    * Establece el estado de un pedido como terminado. 
    */
    public void registrarComoTerminado(){estado = true;}
    
    /**
    * Modifica el codigo del pedido por uno nuevo pasado por parametro
    * @param codigo nuevo codigo del pedido
    */
    public void setCodigo(int codigo){this.codigo = codigo;}
    
    /**
    * Cambia el estado de retiro de un pedido por uno nuevo pasado por parametro.
    * @param retirado nuevo estado de retiro del pedido
    */
    public void setRetirado(boolean retirado){this.retirado = retirado;}
    
    /**
    * Establece que el pedido fue retirado. 
    */
    public void registrarComoRetirado(){retirado = true;}
    
    /**
    * Modifica el codigo de cliente que realizo el pedido. 
    * @param codigoCliente nuevo codigo de cliente
    */
    public void setCodigoCliente(int codigoCliente){this.codigoCliente = codigoCliente;}
    
    /**
    * Elimina una planta del mapa de pedidos. 
    * @param planta planta a eliminar
    */
    public void removePlanta(Planta planta){
        monto -= planta.getPrecio()*pedido.get(planta);
        pedido.remove(planta);
    }
    
    /**
    * Elimina todas las plantas de un pedido.
    */
    public void removeAllPlanta(){
        monto = 0.0;
        pedido.clear();
    }//Usar en el caso de vaciar carrito
    
    /**
    * Agrega una nueva planta 
    * @param planta planta a agregar
    * @param cantidad cantidades de plantas a agregar
    *
    */
    public void addPlanta(Planta planta,int cantidad){
        monto += planta.getPrecio()*cantidad;
        pedido.put(planta,cantidad);
    }
    
    /**
    * Agrega un conjunto de plantas y sus cantidades al mapa del pedido
    * @param pedido mapa de plantas y cantidades a agregar
    *
    */
    public void addAllPlanta(Map <Planta,Integer> pedido){
        this.pedido.putAll(pedido);
        monto = 0.0;
        Iterator i = this.pedido.keySet().iterator();
        while(i.hasNext()){//Recorro el mapa para calcular el monto total del pedido
            Planta aux = (Planta)i.next();
            monto+=aux.getPrecio()*this.pedido.get(aux); 
        }
    }
    
    
    /**
    * Reemplaza la cantidad de una planta pedida
    * @param planta planta cuya cantidad se va a modificar
    * @param cantidad nueva cantidad 
    *
    */
    public void replaceCantidad(Planta planta,int cantidad){
        monto -= planta.getPrecio()*pedido.get(planta);
        monto += planta.getPrecio()*cantidad;
        pedido.replace(planta,cantidad);
    }
    

    //Observadores
    
    /**
    * Retorna el codigo del pedido.
    * @return codigo del pedido
    */
    public int getCodigo(){return codigo;}
    
    /**
    * Retorna el estado del pedido.
    * @return estado del pedido: true terminado, false no terminado
    */
    public boolean getEstado(){return estado;}
    
    /**
    * Retorna el codigo del cliente que realizo el pedido.
    * @return codigo del cliente que realizo el pedido
    */
    public int getCodigoCliente(){return codigoCliente;}
    
    /**
    * Retorna el estado de retiro del pedido.
    * @return estado de retiro del pedido: true retirado, false no retirado
    */
    public boolean getRetirado(){return retirado;}
    
    /**
    * Retorna el mapa de planta y cantidad del pedido.
    * @return mapa de planta y cantidad del pedido.
    */
    public Map<Planta,Integer> getPedido(){return pedido;}
    
    /**
    * Retorna el monto del pedido y cantidad del pedido.
    * @return mapa de planta y cantidad del pedido.
    */
    public double getMonto(){return monto;}
   
    @Override
    /**
    * Retorna un string que contiene todos los datos del pedido
    * @return string con los datos del pedido
    */ 
    public String toString(){
        String nuevalinea = System.getProperty("line.separator");
        Iterator i = pedido.keySet().iterator();
        String plantas = "Plantas y cantidad";
        while(i.hasNext()){
            Planta p = (Planta) i.next();
            plantas += nuevalinea+"\tCodigo de planta: "+p.getCodigo()+nuevalinea+"\tCantidad: "+pedido.get(p);
        }
        plantas += nuevalinea+"-"+nuevalinea;
        return "Codigo del pedido: "+codigo+nuevalinea+"Codigo del Cliente: "+codigoCliente+nuevalinea+"Estado del pedido: "+estado+nuevalinea+"Retirado: "+retirado+nuevalinea+plantas;
    }
}
