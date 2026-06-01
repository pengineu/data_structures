package week13.MinHeap;

public class BHeap <Key extends Comparable<Key>, Value> {   //BHeap class
    private Entry[] a;                                      //Entry 배열 생성
    private int N;                                          //배열 요소의 개수

    public BHeap(Entry[] harray, int initialSize) {         //생성자
        a = harray;                                         //우선순위 큐 배열 초기화
        N = initialSize;                                    //초기 요소 개수 초기화
    }

    public int size() {                                     //size 메서드
        return N;                                           //요소의 개수 반환
    }

    public void createHeap() {                              //최소값이 root인 트리 배열로 만들어주는 메서드
        for (int i = N/2; i > 0; i--) {                     //리프 노드의 부모 노드부터 위로 감
            downHeap(i);                                    //자식 노드 둘과 자신 중 최소값을 부모 노드로 만듦
        }
    }
    private boolean grater(int i, int j) {                  //비교 메서드
        int t = a[i].getKey().compareTo(a[j].getKey());     //인덱스 i 의 key가 j의 key보다 크다면
        return t == 1;                                      //true 반환
    }
    private void upHeap(int j) {                            //위로 가면서 최소값을 올리는 메서드
        while (j != 1) {                                    //루트 노드까지 반복
            if (!grater(j, j/2)) {                        //자식 노드가 부모 노드보다 작다면
                swap(j, j/2);                             //부모와 자식 바꾸기
                j /= 2;                                     //다음 순회는 부모노드
            } else {                                        //한번이라도 부모노드가 더 작으면
                break;                                      //그 위는 이미 최소값 정렬되어있으니 break
            }
        }
    }
    public void insert(Key newKey, Value newValue) {        //새로운 값 삽입 메서드
        a[++N] = new Entry(newKey, newValue);               //새로운 객체 생성 후 마지막 노드에 넣음
        upHeap(N);                                          //마지막 노드를 올리면서 정렬함

    }

    public Entry deleteMin() {                              //최소값 삭제 메서드
        Entry min = a[1];                                   //최소값 = 루트 노드
        swap(1, N);                                       //루트 노드와 마지막 노드를 바꿈
        a[N--] = null;                                      //마지막 노드를 없앰
        downHeap(1);                                      //바뀐 루트 노드를 내려가면서 정렬
        return min;
    }

    private void downHeap(int i) {                          //아래로 가면서 정렬하는 메서드
        while (2*i <= N) {                                  //마지막 노드까지 반복
            int k = 2*i;                                    //k = i의 왼쪽 자식노드
            if (k < N && grater(k, k+1)) {                //i가 리프 노드가 아니고, 오른쪽 자식 노드보다 크다면
                k++;                                        //최소값 후보를 오른쪽 노드로
            }
            if (grater(i, k)) {                             //i보다 작다면
                swap(i, k);                                 //i와 작은 노드를 바꿔치기
                i = k;                                      //i를 자식노드로 이전하고 다시 반복
            } else {                                        //i보다 크다면
                break;                                      //그 아래는 정렬되어있으므로 종료
            }
        }
    }
    private void swap(int i, int j) {                       //인덱스 i 와 j의 Entry를 바꾸는 메서드
        Entry temp = new Entry(a[i].getKey(), a[i].getValue());     //i의 key와 value를 저장할 temp
        a[i].setKey(a[j].getKey());                         //i의 key를 j의 key로
        a[i].setValue(a[j].getValue());                     //i의 value를 j의 value로
        a[j].setKey(temp.getKey());                         //j의 key를 i의 key로
        a[j].setValue(temp.getValue());                     //j의 value를 i의 value로
    }

    public void print() {                                   //heap을 모두 출력하는 메서드
        for (int i = 1; i < N+1; i++) {                     //1부터 (0은 비워졌으니) 순회
            System.out.print("[" + a[i].getKey() + " " + a[i].getValue() + "] ");   //key와 value 출력
        }
        System.out.println();                               //가독성을 위한 줄바꿈
        System.out.println("힙 크기 = " + N);                //힙 크기 출력
        System.out.println();                               //가독성을 위한 줄바꿈
    }

}