package com.example.shiro2.data;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1,9,15,98,64,72};
        BubbleSort(arr);
        System.out.println(Arrays.toString(arr));

    }


    private static void BubbleSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {

            for(int j=0;j<arr.length-i-1;j++){

                if(arr[j+1]<arr[j]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }




            }







        }










    }







}
