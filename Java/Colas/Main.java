package Colas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        TCola colas = new TCola();
        Scanner sc = new Scanner(System.in);
        int dato, opc;


        System.out.println("Programa que indica los turnos (con colas)");
        System.out.println("Bienvenido a nuestro cunsultorio");
        
        do{
            System.out.println("Ingrese su turno");
            dato = sc.nextInt();
            colas.insertaDato(dato);
            opc = colas.preguntaTurno();
        }while (opc != 0);

        System.out.println("Turnos en pasar:");
        while (!colas.colaVacia()) {
            System.out.println("Turno: " + colas.eliminaDato());
        }

        System.out.println("No hay mas turnos");

        sc.close();
    }
}





