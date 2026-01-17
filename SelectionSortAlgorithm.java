/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package SelectionSortAlgorithm;

/**
 *
 * @author Bawantha
 */

import java.util.Arrays;

public class SelectionSortAlgorithm {

    public void sort(int[] arr){
        int n = arr.length;
        
        for (int i = 0; i < n-1; i++){
            //find the minimum element in unsorted array
            
            int minIndex = i;
            for(int j = i+1; i < n-1; i++){
                if(arr[j] < arr[minIndex]){
                minIndex = j;
            }
            }
            
            //swap the found minimum element with the first element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
            
            System.out.println("Step " + (i+1) + ": " + Arrays.toString(arr));
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        SelectionSortAlgorithm s = new SelectionSortAlgorithm();
        int[] data = {37, 23, 17, 5, 8};
        System.out.println("Testing Selection Sort Algorithm.");
        System.out.println("Initial array: " + Arrays.toString(data));
        
        s.sort(data);
        
        System.out.println("\nSorted Array: " + Arrays.toString(data));
    }
    
}
