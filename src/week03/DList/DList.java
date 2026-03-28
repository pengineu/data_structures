package week03.DList;
import java.util.NoSuchElementException;
public class DList <E> {                //Double Linked List class
    protected DNode head, tail;         //맨 앞과 맨 뒤 선언
    protected int size;                 //요소 개수 선언
    public DList(){                                         //생성자
        head = new DNode(null, null, null);   //head node 초기화
        tail = new DNode(null, head, null);   //tail 노드 초기화
        head.setNext(tail);                                 //head가 tail을 가리키도록 설정
        size = 0;                                           //크기는 0
    }
    public int size() {         //크기를 반환하는 함수
        return size;            //크기 반환
    }
    public boolean isEmpty() {  //비어있는지 확인
        return size == 0;
    }
    public void insertBefore(DNode p, E newItem) {              //p이전 노드에 새로운 노드 삽입
        DNode newNode = new DNode(newItem, p.getPrevious(), p); //이전 노드로 p의 이전 노드와 다음 노드로 p를 가리키는 새로운 노드 생성
        p.getPrevious().setNext(newNode);                       //p 이전 노드가 다음 노드로 새로운 노드를 가리키도록 설정
        p.setPrevious(newNode);                                 //p 노드가 이전 노드로 새로운 노드를 가리키도록 설정
        size++;                                                 //size를 하나 늘림
    }
    public void insertAfter(DNode p, E newItem) {               //p 다음 노드에 새로운 노드 삽입
        DNode newNode = new DNode(newItem, p, p.getNext());     //이전 노드로 p와 다음 노드로 p의 다음 노드를 가리키는 새로운 노드 생성
        p.getNext().setPrevious(newNode);                       //p의 다음 노드가 이전 노드로 새로운 노드를 가리키도록 설정
        p.setNext(newNode);                                     //p의 다음 노드로 새로운 노드를 설정
        size++;                                                 //size를 하나 늘림
    }
    public void delete(DNode x) {                     //x노드를 삭제
        x.getNext().setPrevious(x.getPrevious());     //x의 다음노드가 이전 노드로 x의 이전 노드를 가리키도록
        x.getPrevious().setNext(x.getNext());         //x의 이전노드가 다음노드로 x의 다음노드를 가리키도록
        x.setNext(null);                              //x노드의 reference 해제
        x.setPrevious(null);                          //x노드의 reference 해제
        size--;                                       //size를 하나 줄임
    }
    public void print() {                       //리스트의 모든 요소 출력
        if (isEmpty()) {                        //리스트가 비어있으면
            System.out.println("리스트 비어있음"); //해당 문자열 출력
        } else {
            DNode t = head.getNext();           //리스트를 순회할 t를 제일 앞 요소로 설정
            for (int i = 0; i < size; i++) {    //size만큼 순회
                System.out.print(t.getItem());  //t의 요소를 출력
                System.out.print(" ");          //가독성을 위한 공백
                t = t.getNext();                //순회하면서 t를 다음 노드로 옮김
            }
        }
    }
}
