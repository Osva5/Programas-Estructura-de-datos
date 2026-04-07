#include<stdio.h>
#include<stdlib.h>

int main(){
    int **matriz;
    int filas, columnas;

    printf("Ingrese el tamaño de las filas");
    scanf("%d", &filas);
    printf("Ingrese el tamaño de las columnas");
    scanf("%d", &columnas);

    matriz = (int**)malloc(filas * sizeof(int*));

    for (int i = 0; i < filas; i++){
        *(matriz+i) = (int*)malloc(columnas * sizeof(int));   //matriz[i]
    }

    printf("Ingrese los valores de la matriz\n");

    for (int i = 0; i < filas; i++){
        for (int j = 0; j < columnas; j++){
            printf("Posicion [%d][%d]: ", i+1, j+1 );
            scanf("%d", *(matriz +i)+j);
        }
    }

    printf("Mostrando matriz:\n");
    
    for (int i = 0; i < filas; i++){
        for (int j = 0; j < columnas; j++){
            printf("%d ", *(*(matriz+i)+j));  //matriz[i][j]
        }
        printf("\n");
    }
    
    free(matriz);
    return 0;
}