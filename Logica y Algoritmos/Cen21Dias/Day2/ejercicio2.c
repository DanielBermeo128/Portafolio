/*Ejercicio: comentar el codigo que se proporciona identificando sus partes*/
/*ejercicio2.c*/

#include <stdio.h> // inclusion de archivos

void display_line(void); // Prototipo de funcion

main(){
    display_line(); // Llamada de funcion
    printf("\n Teach Yourself C In 21 Days!\n"); // Enunciado
    display_line(); // Llamada de funcion
    
    return 0; // Enuncidado
}

/*Imprime una lineas de asteriscos*/
void display_line(void){ // Definicion de funcion
    int counter; // Declaracion de variable

    for(counter=0 ; counter<21 ; counter++) // Enunciado
        printf("*"); // Enunciado
}

/*Fin del programa*/