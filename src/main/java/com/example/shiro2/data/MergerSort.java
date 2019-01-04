package com.example.shiro2.data;

import java.util.Arrays;

public class MergerSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,4,6,8,10};
        merge(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }
    private static void merge(int[] arr,int low,int high){
        int middle = (low+high)/2;
        if(low<high){
            merge(arr,low,middle);
            merge(arr,middle+1,high);
            mergeSort(arr,low,middle,high);
        }

    }

    private static void mergeSort(int[] arr,int low,int middle,int high){
        int[] temp = new int[high-low+1];
        int i = low;
        int j = middle+1;
        int index = 0;
        while(i<=middle&&j<=high){
            if(arr[i]<arr[j]){
                temp[index] = arr[i];
                i++;
                index++;
            }
            else{
                temp[index] = arr[j];
                j++;
                index++;

            }
        }
        //处理多余的数据
        while(j<=high){
            temp[index] = arr[j];
            j++;
            index++;

        }
        while(i<=middle){
            temp[index] = arr[i];
            i++;
            index++;

        }
        for (int i1 = 0; i1 < temp.length; i1++) {
              arr[i1] = temp[i1];
        }
    }
}
