package data_structure;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Odin on 2016-10-23.
 */
public class DIYLinkedListImplTest {
    private static final String ITEM = "item";
    public static final List STRINGS = Collections.unmodifiableList(
            Arrays.asList("ONE", "TWO", "THREE", "FOUR", "FIVE"));


    DIYLinkedList linkedlist;
    @org.junit.Before
    public void setUp() throws Exception {
        linkedlist = new DIYLinkedListImpl();
    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void pushOne() throws Exception {
        linkedlist.push(ITEM);
        assertEquals(1, linkedlist.length());
    }

    @org.junit.Test
    public void pushThree() throws Exception {
        String item1 = "One";
        String item2 = "Two";
        String item3 = "Three";
        linkedlist.push(item1);
        linkedlist.push(item2);
        linkedlist.push(item3);
        assertEquals(3, linkedlist.length());
    }

    @org.junit.Test
    public void popOne() throws Exception {
        assertEquals(null, linkedlist.pop());
        linkedlist.push(ITEM);
        assertEquals(ITEM, linkedlist.pop());
    }

    @org.junit.Test
    public void popThree() throws Exception {
        linkedlist.push("One");
        linkedlist.push("Two");
        linkedlist.push("Three");
        assertEquals(3, linkedlist.length());
        assertEquals("Three", linkedlist.pop());
        assertEquals(2, linkedlist.length());
        assertEquals("Two", linkedlist.pop());
        assertEquals(1, linkedlist.length());
        assertEquals("One", linkedlist.pop());
        assertEquals(0, linkedlist.length());

    }

    @org.junit.Test
    public void remove() throws Exception {
        assertEquals(false, linkedlist.remove(ITEM));
        populateLinkedLIst();
        assertEquals(STRINGS.size(), linkedlist.length());
        assertEquals(false, linkedlist.remove("FOO"));
        assertEquals(STRINGS.size(), linkedlist.length());

        for (int i = 0; i < STRINGS.size(); i++) {
            assertEquals(true, linkedlist.remove((String) STRINGS.get(i)));
            assertEquals(false, linkedlist.remove((String) STRINGS.get(i)));
            assertEquals(STRINGS.size() - i - 1, linkedlist.length());
        }
    }

    private void populateLinkedLIst() {
        for (int i = 0; i < STRINGS.size(); i++) {
            linkedlist.push((String) STRINGS.get(i));
        }
    }

    @org.junit.Test
    public void get() throws Exception {
        assertEquals(null, linkedlist.get(0));
        populateLinkedLIst();
        for (int i = 0; i < STRINGS.size(); i++) {
            assertEquals(STRINGS.get(0), linkedlist.get(0));
            assertEquals(STRINGS.get(0), linkedlist.get(0));
            assertEquals(STRINGS.size(), linkedlist.length());
        }

    }

    @org.junit.Test
    public void length100() throws Exception {
        assertEquals(0, linkedlist.length());
        int size = 100;

        for (int i = 0; i < size; i++) {
            linkedlist.push(ITEM);
        }
        assertEquals(size, linkedlist.length());
    }

    @org.junit.Test
    public void lengthTwo() throws Exception {
        assertEquals(0, linkedlist.length());
        linkedlist.push("one");
        assertEquals(1, linkedlist.length());
        linkedlist.push("two");
        assertEquals(2, linkedlist.length());
    }

    @org.junit.Test
    public void lengthZero() throws Exception {
        assertEquals(0, linkedlist.length());
    }

    @org.junit.Test
    public void lengthOne() throws Exception {
        assertEquals(0, linkedlist.length());
        linkedlist.push("one");
        assertEquals(1, linkedlist.length());
    }

    @org.junit.Test
    public void isEmpty() throws Exception {
        assertEquals(true, linkedlist.isEmpty());
        linkedlist.push(ITEM);
        assertEquals(false, linkedlist.isEmpty());
        linkedlist.pop();
        assertEquals(true, linkedlist.isEmpty());
    }

}