/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras.Queues.Array;

import java.lang.reflect.Array;

/**
 *
 * @author Alejandro
 */
public class QueueArray <T> {
    private T[] queue;
    int capacity;
    int read,write;

    public QueueArray(Class<T> c, int cap) {
        //Esta parte la saque de: https://stackoverflow.com/questions/529085/how-to-create-a-generic-array-in-java
        queue = (T[])Array.newInstance(c, cap);
        this.capacity = cap;
        read = 0;
        write = 0;
    }
    
    public void Enqueue (T key){
        if (queue[write] != null){
            System.out.println("No hay mas espacio para agregar mas elementos");
            return;
        }
        
        queue[write] = key;
        write = (write+1)%capacity;
    }
    
    public T Dequeue (){
        if (queue[read] == null){
            return null;
        }
        
        T temp = queue[read];
        queue[read] = null;
        read = (read+1)%capacity;
        return temp;
    }
    
    public boolean Empty () {
        return read == write;
    }
    
    public T Top (){
        if (queue[read] == null){
            return null;
        }
        return queue[read];
    }
    
    public void TempPrintAll () {
        for (int i = 0; i < capacity; i++){
            System.out.print(queue[i] + " ");
        }
        System.out.println("");
    }
}
