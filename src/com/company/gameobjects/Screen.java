package com.company.gameobjects;


public class Screen {

    public static final int SCREEN_HEIGHT = 22;
    public static final int SCREEN_WIDTH = 20;

    private char[][] screen;

    public Screen() {
        screen = new char[SCREEN_HEIGHT][SCREEN_WIDTH];
    }

    public void clearScreen()
    {
        for (int i = 0; i < SCREEN_HEIGHT; i++) {
            for (int j = 0; j < SCREEN_WIDTH; j++) {
                screen[i][j] = ' ';
            }
        }
    }

    public void printScreen() {
        for (int i = 0; i < SCREEN_HEIGHT; i++) {
            for (int j = 0; j < SCREEN_WIDTH; j++) {
                System.out.print(screen[i][j]);
            }
            System.out.println();
        }
    }

    public void draw(GameObject gameObject)
    {
        screen[gameObject.getX()][gameObject.getY()] = gameObject.getSymbol();
    }

    public char[][] getScreen() {
        return screen;
    }

    public void setScreen(char[][] screen) {
        this.screen = screen;
    }
}
