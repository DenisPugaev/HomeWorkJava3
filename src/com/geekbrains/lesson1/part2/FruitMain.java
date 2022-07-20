package com.geekbrains.lesson1.part2;
//Created by PugaevDenis

import lombok.extern.slf4j.Slf4j;

import java.util.logging.Logger;


/*Задача:
        3. Большая задача:
a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта, поэтому в одну коробку
нельзя сложить и яблоки, и апельсины;
c. Для хранения фруктов внутри коробки можете использовать ArrayList;
d. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов и вес одного фрукта(вес
яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той, которую подадут
в compare в качестве параметра, true - если их веса равны, false в противном случае(коробки с яблоками мы можем
сравнивать с коробками с апельсинами);
f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку(помним про сортировку фруктов,
нельзя яблоки высыпать в коробку с апельсинами), соответственно в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в этой коробке;
g. Не забываем про метод добавления фрукта в коробку.*/
@Slf4j
public class FruitMain {

    public static void main(String[] args) {
        Logger log = Logger.getLogger(String.valueOf(FruitMain.class));

        Apple apple = new Apple();
        Orange orange = new Orange();

        Box boxMix1 = new Box();
        Box boxMix2 = new Box();
        Box boxMix3 = new Box();
        Box boxApple = new Box();
        Box boxOrange = new Box();

        boxMix1.addFruitInBox(apple, 4);
        boxMix1.addFruitInBox(orange, 7);

        boxMix2.addFruitInBox(apple, 5);
        boxMix2.addFruitInBox(orange, 6);

        boxMix3.addFruitInBox(orange, 1);
        boxMix3.addFruitInBox(apple, 1);

        boxApple.addFruitInBox(apple, 6);
        boxOrange.addFruitInBox(orange, 4);

        System.out.printf("Вес первой коробки: %s %n", boxMix1.getWeight());
        System.out.printf("Вес второй коробки: %s %n", boxMix2.getWeight());
        System.out.printf("Вес третьей коробки: %s %n", boxMix3.getWeight());
        System.out.printf("Вес коробки с только яблоками: %s %n", boxApple.getWeight());
        System.out.printf("Вес коробки с только с апельсинами: %s \n%n", boxOrange.getWeight());

        System.out.printf("Сравниваем  две коробки первую и вторую: %s \n%n", boxMix1.compare(boxMix2));

        boxMix2.pourInto(boxMix3);
        System.out.printf("Пересыпаем из коробки 2 в коробку 3.\nКоробка 2 весит: %s \nКоробка 3 весит: %s \n%n", boxMix2.getWeight(), boxMix3.getWeight());


        System.out.printf("Сравниваем  коробку с яблоками и коробку с апельсинами: %s \n%n", boxApple.compare(boxOrange));
    }


}
