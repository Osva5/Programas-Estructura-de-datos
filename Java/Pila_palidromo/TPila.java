package Pila_palidromo;

public class TPila extends TLista {

    public void push(char dato) {
        insertarFinal(dato);
    }

    public char pop() {
        if (!listaVacia()) {
            return eliminarInicio();
        } else {
            return '\0';
        }
    }
}