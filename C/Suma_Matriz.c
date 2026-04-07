#include <stdio.h>
#include <stdlib.h>

int main (){
    int **matriz1, **matriz2, **matriz3;
    int filas, columnas;

    printf("-----------Programa para realizar suma de Matriz-----------\n");

    printf("Ingrese el tamano de las matrices (Filas)\n");
    scanf("%d", &filas);
    printf("Ingrese el tamano de la matrices (Columnas)\n");
    scanf("%d", &columnas);
    //Para la suma de matrices, las filas y columnas son igual en tamaño 

    matriz1 = (int**)malloc(filas * sizeof(int*));
    matriz2 = (int**)malloc(filas * sizeof(int*));
    matriz3 = (int**)malloc(filas * sizeof(int*));

    for (int i = 0; i < filas; i++){
        *(matriz1+i) = (int*)malloc(columnas * sizeof(int));
        *(matriz2+i) = (int*)malloc(columnas * sizeof(int));
        *(matriz3+i) = (int*)malloc(columnas * sizeof(int));
    }

    printf("Ingrese los valores de la primer matriz\n");
    for (int i = 0; i < filas; i++){
        for (int j = 0; j < columnas; j++){
            printf("Posicion [%d][%d]: ", i+1, j+1);
            scanf("%d", *(matriz1+i)+j); 
        }
    }

    printf("Ingrese los valores de la segunda matriz\n");
    for (int i = 0; i < filas; i++){
        for (int j = 0; j < columnas; j++){
            printf("Posicion [%d][%d]: ", i+1, j+1);
            scanf("%d", *(matriz2+i)+j); 
        }
    }
    
    //Mostrar matriz 1
    printf("\nMatriz 1: \n");
    for (int i = 0; i < filas; i++){
        for (int j = 0; j < columnas; j++){
            printf("%d ", *(*(matriz1+i)+j));
        }
        printf("\n");
    }
    
    //Mostrar matriz 2
    printf("\nMatriz 2: \n");
    for (int i = 0; i < filas; i++){
        for (int j = 0; j < columnas; j++){
            printf("%d ", *(*(matriz2+i)+j));
        }
        printf("\n");
    }
    

    for (int i = 0; i < filas; i++){
        for (int j = 0; j < columnas; j++){
            *(*(matriz3+i)+j) = *(*(matriz1+i)+j) + *(*(matriz2+i)+j);  //sintaxis necesaria para acceder al contenido de la matriz
        }
    }

    //Mostrar matriz resultante
    printf("\nMatriz resultante de la suma: \n");
    for (int i = 0; i < filas; i++){
        for (int j = 0; j < columnas; j++){
            printf("%d ", *(*(matriz3+i)+j));
        }
        printf("\n");
    }

    //Liberar memoria de las matrizes

    for (int i = 0; i < filas; i++){
        free(*(matriz1+i));
        free(*(matriz2+i));
        free(*(matriz3+i));
    }

    free(matriz1);
    free(matriz2);
    free(matriz3);

    return 0;
}