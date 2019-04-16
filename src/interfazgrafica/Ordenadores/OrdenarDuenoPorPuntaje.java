package interfazgrafica.Ordenadores;

import interfazgrafica.ClasesBase.Dueño;
import java.util.Comparator;


public class OrdenarDuenoPorPuntaje implements Comparator<Dueño> {
    @Override
    /**
    * Compara dos dueños por puntaje
    * @return 0 si los puntajes de los dueños son iguales, un numero positivo si el 
    * puntaje dueño pasado por parametro es mayor que el del receptor, un numero negativo si el puntaje 
    * del dueño pasado por parametro es menor que el del receptor.
    */ 
    public int compare(Dueño d1, Dueño d2) {
        return d2.getPuntaje() - d1.getPuntaje();
    }
    
}
