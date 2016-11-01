package data_structure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Odin on 2016-10-28.
 */
public class DIYTrieTreeImpl implements DIYTrieTree {
    DIYTrieTreeNode root = new DIYTrieTreeNode(' ');

    @Override
    public void add(String s) {
        if (s == null || s.equals("")) {
            return;
        }

        placeInTree(s, 0, root);
    }

    private void placeInTree(String s, int i, DIYTrieTreeNode parent) {
        if (parent == null) {
            return;
        }

        DIYTrieTreeNode child = parent.setChild(s.charAt(i));
        if (i == s.length() - 1) {
            child.setEndOfWord();
            return;
        }
        placeInTree(s, ++i, child);
    }

    @Override
    public void clear() {
        root = new DIYTrieTreeNode(' ');
    }

    @Override
    public List<String> predict(String s) {
        DIYTrieTreeNode node = rootOfPrediction(s, 0, root);
        List<String> strings = new ArrayList<>();
        getAllPredictions(node, strings, s.substring(0, s.length()-1));
        return strings;
    }

    private DIYTrieTreeNode rootOfPrediction(String s, int i, DIYTrieTreeNode node) {
        if (s.length() == i) {
            return node;
        }

        for (int j = 0; j < node.getChildren().size(); j++) {
            if (node.getChildren().get(j).getItem() == s.charAt(i)) {
                return rootOfPrediction(s, ++i, node.getChildren().get(j));
            }
        }

        return null;
    }

    private void getAllPredictions(DIYTrieTreeNode node, List<String> stringsToFillUp, String stringSoFar) {
        if (node.getChildren().size() == 0) {
            stringSoFar += node.getItem();
            stringsToFillUp.add(stringSoFar);
            return;
        } else {
            Collections.sort(node.getChildren());
        }

        if (node.isEndOfWord() && stringsToFillUp.size() > 0) {

            stringSoFar += node.getItem();
            stringsToFillUp.add(stringSoFar);
        }
        stringSoFar += node.getItem();
        for (DIYTrieTreeNode child : node.getChildren()) {
            getAllPredictions(child, stringsToFillUp, stringSoFar);
        }
    }

    @Override
    public int size() {
        if (root.getChildren().size() == 0) {
            return 0;
        }
        return getCount(root) - 1;
    }

    private int getCount(DIYTrieTreeNode node) {
        if (node == null) {
            return 0;
        }
        int k = 1;
        List<DIYTrieTreeNode> children = node.getChildren();
        for (int i = 0; i < children.size(); i++) {
            k = k + getCount(children.get(i));
        }
        return k;
    }

}
