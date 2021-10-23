package com.practice.heap;

import java.util.Arrays;

public class SmallestElements {

    public static void main(String[] args) {
        int[] heap = {9, 4, 7, 1, -2, 6, 5};
       // int[] heap = {-2, 9, 5, 1, 4, 6, 7};

        System.out.println("Min Heap: " + Arrays.toString(findKSmallest(heap,3)));
    }
    public static int[] findKSmallest(int[] arr, int k) {

        int[] result = new int[k];
        int i = 0;
        while (k > i) {
            buildMinHeap(arr);
            result[i++] = arr[0];
            arr[0] = arr[arr.length - 1];
            arr[arr.length - 1] = Integer.MAX_VALUE;
        }

        return result;
    }

    private static void buildMinHeap(int[] heap) {
        int heapSize = heap.length;
        for (int i = heapSize / 2; i >= 0; i--) {
            minHeap(heap, i);
        }
    }

    private static void minHeap(int[] heap, int index) {
        int smallest = index;

        while (smallest < heap.length / 2) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;

            if (left < heap.length && heap[left] < heap[index]) {
                smallest = left;
            }
            if (right < heap.length && heap[right] < heap[smallest]) {
                smallest = right;
            }
            if (smallest != index) {
                int temp = heap[index];
                heap[index] = heap[smallest];
                heap[smallest] = temp;

                index = smallest;
            } else {
                break;
            }

        }
    }

}
