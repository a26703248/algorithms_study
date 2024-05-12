package data_structure;

import java.util.*;

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
        arr2.add(5);
        arr2.add(6);
        arr2.add(7);
        arr2.add(8);
        arr2.add(9);
//        arr2.remove(3);
//        arr2.addAll(arr1);
        end = System.currentTimeMillis();
        System.out.println(arr2);
        System.out.println(arr2.size());
        System.out.println("cost: " + (end-start) + " ms");
        System.out.println("=================================");
        try {
            arr2.removeAll(arr1);
        } catch (Exception e) {
            // pass
        }
        System.out.println(arr2);
    }

}
