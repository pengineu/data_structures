package week03.CList;

public class CNode <E> {
    private E item;         //리스트 요소
    private CNode<E> next;   //요소 개수
    public CNode(E newItem, CNode<E> node) {  //생성자
        item = newItem;
        next = node;
    }
    public E getItem() {                    //getter
        return item;
    }
    public CNode<E> getNext() {              //getter
        return next;
    }
    public void setItem(E newItem) {        //setter
        item = newItem;
    }
    public void setNext(CNode<E> newNext) {  //setter
        next = newNext;
    }
}
