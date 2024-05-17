package utils;

import java.util.Random;

public class RandomArray {
    public static final int testArraySize = 100000;

    public static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = Math.abs(random.nextInt()); // 生成隨機 int 值
        }
        return array;
    }
}
