/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package LinkedListFIFOQueue;

/**
 *
 * @author Bawantha
 */
public class LinkedListFIFOQueue {

    private static class Node{
        int data;
        Node next;
        
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    
    private Node head; //head is the front of the queue (for dequeue)
    private Node tail; //tail is the rear of the queue (for enqueue)
    private int size;
    
    public LinkedListFIFOQueue(){
        head = null;
        tail = null;
        size = 0;
    }
    
    //add elements to rear of the queue (add to tail)
    public void enqueue(int x){
        Node newNode = new Node(x);
        
        if(isEmpty()){
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
    
    //removes and return the element fromthe front of the queue (delete from queue)
    public int dequeue(){
        if(isEmpty()){
            throw new java.util.NoSuchElementException("Queue is empty");
        }
        int data = head.data;
        head = head.next;
        size--;
        
        //if the queue becomes empty, update tail to null too
        if(head == null){
            tail = null;
        }
        return data;
    }
    
    //return the elemnt at the front of the queue without removing
    public int peek(){
        if(isEmpty()){
            throw new java.util.NoSuchElementException("Queue is empty");
        }
        
        return head.data;
    }
    
    //return true if queue is empty
    public boolean isEmpty(){
        return head == null;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        LinkedListFIFOQueue list = new LinkedListFIFOQueue();
        
        System.out.println("Testing Linked List Stack\n");
        System.out.println("isEmpty: " + list.isEmpty());
        System.out.println("Push: 3, 5, 7");
        list.enqueue(3);
        list.enqueue(5);
        list.enqueue(7);
        
        System.out.println("Peek: " + list.peek());
       
        System.out.println("");
        
        System.out.println("Pop: " + list.dequeue());
        
        System.out.println("Peek: " + list.peek());
        
        System.out.println("isEmpty: " + list.isEmpty());

    }
    
}
