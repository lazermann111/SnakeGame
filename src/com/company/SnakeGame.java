package com.company;


import com.company.gameobjects.Food;
import com.company.gameobjects.Screen;
import com.company.gameobjects.Snake;

import java.util.Random;
import java.util.Scanner;

import static com.company.gameobjects.Screen.SCREEN_HEIGHT;
import static com.company.gameobjects.Screen.SCREEN_WIDTH;

public class SnakeGame {

    public static void main(String[] args) {
        Screen screen = new Screen();
        Food f = new Food();

        screen.setSymbol(
                getRandomPosOnScreen(SCREEN_HEIGHT),
                getRandomPosOnScreen(SCREEN_WIDTH),
                f.getSymbol());
        Snake s = new Snake(10,10);
        screen.setSymbol(s.getX(), s.getY(), s.getSymbol());
        screen.printScreen();


        // Input from player
        Scanner scanner = new Scanner(System.in);
        char input;

        // The game logic starts here
        boolean isRunning = true;

        while (isRunning) {
            screen.printScreen();
            // Get input from player and do something
            switch (input = scanner.nextLine().charAt(0)) {
                case 'a':
                    s.moveLeft(screen, s);
                    break;
                case 'd':
                    s.moveRight(screen, s);
                    break;
                case 'w':
                    s.moveUp(screen, s);
                    break;
                case 's':
                    s.moveDown(screen, s);
                    break;
            }
        }
    }



    private static Random rnd = new Random();
    private static final int getRandomPosOnScreen(int max)
    {
       return rnd.nextInt(max);
    }
}
