/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package InsertionSortAlgorithm;

/**
 *
 * @author Bawantha
 */
import java.util.Arrays;

public class InsertionSortAlgorithm {

    public void insertionSort(int[] arr){
        int n = arr.length;
        
        //start from the second element (i=1), as the first is the "sorted" sub-array
        for(int i = 1; i < n; i++){
            int key = arr[i]; //the element to be inserted into the sorted sub-array
            int j = i-1; //index of the last element in the sorted sub-array
            
            //move elements of arr[0..i-1] that are greater than key. one position ahead of ther current position
            while(j >= 0 && arr[j] > key){
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = key; //insert the key in its correct position
            
            System.out.println("After insertion of " + key + ": " + Arrays.toString(arr));
            
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        InsertionSortAlgorithm sort = new InsertionSortAlgorithm();
        
        int[] data = {64, 34, 25, 90, 12};
        
        System.out.println("Testing Insertion Sort Algorithm.");
        System.out.println("Initial array: " + Arrays.toString(data));
        
        sort.insertionSort(data);
        
        System.out.println("\nSorted Array: " + Arrays.toString(data));
    }
    
}
