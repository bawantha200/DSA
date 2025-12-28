/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package StackQueueDequeueFriendly;

/**
 *
 * @author Bawantha
 */

import java.util.Stack;
import java.util.NoSuchElementException;

public class StackQueueDequeueFriendly {

    private Stack<Integer> enStack = new Stack<>(); //tempory storage
    private Stack<Integer> deStack = new Stack<>(); //primary stack
    
    public StackQueueDequeueFriendly(){
        enStack = new Stack<>();
        deStack = new Stack<>();
    }
    
    public void enqueue(int x){
        while(!deStack.isEmpty()){
            enStack.push(deStack.pop()); //move all elements form deStack to enStack
        }
        
        enStack.push(x);
        
        while(!enStack.isEmpty()){
            deStack.push(enStack.pop()); //move all elements back form enStack to deStack
        }
    }
    
    public int dequeue(){
        if(empty()){
            throw new NoSuchElementException("Queue is empty");
        }
        
        return deStack.pop();
    }
    
    public int peek(){
        if(empty()){
            throw new NoSuchElementException("Queue is empty");
        }
        
        return deStack.peek();
    }
    
    public boolean empty(){
        return deStack.isEmpty();
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        StackQueueDequeueFriendly q = new StackQueueDequeueFriendly();
        
        System.out.println("Testing Stack Queue Dequeue Friendly\n");
        System.out.println("isEmpty : " + q.empty());
        System.out.println("[  ]");
        q.enqueue(3);
        System.out.println("Enqueue : 3");
        q.enqueue(5);
        System.out.println("Enqueue : 5");
        System.out.println("[ 3 , 5 ]");
        System.out.println("= = = = = =");
        
        try {
            System.out.println("Dequeue : " + q.dequeue());
            System.out.println("[ 5 ]");
            System.out.println("= = = = = =");
        } catch (NoSuchElementException e) {
            System.out.println("Cannot pop - stack is empty. Moving to next operation...");
        }

        q.enqueue(7);
        System.out.println("Enqueue : 7");
        System.out.println("[ 5 , 7 ]");
        System.out.println("= = = = = =");

        try {
            System.out.println("Dequeue : " + q.dequeue());
            System.out.println("[ 7 ]");
            System.out.println("= = = = = =");
        
            System.out.println("Peek : " + q.peek());
        } catch (NoSuchElementException e) {
            System.out.println("Cannot pop - stack is empty. Moving to next operation...");
        }
        
        System.out.println("isEmpty : " + q.empty());
 
    }
    
}
