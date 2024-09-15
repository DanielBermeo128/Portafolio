/*Muestra las variables y constantes*/
#include <stdio.h>
/*Define una constante para convertir libras a gramos*/
#define GRAMS_PER_POUND 454
/*Define una constante para el año que se quiere llegar*/
const int NEXT_DECADE = 2030;
/*Declara las variables necesarias*/
long weightInGrams, weightInPounds;
int yearOfBirthday, nextAge;

main(){
    /*Recibe entrada de datos del usuario*/
    printf("Enter your weight in pounds: ");
    scanf("%d",&weightInPounds);
    printf("Enter your year of birthday: ");
    scanf("%d", &yearOfBirthday);

    /*Ejecuta conversiones*/
    weightInGrams = weightInPounds * GRAMS_PER_POUND;
    nextAge = NEXT_DECADE - yearOfBirthday;

    /*Despliega los resultados en pantalla*/
    printf("Your weight in grams is: %ld",weightInGrams );
    printf("\nIn %d you will be %d years old", NEXT_DECADE, nextAge);

    return 0;
}