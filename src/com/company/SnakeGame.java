package com.company;


import com.company.gameobjects.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static com.company.gameobjects.Screen.SCREEN_HEIGHT;
import static com.company.gameobjects.Screen.SCREEN_WIDTH;

public class SnakeGame {

    public static void main(String[] args) {
        Screen screen = new Screen();
        List<GameObject> objectList = new ArrayList<>();
        Food f = new Food(getRandomPosOnScreen(SCREEN_HEIGHT), getRandomPosOnScreen(SCREEN_WIDTH));
        Snake snake = new Snake(10,10);

        objectList.add(f);
        objectList.addAll(setUpWalls());

        // Input from player
        Scanner scanner = new Scanner(System.in);
        char input;

        // The game logic starts here
        boolean isRunning = true;

        while (isRunning) {
            screen.clearScreen();
            for(GameObject object : objectList) //objectList.forEach(screen::draw);
            {
                screen.draw(object);
            }
            snake.draw(screen);

            screen.printScreen();

            checkCollisions(snake, objectList);

            // Get input from player and do something
            switch (input = scanner.nextLine().charAt(0)) {
                case 'a':
                    snake.moveLeft(screen, snake);
                    break;
                case 'd':
                    snake.moveRight(screen, snake);
                    break;
                case 'w':
                    snake.moveUp(screen, snake);
                    break;
                case 's':
                    snake.moveDown(screen, snake);
                    break;
            }
        }
    }

    private static void checkCollisions(Snake snake,  List<GameObject> objectList )
    {
        for (GameObject o : objectList)
        {
            if(snake.collides(o))
            {
               snake.applyCollisionEffect(o);
            }
        }
    }


    public static List<Wall> setUpWalls()
    {
        List<Wall> result = new ArrayList<>();

        //vertical walls
        for (int i = 0; i < SCREEN_WIDTH ; i++) {
            result.add(new Wall(0, i));
            result.add(new Wall(SCREEN_HEIGHT - 1, i));
        }

        //horizontal walls
        for (int i = 0; i < SCREEN_HEIGHT ; i++) {
            result.add(new Wall(i, 0));
            result.add(new Wall( i, SCREEN_WIDTH - 1));
        }

        return result;
    }

    private static Random rnd = new Random();
    private static final int getRandomPosOnScreen(int max)
    {
       return rnd.nextInt(max)/2 + max/2;
    }
}
