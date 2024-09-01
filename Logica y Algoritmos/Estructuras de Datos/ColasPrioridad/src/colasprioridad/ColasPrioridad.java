/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colasprioridad;

import Colas.ColaPrioridadAcot;
import Colas.ColaPrioridadNOAcot;
import Colas.PrioridadFueraDeRango;

/**
 *
 * @author Daniel Bermeo
 */
public class ColasPrioridad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ColaPrioridadAcot colaAct = new ColaPrioridadAcot(6);
        ColaPrioridadNOAcot colaNOAct = new ColaPrioridadNOAcot();

        System.out.println("Funcionamento cola No Acotada");
        colaNOAct.enqueue(4, "Maestre");
        colaNOAct.enqueue(2, "Niños");
        colaNOAct.enqueue(4, "Mecanicos");
        colaNOAct.enqueue(3, "Hombres");
        colaNOAct.enqueue(5, "Capitan");
        colaNOAct.enqueue(4, "Timonel");
        colaNOAct.enqueue(3, "Mujeres");
        colaNOAct.enqueue(2, "3ra edad");
        colaNOAct.enqueue(1, "Niñas");
        System.out.println(".\n.\n.\n");
        System.out.println("Cola cargada");

        System.out.println("\nTamaño de la cola: " + colaNOAct.lenght());
        System.out.println("Estado:\n " + colaNOAct);

        System.out.println("\nSe decargar la Cola no Acotada: ");
        while (!colaNOAct.isEmpty())
        {
            System.out.println(colaNOAct.dequeue());
        }

        System.out.println("\n\n\nFuncionamento cola Acotada");
        try
        {
            colaAct.enqueue(4, "Maestre");
            colaAct.enqueue(2, "Niños");
            colaAct.enqueue(4, "Mecanicos");
            colaAct.enqueue(3, "Hombres");
            colaAct.enqueue(5, "Capitan");
            colaAct.enqueue(4, "Timonel");
            colaAct.enqueue(3, "Mujeres");
            colaAct.enqueue(2, "3ra edad");
            colaAct.enqueue(1, "Niñas");
            
        } catch (PrioridadFueraDeRango ex)
        {
            System.out.println("Se intento añadir un elemento con prioridad fuera de rango");
        }
        System.out.println(".\n.\n.\n");

        System.out.println("Cola cargada");

        System.out.println("\nTamaño de la cola: " + colaAct.length());
        System.out.println("Estado\n: " + colaAct);

        System.out.println("\nse decargar la Cola no Acotada: ");
        while (!colaAct.isEmpty())
        {
            System.out.println(colaAct.dequeue());
        }
    }

}
