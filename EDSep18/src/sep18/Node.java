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
public class Node <T> {
    private T key;
    private Node<T> next;

    public Node(T key) {
        this.key = key;
    }

    public Node(T key, Node<T> next) {
        this.key = key;
        this.next = next;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
