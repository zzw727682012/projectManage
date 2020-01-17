package com.practice.arithmetic;


public class SelectionSort implements SortAlgorithm {
    @Override
    public void sort(int[] ints) {
        int len = ints.length;
        for (int i = 0; i < len - 1; i++) {
            int min = ints[i];
            int point = i;
            for (int j = i + 1; j < len; j++) {
                if (ints[j] < min) {
                    min = ints[j];
                    point = j;
                }
            }
            ints[point] = ints[i];
            ints[i] = min;
        }
    }
}
