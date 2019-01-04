package com.example.shiro2.data;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[]{85,9,15,98,64,72};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));

    }


    private static void insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]<arr[i-1]){
                int temp = arr[i];
                int j;
                for( j = i-1;j>=0&&temp<arr[j];j--){
                    arr[j+1] = arr[j];
                }
                arr[j+1] = temp;
            }


        }



















    }

}
