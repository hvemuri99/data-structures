package com.ds.core.sorting;

public class BubbleSort {

    public void bubbleSort(int[] input) {
        int count = 1;
        while (count > 0) {
            count = 0;
            for (int i = 0; i < input.length; i++) {
                if (i + 1 == input.length) {
                    continue;
                }
                int var1 = input[i];
                int var2 = input[i + 1];
                if (var2 < var1) {
                    input[i] = var2;
                    input[i + 1] = var1;
                    count++;
                }
            }
        }
    }
}
