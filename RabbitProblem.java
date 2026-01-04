/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package RabbitProblem;

/**
 *
 * @author Bawantha
 */
public class RabbitProblem {

    public static long calculateRabbitPairs(int n){
        if(n<0){
            throw new IllegalArgumentException("Months cannot be negative.");
        }
        
        if(n == 0){
            return 0;
        }
        
        if(n == 1){
            return 1;
        }
        
        long previous = 0; //f(n-2)
        long current = 1; //f(n-1)
        long next = 1; //f(n)
        
        //start loop from the 2nd month (n = 2)
        
        for(int i = 2; i <= n; i++){
            next = previous + current;
            previous = current;
            current = next;
        }
        
        return current;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Testing Rabbit Problem ( Fibonacci Sequence)\n");
        
        int monthsToTest = 12;
        
        System.out.println("Calculateing rabbit pairs after " + monthsToTest + "months: ");
        
        for(int i = 0; i <= monthsToTest; i++){
            long pairs = calculateRabbitPairs(i);
            System.out.printf("Months %2d: %d pairs\n", i, pairs);
        }
    }
    
}
