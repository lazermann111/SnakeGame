package com.company.snake.entities;


public class Wall extends GameObject {
    private final static char WALL_CELL = '#';

    public Wall(int x, int y) {
        super(x, y);
    }

    @Override
    public char getSymbol() {
        return WALL_CELL;
    }
}
