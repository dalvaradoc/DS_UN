/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras.Queues.Lista;

/**
 *
 * @author Alejandro
 */
public class QueueList <T> {
    Node<T> head;
    Node<T> tail;

    public QueueList() {
        head = null;
        tail = head;
    }
    
    public void Enqueue (T key){
        Node<T> newNode = new Node<>(key);
        if (this.Empty()){
            head = newNode;
            tail = head;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }
    
    public T Dequeue () {
        if (this.Empty()){
            return null;
        }
        T temp = head.key;
        if (head.next == null){
            head = null;
            tail = head;
            return temp;
        }
        head = head.next;
        return temp;
    }
    
    public T Top () {
        if (this.Empty()){
            return null;
        }
        return head.key;
    }    
    
    public boolean Empty () {
        return head == null;
    }
    
    
}
