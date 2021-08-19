/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras.DLL.NoTail;

/**
 *
 * @author Alejandro
 */
public class DLListNT <T> {
    Node<T> head;
    int length;

    public DLListNT() {
        head = null;
        length = 0;
    }
    
//    PushFront(Key) add to front
    public void PushFront (T key) {
        length++;
        Node<T> node = new Node<T>(key);
        node.next = head;
        head.prev = node;
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
        head = head.next;
        head.prev = null;
    }
//    PushBack(Key) add to back
    public void PushBack(T key){
        length++;
        Node<T> node = new Node<>(key);
        if (head == null){
            head = node;
            return;
        }
//        Node<T> temp0 = head;
//        Node<T> temp1 = head.next;
//        while (temp1 != null){
//            temp0 = temp1;
//            temp1 = temp1.next;
//        }
//        temp0.next = node;
        Node<T> temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        node.prev = temp;
        temp.next = node;
        
    }
//    Key TopBack() return back item
    public T TopBack () {
        if (head == null){
            return null;
        }
        Node<T> temp0 = head;
        Node<T> temp1 = head.next;
        while (temp1 != null){
            temp0 = temp1;
            temp1 = temp1.next;
        }
        
        return temp0.key;        
    }
//    PopBack() remove back item
    public void PopBack () {
        if (head == null){
            return;
        }
        length--;
        if (head.next == null){
            head.next.prev = null;
            head = null;
            return;
        }
        Node<T> temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.prev.next = null;
        temp = null;
        
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
                length = 0;
                return;
            }
        }
        length--;
        Node<T> temp = head;
        while (temp.next.next != null){
            if (temp.next.key.equals(key)){
                temp.next.next.prev = temp;
                temp.next = temp.next.next;
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
//        if (head == null){
//            return;
//        }
//        Node<T> newNode = new Node<>(key);
//        if (head == node){
//            newNode.next = head;
//            head = newNode;
//            length++;
//            return;
//        }
//        Node<T> temp = head;
//        while (temp.next != null){
//            if (temp.next == node){
//                newNode.next = temp.next;
//                temp.next = newNode;
//                length++;
//                return;
//            }
//            temp = temp.next;
//        }

        if (node == null){
            return;
        }

        if (node == head){
            PushFront(key);
            return;
        }
        Node<T> newNode = new Node<>(key);
        node.prev.next = newNode;
        newNode.prev = node.prev.next;
        newNode.next = node;
        node.prev = newNode;
        
    }
//    AddAfter(Node, Key)
    public void AddAfter (Node<T> node, T key){
        //Deberia ser O(1)...
//        Node<T> temp = head;
//        Node<T> newNode = new Node<>(key);
//        while (temp != null){
//            if (temp == node){
//                newNode.next = temp.next;
//                temp.next = newNode;
//                length++;
//                return;
//            }
//            temp = temp.next;
//        }
        //Como "deberia ser":
        if (node == null){
            return;
        }
        
        if (node.next == null){
            PushBack(key);
        }
        
        length++;        
        Node<T> newNode = new Node<>(key);
        newNode.prev = node;
        newNode.next = node.next;
        node.next = newNode;
        newNode.next.prev = newNode;
        
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
