package com.practice.heap;

import java.util.Arrays;

public class MaxHeap {

    public static void main(String[] args) {
        //int[] heap = {9, 4, 7, 1, -2, 6, 5};
        int[] heap = {-2, 9, 5, 1, 4, 6, 7};
        buildMinHeap(heap);
    }

    private static void buildMinHeap(int[] heap) {
        int heapSize = heap.length - 1;
        System.out.println("Before heapify: " + Arrays.toString(heap));
        for (int i = heapSize / 2; i >= 0; i--) {
            maxHeap(heap,i);
//            maxHeapRecursive(heap, i);
        }
        System.out.println("After heapify: " + Arrays.toString(heap));
    }

    private static void maxHeap(int[] arr, int index) {
        int largest = index;
        while (largest < arr.length / 2) {
            int left = (2 * index) + 1;
            int right = (2 * index) + 2;

            if (left < arr.length && arr[left] > arr[index])
                largest = left;
            if (right < arr.length && arr[right] > arr[largest])
                largest = right;
            if (largest != index) {
                int temp = arr[index];
                arr[index] = arr[largest];
                arr[largest] = temp;
                index = largest;
            } else {
                break;
            }
        }
    }

    private static void maxHeapRecursive(int[] arr, int index) {
        int largest = index;
        int left = (2 * index) + 1;
        int right = (2 * index) + 2;

        if (left < arr.length && arr[left] > arr[index])
            largest = left;
        if (right < arr.length && arr[right] > arr[largest])
            largest = right;
        if (largest != index) {
            int temp = arr[index];
            arr[index] = arr[largest];
            arr[largest] = temp;
            maxHeapRecursive(arr, largest);
        }
    }
}
