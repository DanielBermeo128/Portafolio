/*Teclee el programa y compilelo
Ejercicio: describir que hace el programa*/

#include <stdio.h>

// se declaran dos variables enteras que seran nuestros contadores
int x,y;

//El resultado del programa es un rectangulo de 10 * 10 taches
main(){
    // Se aplican un for de  10 ciclos y cada que itera agrega un salto de linea a la salida
    for(x=0 ; x<10 ; x++,printf("\n"))
        // Se aplica un for anidado con 10 ciclos y cada que itera imprime un caracter
        for (y=0 ; y<10 ; y++)
            printf("%c",35);

    return 0;
}