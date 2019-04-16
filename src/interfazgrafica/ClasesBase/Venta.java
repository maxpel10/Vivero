package interfazgrafica.ClasesBase;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
        
public class Venta {
    /**
    * Variable que almacena un mapa de planta y cantidad de la venta
    */ 
    private Map<Integer,Integer> venta;//La clave del mapa es la planta y el valor es la cantidad.
    /**
    * Variable que almacena la fecha en la que se realizo la venta
    */ 
    private Calendar fecha;

    /**
    * Crea una nueva venta con el mapa pasado por parametro.
    * @param venta mapa de la venta
    */ 
    public Venta(Map<Integer,Integer> venta){
        this.venta = new HashMap<>(venta);
        fecha = new GregorianCalendar();
        fecha.set(fecha.get(Calendar.YEAR),fecha.get(Calendar.MONTH),fecha.get(Calendar.DATE));
    }
    
    /**
    * Crea una nueva venta con los atributos sin inicializar
    */ 
    public Venta(){
        this.venta = new HashMap<>();
        fecha = new GregorianCalendar();
        fecha.set(fecha.get(Calendar.YEAR),fecha.get(Calendar.MONTH),fecha.get(Calendar.DATE));
    }

    /**
    * Modifica la fecha de la venta por una nueva fecha pasada por parametro
    * @param dia dia de la nueva fecha
    * @param mes mes de la nueva fecha
    * @param anio anio de la nueva fecha
    */ 
    public void setFecha(int dia,int mes,int anio){fecha.set(anio,mes,dia);}
    
    /**
    * Agrega una nueva planta con su cantidad al mapa de ventas
    * @param codigo codigo de la planta a agregar
    * @param cantidad cantidad de plantas a agregar
    */ 
    public void addPlanta(int codigo,int cantidad){
        venta.put(codigo,cantidad); 
    }
   
    /**
    * Retorna la fecha en la que se realizo la venta
    * @return fecha en la que se realizo la venta
    */ 
    public Calendar getFecha(){return fecha;}
    
    
    /**
    * Retorna el mapa de la venta
    * @return mapa de la venta
    */ 
    public Map getVenta(){return venta;}
    
    @Override
    /**
    * Retorna un string que contiene todos los datos de la venta
    * @return string con los datos de la venta
    */ 
    public String toString(){
        String nuevalinea = System.getProperty("line.separator");
        Iterator i = venta.keySet().iterator();
        String compra = "";
        while(i.hasNext()){
            int codigo = (Integer)i.next();
            compra += nuevalinea+"\tCodigo de planta: "+codigo+nuevalinea+"\tCantidad: "+venta.get(codigo);
        }
        compra += nuevalinea+"-";
        return "Dia: "+fecha.get(Calendar.DATE)+nuevalinea+"Mes: "+(fecha.get(Calendar.MONTH)+1)+nuevalinea+"Año: "+fecha.get(Calendar.YEAR)+nuevalinea+"Compra: "+compra+nuevalinea;
    }

}