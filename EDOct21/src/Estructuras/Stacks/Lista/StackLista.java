/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras.Stacks.Lista;

/**
 *
 * @author Alejandro
 */
public class StackLista <T> {
    Node<T> head;
    int numElemets;

    public StackLista() {
        head = null;
        numElemets = 0;
    }
    
    public void Push (T key){
        Node<T> newNode = new Node<>(key);
        if (this.Empty()){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }
    
    public T Top () {
        if (this.Empty()){
            return null;
        }
        return head.key;
    }
    
    public T Pop () {
        if (this.Empty()){
            return null;
        }
        T temp = head.key;
        if (head.next == null){
            head = null;
            return temp;
        }
        head = head.next;
        return temp;
    }
    
    public boolean Empty () {
        return head == null;
    }
    
    
}
