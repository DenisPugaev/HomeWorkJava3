package com.geekbrains.lesson6;
//Created by PugaevDenis

/*Задача:
    1. Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив. Метод должен
вернуть новый массив, который получен путем вытаскивания из исходного массива элементов, идущих после последней
четверки. Входной массив должен содержать хотя бы одну четверку, иначе в методе необходимо выбросить RuntimeException.
Написать набор тестов для этого метода (по 3-4 варианта входных данных). Вх: [1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
    2. Написать метод, который проверяет состав массива из чисел 1 и 4. Если в нем нет хоть одной четверки или
единицы, то метод вернет false; Написать набор тестов для этого метода (по 3-4 варианта входных данных).*/

public class ActionsOnArrays {
    public ActionsOnArrays() {}
    public int[] arrCopy(int[] arrA) {
        int index = 0, length = 0;
        for (int i = 0; i < arrA.length; i++) {
            if (arrA[i] == 4) {
                index = i;
                length = arrA.length - index;
            }
        }
        if (arrA[index] != 4) throw new RuntimeException();
        int[] arrB = new int[length - 1];
        System.arraycopy(arrA, index + 1, arrB, 0, length - 1);
        return arrB;
    }

    public boolean arrFound(int[] arr) {
        boolean one = false, four = false;
        for (int a : arr) {
            if (a == 1) one = true;
            if (a == 4) four = true;
        }
        return one & four;
    }
}



