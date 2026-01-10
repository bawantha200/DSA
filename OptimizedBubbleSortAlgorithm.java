/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package OptimizedBubbleSortAlgorithm;

/**
 *
 * @author Bawantha
 */
import java.util.Arrays;

public class OptimizedBubbleSortAlgorithm {

    public void bubbleSortOptimized(int[] arr){
        int n = arr.length;
        boolean swapped;
        
        //outer loop runs n passes max
        for(int i = 0; i < n-1; i++){
            swapped = false; //reset the flag for the new pass
        
            System.out.println("Pass " + (i+1) + " starting. Array: " + Arrays.toString(arr));

            //inner loop
            for(int j = 0; j < n-1-i; j++){
                if(arr[j] > arr[i+1]){
                    //swp arr[j] and aa[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    
                    swapped = true; //mark that a swap occurred
                }
            }
            
            //optimization: if no two elements were swapped by inner loop, then break
            if(!swapped){
                System.out.println("Optimization triggered: No swaps occured in this pass. Array is sorted.");
                break;
            }
        }
        
    }
    public static void main(String[] args) {
        // TODO code application logic here
        OptimizedBubbleSortAlgorithm sort = new OptimizedBubbleSortAlgorithm();
        
        int[] data = {64, 34, 25, 90, 12};
        
        System.out.println("Testing Optimized Bubble Sort Algorithm.");
        System.out.println("Initial array: " + Arrays.toString(data));
        
        sort.bubbleSortOptimized(data);
        
        System.out.println("\nSorted Array: " + Arrays.toString(data));
    }
    
}
