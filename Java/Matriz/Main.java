package Matriz;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MMatriz M;
        int filas, columnas; 
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el numero de filas\n");
        filas = sc.nextInt();
        System.out.println("Ingrese el numero de columnas\n");
        columnas = sc.nextInt();
        M = new MMatriz(filas, columnas);
        System.out.println("Ingresa los datos de la Matriz\n");
        M.leerMatriz();
        System.out.println("Los elementos del arreglo son:\n");
        M.imprimeMatriz();
        System.out.println("Cambio de componente:\n");
        M.cambiarcomponente();
        M.imprimeMatriz();
        System.out.println("Devolver componente:\n");
        M.devolvercomponente();
        //M.imprimeMatriz();
        System.out.println("La traza de la matriz es:\n");
        M.trazaMatriz();
        

        sc.close();

        


    }
    
}
