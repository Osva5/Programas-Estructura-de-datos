package Grafos;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TGrafo grafo;
        int n;
        Scanner sc = new Scanner(System.in);

        System.out.println("Porgrama de grafos");
        System.out.println("Dame el numero de vertices del grafo: ");
        n = sc.nextInt();
        grafo = new TGrafo(n);
        grafo.leeMatrizC();
        grafo.muestraMatrizA();
        grafo.muestraMatrizC();



        sc. close();
    }   //fin void main
    
}   //Fin clase Main

