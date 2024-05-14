package data_structure.queue;

import java.util.Iterator;

public interface Queue<T>{
    void enqueue(T o);

    T dequeue();

    Iterator<T> iterator();
}
