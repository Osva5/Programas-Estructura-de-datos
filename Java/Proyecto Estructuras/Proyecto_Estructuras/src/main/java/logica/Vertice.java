package logica;
    // Importamos estructura TLista
/**
 *
 * @author Osvaldo
 */
public class Vertice {
    public int id;
    public int x, y;
    public boolean visitado; // Para marcar si el vértice ha sido visitado durante el recorrido
    
    //Usamos TLista para las aristas
    public TLista<Arista> adyacentes; //Lista de adyacencia, guardar objetos de tipo arista
    public Vertice predecesor; // Para guardar de dónde venimos en la ruta corta
    
    // Atributos que usamos para Dijkstra
    public int distanciaMinima = Integer.MAX_VALUE;     //Asignar el numero mas grande posible, representa infinito
    public Vertice padre = null;        //Asigna que todos los vertices en su atributo padre sean = a null

    // Constructor 
    public Vertice(int id, int x, int y) {  
        this.id = id;
        this.x = x;             //Para poder guardar los valores
        this.y = y;
        this.visitado = false;
        this.predecesor = null;
        
        //Inicializamos TLista, (Guarda la lista de adyacencia)
        this.adyacentes = new TLista<Arista>(); 
    }
}

