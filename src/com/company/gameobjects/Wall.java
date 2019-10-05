package com.company.gameobjects;


public class Wall extends GameObject {
    private final static char WALL_CELL = '#';

    @Override
    public char getSymbol() {
        return WALL_CELL;
    }
}
