public class TArbol {
    private TNodoA raiz;

    TArbol(int dato){
        raiz = new TNodoA(dato);
    }

    public TNodoA devuelveRaiz(){
        return raiz;
    }

    public void insertaDatoABB(TNodoA raiz, int dato){
        if (raiz != null){
            if(dato < raiz.getDato()){
                if(raiz.getIzq() == null){
                    TNodoA nodo = new TNodoA(dato);
                    raiz.setIzq(nodo);
                }else
                    insertaDatoABB(raiz.getIzq(), dato);

            }else if(dato > raiz.getDato()){
                if(raiz.getDer() == null){
                    TNodoA nodo = new TNodoA(dato);
                    raiz.setDer(nodo);
                }else{
                    insertaDatoABB(raiz.getDer(), dato);
                }
            }else
                System.out.println("Dato existente en el arbol");
        }   
    }

    public void imprimePreOrden(TNodoA raiz){
        if (raiz != null){
            System.out.println(raiz.getDato());
            imprimePreOrden(raiz.getIzq());
            imprimePreOrden(raiz.getDer());
        }
    }

    public void imprimeInOrden(TNodoA raiz){
        if (raiz != null){
            imprimeInOrden(raiz.getIzq());
            System.out.println(raiz.getDato());
            imprimeInOrden(raiz.getDer());
        }
    }

    public void imprimePostOrden(TNodoA raiz){
        if (raiz != null){
            imprimePostOrden(raiz.getIzq());
            imprimePostOrden(raiz.getDer());
            System.out.println(raiz.getDato());
        }
    }

}
