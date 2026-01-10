/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package BubbleSortAlgorithm;

/**
 *
 * @author Bawantha
 */
import java.util.Arrays;

public class BubbleSortAlgorithm {

    public void bubbleSort(int[] arr){
        int n = arr.length;
        
        //outer loop runs n times (for n passes)
        for (int i = 0; i < n-1; i++){
            System.out.println("Pass " + (i+1) + " starting. Array: " + Arrays.toString(arr));
            
            //inner loop compares adjacent elements and swap them.
            //j runs up to n-1-i, because the last 'i' elemnts are already sorted.
            for(int j = 0; j < n-1-i; j++){
                //if current element is greater than the next element, swap them
                if(arr[j] > arr[j+1]){
                    //swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        BubbleSortAlgorithm sort = new BubbleSortAlgorithm();
        int[] data = {64, 34, 25, 90, 12};
        
        System.out.println("Testing Basic Bubble Sort Algorithm.");
        System.out.println("Initial array: " + Arrays.toString(data));
        
        sort.bubbleSort(data);
        
        System.out.println("\nSorted Array: " + Arrays.toString(data));
    }
    
}
