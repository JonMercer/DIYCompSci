package data_structure;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Odin on 2016-11-01.
 */
public class DIYRedBlackTreeImplTest {
    DIYRedBlackTree tree;
    @Before
    public void setUp() throws Exception {
        tree = new DIYRedBlackTreeImpl();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void add() throws Exception {
        tree.add(11);
        assertEquals(1, tree.size());
        tree.add(12);
        assertEquals(2, tree.size());
        tree.add(-30);
        assertEquals(3, tree.size());
        tree.add(-15);
        assertEquals(4, tree.size());
    }

    @Test
    public void remove() throws Exception {
        tree.add(11);
        tree.add(12);
        tree.add(-30);
        tree.add(-15);
        assertEquals(4, tree.size());
        tree.remove(11);
        assertEquals(3, tree.size());
        tree.remove(-15);
        assertEquals(2, tree.size());
        tree.remove(12);
        assertEquals(1, tree.size());
        tree.remove(-30);
        assertEquals(0, tree.size());
    }

    @Test
    public void inOder() throws Exception {

    }

    @Test
    public void size() throws Exception {
        assertEquals(0, tree.size());
        tree.add(11);
        tree.add(12);
        tree.add(-30);
        tree.add(-15);
        assertEquals(4, tree.size());
        tree.remove(11);
        assertEquals(3, tree.size());
        tree.remove(-15);
        assertEquals(2, tree.size());
        tree.remove(12);
        assertEquals(1, tree.size());
        tree.remove(-30);
        assertEquals(0, tree.size());
        assertEquals(0, tree.size());
    }

}