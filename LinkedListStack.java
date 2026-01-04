/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package LinkedListStack;

/**
 *
 * @author Bawantha
 */
public class LinkedListStack {

    private static class Node{
        int data;
        Node next;
        
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    
    private Node head; //head is the top of sstack
    private int size;
    
    public LinkedListStack(){
        head = null;
        size = 0;
    }
    
    //push element on to top of the stack (add to head)
    public void push(int x){
        Node newNode = new Node(x);
        newNode.next = head;
        head = newNode;
        size++;
    }
    
    //removes and return the element on top of the stack (delete from head)
    public int pop(){
        if(isEmpty()){
            throw new java.util.NoSuchElementException("Stack is empty");
        }
        
        int data = head.data;
        head = head.next;
        size--;
        return data;
    }
    
    //return the element on top of the stack without removing
    public int peek(){
        if(isEmpty()){
            throw new java.util.NoSuchElementException("Stack is empty");
        }
        
        return head.data;
    }
    
    public boolean isEmpty(){
        return head == null;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        LinkedListStack list = new LinkedListStack();
        
        System.out.println("Testing Linked List Stack\n");
        System.out.println("isEmpty: " + list.isEmpty());
        System.out.println("Push: 3, 5, 7");
        list.push(3);
        list.push(5);
        list.push(7);
        
        System.out.println("Peek: " + list.peek());
       
        System.out.println("");
        
        System.out.println("Pop: " + list.pop());
        
        System.out.println("Peek: " + list.peek());
        
        System.out.println("isEmpty: " + list.isEmpty());
        
    }
    
}
