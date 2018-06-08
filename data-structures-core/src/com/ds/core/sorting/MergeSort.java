package com.ds.core.sorting;

public class MergeSort {

    public int[] merge(int[] input1, int[] input2, int length) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] output = new int[length];

        while (i < input1.length && j < input2.length) {
            if (input1[i] <= input2[j]) {
                output[k] = input1[i];
                i++;
            } else {
                output[k] = input2[j];
                j++;
            }
            k++;
        }

        while (i < input1.length) {
            output[k] = input1[i];
            i++;
        }

        while (j < input2.length) {
            output[k] = input2[j];
            j++;
        }

        return output;
    }
}
