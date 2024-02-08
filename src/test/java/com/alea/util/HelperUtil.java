package com.alea.util;

import java.util.Random;
import java.util.UUID;

public class HelperUtil {

    public static String getRandomString(int n) {
        return UUID.randomUUID().toString().substring(0, n); // generise random string
    }

    public static String getRandomNumbers(int randomNumbersCount) {
        String random = "";
        int[] randomNumbers = new int[randomNumbersCount];
        Random number = new Random();
        for (int i = 0; i < randomNumbersCount; i++) {
            randomNumbers[i] = number.nextInt(8) + 1;
        }
        for (int j = 0; j < randomNumbers.length; j++) {
            random += randomNumbers[j];
        }
        return random;
    }

    public static String getRandomEmail() {
        return UUID.randomUUID().toString().substring(0, 5) + "@" + UUID.randomUUID().toString().substring(0, 5)
                + ".com";
    }
}
