package com.company.gameobjects;


public class Screen {

    public static final int SCREEN_HEIGHT = 22;
    public static final int SCREEN_WIDTH = 20;

    private char[][] screen;

    public Screen() {
        screen = new char[SCREEN_HEIGHT][SCREEN_WIDTH];

        for (int i = 0; i < SCREEN_HEIGHT; i++) {
            for (int j = 0; j < SCREEN_WIDTH; j++) {
                screen[i][j] = ' ';
            }
        }

        setUpWalls();
    }

    public void setSymbol(int x, int y, char symbol) {
        screen[x][y] = symbol;
    }

    public void printScreen() {
        for (int i = 0; i < SCREEN_HEIGHT; i++) {
            for (int j = 0; j < SCREEN_WIDTH; j++) {
                System.out.print(screen[i][j]);
            }
            System.out.println();
        }
    }

    public void setVerticalRow(int row, char wallSymbol)
    {
        for (int i = 0; i < SCREEN_HEIGHT ; i++) {
            screen[i][row] = wallSymbol;
        }
    }

    public void setHorizontalRow(int row, char wallSymbol)
    {
        for (int i = 0; i < SCREEN_WIDTH ; i++) {
            screen[row][i] = wallSymbol;
        }
    }

    private void setUpWalls()
    {
        Wall w = new Wall();

        setVerticalRow(0, w.getSymbol());
        setVerticalRow(SCREEN_WIDTH - 1, w.getSymbol());

        setHorizontalRow(0, w.getSymbol());
        setHorizontalRow(SCREEN_HEIGHT - 1, w.getSymbol());
    }

    public char[][] getScreen() {
        return screen;
    }

    public void setScreen(char[][] screen) {
        this.screen = screen;
    }
}
