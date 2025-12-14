/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package StackQueueEnqueueFriendly;

/**
 *
 * @author Bawantha
 */

import java.util.NoSuchElementException;
import java.util.Stack;

public class StackQueueEnqueueFriendly {
    
    private Stack<Integer> enStack = new Stack<>();
    private Stack<Integer> deStack = new Stack<>();
    
    public StackQueueEnqueueFriendly(){
        enStack = new Stack<>();
        deStack = new Stack<>();
    }
    
    public void enqueue(int x){
        enStack.push(x);
    }
    
    public int dequeue(){
        if(enStack.isEmpty()){
            throw new NoSuchElementException("Queue is empty!");
        }
        
        while(enStack.size()>1){
            deStack.push(enStack.pop());
        }
        
        int dequeued = enStack.pop();
        
        while (!deStack.isEmpty()){
            enStack.push(deStack.pop());
        }
        
        return dequeued;
    }
    
    public int peek(){
        if(enStack.empty()){
            throw new NoSuchElementException("Queue is empty!");
        }
        if(deStack.isEmpty()){
            while (!enStack.isEmpty()){
                deStack.push(enStack.pop());
            }
        }
        return deStack.peek();
    }
    
    public boolean empty(){
        return enStack.isEmpty() && deStack.isEmpty();
    }

    
    public static void main(String[] args) {
        // TODO code application logic here
        StackQueueEnqueueFriendly q = new StackQueueEnqueueFriendly();
        
        System.out.println("Testing Stack Queue Enequeue Friendly\n");
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

