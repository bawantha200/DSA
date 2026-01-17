/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package MergeSortAlgorithm;

/**
 *
 * @author Bawantha
 */

import java.util.Arrays;

public class MergeSortAlgorithm {

    public void sort(int[] arr, int left, int right){
        if(left < right){
            int mid = left + (right - left)/2;
            
            //sort first and second halves
            sort(arr, left, mid);
            sort(arr, mid+1, right);
            
            //merge the sorted halves
            merge(arr, left, mid, right);
        }
    }
    
    private void merge(int[] arr, int left, int mid, int right){
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        int[] L = new int[n1];
        int[] R = new int[n2];
        
        for(int i = 0; i < n1; ++i){
            L[i] = arr[left + i];
        }
        for(int j = 0; j< n2; ++j){
            R[j] = arr[mid + 1 + j];
        }
        
        int i = 0, j = 0, k = left;
        
        while(i < n1){
            arr[k++] = L[i++];
        }
        while(j < n2){
            arr[k++] = R[j++];
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        MergeSortAlgorithm s = new MergeSortAlgorithm();
        int[] data = {37, 23, 17, 5, 8};
        System.out.println("Testing Merge Sort Algorithm.");
        System.out.println("Initial array: " + Arrays.toString(data));
        
        s.sort(data, 0, data.length -1);
        
        System.out.println("\nSorted Array: " + Arrays.toString(data));
    }
    
}
