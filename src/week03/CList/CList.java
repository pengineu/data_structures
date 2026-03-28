package week03.CList;
import java.util.NoSuchElementException;

public class CList <E> {        //Circular Linked List class
    private CNode last;         //마지막 요소를 가리킴
    private int size;           //요소의 개수
    public CList() {            //생성자
        last = null;            //마지막 요소 초기화
        size = 0;               //사이즈 초기화
    }
    public int size() {         //요소의 개수를 반환하는 함수
        return size;            //size 반환
    }
    public boolean isEmpty() {  //empty 여부 반환하는 함수
        return size == 0;       //요소가 없으면 true 반환
    }
    public CNode getLast() {    //마지막 노드를 반환
        return last;
    }
    public void insert(E newItem) {                         //마지막 노드 다음에 삽입(맨 처음에 삽입)
        CNode newNode = new CNode(newItem, null);     //last의 다음 노드를 가리키는 새로운 노드 생성
        if (last == null) {                                 //last가 없는 초기의 경우
            last = newNode;                                 //newNode가 마지막이자
            newNode.setNext(newNode);                       //첫 노드
        } else {
            newNode.setNext(last.getNext());                //NewNode는 기존의 첫 번째 노드를 가리키고
            last.setNext(newNode);                          //기존 last의 다음 노드가 됨
        }
        size++;                                             //size를 늘려줌
    }
    public CNode delete() {                                 //마지막 노드 다음 노드를 제거(맨 처음 노드를 제거) 후 반환
        if (isEmpty()) throw new NoSuchElementException();  //비어있는 경우 삭제할 경우 예외
        CNode t = last.getNext();                           //reference를 끊기 위해 t를 설정
        if (last == t) {                                    //요소가 1개라면
            last = null;                                    //마지막을 없앰
        } else {
            last.setNext(t.getNext());                      //기존 last의 다음 노드가 삭제할 노드의 다음 노드를 가리키도록
            t.setNext(null);                                //삭제할 노드의 reference를 끊어줌
        }
        size--;                                             //size를 하나 줄임
        return t;                                           //t반환
    }
    public void print() {                                   //리스트의 모든 요소 출력
        CNode t = last.getNext();                           //리스트를 순회할 t 초기화
        for (int i = 0; i < size; i++) {                    //size만큼 순회
            System.out.print(t.getItem());                  //t에 해당하는 요소 출력
            System.out.print(" ");                          //가독성을 위한 공백
            t = t.getNext();                                //t를 다음 노드로 바꿈
        }
    }
}
