package Colas;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {

        TCola cola = new TCola();
        Scanner sc = new Scanner(System.in);
        int opc, cliente;
        int boletos = 5;   //cantidad de boletos

        do {
            System.out.println("\n---- Venta de Boletos ----");
            System.out.println("Boletos disponibles: " + boletos);
            System.out.println("1) Ingresar cliente");
            System.out.println("2) Vender boleto");
            System.out.println("3) Ver si hay clientes");
            System.out.println("4) Salir");
            opc = sc.nextInt();

            switch(opc) {
                case 1:
                    System.out.print("Numero del cliente: ");
                    cliente = sc.nextInt();
                    cola.insertaDato(cliente);
                    System.out.println("Cliente agregado a la fila");
                    break;
                case 2:
                    if(boletos == 0){
                        System.out.println("Ya no hay boletos");
                        break;
                    }

                    if(!cola.colaVacia()){
                        System.out.println("Boleto vendido al cliente: " + cola.eliminaDato());
                        boletos--;
                    }else{
                        System.out.println("No hay clientes en la fila");
                    }
                    break;

                case 3:
                    if(cola.colaVacia())
                        System.out.println("No hay clientes.");
                    else
                        System.out.println("Hay clientes esperando.");
                    break;
            }

        } while(opc != 4);

        System.out.println("Programa terminado.");
        sc.close();
    }

    
}
