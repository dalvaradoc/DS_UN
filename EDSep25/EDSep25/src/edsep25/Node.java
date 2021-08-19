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
public class Node<T> {
    public Node<T> next;
    public Node<T> last;
    public T key;

    public Node(T key) {
        this.key = key;
    }
}
