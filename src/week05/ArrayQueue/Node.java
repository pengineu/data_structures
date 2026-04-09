package week05.ArrayQueue;

public class Node <E> {
    private E item;         //리스트 요소
    private Node<E> next;   //다음 요소
    public Node(E newItem, Node<E> node) {  //생성자
        item = newItem;
        next = node;
    }
    public E getItem() {                    //getter
        return item;                        //요소 반환
    }
    public Node<E> getNext() {              //getter
        return next;                        //다음 노드 반환
    }
    public void setItem(E newItem) {        //setter
        item = newItem;                     //요소 설정
    }
    public void setNext(Node<E> newNext) {  //setter
        next = newNext;                     //다음 노드 설정
    }
}
