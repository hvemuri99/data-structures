package com.ds.core.sorting;

public class InsertionSort {

    public void insertionSort(int[] input) {
        int var1 = input[0];
        int var2 = input[1];

        if (var2 < var1) {
            input[0] = var2;
            input[1] = var1;
        }

        for (int i = 1; i < input.length; i++) {
            var1 = input[i];
            int p = i;
            for (int j = i - 1; j >= 0; j--) {
                var2 = input[j];
                if (var1 < var2) {
                    input[j] = var1;
                    input[p] = var2;
                    p = j;
                }
            }
        }
    }
}
