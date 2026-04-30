class TNodoA{
    private int dato;
    TNodoA izq, der; 

    TNodoA(){
        dato = 0; 
        izq = null; 
        der = null; 
    }
    
    TNodoA (int dato){
        this.dato = dato;
        izq = null; 
        der = null; 
    }
    public void setDato(int dato){
        this.dato = dato;
    }
    
    public void setIzq(TNodoA nodo){
        this.izq = nodo;
    }

    public void setDer(TNodoA nodo){
        this.der = nodo;
    }


    public int getDato(){
        return dato; 
    }

    public TNodoA getIzq(){
        return izq; 
    }

    public TNodoA getDer(){
        return der;
    }

    public void imprimeValor(){
        System.out.println(dato);
    }
} //Fin TNodoA