package com.geekbrains.lesson1.part1;
//Created by PugaevDenis

/*Задача:
        1.Написать метод,который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
        2.Написать метод,который преобразует массив в ArrayList;*/
public class Main {

    private static String[] arrString = {"Привет", "Как деал?", "Хорошо", "Пока"};
    private static Character[] arrChar = {'П', 'р', 'и', 'в', 'е', 'т'};
    private static Integer[] arrInt = {1, 2, 3, 4, 5};

    public static void main(String[] args) {

        ArraySwapped arraySwapped = new ArraySwapped();
        arraySwapped.swapped(arrString);
        arraySwapped.swapped(arrChar);
        arraySwapped.swapped(arrInt);

        ConvertArray convertArray = new ConvertArray();
        convertArray.convertToList(arrString);
        convertArray.convertToList(arrChar);
        convertArray.convertToList(arrInt);

    }

}

