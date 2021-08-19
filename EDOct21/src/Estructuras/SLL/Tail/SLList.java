/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras.SLL.Tail;

/**
 *
 * @author Alejandro
 */
public class SLList <T> {
    Node<T> head;
    Node<T> tail;
    int length;

    public SLList() {
        head = null;
        tail = null;
        length = 0;
    }
    
    public void PushFront (T key) {
        length++;
        Node<T> node = new Node<T>(key);
        if (head == null){
            tail = node;
        }
        node.next = head;
        head = node;
    }
//    Key TopFront() return front item
    public T TopFront () {
        return head.key;
    }
//    PopFront() remove front item
    public void PopFront () {
        if (head == null){
            return;
        }
        length--;
        if (tail == head){
            tail = null;
        }
        head = head.next;
    }
//    PushBack(Key) add to back
    public void PushBack(T key){
        length++;
        Node<T> node = new Node<>(key);
        if (tail == null){
            tail = node;
            head = tail;
            return;
        }
        tail.next = node;
        tail = node;
    }
//    Key TopBack() return back item
    public T TopBack () {
        return tail.key;       
    }
//    PopBack() remove back item
    public void PopBack () {
        if (head == null){
            return;
        }
        
        length--;
        
        if (head.next == null){
            head = null;
            tail = null;
            return;
        }
        
        Node<T> temp = head;
        while (temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;
    }
//    Boolean Find(Key) is key in list?
    public boolean Find (T key){
        Node<T> temp = head;
        while (temp != null){
            if (temp.key.equals(key)){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
//    Erase(Key) remove key from list
    public void Erase (T key){
        if (head == null){
            return;
        }
        if (head.next == null){
            if (head.key.equals(key)){
                head = null;
                tail = null;
                length = 0;
                return;
            }
        }
        Node<T> temp = head;
        if (tail.key.equals(key)){
            while (temp.next.next != null){
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
            return;
        }
        while (temp.next.next != null){
            if (temp.next.key.equals(key)){
                temp.next = temp.next.next;
                length--;
                return;
            }
            temp = temp.next;
        }
    }
//    Boolean Empty() empty list?
    public boolean Empty () {
        return head == null;
    }
//    AddBefore(Node, Key) adds key before node
    public void AddBefore (Node<T> node, T key){
        if (head == null){
            return;
        }
        Node<T> newNode = new Node<>(key);
        if (head == node){
            newNode.next = head;
            head = newNode;
            length++;
            return;
        }
        Node<T> temp = head;
        while (temp.next != null){
            if (temp.next == node){
                newNode.next = temp.next;
                temp.next = newNode;
                length++;
                return;
            }
            temp = temp.next;
        }
        
        
    }
//    AddAfter(Node, Key)
    public void AddAfter (Node<T> node, T key){
//        Node<T> temp = head;
//        Node<T> newNode = new Node<>(key);
//        while (temp != null){
//            if (temp == node){
//                newNode.next = temp.next;
//                temp.next = newNode;
//                if (newNode.next == null){
//                    tail = newNode;
//                }
//                length++;
//                return;
//            }
//            temp = temp.next;
//        }
        length++;
        Node<T> newNode = new Node<>(key);
        newNode.next = node.next;
        node.next = newNode;
    }
    
    //Temp Function
    public void PrintAll () {
        Node<T> temp = head;
        while (temp != null){
            System.out.println(temp.key);
            temp = temp.next;
        }
    }
}
