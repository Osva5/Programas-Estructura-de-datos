package Arreglo;
import java.util.Scanner;

class Main{
    public static void main(String args[]){
        TArreglo A;
        int n, numbuscar;
        Scanner sc = new Scanner(System.in);  // Crear un objeto Scanner para leer desde la entrada estándar (teclado)



        System.out.println("\nEstructura de datos arreglo");
        System.out.println("\nDame el tama\u00f1o del arreglo");
        n = sc.nextInt();
        A = new TArreglo(n);
        System.out.println("\nIngresa los datos del arreglo");
        A.leerArreglo();
        System.out.println("\nLos elementos del arreglo son:");
        A.imprimeArreglo();
        System.out.println("\nEl arreglo ordenado es:");
        A.ordenaArreglo();
        A.imprimeArreglo();
        System.out.println("Ingresa el numero que deseas buscar");
        numbuscar = sc.nextInt();
        A.busquedasecuencial(numbuscar);
        if (A.busquedabinaria(numbuscar) != 0){
            System.err.printf("El numero se encunetra en la posicion %d\n", A.busquedabinaria(numbuscar));
        }else{
            System.err.printf("El numero no se encontro en el Arreglo");
        }
        if (A.busquedalineal(numbuscar) != 0){
            System.err.printf("El numero se encunetra en la posicion %d\n", A.busquedabinaria(numbuscar));
        }else{
            System.err.printf("El numero no se encontro en el Arreglo");
        }

        A.imprimeArreglo();

        sc.close();
    }//fin metodo main

} // fin clase Main4