/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package SinglyLinkedList;

/**
 *
 * @author Bawantha
 */

import java.util.NoSuchElementException;

public class SinglyLinkedList {

    private Node head; //first node
    private int size;
    
    //inner class
    private static class Node{
        int data; //data of node
        Node next; //reference to next node
        
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    
    public SinglyLinkedList(){
        head = null;
        size = 0;
    }
    
    // add new node at the beginning of the list
    public void addFirst(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }
    
    //add new node at the enf of the list
    public void addLast(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            size++;
            return;
        }
        
        Node current = head;
        while(current.next!=null){
            current = current.next;
        }
        
        current.next = newNode;
        size++;
    }
    
    //delete the node at the beggining of list
    public int deleteFirst(){
        if(head == null){
            throw new java.util.NoSuchElementException("List is empty.");
        }
        
        int data = head.data;
        head = head.next;
        size--;
        return data;
    }
    
    //delete the node at the beggining of list
    public int deleteLast(){
        if(head == null){
            throw new java.util.NoSuchElementException("List is empty.");
        }
        
        if(head.next==null){
            int data = head.data;
            head = null;
            size--;
            return data;
        }
        
        Node current = head;
        while(current.next.next!=null){
            current = current.next;
        }
        
        int data = current.next.data;
        current.next = null;
        size--;
        return data;
    }
    
    //delete the given value
    public boolean deleteByValue(int value){
        if(head == null){
            return false;
        }
        
        //value is in the first node
        if(head.data == value){
            head = head.next;
            size--;
            return true;
        }
        
        //travels to find the node
        Node current = head;
        while(current.next !=null && current.next.data !=value){
            current = current.next;
        }
        
        //value not found
        if(current.next == null){
            return false;
        }
        
        //remove node by skiping
        current.next = current.next.next;
        size--;
        
        return true;
    }
    
    //return the current size of list
    public int size(){
        return size;
    }
    
    //display the elements of the list
    public void display(){
        Node current = head;
        System.out.print("List: ");
        while (current!=null){
            System.out.print( current.data +" -> ");
            current = current.next;
        }
        System.out.println("null (size: "+size+" )");
    }
    public static void main(String[] args) {
        // TODO code application logic here
        SinglyLinkedList list = new SinglyLinkedList();
        
        System.out.println("Testing Singly Linked List\n");
        System.out.println("Add to front");
        list.addFirst(3);
        list.addFirst(5);
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
        
        System.out.println("Delete 10");
        if(list.deleteByValue(10)){
            System.out.println("Value deleted successfully.");
        } else {
            System.out.println("Value not found.");
        }
        list.display();
        System.out.println("");
        
        System.out.println("Delete 7");
        if(list.deleteByValue(7)){
            System.out.println("Value deleted successfully.");
        } else {
            System.out.println("Value not found.");
        }
        list.display();
        System.out.println("");
        
        System.out.println("Current size: " + list.size());
    }
    
}
