package algorithms;

import utils.RandomArray;

public class InsertSortedMain {
    public static void main(String[] args) {
        int[] arr = RandomArray.generateRandomArray(RandomArray.testArraySize);
        int count = 0;
        long start = System.currentTimeMillis();
        for (int i = 1; i < arr.length; i++) {
            int leftNumIndex = i;
            for (int j = (i - 1); j >= 0; j--) {
                if (arr[j] > arr[leftNumIndex]) {
                    int k = arr[j];
                    arr[j] = arr[leftNumIndex];
                    arr[leftNumIndex] = k;
                    leftNumIndex--;
                }
                count++;
            }
        }
        long end = System.currentTimeMillis();
        // cost: 8574 ms, foreach count: 704982704
        System.out.println("cost: " + (end - start) + " ms, foreach count: " + count);
    }
}
