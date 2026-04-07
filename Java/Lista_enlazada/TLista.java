package Lista_enlazada;

import java.util.Scanner;


public class TLista {
    private TNodo cab, fin;
    Scanner sc = new Scanner(System.in);
    
    TLista(){
        cab = new TNodo();
        fin = null;
    }

    public void insertaInicio(int dato){
        TNodo p = new TNodo(dato);

        if (cab.getSiguiente() == null){
            fin = p;
        }

        p.setSiguinte(cab.getSiguiente());
        cab.setSiguinte(p);
    }

    public void insertaFinal(int dato){
        TNodo p = new TNodo(dato);

        if(fin == null)
            cab.setSiguinte(p);
        else
            fin.setSiguinte(p);
        fin = p;
    }

    public void muestraLista(){
        TNodo p;
        p = cab.getSiguiente();
        if (p != null) {
            System.out.print("\nLos elementos de la lista son: \n");
            while (p != null) {
                System.out.println(p.getDato());
                p = p.getSiguiente();
            }
        }else{
            System.out.print("---Lista vacia---\n");
        }
    }

    public int deseacontinuar(){
        int preg;
        do{
        System.out.print("Deseas continuar (1-Si / 0-No): ");
        preg = sc.nextInt();
        if(preg != 1 && preg != 0){
            System.out.println("Ingrese dato correcto");
        }
        }while(preg  != 1 && preg != 0);
        return preg;
    }

    public void eliminaLista(){
        TNodo p; // aqui tambien podria estar la q, pero eso es mas para C
        p = cab.getSiguiente();
        while (p != null) {
            //q = p;
            p = p.getSiguiente();
            cab.setSiguinte(p);
            //Equivalente a free(p) en c
        }   
        fin = null;
    }

    public void insertaOrdenado(int dato){
        //ordena de menor a mayor
        TNodo p, q;
        p = new TNodo(dato);
        if(cab.getSiguiente() == null){
            cab.setSiguinte(p);
            fin = p;
        }else{
            q = cab;
            while (q.getSiguiente() != null && (q.getSiguiente()).getDato() < dato){
                q = q.getSiguiente();
            }
            if (q.getSiguiente() == null){
                q.setSiguinte(p);
                fin = p;
            }else{
                p.setSiguinte(q.getSiguiente());
                q.setSiguinte(p);
            }
        }
    }

    public int eliminarInicio(){
        TNodo p;
        int dato;
        p = cab.getSiguiente();
        if(p != null){
            dato = p.getDato();
            cab.setSiguinte(p.getSiguiente());
            if(p.getSiguiente() == null){
                fin = null;
                //delete(p) c++
            }
        }else{
            dato = Integer.MIN_VALUE;
            return dato;
        }
        return dato;
    }

    public TNodo devuelveDireccion(int dato){
        TNodo p;

        p = cab.getSiguiente();
        while (p != null && p.getDato() != dato){
            p = p.getSiguiente();
        }
        return p;
    }

    public TNodo devuelveDirAnterior(int dato){
        TNodo p;

        p = cab;
        while (p.getSiguiente() != null && (p.getSiguiente()).getDato() != dato){
            p = p.getSiguiente();
        }
        return p;
    }

    public void eliminarDato(int dato){
        TNodo p, q;
        p = devuelveDireccion(dato);
        q = devuelveDirAnterior(dato);
        if(p != null){
            if(p == fin){
                fin = q;
            }
            q.setSiguinte(p.getSiguiente());
            System.out.println("Dato eliminado");
        }else{
            System.out.println("Dato a eliminar no encontrado");
        }
    }

    public boolean listaVacia(){
        return cab.getSiguiente() == null;
    }

}
