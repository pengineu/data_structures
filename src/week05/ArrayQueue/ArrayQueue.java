package week05.ArrayQueue;
import java.util.NoSuchElementException;
public class ArrayQueue <E> {       //ArrayQueue class
    private E[] q;                  //배열 선언
    private int front, rear, size;  //변수들 선언
    public ArrayQueue() {           //생성자
        q = (E[]) new Object[2];    //크기 2의 배열 (1+1)
        front = rear = size = 0;    //변수 초기화
    }

    public int size(){              //size를 반환하는 메서드
        return size;                //size 반환
    }

    public boolean isEmpty() {      //비어있는지 확인
        return size == 0;           //size가 0이면 true 반환
    }

    public void add(E newItem) {        //새로운 요소 queue에 삽입
        if (size+1 == q.length) {       //비어있는 요소가 1개뿐일경우(가득 찬 경우)
            resize(q.length*2); //2배로 크기를 늘림
        }
        rear = (rear + 1) % q.length;   //rear를 뒤로 하나 밀음, 맨 뒤면 맨 앞으로 오게 함
        q[rear] = newItem;              //rear에 새 요소를 넣음
        size++;                         //size를 하나 늘림
    }

    public E remove() {                         //맨 앞을 없애고 반환하는 메서드
        if (size*4 < q.length) {                //리스트에 빈 값이 3/4이상이라면
            resize(q.length / 2);       //크기를 반으로 줄임
        }
        if (isEmpty()){                         //비어있는경우
            throw new NoSuchElementException(); //예외처리
        }
        E returnVal = q[front];                 //반환할 값 저장
        front = (front + 1) % q.length;         //front를 뒤로 밀음
        q[front] = null;                        //front다음 요소가 맨 앞 요소이므로 민 후에 삭제
        size--;                                 //size를 하나 줄임
        return returnVal;                       //저장한 값 반환
    }

    public void resize(int newSize) {                       //리스트의 크기를 조정하는 메서드
        E[] newQueue = (E[]) new Object[newSize];           //지정한 크기의 새로운 배열 생성
        for (int i = front, j = 1; j < size+1; i++, j++) {  //size만큼 순회
            newQueue[j] = q[(i+1) % q.length];              //front다음 요소가 저장되어있는 요소의 시작이므로 i+1으로 순회, 맨 끝으로 가면 맨 앞으로 돌려줌
        }                                                   //newQueue에는 front를 다시 앞으로 하기 위해 j라는 변수로 순회
        q = newQueue;                                       //새로운 배열을 기존 배열에 덮어씌움
        front = 0;                                          //front초기화
        rear = size;                                        //rear를 다시 맞춰줌
    }

    public void print() {                       //모든 요소를 출력하는 메서드
        for (int i = 0; i < q.length; i++) {    //길이만큼 순회
            System.out.print(q[i]);             //배열의 모든 요소 출력
            System.out.print(" ");              //가독성을 위한 공백
        }
        System.out.println();                   //가독성을 위한 줄바꿈
    }
}
