package data_structure;

/**
 * Created by Odin on 2016-10-24.
 */
public class DIYHashMapNode<K, V> {
    private K k;
    private V v;
    private DIYHashMapNode<K, V> parent;
    private DIYHashMapNode<K, V> child;

    public DIYHashMapNode(K k, V v) {
        this.k = k;
        this.v = v;
    }

    public K getK() {
        return k;
    }

    public void setK(K k) {
        this.k = k;
    }

    public V getV() {
        return v;
    }

    public void setV(V v) {
        this.v = v;
    }

    public DIYHashMapNode<K, V> getParent() {
        return parent;
    }

    public void setParent(DIYHashMapNode<K, V> parent) {
        this.parent = parent;
    }

    public DIYHashMapNode<K, V> getChild() {
        return child;
    }

    public void setChild(DIYHashMapNode<K, V> child) {
        this.child = child;
    }
}
