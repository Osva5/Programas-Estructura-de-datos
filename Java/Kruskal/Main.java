package Kruskal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el número de vértices: ");
        int vertices = sc.nextInt();        //Ingresar el numero de vertices 

        GKruskal grafo = new GKruskal(vertices);    //Crear el objeto grafo para almacenar los vertices 

        System.out.print("Ingrese el número de aristas: ");
        int numAristas = sc.nextInt();      //Ingresar el numero de aristas 

        System.out.println("\nIngrese las aristas (origen destino costo)");
        System.out.println("Los vértices deben estar entre 0 y " + (vertices - 1));     //Instrucciones para el usuario
        System.out.println();

        for (int i = 0; i < numAristas; i++) {          //Repettir el ciclo de entradas, basado en el numero de aristas 
            System.out.println("Arista " + (i + 1) + ":");
            System.out.println("\n");

            System.out.print("Origen: ");
            int origen = sc.nextInt();

            System.out.print("Destino: ");      //Lectura de origen, destino y costo
            int destino = sc.nextInt();

            System.out.print("Costo: ");
            int costo = sc.nextInt();

            grafo.agregarArista(origen, destino, costo);       //guardar los datos en el objeto grafo y la arista en la lista
            System.out.println();
        }

        grafo.ejecutarKruskal();        //Llamamos al algoritmo de kruskal

        sc.close();
    }
}