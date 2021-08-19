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
public class DoubleLinkedList <T>{
    
    DoubleNode<T> head = null;
    DoubleNode<T> tail = null;
    
    public void PushFront(T key){
        DoubleNode<T> node2 = new DoubleNode(key);
        
        if (this.head == null){
            this.tail = node2;
            this.head = tail;
        } else {
            node2.next = head;
            node2.prev = null;
            this.head = node2;
            this.head.next.prev = head;
        }
        if (this.tail == null){
            this.tail = this.head;
        }
    }
    
    public void PushBack (T key){
        DoubleNode<T> node2 = new DoubleNode(key);
        
        node2.next = null;
        node2.prev = tail;
        
        if (this.head == null){
            this.tail = node2;
            this.head = tail;
        } else {
            this.tail.next = node2;
            node2.prev = this.tail;
            this.tail = node2;
        }
    }
    
    public void PopBack () {
        if (this.head == null){
            System.out.println("Error!!!!. Lista Vacia.");
            return;
        }
        
        if (this.head == this.tail){
            this.tail = null;
            this.head = tail;
        }
        else {
            this.tail = this.tail.prev;
            this.tail.next = null;
        }
    }
    
    public DoubleNode FindByKey (T key){
        
        DoubleNode<T> dn = null;
        DoubleNode<T> p = this.head;
        
        while (p != null){
            if (p.key == key){
                dn = p;
                break;
            }
            p = p.next;
        }
        return dn;
    }
    
    public void Pop (T key){
        if (this.head == null){
            return;
        }
        
        if (this.head.key == key){
            this.head = this.tail = null;
        } else if (head.key == key){
            head = head.next;
        } else {
            DoubleNode anterior = head;
            DoubleNode p = head.next;
            
            while (p != tail && p.key != key) {
                if (p.key == key){
                    anterior.next = p.next;
                    p.next.prev = anterior;
                    p = null;
                }
                anterior = anterior.next;
                p = anterior.next;
            }
            
            if (p != null){
                anterior.next = p.next;
                if (p == tail){
                    tail = anterior;
                }
            }
        }
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    public void DisplayList () {
        if (this.head == null){
            System.out.println("Lista Vacia...");
        }
        
        DoubleNode<T> p = this.head;
        while (p != null){
            System.out.println(p.key);
            p = p.next;
        }
    }
    
    public void AddAfter (DoubleNode node, T key){
        DoubleNode<T> node2 = new DoubleNode(key);
        
        node2.next = node.next;
        node2.prev = node;
        node.next = node;
        
        if (node2.next != null){
            node2.next.prev = node2;
        }
        
        if (this.tail == node){
            this.tail = node2;
        }
    }
    
    public void AddBefore (DoubleNode node, T key){
        
        DoubleNode<T> node2 = new DoubleNode(key);
        
        node2.next = node;
        node2.prev = node.prev;
        node.prev = node2;
        
        if (node2.prev != null){
            node2.prev.next = node2;
        }
        
        if (this.head == node){
            this.head = node2;
        }
    }
    
    
}
