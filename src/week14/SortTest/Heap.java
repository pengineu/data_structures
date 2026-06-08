package week14.SortTest;

public class Heap {
    private static boolean isLess(Comparable i, Comparable j) {     //비교 메서드
        return (i.compareTo(j) < 0);                                //첫 번째 인자가 더 적으면 true 반환
    }
    private static void swap(Comparable[] arr, int i, int j) {      //두 요소의 위치를 바꾸는 메서드
        Comparable temp = arr[i];                                   //arr[i] 와
        arr[i] = arr[j];                                            //arr[j] 를 바꿈
        arr[j] = temp;
    }
    public static void downHeap(Comparable arr[], int p, int size) {//heap을 만드는 메서드
        while (2 * p <= size) {                                     //자식이 존재할 때까지 반복
            int s = 2 * p;                                          //자식 s
            if (s < size && isLess(arr[2*p], arr[2*p + 1])) {       //자식이 범위 안에 있고, 오른쪽 자식이 더 크다면
                s++;                                                //비교할 대상을 오른쪽 자식으로 넘김
            }
            if (isLess(arr[p], arr[s])) {                           //자식과 부모를 비교해서 자식이 더 크다면
                swap(arr, p, s);                                    //부모와 바꿈
            }
            p = s;                                                  //자식을 부모로 만듦
        }
    }
    public static void sort(Comparable[] arr) {                     //Heap sort 메서드
        int size = arr.length - 1;                                  //Heap sort는 인덱스 1부터 시작
        for (int i = size/2; i > 0; i--) {                          //MaxHeap을 만듦
            downHeap(arr, i, size);
        }
        while (size > 1) {                                          //size만큼 반복
            swap(arr, 0, size);                                   //Max를 맨 뒤에 넣음
            size--;                                                 //size를 줄임
            downHeap(arr, 1, size);                              //다시 MaxHeap 생성
        }
    }
}
