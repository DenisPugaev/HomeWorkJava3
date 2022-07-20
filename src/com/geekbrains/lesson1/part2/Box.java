package com.geekbrains.lesson1.part2;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.logging.Logger;

@Slf4j
public class Box <E extends Fruit> {
    Logger logBox = Logger.getLogger(String.valueOf(Box.class));
    private ArrayList<E> box = new ArrayList<>();

    public void addFruitInBox(E fruit, int amount){
        for(int i=0;i<amount;i++){
            box.add(fruit);
        }
    }
    public float getWeight(){
        float weight = 0.0f;

        for(E fruit : box){
          weight+= fruit.getWeight();
//            logBox.info(" info: weight "+ weight);
        }
        return weight;
    }
    public boolean compare(Box anotherBox) {
        if(getWeight() == anotherBox.getWeight()) return true;
        return false;
    }

    public void pourInto(Box <E>anotherBox){
        anotherBox.box.addAll(box);
        box.clear();

    }
}

