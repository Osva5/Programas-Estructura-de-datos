package Pila;

public class TNodo{
    private int dato;
    private TNodo sig;

    TNodo(){
        dato = 0;
        sig = null;
    }

    TNodo(int dato){
        this.dato = dato;
        sig = null;
    }

    public void setDato(int dato){
        this.dato = dato;
    }

    public void setSiguinte(TNodo sig){
        this.sig = sig;
    }

    public int getDato(){
        return dato;
    }
    
    public TNodo getSiguiente(){
        return sig;
    }

    @Override
    public String toString(){
        String cadena;
        cadena = "Dato del nodo: " + Integer.toString(dato) + "\n";
        return cadena;
    }

} //Fin de clase nodo