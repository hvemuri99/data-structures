package com.ds.core.sorting;

public class RadixSort {

    private int findMaxNum(int[] input) {
        int maxNum = input[0];
        for (int i = 1; i < input.length; i++) {
            if (maxNum < input[i]) {
                maxNum = input[i];
            }
        }
        return maxNum;
    }

    private int findBase(int num) {
        int length = 0;
        int temp = 1;
        while (temp <= num) {
            length++;
            temp *= 10;
        }
        return length;
    }

    private int[] getArrayDigits(int num, int maxBase) {
        int[] numBaseArray = new int[maxBase];
        int i = 0;
        while (i < maxBase) {
            if (num == 0) {
                numBaseArray[i]
            } else {
                numBaseArray[i] = num % 10;
                num /= 10;
            }
            i++;
        }
        return numBaseArray;
    }

    private int[][] constructArrayBase(int[] input, int maxBase) {
        int[][] baseInput = new int[input.length][maxBase];
        int j = 0;
        for (int i = 0; i < input.length; i++) {
            baseInput[j] = getArrayDigits(input[i], maxBase);
            j++;
        }

        return baseInput;
    }
}
