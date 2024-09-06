/*Busqueda de errores

Se debe encontrar el error de acuerdo a lo lanzado por el compilador*/

#include <stdio.h>
/* Error: El agregar el nombre de la funcion mas los parentesis y el 
punto y coma es la invocacion de la funcion no su definicion */ 
// siguiente linea original:main();
main()
{
    printf("Keep looking!");
    printf("You\'l find it!");
    return 0;
}