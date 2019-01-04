package com.example.shiro2.data;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{85,9,15,98,64,72};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr,int start,int end){
        int standard = arr[start];
        int low = start;
        int high = end;
        if(start<end){
            while(low<high){
                while(low<high&&standard<=arr[high]){
                    high--;
                }
                //使用右面的数替代左面的数字
                arr[low] = arr[high];
                while(low<high&&arr[low]<=standard){

                    low++;
                }
                //使用左面的数替代右面的数
                arr[high] = arr[low];
            }
            arr[low] = standard;
            //递归
            quickSort(arr,start,low);
            quickSort(arr,low+1,end);


        }

    }




}
