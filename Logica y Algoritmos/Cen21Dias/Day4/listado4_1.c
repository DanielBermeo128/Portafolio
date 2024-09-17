/*Demuestra los modos prefijo y posfijo de operadores unarios*/

#include <stdio.h>

int a,b;

main(){
    /* Pone a y b igual a 5 */

    a = b = 5;

    /*Los imprime decrementandolos cada vez*/
    /*Usa el modo prefijo para b y el modo posfijo para a*/
    printf("\na: %d   b:%d",a--,--b);
    printf("\na: %d   b:%d",a--,--b);
    printf("\na: %d   b:%d",a--,--b);
    printf("\na: %d   b:%d",a--,--b);
    printf("\na: %d   b:%d",a--,--b);

    return 0;
}