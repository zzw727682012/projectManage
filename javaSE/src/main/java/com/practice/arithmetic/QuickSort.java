package com.practice.arithmetic;

public class QuickSort implements SortAlgorithm {
    @Override
    public void sort(int[] ints) {
        if (ints.length > 0) {
            quickSort(ints, 0, ints.length - 1);
        }
    }

    public void quickSort(int[]a,int start,int end){
        if(start<end){
            int baseNum=a[start];//选基准值
            int midNum;//记录中间值
            int i=start;
            int j=end;
            while(i<=j){
                while((a[i]<baseNum)&&i<end){
                    i++;
                }
                while((a[j]>baseNum)&&j>start){
                    j--;
                }
                if(i<=j){
                    midNum=a[i];
                    a[i]=a[j];
                    a[j]=midNum;
                    i++;
                    j--;
                }
            }
            if(start<j){
                quickSort(a,start,j);
            }
            if(end>i){
                quickSort(a,i,end);
            }
        }
    }
}
