package com.ds.core.sorting;

public class SelectionSort {

    public void selectionSort(int[] input) {
        int p = 0;
        while (p < input.length) {
            int smallNum = input[p];
            int smallNumP = p;
            for (int i = p; i < input.length; i++) {
                if (input[i] < smallNum) {
                    smallNum = input[i];
                    smallNumP = i;
                }
            }
            input[smallNumP] = input[p];
            input[p] = smallNum;
            p++;
        }
    }
}
