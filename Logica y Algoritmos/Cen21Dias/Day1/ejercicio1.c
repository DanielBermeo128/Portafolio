/*Teclee el programa y compilelo
Ejercicio: describir que hace el programa*/

#include <stdio.h>

// Se declaran dos enteros
int radius,area;
// El programa obtiene el area de un circulo
main(){
    // Se solicita el radio
    printf("Enter radius(i.e.10): ");
    // Se recibe una entrada en la terminal
    scanf("%d",&radius);
    // Se aplica la formula de area del circulo y se guarda en la variable area
    /*Recomendacion: 
        Seria mucho mejor aplicar una variable de punto flotante para esta aplicacion
    */
    area = 3.14159 * radius * radius;
    
    printf("\n\nArea = %d", area); // Se imprime el area del circulo
    return 0;
}