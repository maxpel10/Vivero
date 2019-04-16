package interfazgrafica.Ordenadores;

import java.util.Comparator;
import java.util.Map;

public class OrdenarMapaPorValor implements Comparator<Integer>{
    
    /**
    * Variable que almacena el mapa codigo de planta - cantidad que se va a ordenar
    */ 
    Map<Integer,Integer> base;
    
    /**
    * Apunta el mapa de la instancia al mapa pasado por parametro
    * @param base mapa a ordenar
    */ 
    public OrdenarMapaPorValor(Map<Integer, Integer> base) {
        this.base = base;
    }

    @Override
    /**
    * Compara dos cantidades del mapa
    * @return -1 si la cantidad de a es mayor que la de b, 1 si la cantidad de b es mayor que la de a
    */ 
    public int compare(Integer a, Integer b) {
        if (base.get(a) >= base.get(b)) {
            return -1;
        } else {
            return 1;
        } // si retornara 0, sobrescribiria claves.
    }


}