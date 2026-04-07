#include <stdio.h>
#include <stdlib.h>

int **crearMatriz(int filas, int columnas){
    int **matriz = malloc(filas * sizeof(int*));
    int *datos = malloc(filas * columnas * sizeof(int));   //pedir memoria para los datos
    //filas * columnas para sacar la dimencion del arreglo 

    for (int i = 0; i < filas; i++){
        *(matriz+i) = datos + i * columnas; //la palabra datos viene aca por que es la direccion inicial
        //Osea que es el puntero inicial 
        // i * columnas desplaza al inicio de la fila correcta

    }
    return matriz;
}

void mostrar_Matriz(int **matriz, int filas, int columnas){
    for (int i = 0; i < filas; i++){
        for (int j = 0; j < columnas; j++){
            printf("%d ", *(*(matriz+i)+j));
        }
        printf("\n");
    }
}

void liberar_Memoria(int **matriz){
    free(*(matriz+0));     //Liberamos lo asignado con datos
                          //Primero el bloque de datos

    free(matriz);        //Segundo el arreglo de punteros
                        //liberamos la matriz
}


int main(){
    int filas1, columnas1, filas2, columnas2;
    int **matriz1, **matriz2, **matriz3;


    printf("-----------Ingrese el tamano de la primer matriz---------------\n");
    printf("Ingrese el tamano de las fila\n");
    scanf("%d", &filas1);
    printf("Ingrese el tamano de las columnas\n");
    scanf("%d", &columnas1);

    matriz1 = crearMatriz(filas1, columnas1);


    printf("Ingrese los valores de la primer matriz\n");
    for (int i = 0; i < filas1; i++){
        for (int j = 0; j < columnas1; j++){
            printf("Posicion [%d][%d]: ", i+1, j+1);
            scanf("%d", *(matriz1+i)+j);
        }
    }

    printf("-----------Ingrese el tamano de la segunda matriz---------------\n");
    printf("Ingrese el tamano de las fila\n");
    scanf("%d", &filas2);
    printf("Ingrese el tamano de las columnas\n");
    scanf("%d", &columnas2);

    if (columnas1 != filas2){
        printf("La multiplicacion no puede realizarse por las reglas de multiplicacion de matriz\n");
        return 0;
    }

    matriz2 = crearMatriz(filas2, columnas2);
    matriz3 = crearMatriz(filas1, columnas2);

    printf("Ingrese los valores de la segunda matriz\n");
    for (int i = 0; i < filas2; i++){
        for (int j = 0; j < columnas2; j++){
            printf("Posicion [%d][%d]: ", i+1, j+1);
            scanf("%d", *(matriz2+i)+j);
        }
    }

    //Multiplicacion de matrices
    for (int i = 0; i < filas1; i++){
        for (int j = 0; j < columnas2; j++){
            *(*(matriz3+i)+j) = 0;           //Asignar con 0 cada posicion antes de ser usada
            for (int k = 0; k < columnas1; k++){
                *(*(matriz3+i)+j) += *(*(matriz1+i)+k) * *(*(matriz2+k)+j);
                // i recoore la fila de la matriz 1
                // j recorre la columna de la matriz 2
                // se multiplica y se suma 
            }
            
        }
    }

    printf("\nMatriz 1: \n");
    mostrar_Matriz(matriz1, filas1, columnas1);
    printf("\nMatriz 2: \n");
    mostrar_Matriz(matriz2, filas2, columnas2);
    printf("\nMatriz resultante: \n");
    mostrar_Matriz(matriz3, filas1, columnas2);


    liberar_Memoria(matriz1);
    liberar_Memoria(matriz2);
    liberar_Memoria(matriz3);

    return 0;
}
