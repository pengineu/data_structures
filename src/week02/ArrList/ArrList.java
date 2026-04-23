package week02.ArrList;

public class ArrList <E> {
    private E[] a;          //ArrList 배열
    private int size;       //ArrList의 항목 수
    public ArrList() {      //생성자
        a = (E[]) new Object[1];    //크기가 1인 ArrList 초기화
        size = 0;                   //항목 수 0으로 초기화
    }

    public boolean isEmpty() {  //ArrList가 비었는지 확인해주는 함수
        return a.length == 0;   //a의 길이가 0이면 True 그대로 return
    }

    public void insertLast(E newItem) { //ArrList의 마지막 요소에 newItem을 추가해주는 함수
        if (size == a.length) {         //overflow 방지를 위해 항목 수가 길이와 같다면(ArrList가 꽉 차있다면)
            resize(size*2);     //늘어난 size만큼 공간 확보
        }
        a[size] = newItem;              //size가 마지막 요소의 인덱스이므로 a[size]에 newItem 저장
        size += 1;                  //size변수를 늘려줌
    }


    public void insert(E newItem, int k) {          //ArrList의 k번째 요소에 newItem을 넣고 이전 요소는 하나씩 밀어내는 함수
//        E[] temp = (E[]) new Object[a.length];      //a의 빼낼 요소들을 담아낼 temp 배열 생성
//        int idx = 0;                                //인덱스를 조절할 변수 설정
//        for (int i = size; i > k; i--) {           //size와 같은값인 i값을 줄여나가며 k번째 인덱스에 도달할 때까지 반복
//            temp[idx] = a[i-1];                     //temp에 0번째 인덱스부터 순서대로 a의 마지막부터 빼옴
//            idx += 1;                               //temp의 인덱스 조절
//        }
//
//        if (size == a.length) {                     //insert 하기 전, ArrList과 꽉 차있는지 확인
//            resize(2*size);                 //꽉 차있으면 insert 하기 전 overflow방지를 위해 크기를 2배로 늘림
//        }
//        a[k] = newItem;                             //k에 newItem Insert
//        int tempLength = idx;                       //temp의 요소 수를 세기 위한 변수 선언
//        for (int i = (k+1); tempLength + k >= i; i++) {      //값을 넣은 k보다 하나 더 큰 인덱스부터 넣은 요소의 수만큼 반복
//            a[i] = temp[--idx];                     //a의 k+1번째부터 temp에 저장된 것을 거꾸로 넣어줌
//        }
//        size += 1;                                  //요소가 하나 늘었으니 size값을 1 키워줌
        if (size == a.length) {                     //전부 차있는지 검사
            resize(size*2);                 //전부 차있다면 크기를 2배로 늘림
        }
        for (int i = size - 1; i >= k; i--) {       //size부터 k까지
            a[i] = a[i+1];                          //요소를 뒤로 밂
        }
        a[k] = newItem;                             //비워진 k에 새로운 값을 넣음
        size++;                                     //k가 새로 들어갔으니 size를 늘림
    }

    public E delete(int k) {                        //k번째 요소를 삭제하고 삭제한 값을 반환하는 함수
        E key = a[k];                               //삭제한 값을 저장
        for (int i = k; i < size-1; i++) {          //삭제할 요소부터 삭제할 요소에 다음 요소를 채워넣음
            a[i] = a[i+1];                            //기존 요소에 다음 요소의 값을 넣어서 삭제함
        }
        a[size] = null;                             //원래의 마지막 요소를 null로 바꿈
        size -= 1;                                  //size 변수를 하나 줄임

        if ((size*4) <= a.length) {                 //삭제 시 size가 줄어들기에 3/4 이상이 null이라면
            resize(a.length/2);             //ArrList의 크기를 반으로 줄임
        }
        return key;                                 //저장해두었던 삭제한 값 반환
    }

    public E peek(int k) {                          //k번째 인덱스 값을 반환하는 함수
        return a[k];                                //ArrList의 인덱스로 접근하여 반환
    }

    private void resize(int newSize) {              //ArrList의 크기를 변환하는 함수
        E[] resizeList = (E[]) new Object[newSize]; //newSize 크기의 새로운 제네릭 배열 생성
        for (int i = 0; i < size; i++) {            //기존 ArrList의 값을 순환
            resizeList[i] = a[i];                   //기존 ArrList의 값을 새로운 크기의 리스트에 순서대로 넣어줌
        }
        a = resizeList;                             //요소의 값은 같고, 크기만 늘어난 새로운 리스트를 ArrList에 할당
    }

    public void print() {                           //ArrList의 모든 요소를 출력하는 함수
        for (int i = 0; i < a.length; i++) {        //ArrList의 크기만큼 순회
            System.out.print(a[i]);                 //인덱스 순서대로 ArrList의 요소를 출력함
            System.out.print(' ');                  //가독성을 위해 출력 간격마다 띄어쓰기 문자를 추가해줌
        }
        System.out.println();                       //줄바꿈
    }
}