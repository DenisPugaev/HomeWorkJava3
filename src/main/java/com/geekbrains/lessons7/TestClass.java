package com.geekbrains.lessons7;


public class TestClass {
    String name = "Мартин";

    @Test(priority = 4)
    public void order() {
        System.out.print("[2]");
        System.out.println("Пиццерия приняла заказ на пиццу");
    }

    @Test(priority = 5)
    public void call() {
        System.out.print("[1]");
        System.out.println(name + " позвонил и заказал пиццу");
    }

    @Test(priority = 3)
    public void cooking() {
        System.out.print("[3]");
        System.out.println("Пиццерия  готовит пиццу");
    }

    @Test(priority = 1)
    public void delivered() {
        System.out.print("[5]");
        System.out.println(name + " получил пиццу и вкусил сей шедевр кулинарии");
    }


    @Test(priority = 2)
    public void delivery() {
        System.out.print("[4]");
        System.out.println("Пицца приготовлена и передана курьеру на доставку");
    }


}