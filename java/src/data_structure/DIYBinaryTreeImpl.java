package data_structure;

/**
 * Created by Odin on 2016-10-25.
 */
public class DIYBinaryTreeImpl implements DIYBinaryTree {
    DIYBinaryTreeNode head = null;

    private enum Order {
        PRE,
        POST,
        IN
    }

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
            return null;
        }

        int[] toReturn = new int[size()];
        int i = 0;

        traverseInOrder(i, toReturn, head, Order.IN);
        return toReturn;
    }

    private int traverseInOrder(int i, int[] toReturn, DIYBinaryTreeNode node, Order order) {
        if (node == null) {
            return i;
        }

        switch (order) {
            case IN:
                i = traverseInOrder(i, toReturn, node.getLeft(), order);
                toReturn[i] = node.getItem();
                i++;
                i = traverseInOrder(i, toReturn, node.getRight(), order);
                break;
            case PRE:
                toReturn[i] = node.getItem();
                i++;
                i = traverseInOrder(i, toReturn, node.getLeft(), order);
                i = traverseInOrder(i, toReturn, node.getRight(), order);
                break;
            case POST:
                i = traverseInOrder(i, toReturn, node.getLeft(), order);
                i = traverseInOrder(i, toReturn, node.getRight(), order);
                toReturn[i] = node.getItem();
                i++;
                break;
        }

        return i;
    }

    @Override
    public int[] postOrder() {
        if (head == null) {
            return new int[0];
        }

        int[] toReturn = new int[size()];
        int i = 0;

        traverseInOrder(i, toReturn, head, Order.POST);
        return toReturn;
    }

    @Override
    public int[] preOrder() {
        if (head == null) {
            return new int[0];
        }

        int[] toReturn = new int[size()];
        int i = 0;

        traverseInOrder(i, toReturn, head, Order.PRE);
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
