package com.example.shiro2.data;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {
        int[] arr = new int[]{85,9,15,98,64,72};
       shellSort(arr);
        System.out.println(Arrays.toString(arr));

    }
    private static void shellSort(int[] arr){
        //循环所有的步长
        int k = 0 ;
        for (int d = arr.length/2;d>0;d/=2){
            for(int i = d;i<arr.length;i++){

                for(int j =i-d;j>=0;j-=d){
                    if(arr[j]>arr[j+d]){
                        int temp = arr[j+d];
                        arr[j+d] = arr[j];
                        arr[j] = temp;


                    }






                }



            }
            k++;
            System.out.println("第"+(k)+"次循环结果为"+Arrays.toString(arr));


        }














        }






    }



