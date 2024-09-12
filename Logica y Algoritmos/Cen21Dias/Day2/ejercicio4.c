/*¿Que hace el siguiente programa? (Tecleelo, compilelo y ejecutelo)*/
/*ejercicio4.c*/
/*Se recibe una cadena a la entrada y 
se regresa un conteo de los caracteres de la cadena*/

#include<stdio.h>
#include<string.h>

main(){
    char buffer[256];
    printf("Enter your name and press <Enter>:\n");
    gets(buffer);
    
    printf("\nYour name has %d characters and spaces!", strlen(buffer));

    return 0;
}