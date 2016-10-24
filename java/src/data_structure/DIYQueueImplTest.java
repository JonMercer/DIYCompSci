package data_structure;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Odin on 2016-10-23.
 */
public class DIYQueueImplTest {
    private static final int MAX_QUEUE_SIZE = 16;

    private DIYQueue q;
    @Before
    public void setUp() throws Exception {
        q = new DIYQueueImpl(MAX_QUEUE_SIZE);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void enqueue() throws Exception {
        assertEquals(true, q.isEmpty());
        assertEquals(0, q.size());
        q.enqueue("one");
        assertEquals(false, q.isEmpty());
        assertEquals(1, q.size());
        q.enqueue("one");
        assertEquals(2, q.size());
        q.enqueue("two");
        assertEquals(3, q.size());
    }

    @Test
    public void dequeue() throws Exception {
        assertEquals(true, q.isEmpty());
        q.enqueue("zero");
        assertEquals("zero", q.dequeue());
        assertEquals(true, q.isEmpty());
        assertEquals(0, q.size());
        q.enqueue("one");
        q.enqueue("two");
        q.enqueue("three");
        assertEquals(3, q.size());
        assertEquals("one", q.dequeue());
        assertEquals(2, q.size());
        assertEquals("two", q.dequeue());
        assertEquals(1, q.size());
        assertEquals("three", q.dequeue());
        assertEquals(0, q.size());
        assertEquals(null, q.dequeue());
    }

    @Test
    public void isEmpty() throws Exception {
        assertEquals(true, q.isEmpty());
        q.enqueue("one");
        assertEquals(false, q.isEmpty());
        q.dequeue();
        assertEquals(true, q.isEmpty());
    }

    @Test
    public void size() throws Exception {
        assertEquals(0, q.size());
        q.enqueue("one");
        assertEquals(1, q.size());
        q.enqueue("two");
        assertEquals(2, q.size());
        q.dequeue();
        assertEquals(1, q.size());
        q.dequeue();
        assertEquals(0, q.size());
    }

    @Test
    public void bigQueue() throws Exception {
        int queue_size = 3;
        DIYQueue myQueue = new DIYQueueImpl(queue_size);

        myQueue.enqueue("one");
        myQueue.enqueue("two");
        myQueue.enqueue("three");
        myQueue.enqueue("four");

        assertEquals(queue_size, myQueue.size());
        assertEquals("one", myQueue.dequeue());
        assertEquals(2, myQueue.size());
        assertEquals("two", myQueue.dequeue());
        assertEquals(1, myQueue.size());
        assertEquals("three", myQueue.dequeue());
        assertEquals(0, myQueue.size());
        assertEquals(null, myQueue.dequeue());

    }

        @Test
    public void biggerQueue() throws Exception {
        for (int i = 0; i < MAX_QUEUE_SIZE * 3; i++) {
            q.enqueue(String.valueOf(i));
        }
        assertEquals(MAX_QUEUE_SIZE, q.size());

        for (int i = 0; i < MAX_QUEUE_SIZE; i++) {
            assertEquals(String.valueOf(i), q.dequeue());
        }

        assertEquals(true, q.isEmpty());
    }

}