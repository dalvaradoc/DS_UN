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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        DoubleLinkedList dList = new DoubleLinkedList<>();
        System.out.println("Adicionando con PushFront...(x 5)");
        dList.PushFront(new DoubleNode<Integer>(1));
        dList.PushFront(new DoubleNode<Integer>(2));
        dList.PushFront(new DoubleNode<Integer>(3));
        dList.PushFront(new DoubleNode<Integer>(4));
        dList.PushFront(new DoubleNode<Integer>(5));
        
        System.out.println("Adicionando con PushBack... (x 5)");
        dList.PushBack(new DoubleNode<Integer>(6));
        dList.PushBack(new DoubleNode<Integer>(7));
        dList.PushBack(new DoubleNode<Integer>(8));
        dList.PushBack(new DoubleNode<Integer>(9));
        dList.PushBack(new DoubleNode<Integer>(0));
        
        System.out.println("Imprimiendo");
        dList.DisplayList();
    }
    
}
