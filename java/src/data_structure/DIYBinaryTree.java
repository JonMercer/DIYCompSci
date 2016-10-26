package data_structure;

import java.util.List;

/**
 * Created by Odin on 2016-10-25.
 */
public interface DIYBinaryTree {
    void add(int i);

    int[] inOrder();

    int[] postOrder();

    int[] preOrder();

    boolean isEmpty();

    int size();

}
