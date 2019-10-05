package com.company.gameobjects;


public class Snake extends GameObject {
    private final static char SNAKE_CELL ='Y';

    public Snake(int x, int y) {
        super(x, y);
    }


    @Override
    public char getSymbol() {
        return SNAKE_CELL;
    }


    public void moveLeft(Screen screen, Snake snake) {
        snake.setX(getX() - 1);
    }

    public void moveRight(Screen screen, Snake snake) {
        snake.setX(getX() + 1);
    }

    public void moveUp(Screen screen, Snake snake) {
        snake.setY(getY() - 1);
    }

    public void moveDown(Screen screen, Snake snake) {
        snake.setY(getY() + 1);
    }

}
