package com.geekbrains.lesson1.part1;

import java.util.ArrayList;
import java.util.List;

public class ConvertArray<T> {

    public List<T> convertToList(T arr[]) {
        List<T> arrayList = new ArrayList<>();
        for (T t : arr) {

            arrayList.add(t);

        }
        System.out.println("Convert to ArrayList "+arrayList);
        return arrayList;
    }
}
