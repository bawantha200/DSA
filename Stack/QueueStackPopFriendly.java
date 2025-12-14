/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package QueueStackPopFriendly;

/**
 *
 * @author Bawantha
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.NoSuchElementException;

public class QueueStackPopFriendly {

    private Queue<Integer> mainQueue = new LinkedList<>();
    private Queue<Integer> tempQueue = new LinkedList<>();
    
    public QueueStackPopFriendly(){
        mainQueue = new LinkedList<>();
        tempQueue = new LinkedList<>();
    }
    
    public boolean empty(){
        return mainQueue.isEmpty(); // isEmpty
    }
    
    public void push(int x){
        tempQueue.add(x);
        
        while(!mainQueue.isEmpty()){
            tempQueue.add((mainQueue.remove())); //moves all element except the last one from maineQueue to tempQueue
        }
        
        Queue<Integer> temp = mainQueue;
        mainQueue = tempQueue; // mainQueue now point to tempQueue
        tempQueue = temp; // empty tempQueue for next operation
    }
    
    public int pop(){
        if(empty()){
            throw new NoSuchElementException("Stack is empty!");
        }
        return mainQueue.remove(); // dequeue
    }
    
    public int peek(){
       if(empty()){
            throw new NoSuchElementException("Stack is empty!");
        }
       return mainQueue.peek(); // peek
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        QueueStackPopFriendly s = new QueueStackPopFriendly();
        
        System.out.println("Testing Queue Stack (Pop Friendly)\n");
        System.out.println("[  ]");
        System.out.println("isEmpty : " + s.empty());
        
        s.push(3);
        System.out.println("Push : 3");
        s.push(5);
        System.out.println("Push : 5");
        s.push(7);
        System.out.println("Push : 7");
        System.out.println("[3,5,7]");
        System.out.println("= = = = = = = =");
        
        try {
            System.out.println("Pop : " + s.pop()); // remove 7
        } catch (NoSuchElementException e) {
            System.out.println("Cannot pop - stack is empty. Moving to next operation...");
        }
        System.out.println("[3,5]\n");
        
        s.push(9);
        System.out.println("Push : 9");
        System.out.println("[3,5,9]\n");

        try {
            System.out.println("Pop : " + s.pop()); // remove 9
            System.out.println("[3,5]\n");
            
            System.out.println("Pop : " + s.pop()); // remove 5
            System.out.println("[3]\n");
            
            System.out.println("Peek : " + s.peek()); // show 3
            System.out.println("isEmpty : " + s.empty());
        } catch (NoSuchElementException e) {
            System.out.println("Cannot pop - stack is empty. Moving to next operation...");
        }   
    }
}

