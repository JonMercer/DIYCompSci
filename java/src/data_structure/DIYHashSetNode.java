package data_structure;

/**
 * Created by Odin on 2016-10-23.
 */
public class DIYHashSetNode {
    private String item;
    private DIYHashSetNode next = null;
    private DIYHashSetNode parent = null;

    public DIYHashSetNode(String item) {
        this.item = item;
    }

    public DIYHashSetNode(String s, DIYHashSetNode parent) {
        this.item = s;
        this.parent = parent;

    }

    public String getItem() {
        return this.item;
    }


    public DIYHashSetNode getNext() {
        return next;
    }

    public void setNext(DIYHashSetNode next) {
        this.next = next;
    }

    public DIYHashSetNode getParent() {
        return parent;
    }

    public void setParent(DIYHashSetNode parent) {
        this.parent = parent;
    }
}
