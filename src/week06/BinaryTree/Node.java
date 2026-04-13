package week06.BinaryTree;

public class Node <Key extends Comparable<Key>> {
    private Key item;
    private Node<Key> left;
    private Node<Key> right;

    public Node(Key newItem, Node lt, Node rt) {
        item = newItem;
        left = lt;
        right = rt;
    }

    public Key getItem() {
        return item;
    }
    public void setItem(Key newItem) {
        item = newItem;
    }

    public void setLeft (Node<Key> newNode) {
        left = newNode;
    }

    public void setRight(Node<Key> newNode) {
        right = newNode;
    }

    public Node<Key> getLeft() {
        return left;
    }

    public Node<Key> getRight() {
        return right;
    }
}
