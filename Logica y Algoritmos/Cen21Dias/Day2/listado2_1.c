/*Programa para calcular el producto de dos numeros*/

/*Archivos de encabezado o de inclusion*/
/*Arcivo de inclusion: archivo que contiene informacion que requerira el compilador*/
#include <stdio.h>

/*Definicion de variables*/
/*variable: nombre de una posicion de almacenamiento de datos*/
int a,b,c;
/*protoripo de funcion*/
/*proporciona nombre y argumentos de una funcion contenida en el programa*/
/*Debe aparecer antes que la funcion sea usada*/
int product(int x, int y);
/*La funcion main es un elemento obligatorio en cada programa en C*/
int main()
/*Las lineas contenidas entre llaves son un bloque de codigo*/
{
    /*Los enunciados son escritos uno por linea y siempre terminan con punto y coma*/
    /*printf imprime una cadena de caracteres por consola*/
    /*scanf escanea un tipo de dato del teclado y lo guarda en una variable dada*/
    /*Pide el primer numero*/
    printf("Enter a number between 1 and 100: ");
    scanf("%d",&a);
    /*Pide el segundo numero*/
    printf("Enter another number between 1 and 100: ");
    scanf("%d",&b);

    /*Calcula y despliega el producto*/
    /* Se LLAMA a la funcion product pasandole 2 argumentos (a,b)*/
    /* Cuando product retorne el entero se guardara en c*/
    c = product(a,b);
    printf("\n%d times %d = %d",a,b,c);

}
/*Funcion que regresa el producto de sus dos argumentos*/
/* Una funcion es una seccion de codigo independiente y autocontenida que realiza determinada tarea*/
/*Esta es una funcion definida por el usuario*/
int product(int x, int y){
    /*calcula y retorna el producto de los dos enteros recibidos*/
    return (x*y);
}
