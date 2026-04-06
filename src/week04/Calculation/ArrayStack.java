package week04.Calculation;
import java.util.NoSuchElementException;

public class ArrayStack <E> {       // stack class
    private E[] s;                  //stack 을 구현할 array
    private int top;                //맨 마지막 요소를 가리키는 변수
    public ArrayStack() {           //생성자
        s = (E[]) new Object[1];    //배열 선언 및 초기화
        top = -1;                   //top을 -1로 설정(요소가없음)
    }
    public int size() {             //요소의 개수를 반환하는 메서드
        return top + 1;             //마지막 요소의 인덱스 + 1을 반환
    }
    public boolean isEmpty() {      //비어있는지 확인하는 메서드
        return (top == -1);         //마지막 요소가 없을 때 ture 반환
    }
    public E peek() {                                       //마지막 요소를 반환하는 메서드
        if (isEmpty()) throw new NoSuchElementException();  //예외처리
        return s[top];                                      //마지막 요소 반환
    }
    public void push(E newItem) {                           //마지막에 새로운 요소를 삽입하는 메서드
        if (s.length == size()) {                           //요소가 가득 차 있을 때
            resize(size()*2);                            //배열의 크기를 늘려서 공간 확보
        }
        s[++top] = newItem;                                 //top+1에 새로운 요소를 넣고 top을 하나 늘림

    }
    public E pop() {                                        //마지막 요소를 삭제하고 반환하는 메서드
        if (s.length > size()*4) {                          //배열의 크기가 요소의 크기보다 4배 이상 클 때
            resize(s.length / 2);                        //배열의 크기를 1/2로 줄임
        }
        return s[top--];                                    //top을 반환한 후 top을 하나 줄임
    }
    public void resize(int n) {                             //크기를 변환하는 함수
        E[] temp = (E[]) new Object[n];                     //새로운 크기의 배열 선언 및 초기화
        for (int i = 0; i < size(); i++) {                  //배열의 요소만큼 반복
            temp[i] = s[i];                                 //배열의 요소를 새로운 배열에 복사 & 붙여넣기
        }
        s = temp;                                           //크기가 바뀌고 요소는 모두 들어있는 배열을 원래 배열로
    }
}
