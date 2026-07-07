/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

/**
 *
 * @author Osvaldo
 */
public class TLista<T> {
    private TNodo<T> cab, fin;

    public TLista() {
        cab = new TNodo<T>();
        fin = null;
    }

    public void insertaFinal(T dato) {
        TNodo<T> p = new TNodo<>(dato);
        if (fin == null) {
            cab.setSiguiente(p);
        } else {
            fin.setSiguiente(p);
        }
        fin = p;
    }

    public TNodo<T> getCabecera() {
        return cab.getSiguiente();
    }

    public void eliminarTodo() {
        cab.setSiguiente(null); // Desconectamos la cabecera de todo lo demás
        fin = null;         // El final vuelve a ser nulo
    }

    public void eliminarInicio() {
        if (cab.getSiguiente() != null) {
            // Si solo hay un elemento (el primero es también el último),
            // al eliminarlo debemos dejar 'fin' en null para indicar lista vacía.
            if (cab.getSiguiente() == fin) {
                cab.setSiguiente(null);
                fin = null;
            } else {
                cab.setSiguiente(cab.getSiguiente().getSiguiente());
            }
        }
    }
    
    public boolean listaVacia() {
        return cab.getSiguiente() == null;
    }

    public void eliminarVerticePorId(int idBusca) {
    if (cab.getSiguiente() == null) return; // Lista vacía

    TNodo<T> ant = cab;
    TNodo<T> actu = cab.getSiguiente();

        while (actu != null) {
            // Casteamos el dato a Vertice para poder leer su .id
            // Esto funciona porque sabemos que esta lista es de Vertices
            logica.Vertice v = (logica.Vertice) actu.getDato();
            
            if (v.id == idBusca) {
                // Si es el último, actualizamos 'fin'
                if (actu == fin) {
                    fin = ant == cab ? null : ant;
                }
                // El anterior ahora apunta al siguiente del actual (lo eliminamos)
                ant.setSiguiente(actu.getSiguiente());
                return; 
            }
            ant = actu;
            actu = actu.getSiguiente();
        }
    }

    public void eliminarAristaPorDestino(int idBusca) {
    if (cab.getSiguiente() == null) return; // Lista vacía

    TNodo<T> ant = cab;
    TNodo<T> actu = cab.getSiguiente();

        while (actu != null) {
            // Casteamos a Arista para poder revisar a dónde apunta
            logica.Arista a = (logica.Arista) actu.getDato();
            
            if (a.destino.id == idBusca) {
                if (actu == fin) {
                    fin = ant == cab ? null : ant;
                }
                // Saltamos el nodo para eliminar la flecha
                ant.setSiguiente(actu.getSiguiente());
                // No ponemos return aquí porque un vértice puede tener 
                // varias flechas al mismo destino si así se dibujó
            } else {
                ant = actu;
            }
            actu = actu.getSiguiente();
        }
    }

        // Devuelve 1 si v2 está en la lista de adyacencia de v1
    public int sonAdyacentes(int idDestino) {
        TNodo<T> actu = cab.getSiguiente();
        while (actu != null) {
            logica.Arista a = (logica.Arista) actu.getDato();
            if (a.destino.id == idDestino) return 1;
            actu = actu.getSiguiente();
        }
        return 0;
    }

    // Cuenta cuántos elementos (aristas) tiene la lista
    public int obtenerGrado() {
        int contador = 0;
        TNodo<T> actu = cab.getSiguiente();
        while (actu != null) {
            contador++;
            actu = actu.getSiguiente();
        }
        return contador;
    }
    
    public int cantidadElementos() {
    int contador = 0;
    TNodo<T> aux = cab.getSiguiente();
    while (aux != null) {
        contador++;
        aux = aux.getSiguiente();
    }
    return contador;
    }

    public boolean buscarPorDestino(int idBusca) {
    TNodo<T> aux = cab.getSiguiente();
    while (aux != null) {
        // Casteamos el dato a Arista para poder ver su destino
        if (aux.getDato() instanceof logica.Arista) {
            logica.Arista a = (logica.Arista) aux.getDato();
            if (a.destino.id == idBusca) {
                return true; // Sí hay conexión
            }
        }
        aux = aux.getSiguiente();
    }
    return false; // No se encontró conexión
}
}

