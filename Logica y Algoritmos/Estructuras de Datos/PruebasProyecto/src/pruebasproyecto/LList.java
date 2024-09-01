package pruebasproyecto;

import java.util.LinkedList;

/**
 *
 * @author Daniel Bermeo
 */
public class LList {


    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        
        // Demostracion de añadir nuevos miembros
        System.out.println("Demostracion add: ");
        list.add("primero");
        list.add(0, "nuevo Primero");
        System.out.println(list);
        
        // Demostracion de un metodo de agregar especifico
        System.out.println("\nDemostracion addAll: ");
        list.addAll(list);
        System.out.println(list);
        
        // Demostracion de un metodo que limpia la lista
        System.out.println("\nDemostracion clear: ");
        LinkedList guardar = (LinkedList) list.clone();
        list.clear();
        System.out.println(list);
        
        // Demostracion del metodo que retorna su estado
        System.out.println("\nDemostracion isEmpty: ");
        System.out.println(list.isEmpty());
        list = guardar;
        
        // Usamos un metodo de busqueda, que indicara con 
        //un booleano el resultado al buscar un elemento 
        System.out.println("\nDemostracion contains: ");
        System.out.println("Buscando: primero = " 
                + list.contains("primero"));
        System.out.println("Busscando: Primero = " 
                + list.contains("Primero"));
        
        // Usamos un metodo de acceso a los elementos
        System.out.println("\nDemostracion get:");
        System.out.println(list.get(1));
        
        // Usamos un metodo que nos indica su tamaño
        System.out.println("\nDemostracion size:");
        System.out.println(list.size());
        
        // Usamos un metodo de modificacion de elementos
        System.out.println("\nDemostracion set:");
        list.set(1, "segundo");
        list.set(0, "primero");
        System.out.println(list);
        
        // Usamos un metodo destructivo
        System.out.println("\nDemostracion remove:");
        list.remove(3);
        list.remove("nuevo Primero");
        System.out.println(list);
        
    }
    
}
