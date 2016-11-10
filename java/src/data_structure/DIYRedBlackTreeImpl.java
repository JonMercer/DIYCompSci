package data_structure;

/**
 * Created by Odin on 2016-11-01.
 */
public class DIYRedBlackTreeImpl implements DIYRedBlackTree {
    private DIYRedBlackTreeNode root = null;


    //http://www.geeksforgeeks.org/red-black-tree-set-2-insert/
    @Override
    public void add(int i) {
        if (root == null) {
            root = new DIYRedBlackTreeNode(i);
        }

        insert(root, i);
    }

    private DIYRedBlackTreeNode insert(DIYRedBlackTreeNode node, int i) {
        if (node.getItem() == i) {
            return node;
        } else if (node.getItem() > i) {
            if (node.getRight() != null) {
                insert(node.getRight(), i);
            } else {
                return new DIYRedBlackTreeNode(i, node);
            }
        } else {
            if (node.getLeft() != null) {
                insert(node.getLeft(), i);
            } else {
                return new DIYRedBlackTreeNode(i, node);
            }
        }
        return null;
    }

    //http://www.geeksforgeeks.org/red-black-tree-set-3-delete-2/
    @Override
    public void remove(int i) {
        if (root.getLeft() == null && root.getRight() == null) {
            if (root.getItem() == i) {
                root = null;
            }
            return;
        }
    }

    @Override
    public int[] inOder() {
        return new int[0];
    }

    @Override
    public int size() {
        return 0;
    }
}
