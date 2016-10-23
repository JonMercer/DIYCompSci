package data_structure;

/**
 * Created by Odin on 2016-10-23.
 */
public class DIYStackImpl implements DIYStack {

    DIYStackNode node = null;

    @Override
    public void push(String s) {
        if (node == null) {
            node = new DIYStackNode(s);
            return;
        }

        node = new DIYStackNode(s, this.node);
    }

    @Override
    public String pop() {
        if (node == null) {
            return null;
        }
        String temp = node.getItem();
        node = node.getParent();
        return temp;
    }

    @Override
    public String top() {
        if (node == null) {
            return null;
        }
        return node.getItem();
    }

    @Override
    public boolean isEmpty() {
        if (node == null) {
            return true;
        }
        return false;
    }

    @Override
    public int length() {
        return traverseNodes(0, node);
    }

    private int traverseNodes(int count, DIYStackNode tempNode) {
        if (tempNode == null) {
            return count;
        }
        return traverseNodes(++count, tempNode.getParent());
    }
}
