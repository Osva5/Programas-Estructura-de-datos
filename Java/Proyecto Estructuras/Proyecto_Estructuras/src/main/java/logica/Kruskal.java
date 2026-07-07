package logica;

public class Kruskal {
    public static String ejecutarKruskal(TLista<Vertice> listaVertices) {
        // 1. Creamos una TLista para almacenar TODAS las aristas del grafo
        TLista<AristaKruskal> todasLasAristas = new TLista<>();
        
        TNodo<Vertice> vAux = listaVertices.getCabecera();
        while (vAux != null) {
            Vertice v = vAux.getDato();
            TNodo<Arista> aAux = v.adyacentes.getCabecera();
            while (aAux != null) {
                Arista a = aAux.getDato();
                // En grafos no dirigidos, evitamos duplicar (A-B es igual a B-A)
                if (v.id < a.destino.id) {
                    todasLasAristas.insertaFinal(new AristaKruskal(v.id, a.destino.id, a.peso));
                }
                aAux = aAux.getSiguiente();
            }
            vAux = vAux.getSiguiente();
        }

        // 2. Ordenar la TLista de aristas por peso (Ordenamiento Burbuja manual)
        ordenarListaAristas(todasLasAristas);

        // 3. Union-Find con un arreglo simple para detectar ciclos
        int[] padre = new int[101]; // Soporta hasta 100 nodos
        for (int i = 0; i < 101; i++) padre[i] = i;

        StringBuilder sb = new StringBuilder("--- Árbol de Expansión Mínima (Kruskal) ---\n");
        int costoTotal = 0;

        TNodo<AristaKruskal> nodoArista = todasLasAristas.getCabecera();
        while (nodoArista != null) {
            AristaKruskal aristaActual = nodoArista.getDato();
            
            int raizOrigen = encontrar(padre, aristaActual.origen);
            int raizDestino = encontrar(padre, aristaActual.destino);

            if (raizOrigen != raizDestino) {
                sb.append("Conexión: ").append(aristaActual.origen)
                  .append(" - ").append(aristaActual.destino)
                  .append(" | Peso: ").append(aristaActual.peso).append("\n");
                
                costoTotal += aristaActual.peso;
                padre[raizOrigen] = raizDestino; // Unión de conjuntos
            }
            nodoArista = nodoArista.getSiguiente();
        }

        sb.append("Costo Total del Árbol de Expansión Mínima: ").append(costoTotal);      
        return sb.toString();
    }

    // Método auxiliar para encontrar la raíz (Union-Find)
    private static int encontrar(int[] padre, int i) {
        if (padre[i] == i) return i;
        return encontrar(padre, padre[i]);
    }

    // Ordenamiento manual para tu TLista
    private static void ordenarListaAristas(TLista<AristaKruskal> lista) {
        if (lista.getCabecera() == null) return;
        boolean huboIntercambio;
        do {
            huboIntercambio = false;
            TNodo<AristaKruskal> actual = lista.getCabecera();
            while (actual.getSiguiente() != null) {
                if (actual.getDato().peso > actual.getSiguiente().getDato().peso) {
                    // Intercambiamos los datos de los nodos
                    AristaKruskal temp = actual.getDato();
                    actual.setDato(actual.getSiguiente().getDato());
                    actual.getSiguiente().setDato(temp);
                    huboIntercambio = true;
                }
                actual = actual.getSiguiente();
            }
        } while (huboIntercambio);
    }
}

// Clase auxiliar simple para Kruskal
class AristaKruskal {
    int origen, destino, peso;
    AristaKruskal(int o, int d, int p) {
        this.origen = o;
        this.destino = d;
        this.peso = p;
    }
}

