package com.practice.arithmetic;


public class BubbleSort implements SortAlgorithm {
    @Override
    public void sort(int[] ints) {
        int len = ints.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (ints[i] > ints[j]) {
                    int t = ints[i];
                    ints[i] = ints[j];
                    ints[j] = t;
                }
            }
        }
    }
}
