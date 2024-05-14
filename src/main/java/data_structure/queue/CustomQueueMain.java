package data_structure.queue;

public class CustomQueueMain {
    public static void main(String[] args) {
        CustomQueue customQueue = new CustomQueue();
        customQueue.enqueue(1);
        System.out.println(customQueue);
        customQueue.enqueue(2);
        System.out.println(customQueue);
        customQueue.enqueue(3);
        System.out.println(customQueue);
        customQueue.enqueue(4);
        System.out.println(customQueue);
        customQueue.enqueue(5);
        customQueue.dequeue();
        System.out.println(customQueue);
        customQueue.dequeue();
        System.out.println(customQueue);
        customQueue.dequeue();
        System.out.println(customQueue);
        customQueue.dequeue();
        System.out.println(customQueue);
    }
}
