package com.ds.core.sorting;

public class HeapSort {

    public void heapSort(int[] input) {
        int length = input.length;
        formMaxHeap(input, length);
        swap(input, length);
    }

    private void formMaxHeap(int[] input, int length) {
        int i = 0;
        int j = 1;
        int count = 0;
        while (i < length && j < length) {
            int temp1 = input[i];
            int temp2 = input[j];

            if (count == 2) {
                i++;
                count = 0;
                continue;
            }
            if (temp1 < temp2) {
                input[i] = temp2;
                input[j] = temp1;
                j++;
                count++;
            } else {
                j++;
                count++;
            }
        }
    }

    private void swap(int[] input, int length) {
        int rn = input[0];
        int ln = input[length - 1];

        input[0] = ln;
        input[length - 1] = rn;
        length--;
        if (length > 1) {
            formMaxHeap(input, length);
            swap(input, length);
        }
    }
}