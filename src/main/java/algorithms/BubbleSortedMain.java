package algorithms;

import java.util.Arrays;

public class BubbleSortedMain {

    public static void main(String[] args) {
        int[] arr = {10, 100, 61, 22, 44, 67, 30, 90, 20, 34};
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
                System.out.println(Arrays.toString(arr));
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("cost: " + (end-start) + " ms, foreach count: " + count);
    }
}
