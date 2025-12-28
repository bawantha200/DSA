/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package DoublyLinkedList;

/**
 *
 * @author Bawantha
 */
public class DoublyLinkedList {

    private Node head; // first node
    private Node tail; //last node
    private int size;
    
    //inner class
    private static class Node{
        int data;
        Node next;
        Node previous;
        
        public Node(int data){
            this.data = data;
            this.next = null;
            this.previous = null;
        }
    }
    
    public DoublyLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }
    
    // add new node at the beginning of the list
    public void addFirst(int data){
        Node newNode = new Node(data);
        
        if(head == null){
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }
        
        size++;
    }
    
    // add new node at the end of the list
    public void addLast(int data){
        Node newNode = new Node(data);
        
        if(tail==null){
            head = newNode;
            tail = newNode;
        } else {
            newNode.previous = tail;
            tail.next = newNode;
            tail = newNode;
        }
        
        size++;
    }
    
    //delete the node at the beginning of list
    public int deleteFirst(){
        if(head == null){
            throw new java.util.NoSuchElementException("List is empty.");
        }
        
        int data = head.data;
        if(head == tail){
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.previous = null;
        }
        
        size--;
        return data;
    }
    
    //delete the node at the end of list
    public int deleteLast(){
        if(head == null){
            throw new java.util.NoSuchElementException("List is empty.");
        }
        
        int data = tail.data;
        if(head == tail){
            head = null;
            tail = null;
        } else {
            tail = tail.previous;
            tail.next = null;
        }
        
        size--;
        return data;
    }
    
    //delete the given value
    public boolean deleteByValue(int value){
        if(head == null){
            return false;
        }
        
        Node current = head;
        
        //travels to find the node
        while(current.next !=null && current.next.data !=value){
            current = current.next;
        }
        
        //value not found
        if(current.next == null){
            return false;
        }
        
        //if the node to delete is head
        if(current == head){
            deleteFirst();
        }
        
        //if the node to delete is tail
        else if(current == tail){
            deleteLast();
        } 
        //if the node is in middle
        else {
            current.previous.next = current.next;
            current.next.previous = current.previous;
            size--;
        }
        
        return true;
    }
    
    //return the current size of list
    public int size(){
        return size;
    }
    
    public void displayForward(){
        Node current = head;
        System.out.print("List (Forward): ");
        while (current != null){
            System.out.print( current.data +" <-> ");
            current = current.next;
        }
        System.out.println("null (size: "+ size +" )");
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        DoublyLinkedList list = new DoublyLinkedList();
        
        System.out.println("Testing Doubly Linked List\n");
        System.out.println("Add to front");
        list.addFirst(3);
        list.addFirst(5);
        list.displayForward();
        System.out.println("");
        
        System.out.println("Add to back");
        list.addLast(7);
        list.addLast(9);
        list.displayForward();
        System.out.println("");
        
        System.out.println("Delete from front");
        list.deleteFirst();
        list.displayForward();
        System.out.println("");
        
        System.out.println("Delete from back");
        list.deleteLast();
        list.displayForward();
        System.out.println("");
        
        System.out.println("Delete 10");
        if(list.deleteByValue(10)){
            System.out.println("Value deleted successfully.");
        } else {
            System.out.println("Value not found.");
        }
        list.displayForward();
        System.out.println("");
        
        System.out.println("Delete 7");
        if(list.deleteByValue(7)){
            System.out.println("Value deleted successfully.");
        } else {
            System.out.println("Value not found.");
        }
        list.displayForward();
        System.out.println("");
        
        System.out.println("Current size: " + list.size());
    }
    
}
