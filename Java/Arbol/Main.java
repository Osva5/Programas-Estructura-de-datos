import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        char opc; 
        int dato; 

        System.out.println("Programa de arboles binarios de busqueda");
        System.out.println("Inserta el dato qeu sera la raiz");
        dato = sc.nextInt();
        TArbol arbol = new TArbol(dato);
        do{
            System.out.print("\nDame el dato a insertar en el ABB: ");
            dato = sc.nextInt();
            arbol.insertaDatoABB(arbol.devuelveRaiz(), dato);
            System.out.print("Deseas continuar (S/N): ");
            opc = sc2.nextLine().charAt(0);

        }while (opc == 's' || opc == 'S');
        System.out.println("\nRecorrido Preorder");
        arbol.imprimePreOrden(arbol.devuelveRaiz());
        System.out.println("\nRecorrido Inorder");
        arbol.imprimeInOrden(arbol.devuelveRaiz());
        System.out.println("\nRecorrido Postorder");
        arbol.imprimePostOrden(arbol.devuelveRaiz());

        sc.close();
        sc2.close();
    }
    
}//Fin clase Main
