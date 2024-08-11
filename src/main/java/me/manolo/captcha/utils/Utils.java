package me.manolo.captcha.utils;

import java.util.Random;

public class Utils {
    
    public static int randomInteger(int min, int max) {
        Random r = new Random();
        int realMin = Math.min(min, max);
        int realMax = Math.max(min, max);
        int exclusiveSize = realMax - realMin;
        return r.nextInt(exclusiveSize + 1) + min;
    }
}
