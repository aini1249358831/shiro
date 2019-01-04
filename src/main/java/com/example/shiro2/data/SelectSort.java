package com.example.shiro2.data;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = new int[]{85,9,15,98,64,72};
       selectSort(arr);
        System.out.println(Arrays.toString(arr));

    }
    private static void selectSort(int[] arr){

        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            //把当前的数和后面的数进行比较
            for(int j =i+1;j<arr.length;j++){
                if(arr[j]<arr[minIndex]){
                    minIndex = j;
                }
            }
            if(i!=minIndex){
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] =temp;
            }
        }

    }
}
