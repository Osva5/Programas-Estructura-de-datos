package Pila_estatica;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TPilaA pila = new TPilaA(100);
        Scanner sc = new Scanner(System.in);
        int dato, n, inicio;
        boolean iscapicua;

        System.out.println("Programa que indica si un numero es capicua (con pilas)");
        System.out.println("Dame un numero entero");
        dato = sc.nextInt();

        int numero[] = new int[100];
        int coc;
        n = 0;
        coc = dato;
        do{
            numero[n] = coc % 10;
            coc = coc / 10;
            n++;
        }while (coc != 0);


        
        if(n % 2 == 0){
            inicio = n/2;
        }else{
            inicio= n/2+1;
        }
        //Llenado de la pila 
        for(int i = 0; i < (n/2); i++){
            pila.insertaDato(numero[i]);
        }

        iscapicua = true;

        for(int i = inicio; i<n; i++){
            iscapicua = iscapicua && (numero[i] == pila.eliminaDato());
        }

        if(iscapicua){
            System.out.println("El numero "+ dato + " es capicua");
        }else{
            System.out.println("El numero NO es capicua");
        }

        sc.close();
    }
}
