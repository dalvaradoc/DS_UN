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
 */
public class Node <T> implements Serializable{
    public T key;
    public Node<T> next;
    public Node<T> prev;

    public Node(T key) {
        this.key = key;
    }
}
