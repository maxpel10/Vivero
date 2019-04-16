package interfazgrafica.ClasesBase;


public class Dueño extends Usuario {
    /**
    * Variable que almacena la cantidad de especies creadas por el dueño
    */
    private int especiesCreadas;
    /**
    * Variable que almacena la escala adquirida por el dueño
    */
    private int escala;

    //Constructores
    /**
    * Crea un nuevo dueño con los atributos sin inicializar. 
    */
    public Dueño(){
        super();
        this.especiesCreadas = 0;
        this.escala = 0;
    }
    
    //Modificadores
    
    /**
    * Incrementa la cantidad de especies creadas por el usuario en 1 (una) unidad.
    */   
    public void actualizarEspeciesCreadas(){especiesCreadas++;}
    
    
    /**
    * Modifica la cantidad de especies creadas por el usuario.
    * @param especiesCreadas nueva cantidad de especies creadas
    */       
    public void setEspeciesCreadas(int especiesCreadas){this.especiesCreadas = especiesCreadas;}
    
    
    /**
    * Modifica la escala alcanzada por el usuario.
    * @param escala nueva escala del usuario
    */       
    public void setEscala(int escala){this.escala = escala;}
    
    //Observadores
    
    /**
    * Retorna la cantidad de especies creadas por el dueño.
    * @return cantidad de especies creadas por el dueño.
    */ 
    public int getEspeciesCreadas(){return especiesCreadas;}
    
    /**
    * Retorna la escala del dueño.
    * @return escala del dueño
    */ 
    public int getEscala(){return escala;}
    
    
    //Otros métodos
    
    /**
    * Evalua el desempeño del dueño considerando las ventas realizadas y las nuevas
    * especies creadas. Por cada 20 puntos el dueño sube de escala. Es un procedimiento: 
    * no retorna valores ni tiene parámetros. La escala es acumulativa. El puntaje no.
    */
    @Override
    public void evaluacionDeUsuario(){
        if (((getPuntaje())/20)>20)//Me aseguro que la escala no supere el límite de escala 20.
            escala = 20;
        else
            escala = getPuntaje()/20;
        setPuntaje(0);//Reseteo el puntaje
    }

    /**
    * Incrementa en 5 (cinco) unidades el puntaje del dueño al crear una nueva planta.  
    * Es un procedimiento: no retorna valores ni tiene parámetros.
    */
    public void nuevaEspecie(){
        setPuntaje(getPuntaje()+5);
    }
    
    
    @Override
    /**
    * Retorna un string que contiene todos los datos del dueño
    * @return string con los datos del dueño
    */ 
    public String toString(){
        String nuevalinea = System.getProperty("line.separator");
        return "Dueno"+nuevalinea+super.toString()+"Especies creadas: "+especiesCreadas+nuevalinea+"Escala: "+escala+nuevalinea;   
    }
}
