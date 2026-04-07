package Matriz;

import java.util.Scanner;

public class MMatriz {
    private int matriz[][];
    private int filas, columnas;
    private Scanner sc = new Scanner(System.in);
    
    MMatriz(int filas, int columnas){
        this.filas = filas;
        this.columnas = columnas;
        matriz = new int[filas][columnas];
    }

    public void setElemento(int filas, int columnas, int valor){
        matriz[filas][columnas] = valor;
    }

    public int getElemento(int filas, int columnas){
        return matriz[filas][columnas];
    }

    public void leerMatriz(){
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++){
                System.out.printf("Matriz[%d][%d]: ", i+1, j+1); //Mejora para el usuario
                matriz[i][j] = sc.nextInt();
            }
        }
    }

    public void imprimeMatriz(){
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.printf("%d ",  matriz[i][j]);
            }
            System.out.printf("\n");
        }
    }

    //cambiar componente (i,j)
    public void cambiarcomponente(){
        int numfila, numcolumna, nuevo;
        System.out.printf("Fila a cambiar:\n");
        numfila = sc.nextInt()-1; //mejora para usuario
        System.out.printf("Columna a cambiar\n");
        numcolumna = sc.nextInt()-1;
        System.out.printf("Ingrese el nuevo valor\n");
        nuevo = sc.nextInt();
        matriz[numfila][numcolumna] = nuevo;
    }

    //Devolver un componente
    public void devolvercomponente(){
        int nfila, ncolumna; // Mejora para el usuario
        System.out.printf("Ingrese la fila\n");
        nfila = sc.nextInt()-1;
        System.out.printf("Ingrese la columna\n");
        ncolumna = sc.nextInt()-1;
        System.out.printf("El componente es: %d\n", matriz[nfila][ncolumna]);
    }



    //Traza de la la matriz
    public void trazaMatriz(){
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                //if(i > 0){
                    System.out.printf("  ");
                //}
                if (i == j) {
                    System.out.printf("%d ", matriz[i][j]);                    
                }
            }
             System.out.printf("\n");
        }
    }


}