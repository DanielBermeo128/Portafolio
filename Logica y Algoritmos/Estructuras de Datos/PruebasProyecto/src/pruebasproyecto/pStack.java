package pruebasproyecto;

import java.util.Stack;

/**
 *
 * @author Daniel Bermeo
 */
public class pStack {

    public static void main(String[] args) {
        Stack stack = new Stack();
        
        //Agregamos elementos a la lista
        System.out.println("Demostarcion de push:");
        stack.push("primero");
        stack.push("segundo");
        stack.push("tercero");
        stack.push("cuarto");
        stack.push("quinto");
        System.out.println(stack);
        
        //Veremos cual es el tope de nuestra pila
        System.out.println("\nDemostarcion de peek:");
        System.out.println(stack.peek());
        
        
        // Usasmos el metodo de busqueda
        System.out.println("\nDemostarcion de search:");
        System.out.println(stack.search("tercero"));
        
        //Vaciamos la pila
        System.out.println("\nDemostarcion de pop:");
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
    
}
