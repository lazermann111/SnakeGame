package com.company.gameobjects;


public class Snake {
    private int x, y;

    private char symbol='Y';
    public char getSymbol() {
        return symbol;
    }

    public Snake(int x, int y) {
        this.x = x;
        this.y = y;
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


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
}
