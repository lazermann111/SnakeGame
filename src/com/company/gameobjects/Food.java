package com.company.gameobjects;

public class Food extends GameObject {
    private final static char FOOD_CELL ='*';

    @Override
    public char getSymbol() {
        return FOOD_CELL;
    }
}
