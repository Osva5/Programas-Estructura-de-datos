package Pila_palidromo;

public class TLista {
    protected TNodo cab;
    protected TNodo fin;

    public TLista() {
        cab = new TNodo('\0');
        fin = null;
    }

    public void insertarFinal(char dato) {
        TNodo nuevo = new TNodo(dato);
        if (fin == null) {
            cab.setSiguiente(nuevo);
            fin = nuevo;
        } else {
            fin.setSiguiente(nuevo);
            fin = nuevo;
        }
    }

    public char eliminarInicio() {
        TNodo p = cab.getSiguiente();
        char dato;

        if (p != null) {
            dato = p.getDato();
            cab.setSiguiente(p.getSiguiente());
            if (p.getSiguiente() == null) {
                fin = null;
            }
        } else {
            dato = '\0';
        }
        return dato;
    }

    public boolean listaVacia() {
        return cab.getSiguiente() == null;
    }
}