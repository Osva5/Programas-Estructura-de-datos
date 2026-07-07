/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

/**
 *
 * @author Osvaldo
 */
public class TNodo<T> {     //Que almacene cualquien tipo de dato 
    private T dato; // Ahora T puede ser un Vertice o una Arista
    private TNodo<T> sig;

    public TNodo() {        //Inicializa el nodo con null
        dato = null;
        sig = null;
    }

    public TNodo(T dato) {      //Constructor 
        this.dato = dato;
        this.sig = null;
    }

    public void setDato(T dato) {   //Recibe el dato 
        this.dato = dato; 
    }
    public void setSiguiente(TNodo<T> sig) { 
        this.sig = sig; 
    }
    public T getDato() {        //Retorna el valor 
        return dato; 
    }
    public TNodo<T> getSiguiente() { 
        return sig; 
    }
    
}
    
