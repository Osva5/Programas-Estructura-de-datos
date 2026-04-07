package Colas;

public class TCola {
    private TLista colas = new TLista();

    //para una cola, se debe de insertar al final y eliminar al inicio
    public void insertaDato(int dato){
        colas.insertaFinal(dato);
    }

    public int eliminaDato(){
        return colas.eliminarInicio();
    }

    public boolean colaVacia(){
        return colas.listaVacia();
    }

    public void liberaCola(){
        colas.eliminaLista();
    }

    public void mostrar(){
        colas.muestraLista();
    }

    public int preguntaTurno(){
        return colas.deseacontinuar();
    }

}
