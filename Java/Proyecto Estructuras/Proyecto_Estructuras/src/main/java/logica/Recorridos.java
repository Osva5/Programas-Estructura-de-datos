package logica;

public class Recorridos {
    public static String Amplitud(Vertice inicio, TLista<Vertice> todosLosVertices) {
        StringBuilder resultado = new StringBuilder("Amplitud: ");
        // 1. Resetear todos los vértices a "no visitados"
        resetearVisitados(todosLosVertices);
        
        TLista<Vertice> cola = new TLista<>(); // Usamos TLista como cola
        cola.insertaFinal(inicio);
        inicio.visitado = true;

        while (!cola.listaVacia()) {
            // Sacamos el primero (frente de la cola)
            Vertice actual = cola.getCabecera().getDato();
            cola.eliminarInicio(); // Eliminamos el frente de la cola
            
            resultado.append(actual.id).append(" ");        // Agregamos el vértice actual al resultado

            // Explorar vecinos
            TNodo<Arista> aAux = actual.adyacentes.getCabecera();
            while (aAux != null) {
                Vertice vecino = aAux.getDato().destino;
                if (!vecino.visitado) {
                    vecino.visitado = true;
                    cola.insertaFinal(vecino);
                }
                aAux = aAux.getSiguiente();
            }
        }
        return resultado.toString();
    }

    private static void resetearVisitados(TLista<Vertice> vertices) {
        TNodo<Vertice> aux = vertices.getCabecera();
        while (aux != null) {
            aux.getDato().visitado = false;
            aux = aux.getSiguiente();
        }
    }   

    public static String Profundidad(Vertice inicio, TLista<Vertice> todosLosVertices) {
        StringBuilder resultado = new StringBuilder("Profundidad: ");
        resetearVisitados(todosLosVertices); // Método existente para resetear el estado de visitado
        profundidadRecursivo(inicio, resultado);    
        return resultado.toString();
    }

    private static void profundidadRecursivo(Vertice v, StringBuilder res) {
        v.visitado = true;
        res.append(v.id).append(" ");

        TNodo<Arista> aAux = v.adyacentes.getCabecera();
        while (aAux != null) {
            Vertice vecino = aAux.getDato().destino;
            if (!vecino.visitado) {
                profundidadRecursivo(vecino, res);
            }
            aAux = aAux.getSiguiente();
        }
    }
}
