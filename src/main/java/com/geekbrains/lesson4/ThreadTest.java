package com.geekbrains.lesson4;

import lombok.extern.slf4j.Slf4j;

/*ЗАДАЧА:
1. Создать три потока, каждый из которых выводит определенную букву (A, B и C) 5 раз (порядок – ABСABСABС).
Используйте wait/notify/notifyAll.*/

@Slf4j
public class ThreadTest {

    private static int numberOfRepetitions = 5;

    public static void main(String[] args) {


        CurrentPosition currentPosition = new CurrentPosition();

        //Поток №1
        Thread tra = new Thread(() ->
        {
            synchronized (currentPosition) {
                int counter = 1;
                while (counter <= numberOfRepetitions) {

                    for (int i = 0; i < 5; i++) {
                        try {
//                        log.info("INDEX который пришел в A =" + currentPosition.indexOfLetter());
                            if (currentPosition.indexOfLetter() == 1) {
                                System.out.print("A");
                                counter++;
                                currentPosition.increasePosition();
                                currentPosition.notifyAll();
//                            log.info("Напечатал A разблокировал монитор");
                            } else
//                            log.info("А ждет");
                                currentPosition.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }

        });
        tra.start();

         //Поток №2
        Thread trb = new Thread(() ->
        {
            synchronized (currentPosition) {
                int counter = 1;
                while (counter <= numberOfRepetitions) {
                    try {
//                    log.info("INDEX который пришел в B ="+ currentPosition.indexOfLetter());
                        if (currentPosition.indexOfLetter() == 2) {
                            System.out.print("B");
                            counter++;
                            currentPosition.increasePosition();
                            currentPosition.notifyAll();
//                        log.info("Напечатал B разблокировал монитор");
                        } else
//                        log.info("B ждет");
                            currentPosition.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        trb.start();

        // Поток №3
        Thread trc = new Thread(() ->
        {
            int counter = 1;
            while (counter <= numberOfRepetitions) {
                synchronized (currentPosition) {
                    try {
//                            log.info("INDEX который пришел в C =" + currentPosition.indexOfLetter());

                        if (currentPosition.indexOfLetter() == 0) {
                            System.out.print("C");
                            currentPosition.increasePosition();
                            currentPosition.notifyAll();
//                                log.info("Напечатал C разблокировал монитор");
                        } else
//                                log.info("С ждет");
                            currentPosition.wait();

                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        trc.start();
    }

}
