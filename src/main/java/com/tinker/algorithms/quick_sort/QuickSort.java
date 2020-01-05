package com.tinker.algorithms.quick_sort;

public class QuickSort {


    public static void main(String[] args) {
        int[] arr = {4, 5, 3, 1, 2, 10, 3, 9, 8};
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void quickSort(int[] data, int start, int end) {
        if (start < end) {
            int point = partition(data, start, end);
            quickSort(data, start, point - 1);
            quickSort(data, point + 1, end);
        }
    }

    private static int partition(int[] data, int start, int end) {
        int point = end;
        int pivot = data[end];
        int rl = start;
        for (int i = start; i < end; i++) {
            if (data[i] < pivot) {
                swap(data, i, rl);
                rl++;
            }
        }
        swap(data, rl, end);
        return rl;
    }

    private static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
