/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package UnboundedArrayStack;

import java.util.NoSuchElementException;

/**
 *
 * @author Bawantha
 */
public class UnboundedArrayStack {

    private int[] arr;
    private int top;
    
    public UnboundedArrayStack(){
        arr = new int[2];
        top = -1; //stack is empty
    }
    
    public void push(int x){
        if(top == arr.length - 1){
            resize(arr.length * 2); //if the array is full, doble its size
        }
        arr[++top] = x;
    }
    
    public int pop(){
        if(top == -1){
            throw new NoSuchElementException("Stack is empty!");
        }
        
        int value = arr[top--];
        
        if(top > 0 && top == arr.length/4){
            resize(arr.length/2); //half the array size if it is 1/4 full
        }
        return value;
    }
    
    public boolean empty(){
        return top == -1;
    }    
    public int top(){
        if(empty()){
            throw new NoSuchElementException("Stack is empty!");
        }
        return arr[top]; //get the top element
    }
    
    private void resize(int newSize){
        int[] newArr = new int[newSize];
        for(int i = 0; i <= top; i++){
            newArr[i] = arr[i]; //copy the current element in to the new array
        }
        arr = newArr;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        UnboundedArrayStack s = new UnboundedArrayStack();
        
        System.out.println("Testing Unbounded Array Stack\n");
        System.out.println("isEmpty : " + s.empty());
        System.out.println("Current Array Size: " + s.top);       
        System.out.println("Current Array Capacity: " + s.arr.length);

        System.out.println("= = = = = = = =");
        s.push(3);
        System.out.println("Push : 3 Current Array size(index) : " + s.top + " Current Array Capacity(length) : " + s.arr.length);
        s.push(5);
        System.out.println("Push : 5 Current Array size(index) : " + s.top + " Current Array Capacity(length) : " + s.arr.length);
        s.push(7);
        System.out.println("Push : 7 Current Array size(index) : " + s.top + " Current Array Capacity(length) : " + s.arr.length);
        System.out.println("Top : " + s.top());
        System.out.println("= = = = = = = =");
        
        System.out.println("Pop : " + s.pop() + " Current Array size(index) : " + s.top + " Current Array Capacity(length) : " + s.arr.length); // remove 7
        System.out.println("= = = = = = = =");
        
        s.push(9);
        System.out.println("Push : 9 Current Array size(index) : " + s.top + " Current Array Capacity(length) : " + s.arr.length);
        System.out.println("= = = = = = = =");
        
        System.out.println("Pop : " + s.pop() + " Current Array size(index) : " + s.top + " Current Array Capacity(length) : " + s.arr.length); // remove 7
        System.out.println("= = = = = = = =");
        System.out.println("Pop : " + s.pop() + " Current Array size(index) : " + s.top + " Current Array Capacity(length) : " + s.arr.length); // remove 7
        System.out.println("= = = = = = = =");
        System.out.println("Top : " + s.top());
        System.out.println("isEmpty : " + s.empty());
        
    }
    
}
