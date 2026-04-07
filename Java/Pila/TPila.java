package Pila;

public class TPila {
    private TLista pila = new TLista();

    public void insertaDato(int dato){
        pila.insertaInicio(dato);
    }

    public int eliminaDato(){
        return pila.eliminarInicio();
    }

    public boolean pilaVacia(){
        return pila.listaVacia();
    }

    public void liberaPila(){
        pila.eliminaLista();
    }

}
