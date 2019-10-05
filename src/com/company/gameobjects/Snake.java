package com.company.gameobjects;


public class Snake extends GameObject {
    private final static char SNAKE_CELL ='Y';

    public Snake(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public char getSymbol() {
        return SNAKE_CELL;
    }


    public void moveLeft(Screen screen, Snake snake) {
        snake.setX(getX() - 1);
        screen.setSymbol(snake.getX(), snake.getY(), snake.getSymbol());
    }

    public void moveRight(Screen screen, Snake snake) {
        snake.setX(getX() + 1);
        screen.setSymbol(snake.getX(), snake.getY(), snake.getSymbol());

    }

    public void moveUp(Screen screen, Snake snake) {
        snake.setY(getY() - 1);
        screen.setSymbol(snake.getX(), snake.getY(), snake.getSymbol());

    }

    public void moveDown(Screen screen, Snake snake) {
        snake.setY(getY() + 1);
        screen.setSymbol(snake.getX(), snake.getY(), snake.getSymbol());

    }

}
