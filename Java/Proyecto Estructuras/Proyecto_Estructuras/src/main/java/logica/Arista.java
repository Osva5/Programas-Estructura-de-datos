package logica;

/**
 *
 * @author Osvaldo
 */

//Esta clase representara la conexion de la lista de Adyacencia 
public class Arista {
    public Vertice destino;     //Guarda el vertice y hacia donde apunta  
    public int peso;            //Guarda el peso de la conexion 
    public boolean dirigida;    //Para saber si es dirigido o no (Usamos bandera) 
    

    public Arista(Vertice destino, int peso, boolean dirigida) {      //Constructor 
        this.destino = destino;     //Para poder guardar los valores 
        this.peso = peso;
        this.dirigida = dirigida;
    }
}

