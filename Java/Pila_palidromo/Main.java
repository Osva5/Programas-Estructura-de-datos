package Pila_palidromo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        TPila pila = new TPila();
        Scanner sc = new Scanner(System.in);
        String palabra;
        boolean esPalindromo = true;

        System.out.println("Programa que indica si una palabra es palindromo (con pilas)");
        System.out.println("Dame una palabra:");
        palabra = sc.nextLine();

        // Insertar caracteres en la pila
        for (int i = 0; i < palabra.length(); i++) {
            pila.push(palabra.charAt(i));
        }

        // Comparar
        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) != pila.pop()) {
                esPalindromo = false;
                break;
            }
        }

        if (esPalindromo) {
            System.out.println("Es palindromo");
        } else {
            System.out.println("No es palindromo");
        }


        sc.close();
    }
}