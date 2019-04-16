package interfazgrafica.Ordenadores;

import interfazgrafica.ClasesBase.Empleado;
import java.util.Comparator;

public class OrdenarEmpleadoPorDni implements Comparator<Empleado> {
    @Override
    /**
    * Compara dos empleados por dni
    * @return 0 si los dni de los empleados son iguales, un numero negativo si el 
    * dni empleado pasado por parametro es mayor que el del empleeado, un numero positivo si el dni 
    * del empleado pasado por parametro es menor que el del receptor.
    */ 
    public int compare(Empleado e1, Empleado e2) {
        return e1.getDni() - e2.getDni();
    }
   
    
}
