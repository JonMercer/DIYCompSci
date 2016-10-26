package data_structure;

/**
 * Created by Odin on 2016-10-25.
 */
public class DIYBinaryTreeNode {
    private int item;
    private DIYBinaryTreeNode left;
    private DIYBinaryTreeNode right;
    private DIYBinaryTreeNode parent;

    public DIYBinaryTreeNode(int i) {
        this.item = i;
    }

    public DIYBinaryTreeNode(int i, DIYBinaryTreeNode parent) {
        this.item = i;
        this.parent = parent;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public DIYBinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(DIYBinaryTreeNode left) {
        this.left = left;
    }

    public DIYBinaryTreeNode getRight() {
        return right;
    }

    public void setRight(DIYBinaryTreeNode right) {
        this.right = right;
    }

    public DIYBinaryTreeNode getParent() {
        return parent;
    }

    public void setParent(DIYBinaryTreeNode parent) {
        this.parent = parent;
    }
}
