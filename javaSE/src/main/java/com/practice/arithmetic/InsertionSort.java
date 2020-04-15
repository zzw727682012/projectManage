package com.practice.arithmetic;

public class InsertionSort implements SortAlgorithm {
    @Override
    public void sort(int[] ints) {
        for( int i=0; i<ints.length-1; i++ ) {
            for( int j=i+1; j>0; j-- ) {
                if( ints[j-1] <= ints[j] ){
                    break;
                }
                int temp = ints[j];      //交换操作
                ints[j] = ints[j-1];
                ints[j-1] = temp;
            }
        }
    }
}
