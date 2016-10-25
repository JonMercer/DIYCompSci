package data_structure;

import java.util.List;

/**
 * Created by Odin on 2016-10-25.
 */
public interface DIYBinaryTree {
    void add(int i);

    void remove(int i);

    List<Integer> inOrder();

    List<Integer> postOrder();

    List<Integer> preOrder();

    boolean isEmpty();

    int size();

}
