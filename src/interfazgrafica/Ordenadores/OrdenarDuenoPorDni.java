package interfazgrafica.Ordenadores;

import interfazgrafica.ClasesBase.Dueño;
import java.util.Comparator;

public class OrdenarDuenoPorDni implements Comparator<Dueño> {
    @Override
    /**
    * Compara dos dueños por dni
    * @return 0 si los dni de los dueños son iguales, un numero negativo si el 
    * dni dueño pasado por parametro es mayor que el del receptor, un numero positivo si el dni 
    * del dueño pasado por parametro es menor que el del receptor.
    */ 
    public int compare(Dueño d1, Dueño d2) {
        return d1.getDni() - d2.getDni();
    }
}
