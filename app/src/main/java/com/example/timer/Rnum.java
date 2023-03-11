package com.example.timer;

import java.util.Random;

public class Rnum {
    public static Random random = new Random();
    public static int randomNumber;

    public static int generateRandomNumberv() {
        randomNumber = random.nextInt(1000000);
        // do something with randomNumber
        return randomNumber;
    }

}
