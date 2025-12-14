/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package QueueStackPushFriendly;

/**
 *
 * @author Bawantha
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.NoSuchElementException;

public class QueueStackPushFriendly {

    private Queue<Integer> mainQueue = new LinkedList<>();
    private Queue<Integer> tempQueue = new LinkedList<>();
    
    public QueueStackPushFriendly(){
        mainQueue = new LinkedList<>();
        tempQueue = new LinkedList<>();
    }
    
    public void push(int x){
        mainQueue.add(x); // enqueue
    }
    
    public boolean empty(){
        return mainQueue.isEmpty(); // isEmpty
    }
    
    public int pop(){
        if(empty()){
            throw new NoSuchElementException("Stack is empty!");
        }
        
        while(mainQueue.size()>1){
            tempQueue.add(mainQueue.remove()); //moves all element except the last one from maineQueue to tempQueue
        }
        
        int popped = mainQueue.remove(); // dequeue
        
        Queue<Integer> temp = mainQueue;
        mainQueue = tempQueue; // mainQueue now point to tempQueue
        tempQueue = temp; // empty tempQueue for next operation
        
        return popped;
    }
    
    public int peek(){
         if(empty()){
            throw new NoSuchElementException("Stack is empty!");
        }
        
        while(mainQueue.size()>1){
            tempQueue.add(mainQueue.remove()); //moves all element except the last one from maineQueue to tempQueue
        }
        
        int top = mainQueue.peek(); // peek
        tempQueue.add(mainQueue.remove()); // put element back
        
        Queue<Integer> temp = mainQueue;
        mainQueue = tempQueue; // mainQueue now point to tempQueue
        tempQueue = temp; // empty tempQueue for next operation
        
        return top;
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        QueueStackPushFriendly s = new QueueStackPushFriendly();
        
        System.out.println("Testing Queue Stack (Push Friendly)\n");
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
        
        System.out.println("Pop : " + s.pop()); // remove 7
        System.out.println("[3,5]\n");
        
        s.push(9);
        System.out.println("Push : 9");
        System.out.println("[3,5,9]\n");
        
        System.out.println("Pop : " + s.pop()); // remove 9
        System.out.println("[3,5]\n");
        
        System.out.println("Pop : " + s.pop()); // remove 5
        System.out.println("[3]\n");
        
        System.out.println("Peek : " + s.peek()); // show 3
        System.out.println("isEmpty : " + s.empty());
        
    }
    
}
