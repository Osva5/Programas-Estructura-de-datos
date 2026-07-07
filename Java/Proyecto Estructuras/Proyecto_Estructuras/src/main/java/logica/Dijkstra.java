package logica;


import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Stack;

/**
 *
 * @author Osvaldo
 */



public class Dijkstra {

    // Cambiamos List<Vertice> por TLista<Vertice>
    public static void calcular(TLista<Vertice> vertices, Vertice origen) { 
        
        //Resetear distancias usando punteros
        TNodo<Vertice> auxiliar = vertices.getCabecera();
        while (auxiliar != null) {
            Vertice v = auxiliar.getDato();
            v.distanciaMinima = Integer.MAX_VALUE;
            v.padre = null;
            auxiliar = auxiliar.getSiguiente();
        }

        origen.distanciaMinima = 0;     //El nodo de inicio siempre tendra distancia 0, pues ya estas ahi
        PriorityQueue<Vertice> cola = new PriorityQueue<>(Comparator.comparingInt(v -> v.distanciaMinima));
        //Ordena los elementos,                         sintaxis de comparador      cada vertice tome su atributo para decidir su prioridad
        cola.add(origen);   //Inserta un elemento a la cola, recibido por el metodo calcular 


        while (!cola.isEmpty()) {
            Vertice actu = cola.poll();

            // Recorrer las aristas adyacentes usando punteros (TNodo<Arista>)
            TNodo<Arista> aAux = actu.adyacentes.getCabecera();
            while (aAux != null) {
                Arista arista = aAux.getDato();
                Vertice v = arista.destino;
                int peso = arista.peso;
                int posibleNuevoCosto = actu.distanciaMinima + peso;

                if (posibleNuevoCosto < v.distanciaMinima) {            //Compara si el nuevo camino es mas barato que el que tenia
                    cola.remove(v);             //Si el que conectaba ya esta aqui, lo quita ppara poder actualizar su posicion 
                    v.distanciaMinima = posibleNuevoCosto;      //Actualizamos el atributo con el nuevo costo 
                    v.padre = actu;         //Hacer que recuerde desde que nodo viene su ruta 
                    cola.add(v);        //Ahora si agregamos nuestro nodo paa que el algoritmo ahora analize los siguientes de este
                }
                //Saltar al siguiente nodo de adyacencia
                aAux = aAux.getSiguiente();
            }
        }
    }

    // El método obtenerCamino para obtener el camino desde el origen hasta el destino usando la pila
    public static Stack<Vertice> obtenerCamino(Vertice destino) {       //Indica que retornara una pila, recibe el vertice destino 
        Stack<Vertice> camino = new Stack<>();      //Crear el objeto
        for (Vertice v = destino; v != null; v = v.padre) {     //Ciclo para recordar el camino 
            camino.push(v);     //lo mete a la pila 
        }
        return camino;      //Devuelve la pila completa 
    }

    public String obtenerRutaFormateada(Vertice destino) {
        if (destino.distanciaMinima == Integer.MAX_VALUE) return "No hay ruta";

        String ruta = "";
        Vertice aux = destino;
        while (aux != null) {
            ruta = aux.id + (ruta.isEmpty() ? "" : " -> " + ruta);
            aux = aux.padre;
        }
        return "Ruta: (" + ruta + ") - Costo total: " + destino.distanciaMinima;
    }
}
