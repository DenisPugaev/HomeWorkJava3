package com.geekbrains.lesson4;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CurrentPosition {
    private final int NUMBER_OF_LETTERS = 3;
    public int position = 1;

    public void increasePosition() {
        position++;
    }

    public int indexOfLetter() {

        return position % NUMBER_OF_LETTERS;
    }


}
