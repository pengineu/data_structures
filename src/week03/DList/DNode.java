package week03.DList;

public class DNode <E> {                //Double Linked List Node 클래스
    private E item;                     //노드의 요소
    private DNode previous;             //이전 노드
    private DNode next;                 //다음 노드
    public DNode(E newItem, DNode p, DNode q) { //생성자
        item = newItem;                 //요소
        previous = p;                   //이전 노드
        next = q;                       //다음 노드
    }
    public E getItem() {                //getter
        return item;                    //노드의 요소 리턴
    }
    public DNode getPrevious() {        //getter
        return previous;                //이전 노드 리턴
    }
    public DNode getNext() {            //getter
        return next;                    //다음 노드 리턴
    }
    public void setItem(E newItem) {    //setter
        item = newItem;                 //노드 요소 설정
    }
    public void setPrevious(DNode p) {  //setter
        previous = p;                   //이전 노드의 reference를 p로 설정
    }
    public void setNext(DNode q) {      //setter
        next = q;                       //다음 노드의 reference를 p로 설정
    }
}
