package com.geekbrains.lesson1.part1;

import java.util.Arrays;

public class ArraySwapped<T> {


    public T[] swapped(T[] arr) {
        int n = arr.length;
        T temp;
        for (int i = 0; i < n/2; i++) {
            temp = arr[n-i-1];
            arr[n-i-1] = arr[i];
            arr[i] = temp;
            ;

        }
        System.out.println("Swapped " + Arrays.toString(arr));
        return arr;
    }
}


