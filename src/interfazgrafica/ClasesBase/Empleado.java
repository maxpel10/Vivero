package interfazgrafica.ClasesBase;

public class Empleado extends Usuario {
    /**
    * Variable que almacena el sueldo del empleado
    */
    private double sueldo;
    /**
    * Variable que almacena la antiguedad del empleado
    */
    private int antiguedad;
    /**
    * Variable que almacena el bono extra del empleado
    * que se determina a través de la evaluación de usuarios
    */
    private double bonoExtra; 
        
    //Constructores
    /**
    * Crea un nuevo empleado con los atributos sin inicializar. 
    */
    public Empleado(){
        super();
        this.sueldo = 0;
        this.antiguedad = 0;
        bonoExtra = 0;
    }
        
    //Modificadores
    
    /**
    * Modifica el sueldo del empleado por un nuevo sueldo pasado por parámetro
    * @param sueldo nuevo sueldo que se le va a asignar al sueldo del empleado
    */    
    public void setSueldo(double sueldo){this.sueldo = sueldo;}
    
    /**
    * Modifica la antiguedad del empleado por una nueva antiguedad pasada por parámetro
    * @param antiguedad nueva antiguedad que se le va a asignar a la antiguedad del empleado
    */    
    public void setAntiguedad(int antiguedad){this.antiguedad = antiguedad;}
    
    /**
    * Modifica el bono extra del cliente
    * @param bonoExtra nuevo bono extra del cliente
    */
    public void setBonoExtra(double bonoExtra){this.bonoExtra = bonoExtra;}
    
    //Observadores
    
    /**
    * Retorna el sueldo del empleado.
    * @return sueldo del empleado
    */ 
    public double getSueldo(){return sueldo;}
    
    /**
    * Retorna la antiguedad del empleado.
    * @return escala del empleado
    */ 
    public int getAntiguedad(){return antiguedad;}
    
    /**
    * Retorna el bono extra del empleado.
    * @return bono extra del empleado
    */
    public double getBonoExtra(){return bonoExtra;}
    
    //Otros métodos
    
    /**
    * Evalua el desempeño del empleado considerando las ventas realizadas.
    * Por cada 20 puntos agrega 100$ al sueldo del empleado en concepto de bono 
    * extra. Es un procedimiento: no retorna valores ni tiene parámetros. Ni el bono
    * extra, ni el puntaje es acumulativo.
    */
    @Override
    public void evaluacionDeUsuario(){
        bonoExtra = (getPuntaje()/20)*100;
        setPuntaje(0);//Reseteo el puntaje
    }
    
    
    @Override
    /**
    * Retorna un string que contiene todos los datos del empleado
    * @return string con los datos del empleado
    */ 
    public String toString(){
        String nuevalinea = System.getProperty("line.separator");
        return "Empleado"+nuevalinea+super.toString()+"Sueldo: "+sueldo+nuevalinea+"Antiguedad: "+antiguedad+nuevalinea+"Bono extra: "+bonoExtra+nuevalinea;
    }
    
}
