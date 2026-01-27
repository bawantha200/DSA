/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package OptimizedQuickSortAlgorithm;

/**
 *
 * @author Bawantha
 */

import java.util.Arrays;

public class OptimizedQuickSortAlgorithm {

    private static final int CUTOFF = 10;

    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }
    
    private void quickSort(int[] arr, int low, int high) {
        if (low + CUTOFF > high) {
            insertionSort(arr, low, high);
        } else {
            int pivot = medianOfThree(arr, low, high);
            int i = low, j = high - 1;
            while (true) {
                while (arr[++i] < pivot);
                while (arr[--j] > pivot);
                if (i < j) swap(arr, i, j);
                else break;
            }
            swap(arr, i, high - 1); // Restore pivot
            quickSort(arr, low, i - 1);
            quickSort(arr, i + 1, high);
        }
    }
    
    private int medianOfThree(int[] arr, int low, int high) {
        int mid = (low + high) / 2;
        if (arr[mid] < arr[low]) swap(arr, low, mid);
        if (arr[high] < arr[low]) swap(arr, low, high);
        if (arr[high] < arr[mid]) swap(arr, mid, high);

        // Place pivot at high - 1
        swap(arr, mid, high - 1);
        return arr[high - 1];
    }

    private void insertionSort(int[] arr, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            int tmp = arr[i];
            int j = i;
            for (; j > low && tmp < arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = tmp;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Testing Optimized Quick Sort Algorithm.");
        OptimizedQuickSortAlgorithm sorter = new OptimizedQuickSortAlgorithm();
        int[] data = {24, 8, 42, 75, 29, 77, 38, 57, 14, 19, 26, 3, 100, 1};
        System.out.println("Original: " + Arrays.toString(data));
        sorter.sort(data);
        System.out.println("Sorted:   " + Arrays.toString(data));
    }
    
}
