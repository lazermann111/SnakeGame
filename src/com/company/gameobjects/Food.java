package com.company.gameobjects;

public class Food extends GameObject {
    private final static char FOOD_CELL ='*';

    public Food(int x, int y) {
        super(x, y);
    }

    @Override
    public char getSymbol() {
        return FOOD_CELL;
    }
}
