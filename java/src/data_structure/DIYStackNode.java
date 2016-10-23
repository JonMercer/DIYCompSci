package data_structure;

/**
 * Created by Odin on 2016-10-23.
 */
public class DIYStackNode {
    private String item = null;
    private DIYStackNode parent = null;

    public DIYStackNode(String item, DIYStackNode next) {
        this.parent = next;
        this.item = item;
    }
    public DIYStackNode(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public DIYStackNode getParent() {
        return parent;
    }

    public void setParent(DIYStackNode parent) {
        this.parent = parent;
    }
}
