/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package OptimizedInsertionSortAlgorithm;

/**
 *
 * @author Bawantha
 */

import java.util.Arrays;

public class OptimizedInsertionSortAlgorithm {

    public void sort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int key = arr[i];
            
            //use binary search to find the position to insert key
            int insPos = binarySearch(arr, key, 0, i-1);
            
            //shift elements to the rght to make space
            for (int j = i-1; j >= insPos; j--){
                arr[j +1] = arr[j];
            }
            arr[insPos] = key;
        }
    }
    
    private int binarySearch(int[] arr, int key, int low, int high){
        while(low<=high){
            int mid = low + (high - low)/2;
            if(key< arr[mid]){
                high = mid-1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        OptimizedInsertionSortAlgorithm s = new OptimizedInsertionSortAlgorithm();
        int[] data = {37, 23, 17, 5, 8};
        System.out.println("Testing Optimized Insertion Sort Algorithm.");
        System.out.println("Initial array: " + Arrays.toString(data));
        
        s.sort(data);
        
        System.out.println("\nSorted Array: " + Arrays.toString(data));
    }
    
}
