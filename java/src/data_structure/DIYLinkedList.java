package data_structure;

/**
 * Created by Odin on 2016-10-23.
 */

/**
 * Advantage over array: linked list allocate memory on the fly
 */
public interface DIYLinkedList {
    void push(String item);
    String pop();
    boolean remove(String item);
    String get(int i);
    int length();
    boolean isEmpty();
    void printList();
}
