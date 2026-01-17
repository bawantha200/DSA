/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package QuickSortAlgorithm;

/**
 *
 * @author Bawantha
 */
import java.util.Arrays;

public class QuickSortAlgorithm {

    public void sort(int[] arr, int low, int high){
        if(low < high){
            //pi is partitionin index
            int pi = partition(arr, low, high);
            
            //recursively sort elements before and after partition
            sort(arr, low, pi-1);
            sort(arr, pi + 1, high);
        }
    }
    
    private int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = (low - 1); //index of smaller element
        
        for(int j = low; j < high; j++){
            if(arr[j] < pivot){
                i++;
                //swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        //swap arr[i+1] and aee[high] (pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        
        return i + 1;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        QuickSortAlgorithm s = new QuickSortAlgorithm();
        int[] data = {37, 23, 17, 5, 8};
        System.out.println("Testing Quick Sort Algorithm.");
        System.out.println("Initial array: " + Arrays.toString(data));
        
        s.sort(data, 0, data.length - 1);
        
        System.out.println("\nSorted Array: " + Arrays.toString(data));
    }
    
}
