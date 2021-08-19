/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep18;

/**
 *
 * @author Estudiante
 */
public class DoubleNode <T> {
    T key;
    DoubleNode<T> next;
    DoubleNode<T> prev;

    public DoubleNode() {
    }

    public DoubleNode(T key) {
        this.key = key;
        next = null;
        prev = null;
    }

    public DoubleNode(T key, DoubleNode<T> next, DoubleNode<T> prev) {
        this.key = key;
        this.next = next;
        this.prev = prev;
    }   
    
    
}
