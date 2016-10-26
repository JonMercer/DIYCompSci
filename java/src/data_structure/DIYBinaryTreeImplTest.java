package data_structure;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Odin on 2016-10-25.
 */
public class DIYBinaryTreeImplTest {
    DIYBinaryTree tree;
    @Before
    public void setUp() throws Exception {
        tree = new DIYBinaryTreeImpl();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void add() throws Exception {
        tree.add(1);
        tree.add(1);
        tree.add(2);
        assertEquals(2, tree.size());
    }

    @Test
    public void inOrder() throws Exception {
        DIYBinaryTree myTree = new DIYBinaryTreeImpl();
        myTree.add(3);
        myTree.add(1);
        myTree.add(5);
        myTree.add(4);
        myTree.add(2);

        int[] order = myTree.inOrder();
        assertTrue(compare(new int[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4}, Ord.IN));
        assertTrue(compare(new int[]{1, 2, 3, 4, 5}, new int[]{3, 1, 5, 4, 2}, Ord.IN));
    }

    private enum Ord {
        PRE,
        POST,
        IN
    }

    private boolean compare(int[] solution, int[] entry, Ord ord) {
        DIYBinaryTree myTree = addBunch(entry);
        int[] order;
        switch (ord) {
            case PRE:
                order = myTree.preOrder();
                break;
            case POST:
                order = myTree.postOrder();
                break;
            case IN:
                order = myTree.inOrder();
                break;
            default:
                order = null; //crash it if i mess up
        }
        for (int i = 0; i < solution.length; i++) {
            if (solution[i] != order[i]) {
                return false;
            }
        }
        return true;
    }

    private DIYBinaryTree addBunch(int[] arr) {
        DIYBinaryTree myTree = new DIYBinaryTreeImpl();
        for (int item : arr) {
            myTree.add(item);
        }
        return myTree;
    }

    @Test
    public void postOrder() throws Exception {
        assertTrue(compare(new int[]{4, 3, 2, 1}, new int[]{1, 2, 3, 4}, Ord.POST));
        assertTrue(compare(new int[]{2, 1, 4, 5, 3}, new int[]{3, 1, 5, 4, 2}, Ord.POST));
    }

    @Test
    public void preOrder() throws Exception {
        assertTrue(compare(new int[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4}, Ord.PRE));
        assertTrue(compare(new int[]{3, 1, 2, 5, 4}, new int[]{3, 1, 5, 4, 2}, Ord.PRE));
    }

    @Test
    public void isEmpty() throws Exception {
        assertTrue(tree.isEmpty());
        tree.add(1);
        assertFalse(tree.isEmpty());
    }

    @Test
    public void isEmptyRemove() throws Exception {
        assertTrue(tree.isEmpty());
        tree.add(1);
        assertFalse(tree.isEmpty());
    }

    @Test
    public void size() throws Exception {
        assertEquals(0, tree.size());
        tree.add(1);
        assertEquals(1, tree.size());
    }

    @Test
    public void sizeRemoved() throws Exception {
        assertEquals(0, tree.size());
        tree.add(1);
        assertEquals(1, tree.size());
    }

}