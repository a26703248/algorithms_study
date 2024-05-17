package algorithms;

import utils.RandomArray;

import java.util.Arrays;

public class SelectionSortedMain {

    public static void main(String[] args) {
        int[] arr = RandomArray.generateRandomArray(RandomArray.testArraySize);
        int count = 0;
        long start = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[i] > arr[j]) {
                    int k = arr[i];
                    arr[i] = arr[j];
                    arr[j] = k;
                }
                count++;
            }
        }
        long end = System.currentTimeMillis();
        // cost: 13486 ms, foreach count: 704982704
        System.out.println("cost: " + (end - start) + " ms, foreach count: " + count);
    }
}
