package Arreglo;

import java.util.Scanner;

class TArreglo{
    private int arreglo[];
    private int n;
    private Scanner sc = new Scanner(System.in);

    TArreglo(int n){
        this.n = n;
        arreglo = new int[n];
    }

    public void setElemento(int i, int valor){
        arreglo[i] = valor;
    }

    public int getElemento(int i){
        return arreglo[i];
    }

    public void leerArreglo(){
        for (int i = 0; i < n; i++) {
            System.out.printf("arreglo[%d]: ", i);
            arreglo[i] = sc.nextInt();
        }
    }

    public void imprimeArreglo(){
        for (int i = 0; i < n; i++) {
            System.out.printf("arreglo[%d] = %d\n", i, arreglo[i]);
        }
    }

    public void ordenaArreglo(){
        int i, j, temp;

        for (i = 0; i < n; i++) {
            for (j = i+1; j < n; j++) {
                if (arreglo[i]>arreglo[j]) {
                    temp = arreglo[i];
                    arreglo[i] = arreglo[j];
                    arreglo[j] = temp;
                }
                
            }
            
        }
    }

    public void busquedasecuencial(int numbuscar){
        int Encontrado = 0;
        for(int i = 0; i < n; i++){
            if (arreglo[i] == numbuscar) {
                System.out.printf("El numero se encuentra en la posicion %d\n", i+1); //Mejora para el usuario
                Encontrado = Encontrado +1;                
            }
        }
        if (Encontrado == 0){
            System.out.printf("El numero no existe en el arreglo");
        }
    }

    public int busquedabinaria(int numbuscar){
        int inicio, fin, medio;
        inicio = 0;
        fin = n-1;
        while (inicio <= fin) {
            medio = (inicio + fin)/2;
            if(arreglo[medio] == numbuscar){
                return medio +1; //mejora para el usuario
            }else if (arreglo[medio] > numbuscar) {
                fin = medio - 1; //Izquierda vision personal
            }else if (arreglo[medio] < numbuscar) {
                inicio = medio + 1; // Derecha vision personal
            }
        }
        return 0;
    }

    public int busquedalineal(int numbuscar){
        for(int i = 0; i < n; i++){
            if (arreglo[i]== numbuscar) {
                return i+1;
            }
        }
        return 0;
    }


}  //fin de la clase TArreglo