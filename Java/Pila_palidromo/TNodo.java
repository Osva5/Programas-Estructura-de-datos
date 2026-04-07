package Pila_palidromo;

public class TNodo {
    private char dato;
    private TNodo siguiente;

    public TNodo(char dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public char getDato() {
        return dato;
    }

    public void setDato(char dato) {
        this.dato = dato;
    }

    public TNodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(TNodo siguiente) {
        this.siguiente = siguiente;
    }
}