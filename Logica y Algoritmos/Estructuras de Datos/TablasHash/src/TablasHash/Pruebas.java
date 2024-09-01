/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TablasHash;


/**
 *
 * @author Daniel Bermeo
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try
        {
            TablaHash<String> tablaH = new TablaHash(13);
            
            tablaH.Add(7, "Daniel");
            tablaH.Add("Carlos","Carlos");
            tablaH.Add("Pedro", "Pedro");
            tablaH.Add("Jesus", "Jesus");
            tablaH.Add(59, "Juan");
            tablaH.Add("A214", "Marcos");
            tablaH.Add(571, "Alejandro");
            tablaH.Add("Ernesto", "Ernesto");
            tablaH.Add(85, "Diego");
            tablaH.Add("KN95", "Armando");
            
            System.out.println(tablaH);
            
            System.out.println("Imprimimos unos algunos datos y los eliminamos: ");
            System.out.println(tablaH.valueOf(59));
            tablaH.remove(59);
            System.out.println(tablaH.valueOf("KN95"));
            tablaH.remove("KN95");
            System.out.println(tablaH.valueOf(7));
            tablaH.remove(7);
            System.out.println(tablaH.valueOf("Pedro"));
            tablaH.remove("Pedro");
            
            System.out.println(tablaH);
            
            
        } catch (ExepcionNoPrimo ex)
        {
            System.out.println("El numero ingresado no es primo");
        }
    }
    
}
