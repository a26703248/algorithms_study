package algorithms;

import utils.RandomArray;

public class BubbleSortedMain {

    public static void main(String[] args) {
        int[] arr = RandomArray.generateRandomArray(RandomArray.testArraySize);
        int count = 0;
        long start = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < (arr.length - i - 1); j++) {
                if (arr[j] > arr[j + 1]) {
                    int k = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = k;
                }
                count++;
            }
        }
        long end = System.currentTimeMillis();
        // cost: 16658 ms, foreach count: 704982704
        System.out.println("cost: " + (end - start) + " ms, foreach count: " + count);
    }
}
