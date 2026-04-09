package week05.ListStack;
import java.util.EmptyStackException;

public class ListStack <E>{     //ListStack class
    private Node<E> top;        //맨 위 노드
    private int size;           //stack 수
    public ListStack() {        //생성자
        top = null;             //아무것도 없는 스택 생성
        size = 0;               //stack 수는 0
    }

    public int size() {         //size를 반환하는 메서드
        return size;            //size를 반환
    }
    public boolean isEmpty() {  //비어있는지 확인
        return size == 0;       //size가 0이면 true 반환
    }

    public void push(E newItem) {               //push 메서드
        Node newNode = new Node(newItem, top);  //기존 맨위를 다음 노드로 하는 새로 넣을 노드 생성
        top = newNode;                          //기존 맨위를 가리키던 top을 새로운 노드를 가리키도록 함
        size++;                                 //size를 늘림
    }

    public E peek() {                           //peek 메서드
        if (isEmpty()) {                        //리스트가 비어있을 때
            throw new EmptyStackException();    //예외처리
        }
        return top.getItem();                   //맨 위 요소를 반환
    }

    public E pop() {                            //pop 메서드
        E returnVal = peek();                   //맨 위 요소를 가져옴(peek에서 이미 예외처리를 진행)
        top = top.getNext();                    //맨 위 노드를 없앰
        size--;                                 //size를 줄임
        return returnVal;                       //저장했던 맨 위 요소를 반환
    }
    public void print() {                       //print 메서드
        Node t = top;                           //순회할 노드 t를 설정
        for (int i = 0; i < size; i++) {        //size만큼 순회
            System.out.print(t.getItem());      //순회하는 노드의 요소를 print
            System.out.print(" ");              //가독성을 위한 공백
            t = t.getNext();                    //t를 다음 노드로 이어감
        }
        System.out.println();                   //가독성을 위한 줄바꿈
    }
}
