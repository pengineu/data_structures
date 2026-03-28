package week03.SList;

public class Node <E> {
    private E item;         //리스트 요소
    private Node<E> next;   //다음 요소
    public Node(E newItem, Node<E> node) {  //생성자
        item = newItem;
        next = node;
    }
    public E getItem() {                    //getter
        return item;
    }
    public Node<E> getNext() {              //getter
        return next;
    }
    public void setItem(E newItem) {        //setter
        item = newItem;
    }
    public void setNext(Node<E> newNext) {  //setter
        next = newNext;
    }
}
