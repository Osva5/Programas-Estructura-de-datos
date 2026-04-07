package Pila_estatica;

public class TPilaA {
    private int pila[];
    private int tope, n;

    TPilaA(int n){
        this.n = n;
        pila = new int[n];
        tope = 0;
    }

    public boolean pilaVacia(){
        return tope == 0;
    }

    public boolean pilaLlena(){
        return tope == n;
    }

    public void insertaDato(int dato){
        if(!pilaLlena())
            pila[tope++] = dato;
        else
            System.out.println("Error, pila llena  ¬¬");
    }

    public int eliminaDato(){
        int dato = Integer.MIN_VALUE;

        if(!pilaVacia())
            dato = pila[--tope];
        else
            System.out.println("Error, pila llena  ¬¬");

        return dato;
    }


    
}//Fin de clase TPilaA
