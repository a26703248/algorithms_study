package data_structure.stack;

import java.util.Iterator;

public interface Stack<T> {

    void push(T t);

    T pop();

    T peek();

    Iterator<T> iterator();

}
