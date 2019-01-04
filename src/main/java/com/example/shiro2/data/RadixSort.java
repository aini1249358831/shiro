package com.example.shiro2.data;

import java.util.Arrays;

public class RadixSort {

    public static void main(String[] args) {
        int[] arr = new int[]{102,2,56,79,63,789,654,215};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));

    }
    private static void radixSort(int[] arr){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {

            if(arr[i]>max){
                max = arr[i];
            }

        }
        int maxLength = (max+"").length();
        int[][] temp = new int[10][arr.length];
        int[] counts = new int[10];
        for(int i = 0,n=1;i<maxLength;i++,n*=10){
            for (int i1 = 0; i1 < arr.length; i1++) {
                int ys = arr[i1]/n%10;
                temp[ys][counts[ys]] = arr[i1];
                counts[ys]++;



            }
            int index = 0;
            //取出数字
            for (int k = 0; k < counts.length; k++) {
                if(counts[k]!=0){
                    for(int l = 0;l<counts[k];l++){
                        arr[index] = temp[k][l];
                        index++;

                    }
                    counts[k] = 0;

                }

            }

        }





    }

}
