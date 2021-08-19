/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List;

import java.io.Serializable;

/**
 *
 * @author Alejandro
 * @param <T>
 */
public class DoubleLinkedList <T> implements Serializable{
    //private static final long serialVersionUID = 3035749275265631505L;
    private Node<T> head;
    private Node<T> tail;
    public int size;

    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
        size = 0;
    }
    
    public void PushFront (T key){
        Node<T> node = new Node<T>(key);
        if (this.head != null){
            this.head.prev = node;
        }
        node.prev = null;
        node.next = this.head;
        this.head = node;
        if (this.tail == null){
            this.tail = this.head;
        }
        size++;
    }
    
    public T TopFront (){
        return this.head.key;
    }
    
    public void PopFront (){
        if (this.head != null){
            if (this.head.next == null){
                this.tail = null;
            }
            this.head = this.head.next;
            if (this.head != null){
                this.head.prev = null;
            }
        }
        size--;
    }
    
    public void PushBack (T key){
        Node<T> node = new Node<T>(key);
        if (this.tail != null){
            this.tail.next = node;
        }
        node.prev = this.tail;
        node.next = null;
        this.tail = node;
        if (this.head == null){
            this.head = this.tail;
        }
        size++;
    }
    
    public T TopBack (){
        return this.tail.key;
    }
    
    public void PopBack () {
        if (this.tail != null){
            if (this.tail.prev == null){
                this.head = null;
            }
            this.tail = this.tail.prev;
            if (this.tail != null){
                this.tail.next = null;
            }
        }
        size--;
    }
    
    public boolean Find (T key){
        Node<T> node = this.head;
        while (node != null){
            if (node.key == key){
                return true;
            }
            node = node.next;
        }
        return false;
    }
    
    public void Erase (T key){
        if (this.head.key == key) {
            this.head = this.head.next;
            this.head.prev = null;
            size--;
            return;
        }
        if (this.tail.key == key){
            this.tail = this.tail.prev;
            this.tail.next = null;
            size--;
            return;
        }
        Node<T> node = this.head.next;
        while (node != null){
            if (node.key == key){
                node.prev.next = node.next;
                node.next.prev = node.prev;
                node = null;
                size--;
                return;
            }
            node = node.next;
        }
    }
    
    public boolean EmptyList () {
        return this.head == null && this.tail == null;
    }
    
    public void AddBefore (Node<T> node, T key){
        if (node == this.head){
            this.PushFront(key);
            return;
        }
        Node<T> newNode = new Node<>(key);
        node.prev.next = newNode;
        newNode.prev = node.prev;
        newNode.next = node;
        node.prev = node;
        size++;
    }
    
    public void AddAfter (Node<T> node, T key){
        if (node == this.tail){
            this.PushBack(key);
            return;
        }
        Node<T> newNode = new Node<>(key);
        node.next.prev = newNode;
        newNode.next = node.next;
        size++;
    }
    
    public T getItem (int i){
        Node<T> node = this.head;
        while (i > 0){
            if (node == null){
                return null;
            }
            node = node.next;
            i--;
        }
        if (node == null){
            return null;
        }
        return node.key;
    }
    
}
