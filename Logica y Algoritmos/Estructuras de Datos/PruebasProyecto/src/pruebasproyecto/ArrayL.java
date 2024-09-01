package pruebasproyecto;
import java.util.ArrayList;
/**
 *
 * @author Daniel Bermeo
 */
public class ArrayL {

    public static void main(String[] args) {
        ArrayList array = new ArrayList();
        
        // Demostracion de añadir nuevos miembros
        System.out.println("Demostracion add: ");
        array.add("primero");
        array.add(0, "nuevo Primero");
        System.out.println(array);
        
        // Demostracion de un metodo de agregar especifico
        System.out.println("\nDemostracion addAll: ");
        array.addAll(array);
        System.out.println(array);
        
        // Demostracion de un metodo que limpia la lista
        System.out.println("\nDemostracion clear: ");
        ArrayList guardar = (ArrayList) array.clone();
        array.clear();
        System.out.println(array);
        
        // Demostracion del metodo que retorna su estado
        System.out.println("\nDemostracion isEmpty: ");
        System.out.println(array.isEmpty());
        array = guardar;
        
        // Usamos un metodo de busqueda, que indicara con 
        //un booleano el resultado al buscar un elemento 
        System.out.println("\nDemostracion contains: ");
        System.out.println("Buscando: primero = " 
                + array.contains("primero"));
        System.out.println("Busscando: Primero = " 
                + array.contains("Primero"));
        
        // Usamos un metodo de acceso a los elementos
        System.out.println("\nDemostracion get:");
        System.out.println(array.get(1));
        
        // Usamos un metodo que nos indica su tamaño
        System.out.println("\nDemostracion size:");
        System.out.println(array.size());
        
        // Usamos un metodo de modificacion de elementos
        System.out.println("\nDemostracion set:");
        array.set(1, "segundo");
        array.set(0, "primero");
        System.out.println(array);
        
        // Usamos un metodo destructivo
        System.out.println("\nDemostracion remove:");
        array.remove(3);
        array.remove("nuevo Primero");
        System.out.println(array);
        
        
    }
    
}
