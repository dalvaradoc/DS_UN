/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras.Stacks.Array;

import java.lang.reflect.Array;

/**
 *
 * @author Alejandro
 */
public class StackArray <T> {
    private T[] stack;
    int numElements;

    public StackArray(Class<T> c, int capacity) {
        //Esta parte la saque de: https://stackoverflow.com/questions/529085/how-to-create-a-generic-array-in-java
        stack = (T[])Array.newInstance(c, capacity);
        numElements = 0;
    }
    
    public void Push (T key){
        try {
            stack[numElements] = key;
            numElements++;
        } catch (Exception e) {
            System.out.println("Error, no hay mas espacio en la pila.");
        }
    }
    
    public T Top () {
        if (this.Empty()){
            return null;
        }
        return stack[numElements-1];
    }
    
    public T Pop () {
        if (this.Empty()){
            return null;
        }
        T temp = this.Top();
        stack[numElements-1] = null;
        numElements--;
        return temp;
    }
    
    public boolean Empty () {
        return numElements == 0;
    }
    
}
