package com.ds.core.sorting;

public class CountingSort {

    public int[] countingSort(int[] input, int startRange, int endRange) {
        int[] countArray = createCountArray(input, startRange, endRange);
        int[] output = new int[input.length];
        int i = 0;
        while (i < input.length) {
            int temp = input[i];
            int position = countArray[temp];
            output[position] = temp;
            countArray[temp] = position + 1;
            i++;
        }
        return output;
    }

    private int[] createCountArray(int[] input, int startRange, int endRange) {
        int[] countArray = new int[endRange + 1];
        for (int i = 0; i < countArray.length; i++) {
            countArray[i] = 0;
        }

        for (int i = 0; i < input.length; i++) {
            int temp = input[i];
            countArray[temp] = countArray[temp] + 1;
        }
        addCountArrayAccumulatively(countArray);
        return shiftCountArray(countArray);
    }

    private void addCountArrayAccumulatively(int[] countArray) {
        int i = 0;
        int j = 1;
        while (i < countArray.length && j < countArray.length) {
            countArray[j] = countArray[i] + countArray[j];
            i++;
            j++;
        }
    }

    private int[] shiftCountArray(int[] countArray) {
        int[] newCountArray = new int[countArray.length];
        newCountArray[0] = 0;
        int i = 0;
        while (i < newCountArray.length - 1) {
            newCountArray[i + 1] = countArray[i];
            i++;
        }
        return newCountArray;
    }
}
