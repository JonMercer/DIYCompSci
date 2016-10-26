package data_structure;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Odin on 2016-10-23.
 */
public class DIYStackImplTest {

    DIYStack stack;
    @Before
    public void setUp() throws Exception {
        stack = new DIYStackImpl();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void push() throws Exception {
        assertEquals(true, stack.isEmpty());
        assertEquals(0, stack.length());
        stack.push("One");
        assertEquals(false, stack.isEmpty());
        assertEquals(1, stack.length());
        stack.push("One");
        assertEquals(2, stack.length());
        stack.push("Three");
        assertEquals(3, stack.length());
    }

    @Test
    public void pop() throws Exception {
        assertEquals(true, stack.isEmpty());
        stack.push("One");
        stack.push("Two");
        stack.push("Three");
        assertEquals(3, stack.length());
        assertEquals("Three", stack.pop());
        assertEquals(2, stack.length());
        assertEquals("Two", stack.pop());
        assertEquals(1, stack.length());
        assertEquals("One", stack.pop());
        assertEquals(0, stack.length());
        assertEquals(null, stack.pop());
        assertEquals(0, stack.length());
        assertEquals(true, stack.isEmpty());
    }

    @Test
    public void top() throws Exception {
        stack.push("one");
        stack.push("one");
        stack.push("two");
        assertEquals(3, stack.length());
        assertEquals("two", stack.top());
        assertEquals(3, stack.length());
        assertEquals("two", stack.top());
        assertEquals(3, stack.length());
    }

    @Test
    public void isEmpty() throws Exception {
        assertEquals(true, stack.isEmpty());
        stack.push("one");
        assertEquals(false, stack.isEmpty());
        stack.top();
        assertEquals(false, stack.isEmpty());
        stack.pop();
        assertEquals(true, stack.isEmpty());
    }

    @Test
    public void length() throws Exception {
        assertEquals(0, stack.length());
        stack.push("one");
        assertEquals(1, stack.length());
        stack.top();
        assertEquals(1, stack.length());
        stack.pop();
        assertEquals(0, stack.length());
        stack.push("one");
        stack.push("one");
        assertEquals(2, stack.length());
        stack.push("two");
        assertEquals(3, stack.length());
    }

}