package data_structure;

/**
 * Created by Odin on 2016-11-01.
 */
public class DIYRedBlackTreeImpl implements DIYRedBlackTree {
    private DIYRedBlackTreeNode root = null;

    @Override
    public void add(int i) {
        if (root == null) {
            root = new DIYRedBlackTreeNode(i);
        }
    }

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
