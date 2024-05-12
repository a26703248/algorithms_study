package data_structure;

public class CustomHeapMain {
    public static void main(String[] args) {
        // [1, 2, 4, 3, 5, 30, 10, 12, 81, 7, ]
        // [1, 4, 2, 7, 5, 30, 3, 81, 12, 10, ]
        CustomHeap heap = new CustomHeap();
        heap.add(81);
        heap.add(1);
        heap.add(2);
        heap.add(10);
        heap.add(7);
        heap.add(30);
        heap.add(3);
        heap.add(12);
        heap.add(5);
        heap.add(4);
        System.out.println(heap);
        int searchIndex = heap.search(4);
        System.out.println(searchIndex);
    }
}
