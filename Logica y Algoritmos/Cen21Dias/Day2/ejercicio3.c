/*¿Que hace el siguiente programa? (Tecleelo, compilelo y ejecutelo)*/
/*Se imprime el alfabeto*/
/*ejercicio3.c*/

#include <stdio.h>

main(){
    // Se declara una variable de tipo entero
    int ctr;

    /*El ciclo inicia en 65 y termina en 90 lo cual imprimira 25 caracteres*/
    for(ctr=65;ctr<91;ctr++)
        /*Se imprimer el numero de caracter que se encuentre en la iteracion*/
        printf("%c",ctr);

    return 0;
}

/*Fin del programa*/