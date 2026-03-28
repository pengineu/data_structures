package week03.SList;
import java.util.NoSuchElementException;
public class SList <E> {
    protected Node head;        //첫 번째 요소를 가리키는 head
    private int size;           //요소의 개수
    public SList() {            //생성자
        head = null;            //head 초기화
        size = 0;               //size 초기화
    }

    public Node getHead() {     //첫 번째 요소를 반환
        return head;
    }
    public void setHead(Node n) {   //head의 reference를 설정
        head = n;
    }
    public int size() {             //size를 반환
        return size;
    }
    public boolean isEmpty() {      //비어있는지 확인
        return size == 0;
    }
    public void insertFront(E newItem) {        //제일 앞에 newItem을 insert함
        Node newNode = new Node(newItem, head); //기존 head를 가리키는 새로운 노드 하나 생성
        head = newNode;                         //head의 reference를 바꿔줌
        size++;                                 //size를 하나 늘림
    }
    public void insertAfter(E newItem, Node p) {        //p 노드 다음에 삽입
        Node newNode = new Node(newItem, p.getNext());  //p노드 다음을 가리키는 새로운 노드 생성
        p.setNext(newNode);                             //p는 새로운 노드를 가리키도록
        size++;                                         //size를 하나 늘림
    }
    public void deleteFront() {                         //맨 앞 노드를 없앰
        if (size != 0) {                                //맨 앞 노드가 있을 때만 실행
            head = head.getNext();                      //head가 다음 노드를 가리키도록(기존의 맨 앞 노드는 reference를 받지 않기 때문에 가비지 컬렉터에 의해 자동으로 해제됨)
            size--;                                     //size를 하나 줄임
        }
    }
    public void deleteAfter(Node p) {                   //p 다음 노드를 삭제
        Node t = p.getNext();                           //삭제 후 reference까지 끊기 위해 p다음 노드를 t노드로 가리킴
        p.setNext(t.getNext());                         //p다음 노드를 다다음 노드로 가리킴
        t.setNext(null);                                //t가 가리키던 노드의 reference를 끊어줌
        size--;                                         //size를 하나 줄임
    }
    public int search(E target) {                       //리스트를 순회하면서 target의 인덱스를 반환
        Node t = head;                                  //t를 두어 시작점을 가리킴
        for (int i = 0; i < size; i++) {                //크기만큼 순회
            if (t.getItem() == target) {                //target과 같으면
                return i;                               //인덱스 반환
            }
            t = t.getNext();                            //순회하며 t를 하나씩 밀음
        }
        return -1;                                      //다 돌았는데도 없으면 -1반환
    }
    public void print() {                               //모든 요소 출력
        Node t = head;                                  //t를 두어 시작점을 가리킴
        for (int i = 0; i < size; i++) {                //크기만큼 순회
            System.out.print(t.getItem());              //순회하면서 t의 아이템을 출력
            System.out.print(" ");                      //가독성을 위한 공백 출력
            t = t.getNext();                            //t노드를 다음 노드로 옮김
        }
    }

}
