package data_structure;

/**
 * Created by Odin on 2016-11-01.
 */
public class DIYRedBlackTreeNode {
    private boolean isRed = false;
    private int item;
    private DIYRedBlackTreeNode left = null;
    private DIYRedBlackTreeNode right = null;
    private DIYRedBlackTreeNode parent = null;

    public DIYRedBlackTreeNode(int item) {
        this.item = item;
    }

    public DIYRedBlackTreeNode(int item, DIYRedBlackTreeNode parent) {
        this.item = item;
        this.parent = parent;
    }

    public boolean isRed() {
        return isRed;
    }

    public void setRed(boolean red) {
        isRed = red;
    }

    public int getItem() {
        return item;
    }

    public DIYRedBlackTreeNode getLeft() {
        return left;
    }

    public void setLeft(DIYRedBlackTreeNode left) {
        this.left = left;
    }

    public DIYRedBlackTreeNode getRight() {
        return right;
    }

    public void setRight(DIYRedBlackTreeNode right) {
        this.right = right;
    }

    public DIYRedBlackTreeNode getParent() {
        return parent;
    }

    public void setParent(DIYRedBlackTreeNode parent) {
        this.parent = parent;
    }
}
