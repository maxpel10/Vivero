package interfazgrafica.Ordenadores;

import interfazgrafica.ClasesBase.Empleado;
import java.util.Comparator;

public class OrdenarEmpleadoPorPuntaje implements Comparator<Empleado> {
    @Override
    /**
    * Compara dos empleados por puntaje
    * @return 0 si los puntajes de los empleados son iguales, un numero positivo si el 
    * puntaje empleado pasado por parametro es mayor que el del receptor, un numero negativo si el puntaje 
    * del empleado pasado por parametro es menor que el del receptor.
    */ 
    public int compare(Empleado e1, Empleado e2) {
        return e2.getPuntaje() - e1.getPuntaje();
    }
}
