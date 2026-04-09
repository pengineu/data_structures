package week05.ListQueue;
import java.util.NoSuchElementException;
public class ListQueue <E> {        //ListQueue class
    private Node<E> front, rear;    //front 와 rear 선언
    private int size;               //size 선언
    public ListQueue() {            //생성자
        front = rear = null;        //초기 null
        size = 0;                   //size 0
    }

    public int size() {             //size를 반환하는 메서드
        return size;                //size 반환
    }
    public boolean isEmpty() {      //비어있는지 확인
        return size==0;             //size가 0이면 true 반환
    }
    public void add(E newItem) {                        //queue에 새로운 요소를 추가하는 메서드
        Node newNode = new Node(newItem, null);   //새로운 노드 객체 생성
        if (isEmpty()) {                                //비어있으면
            front = newNode;                            //새로운 노드 또한 맨 앞 노드가 됨
        } else {                                        //비어있지 않으면
            rear.setNext(newNode);                      //기존 맨 뒤 노드가 새로운 노드를 가리키도록
        }
        rear = newNode;                                 //새로운 노드를 맨 뒤 노드로
        size++;                                         //size를 늘림
    }
    public E remove(){                                  //맨 앞 노드를 제거하고 반환하는 메서드
        if (isEmpty()) {                                //비어있는지 확인
            throw new NoSuchElementException();         //예외처리
        }
        E returnVal = front.getItem();                  //노드를 삭제하기 전 요소의 값 저장
        front = front.getNext();                        //맨 앞 노드를 없앰
        if (front == null) {                            //노드가 1개일 때
            rear = null;                                //rear가 가리키고 있던 것도 삭제
        }
        size--;                                         //size를 하나 줄임
        return returnVal;                               //저장하고 있던 요소 값 반환
    }
    public void print() {                               //print 메서드
        Node t = front;                                 //맨 앞부터 순회할 t 설정
        for (int i = 0; i < size; i++) {                //size만큼 순회
            System.out.print(t.getItem());              //순회하는 노드의 요소를 print
            System.out.print(" ");                      //가독성을 위한 공백
            t = t.getNext();                            //t를 다음 노드로 이어감
        }
        System.out.println();                           //가독성을 위한 줄바꿈
    }
}
