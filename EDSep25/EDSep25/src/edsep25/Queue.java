/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edsep25;

/**
 *
 * @author Estudiante
 */
interface IQueue<T> {
    void enQueue (Node<T> node);
    void deQueue (Node<T> node);
    boolean isEmpty();
    Node<T> peek ();
}

public class Queue<T> implements IQueue<T>{
    
    private int size;
    private Node<T> head;
    private Node<T> tail;

    public Queue() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    

    @Override
    public void enQueue(Node<T> node) {
        if (this.isEmpty()){
            this.head = node;
        }
        node.next = null;
        node.last = this.tail;
        this.tail = node;
        this.size++;
        
        
    }

    @Override
    public void deQueue(Node<T> node) {
        if (this.isEmpty()){
            System.out.println("Operacion no permitida.");
            return;
        }
        this.head = this.head.next;
        this.head.last = null;
        this.size--;
    }

    @Override
    public boolean isEmpty() {
        if (this.tail == null && this.head == null){
            return true;
        }
        return false;
    }

    @Override
    public Node<T> peek() {
        return this.head;
    }
    
}
