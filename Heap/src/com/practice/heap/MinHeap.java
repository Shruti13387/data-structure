package com.practice.heap;

import java.util.Arrays;

public class MinHeap {

    public static void main(String[] args) {
        int[] heap = {9, 4, 7, 1, -2, 6, 5};
        buildMinHeap(heap);
    }

    private static void buildMinHeap(int[] heap) {
        int heapSize = heap.length - 1;
        System.out.println("Before heapify: " + Arrays.toString(heap));
        for (int i = heapSize / 2; i >= 0; i--) {
//            minHeap(heap,i);
            minHeapRecursive(heap, i);
        }
        System.out.println("After heapify: " + Arrays.toString(heap));
    }

    private static void minHeap(int[] arr, int index) {
        int smallest = index;
        while (smallest < arr.length / 2) {
            int left = (2 * index) + 1;
            int right = (2 * index) + 2;

            if (left < arr.length && arr[left] < arr[index])
                smallest = left;
            if (right < arr.length && arr[right] < arr[smallest])
                smallest = right;
            if (smallest != index) {
                int temp = arr[index];
                arr[index] = arr[smallest];
                arr[smallest] = temp;
                index = smallest;
            } else {
                break;
            }
        }
    }

    private static void minHeapRecursive(int[] arr, int index) {
        int smallest = index;
        int left = (2 * index) + 1;
        int right = (2 * index) + 2;

        if (left < arr.length && arr[left] < arr[index])
            smallest = left;
        if (right < arr.length && arr[right] < arr[smallest])
            smallest = right;
        if (smallest != index) {
            int temp = arr[index];
            arr[index] = arr[smallest];
            arr[smallest] = temp;
            minHeapRecursive(arr, smallest);
        }
    }
}
