/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras.DA;

import java.lang.reflect.Array;

/**
 *
 * @author Alejandro
 */
public class DinamicArray <T> {
    T[] arr;
    int capacity;
    private int size;
    private Class<T> clase;

    public DinamicArray (Class<T> clase) {
        capacity = 1;
        arr = (T[])Array.newInstance(clase, capacity);
        size = 0;
        this.clase = clase;
    }
    
    public void PushBack (T key){
        if (capacity == size){
            this.Resize(capacity*2);
        }
        arr[size] = key;
        size++;
    }
    
    public void Resize (int n){
        T[] tempArray = (T[])Array.newInstance(clase, n);
        for (int i = 0; i < capacity; i++){
            tempArray[i] = arr[i];
        }
        arr = tempArray;
        capacity = n;
    }
    
    public T Get (int i){
        if (i < 0 || i > capacity-1){
            System.out.println("Error, fuera de limite.");
            return null;
        }
        return arr[i];
    }
    
    public void Set (int i, T val){
        if (i < 0 || i > capacity-1){
            return;
        }
        arr[i] = val;
    }
    
    public void Remove (int i){
        if (i < 0 || i > capacity-1){
            return;
        }
        for (int j = i; j < size-1; j++){
            arr[j] = arr[j+1];
        }
        size--;
    }
    
    public int Size (){
        return size;
    }
}
