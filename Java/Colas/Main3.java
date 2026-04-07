package Colas;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {

        TCola colas = new TCola();
        Scanner sc = new Scanner(System.in);
        int dato, opc;

        System.out.println("Programa de cola dinamica");
        do{
            System.out.println("\n1) Inserta datos en la cola");
            System.out.println("2) Elimina datos de la cola");
            System.out.println("3) Mostrar datos de la cola");
            System.out.println("4) Salir");
            System.out.println("Dame la opcion ");
            opc = sc.nextInt();

            switch (opc){
                case 1:
                    System.out.println("Dame el dato entero a ingrear en la cola");
                    dato = sc.nextInt();
                    colas.insertaDato(dato);
                    break;
                case 2:
                    if(!colas.colaVacia()){
                        System.out.println("El dato a eliminar es: " + colas.eliminaDato());
                    }else{
                        System.out.println("La cola esta vacia");
                    }
                    break;
                case 3:
                    System.out.println("Los datos de la cola son: \n");
                    if(!colas.colaVacia()){
                        colas.mostrar();
                    }else{
                        System.out.println("Cola vacia, ingrese datos\n");
                    }
                    break;
                case 4:
                    System.out.println("Bye :D");
                    break;
                default:
                    System.out.println("Ingrese una opcion correcta\n");
                    break;
            }
        }while( opc != 4);

        sc.close();
    }
}