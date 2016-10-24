package data_structure;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * Created by Odin on 2016-10-23.
 */
public class DIYHashSetImplTest {

    public static final int MAX_SET_SIZE = 16;
    DIYHashSet set;

    @Before
    public void setUp() throws Exception {
        set = new DIYHashSetImpl(MAX_SET_SIZE);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void add() throws Exception {
        assertEquals(0, set.size());
        set.add("one");
        assertEquals(1, set.size());
        set.add("one");
        assertEquals(1, set.size());
        set.add("two");
        assertEquals(2, set.size());
        set.add("one");
        assertEquals(2, set.size());
    }

    @Test
    public void clear() throws Exception {
        set.add("one");
        set.add("Two");
        assertEquals(2, set.size());
        set.clear();
        assertEquals(0, set.size());
    }

    @Test
    public void contains() throws Exception {
        assertEquals(false, set.contains("one"));
        set.add("one");
        assertEquals(true, set.contains("one"));
        assertEquals(false, set.contains("two"));
        set.add("two");
        assertEquals(true, set.contains("two"));
    }

    @Test
    public void isEmpty() throws Exception {
        assertEquals(true, set.isEmpty());
        set.add("one");
        assertEquals(false, set.isEmpty());
        set.remove("one");
        assertEquals(true, set.isEmpty());
    }

    @Test
    public void remove() throws Exception {
        assertEquals(false, set.remove("one"));
        set.add("one");
        set.add("two");
        assertEquals(2, set.size());
        assertEquals(true, set.remove("one"));
        assertEquals(1, set.size());
        assertEquals(false, set.contains("one"));
        assertEquals(false, set.remove("three"));
        assertEquals(true, set.remove("two"));
        assertEquals(false, set.remove("two"));
    }

    @Test
    public void size() throws Exception {
        assertEquals(0, set.size());
        set.add("one");
        assertEquals(1, set.size());
        set.add("two");
        assertEquals(2, set.size());
        set.add("two");
        assertEquals(2, set.size());
        set.remove("one");
        assertEquals(1, set.size());
        set.remove("one");
        assertEquals(1, set.size());
        set.remove("two");
        assertEquals(0, set.size());
    }

    @Test
    public void iterator() throws Exception {
        set.add("one");
        set.add("two");
        set.add("three");

        Iterator<String> iterator = set.iterator();

        int count = 0;
        while (iterator.hasNext()) {
            String next = iterator.next();
            assertEquals(true, next == "one" || next == "two" || next == "three");
            count++;
        }

        assertEquals(3, count);
    }

    @Test
    public void lotOfItems() throws Exception {
        int totalItems = 500;
        DIYHashSet mySet = new DIYHashSetImpl(8);
        for (int i = 0; i < totalItems; i++) {
            mySet.add(String.valueOf(i));
        }
        assertEquals(totalItems, mySet.size());
        for (int i = 0; i < totalItems; i++) {
            assertEquals(true, mySet.contains(String.valueOf(i)));
        }

    }


}