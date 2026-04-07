package Lista_enlazada;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        TLista lista = new TLista();
        Scanner sc = new Scanner(System.in);
        int dato, opc, menu;


        System.out.println("Programa de listas enlazadas");
        do{
            
        System.out.println("1) Insertar al Inicio ");
        System.out.println("2) Insertar al Final ");
        System.out.println("3) Mostrar lista ");
        System.out.println("4) Eliminar Dato ");
        System.out.println("5) Elimina Inicio ");
        System.out.println("6) Eliminar Lista ");
        System.out.println("7) Salir ");
        menu = sc.nextInt();
        switch (menu) {
            case 1:
                do{
                System.err.print("Dame el dato a insertar: ");
                dato = sc.nextInt();
                lista.insertaInicio(dato);
                opc = lista.deseacontinuar();
                }while(opc != 0);
                break;
            case 2:
                do{
                System.err.print("Dame el dato a insertar: ");
                dato = sc.nextInt();
                lista.insertaFinal(dato);
                opc = lista.deseacontinuar();
                }while(opc != 0);
                break;
            case 3:
                lista.muestraLista();
                break;
            case 4:
                System.out.println("Ingrese el dato a eliminar");
                dato = sc.nextInt();
                lista.eliminarDato(dato);
                break;
            case 5:
                lista.eliminarInicio();
                System.out.println("Se elimino el inicio de la lista");
                break;
            case 6:
                lista.eliminaLista();
                System.out.println("Lista eliminada");
                break;
            case 7:
                System.out.print("Saliendo del programa");
                break;
            default:
                System.out.print("Ingrese una opcion valida \n");
                break;
            }
        }while((menu != 7));
        sc.close();
    }//Fin de metodo main

}  //Fin clase Main
