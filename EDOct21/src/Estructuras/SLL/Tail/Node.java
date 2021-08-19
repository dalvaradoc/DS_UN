/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras.SLL.Tail;

import Estructuras.SLL.NoTail.*;

/**
 *
 * @author Alejandro
 */
public class Node <T> {
    T key;
    Node<T> next;

    public Node(T key) {
        this.key = key;
        next = null;
    }
}
