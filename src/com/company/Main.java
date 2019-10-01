package com.company;


import java.util.Random;

public class Main {

    public static void main(String[] args) {

    }

    private static Random rnd = new Random();
    private static final int getRandomPosOnScreen(int max)
    {
       return rnd.nextInt(max);
    }
}
