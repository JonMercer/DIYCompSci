package data_structure;

/**
 * Created by Odin on 2016-10-25.
 */
public class DIYBinaryTreeImpl implements DIYBinaryTree {
    DIYBinaryTreeNode head = null;

    @Override
    public void add(int i) {
        if (head == null) {
            head = new DIYBinaryTreeNode(i);
            return;
        }

        DIYBinaryTreeNode temp = this.head;
        do {
            if (i == temp.getItem()) {
                return;
            } else if (i > temp.getItem()) {
                if (temp.getRight() == null) {
                    temp.setRight(new DIYBinaryTreeNode(i, temp));
                    return;
                } else {
                    temp = temp.getRight();
                    continue;
                }
            } else {
                if (temp.getLeft() == null) {
                    temp.setLeft(new DIYBinaryTreeNode(i, temp));
                    return;
                } else {
                    temp = temp.getLeft();
                    continue;
                }
            }

        } while (temp != null);
    }

    private DIYBinaryTreeNode search(int i, DIYBinaryTreeNode node) {
        if (node.getItem() == i) {
            return node;
        } else if (i < node.getItem()) {
            return search(i, node.getLeft());
        } else {
            return search(i, node.getRight());
        }
    }

    @Override
    public int[] inOrder() {
        if (head == null) {
            return new int[0];
        }

        int[] toReturn = new int[size()];
        int i = 0;

        return traverseInOrder(i, toReturn, head);
    }

    private int[] traverseInOrder(int i, int[] toReturn, DIYBinaryTreeNode node) {
        if (node == null) {
            return toReturn;
        }
        toReturn = traverseInOrder(i, toReturn, node.getLeft());
        toReturn[i] = node.getItem();
        i++;
        return traverseInOrder(i, toReturn, node.getRight());
    }

    @Override
    public int[] postOrder() {
        if (head == null) {
            return new int[0];
        }

        int[] toReturn = new int[size()];
        int i = 0;

        return traversePostOrder(i, toReturn, head);
    }

    private int[] traversePostOrder(int i, int[] toReturn, DIYBinaryTreeNode node) {
        if (node == null) {
            return toReturn;
        }
        toReturn = traverseInOrder(i, toReturn, node.getLeft());

        toReturn = traverseInOrder(i, toReturn, node.getRight());
        toReturn[i] = node.getItem();
        i++;
        return toReturn;
    }

    @Override
    public int[] preOrder() {
        if (head == null) {
            return new int[0];
        }

        int[] toReturn = new int[size()];
        int i = 0;

        return traversePreOrder(i, toReturn, head);
    }

    private int[] traversePreOrder(int i, int[] toReturn, DIYBinaryTreeNode node) {
        if (node == null) {
            return toReturn;
        }
        toReturn[i] = node.getItem();
        i++;
        toReturn = traverseInOrder(i, toReturn, node.getLeft());
        toReturn = traverseInOrder(i, toReturn, node.getRight());
        return toReturn;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        return count(head, 0);
    }

    private int count(DIYBinaryTreeNode node, int soFar) {
        if (node == null) {
            return soFar;
        }
        return count(node.getRight(), count(node.getLeft(), ++soFar));
    }
}
