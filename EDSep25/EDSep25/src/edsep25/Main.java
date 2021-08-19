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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Queue<String> myqueue = new Queue<>();
        myqueue.enQueue(new Node<String>("Batman"));
        
        Node<String> peekVar = myqueue.peek();
        System.out.println(peekVar.key);
    }
    
}
