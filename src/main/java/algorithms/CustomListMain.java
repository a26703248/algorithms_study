package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CustomListMain {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        CustomList arr1 = new CustomList();
        arr1.add(1);
        arr1.add(2);
        arr1.add(3);
        arr1.add(4);
        arr1.add(5);
        arr1.remove(3);
        long end = System.currentTimeMillis();
        System.out.println(arr1);
        System.out.println(arr1.size());
        System.out.println("cost: " + (end-start) + " ms");
        System.out.println("=================================");
        start = System.currentTimeMillis();
        List<Object> arr2 = new ArrayList<>();
        arr2.add(1);
        arr2.add(2);
        arr2.add(3);
        arr2.add(4);
        arr2.add(5);
//        arr2.remove(3);
        arr2.addAll(arr1);
        end = System.currentTimeMillis();
        System.out.println(arr2);
        System.out.println(arr2.size());
        System.out.println("cost: " + (end-start) + " ms");
        System.out.println("=================================");
    }

}
