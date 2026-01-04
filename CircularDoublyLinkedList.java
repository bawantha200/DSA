/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package CircularDoublyLinkedList;

/**
 *
 * @author Bawantha
 */
public class CircularDoublyLinkedList {

    private static class Node{
        int data;
        Node next;
        Node previous;
        
        public Node(int data){
            this.data = data;
            this.next = this;
            this.previous = this;
        }
    }
    
    private Node head; //reference to first nod
    private int size;
    
    public CircularDoublyLinkedList(){
        head = null;
        size = 0;
    }
    
    public boolean isEmpty(){
        return head == null;
    }
    
    public void addFirst(int data){
        Node newNode = new Node(data);
        
        if(isEmpty()){
            head = newNode;
        } else {
            Node tail = head.previous; // last node
            
            newNode.next = head;
            newNode.previous = tail;
            
            head.previous = newNode;
            tail.next = newNode;
            
            head = newNode; // new node is new head
        }
        size++;
    }
    
    public void addLast(int data){
        
        if(isEmpty()){
            addFirst(data);
            return;
        }
        
            Node newNode = new Node(data);
            Node tail = head.previous; // last node
            
            newNode.next = head;
            newNode.previous = tail;

            tail.next = newNode;
            head.previous = newNode;
   
        size++;
    }
    
    public int deleteFirst(){
    
        if(isEmpty()){
            throw new java.util.NoSuchElementException("List is Empty.");
        }
        int data = head.data;
        
        if(size == 1){
            head = null;
        } else {
            Node tail = head.previous;
            head = head.next;
            
            head.previous = tail; //new head's previous points to the old tail
            tail.next = head; //old tail's next point to the new head
        }
        size--;
        return data;
}
    
    public int deleteLast(){
        
        if(isEmpty()){
            throw new java.util.NoSuchElementException("List is Empty.");
        }
        
        Node tail = head.previous;
        int data = tail.data;
        
        if(size == 1){
            head = null;
        } else {
            Node newTail = tail.previous;
            newTail.next = head;
            head.previous = newTail;
            
            head.previous = tail; //old head's previous point to the new tail
            tail.next = head; //new tails's next point to the old head
        }
        size--;
        return data;
    }
    
    public int size(){
        return size;
    }
    
    public void display(){
        if(isEmpty()){
            System.out.println("List: Empty");
            return;
        }
        
        Node current = head;
        System.out.print("List (Size: " + size + "): ");
        
        do{
            System.out.print(current.data + " <-> ");
            current = current.next;
        } while (current != head); //loo[ run until wrap back around to the head
        
        System.out.println("(...circular)");
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        CircularDoublyLinkedList list = new CircularDoublyLinkedList();
        
        System.out.println("Testing Circular Doubly Linked List\n");
        System.out.println("Add to front");
        list.addFirst(3);
        list.addFirst(5);
        list.addFirst(6);
        list.addFirst(8);
        list.display();
        System.out.println("");
        
        System.out.println("Add to back");
        list.addLast(7);
        list.addLast(9);
        list.display();
        System.out.println("");
        
        System.out.println("Delete from front");
        list.deleteFirst();
        list.display();
        System.out.println("");
        
        System.out.println("Delete from back");
        list.deleteLast();
        list.display();
        System.out.println("");
        
        System.out.println("Current size: " + list.size());
    }
    
    }
    
