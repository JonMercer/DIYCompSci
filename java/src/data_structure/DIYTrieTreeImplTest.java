package data_structure;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Odin on 2016-10-28.
 */
public class DIYTrieTreeImplTest {
    DIYTrieTree tree;

    @Before
    public void setUp() throws Exception {
        tree = new DIYTrieTreeImpl();
    }
    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void add() throws Exception {
        assertEquals(0, tree.size());
        tree.add("dog");
        assertEquals(3, tree.size());
        tree.add("dog");
        assertEquals(3, tree.size());
        tree.add("doggy");
        assertEquals(5, tree.size());
        tree.add("dogs");
        assertEquals(6, tree.size());
        tree.add("dogsitting");
        assertEquals(12, tree.size());
        assertEquals(4, tree.wordCount());
        ((DIYTrieTreeImpl) tree).debug();
    }

    @Test
    public void clear() throws Exception {
        assertEquals(0, tree.size());
        tree.add("dog");
        tree.clear();
        assertEquals(0, tree.size());
    }

    @Test
    public void predict() throws Exception {
        tree.add("dog");
        tree.add("dog");
        tree.add("doggy");
        tree.add("dogs");
        tree.add("dogsitting");

        List<String> dogg = tree.predict("dogg");
        assertEquals(1, dogg.size());
        assertEquals("doggy", dogg.get(0));

        List<String> dog = tree.predict("dog");
        assertEquals(4, dog.size());
        for (int i = 0; i < dog.size(); i++) {
            if (i == 0) {
                assertEquals("dog", dog.get(i));
            } else if (i == 1) {
                assertEquals("dogs", dog.get(i));
            } else if (i == 2) {
                assertEquals("dogsitting", dog.get(i));
            } else if (i == 2) {
                assertEquals("doggy", dog.get(i));
            }
        }
    }

    @Test
    public void predictSimple() throws Exception {
        tree.add("a");
        tree.add("aa");
        tree.add("ab");
        tree.add("ab");


        List<String> a = tree.predict("a");
        assertEquals(3, a.size());

        tree.add("abc");

        List<String> c = tree.predict("a");
        assertEquals(4, c.size());
    }

    @Test
    public void perdictOne() throws Exception {
        tree.add("a");
        tree.add("abc");

        List<String> c = tree.predict("a");
        assertEquals(2, c.size());
    }

//    @Test
//    public void testSort() {
//        List<DIYTrieTreeNode> nodes = new ArrayList<>();
//        nodes.add(new DIYTrieTreeNode('a',1));
//        nodes.add(new DIYTrieTreeNode('b',2));
//        nodes.add(new DIYTrieTreeNode('c',3));
//        nodes.add(new DIYTrieTreeNode('d',4));
//        Collections.sort(nodes);
//        System.out.println("hi");
//
//    }

    @Test
    public void size() throws Exception {
        assertEquals(0, tree.size());
        tree.add("hi");
        assertEquals(2, tree.size());
        tree.add("hi");
        assertEquals(2, tree.size());
        tree.add("hello");
        assertEquals(6, tree.size());
        tree.clear();
        assertEquals(0, tree.size());


    }

    @Test
    public void wordCount() throws Exception {
        assertEquals(0, tree.wordCount());
        tree.add("hi");
        assertEquals(1, tree.wordCount());
        tree.add("hi");
        assertEquals(1, tree.wordCount());
        tree.add("hello");
        assertEquals(2, tree.wordCount());
        tree.clear();
        assertEquals(0, tree.wordCount());
    }

}