#include<stdio.h>
#include<stdlib.h>

int main(){
    int *array; //arreglo
    int n; //tam

    printf("Ingrese el tamaño del arreglo\n");
    scanf("%d", &n);

    array = (int *)malloc(n * sizeof(int)); // array = (*)malloc( * sizeof());

    for (int i = 0; i < n; i++){
        printf("Posicion %d: ", i+1);
        scanf("%d", array+i);  //array[i];
    }

    printf("El arreglo es:\n");
    for (int i = 0; i < n; i++){
        printf("Posicion %d: %d\n", i+1, *(array+i));   //*(array+1);        array[i]
    }
    
    
    free(array);
    return 0;
}