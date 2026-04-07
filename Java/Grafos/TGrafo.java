package Grafos;

import java.util.Scanner;

public class TGrafo {
    private int matrizA[][];
    private int matrizC[][];
    private int n;
    //private boolean visitados[];
    private int infinito = Integer.MAX_VALUE / 2;   // max value 2 ^31


    //Constructor
    TGrafo(int n){
        this.n = n;
        matrizA = new int[n][n];
        matrizC = new int[n][n];
        //visitados = new boolean[n];
    }


    public void leeMatrizA(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingresa los datos de la matriz de adyacencia");
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.printf("MA[%d][%d]: ", i+1, j+1);
                matrizA[i][j] = sc.nextInt();
                matrizA[j][i] = matrizA[i][j];
            }
            System.out.println();
        }
        sc.close();
    }
    
    public void leeMatrizC(){
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                matrizA[i][j] = 0;
            }
        }

        System.out.println("Ingresa los datos de la matriz de costos (Grafos dirigidos)");
        System.err.println("Si no hay camino pon -1");
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.printf("MA[%d][%d]: ", i+1, j+1);
                matrizA[i][j] = sc.nextInt();
                if (matrizC[i][j] == -1){
                    matrizC[i][j] = infinito;
                }else{
                    matrizA[i][j] = 1;
                }
            }
            System.out.println();
        }

        sc.close();
    }


    public void muestraMatrizA(){
        System.out.println("\nLa matriz de adyacencia es: ");
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.printf("%d\t", matrizA[i][j]);
            }
            System.out.println();
        }
    }

    public void muestraMatrizC(){
        System.out.println("\nLa matriz de costos es: ");
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if (matrizC[i][j] == infinito){
                    System.out.println("\u221E");    //Valor de infinito
                }else{
                    System.out.printf("%d\t", matrizC[i][j]);
                }
            }
            System.out.println();
        }
    }

}   //Fin clase TGrafo
