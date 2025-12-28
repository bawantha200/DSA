/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ArrayCircularQueue;

/**
 *
 * @author Bawantha
 */

public class ArrayCircularQueue {

    private int[] data; //array
    private int front; //index of the element at the front of the queue
    private int rear; //index of the element's postion + 1 (next insertion point
    private int size; //current no of element
    private final int capacity; //maximum size of queue
 
    public ArrayCircularQueue(int k){
        capacity = k;
        data = new int[capacity];
        front = 0;
        rear = 0;
        size = 0;  
    }
    
    public boolean enqueue (int value){
        if(isFull()){
            return false;
        }
        data[rear] = value; //enqueue
        
        rear = (rear+1)%capacity; //circular update
        size++;
        return true;
    }
    
    public boolean dequeue (){
        if(isEmpty()){
            return false;
        }
        //dequeue
        front = (front+1)%capacity; //move front index circulary
        size--;
        return true;
    }
    
    public int peek(){
        if(isEmpty()){
            return -1; //gets the front element without removing it. return -1 if the queue is empptty
        }
        
        return data[front];
    }
    
    public boolean isEmpty(){
        return size == 0;
    }
    
    public boolean isFull(){
        return size == capacity;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayCircularQueue q = new ArrayCircularQueue(5);
        
        System.out.println("Testing ArrayCircularQueue\n");
        System.out.println("isEmpty : " + q.isEmpty());
        System.out.println("isFull : " + q.isFull());
        System.out.println("Peek : " + q.peek());       
        
        System.out.println("= = = = = = = =");
        q.enqueue(3);
        q.enqueue(5);
        q.enqueue(7);
        System.out.println("Enqueued : 3 , 5 , 7");
        System.out.println("isEmpty : " + q.isEmpty());
        
        System.out.println("Peek : " + q.peek()); 
        
        System.out.println("Dequeue : "+ q.peek()+" " + q.dequeue());
        System.out.println("Dequeue : " + q.peek()+" " + q.dequeue());
        
        System.out.println("Peek : " + q.peek());
        q.enqueue(9);
        q.enqueue(11);
        q.enqueue(13);
        q.enqueue(18);
        System.out.println("Enqueued : 9 , 11 , 13 , 18");
        
        System.out.println("isFull : "+ q.isFull());
        
        System.out.println("Try to enqueue(20) (should fail) : " + q.enqueue(20));
        System.out.println("Dequeue All");
        System.out.println("Dequeued : " + q.peek()+" " + q.dequeue());
        System.out.println("Dequeued : " + q.peek()+" " + q.dequeue());
        System.out.println("Dequeued : " + q.peek()+" " + q.dequeue());
        System.out.println("Dequeued : " + q.peek()+" " + q.dequeue());
        System.out.println("Dequeued : " + q.peek()+" " + q.dequeue());
        System.out.println("isEmpty : " + q.isEmpty());
        
    }
    
}
