package week13.MinHeap;

public class Main {
    public static void main(String[] args) {                                //Main class
        Entry[] a = new Entry[16];                                          //Entry 배열 객체 생성
        a[1] = new Entry<Integer, String>(90, "watermelon");    //12개의 객체를 배열 요소에 순서대로 삽입
        a[2] = new Entry<Integer, String>(80, "pear");
        a[3] = new Entry<Integer, String>(70, "melon");
        a[4] = new Entry<Integer, String>(50, "lime");
        a[5] = new Entry<Integer, String>(60, "mango");
        a[6] = new Entry<Integer, String>(20, "cherry");
        a[7] = new Entry<Integer, String>(30, "grape");
        a[8] = new Entry<Integer, String>(35, "orange");
        a[9] = new Entry<Integer, String>(10, "apricot");
        a[10] = new Entry<Integer, String>(15, "banana");
        a[11] = new Entry<Integer, String>(45, "lemon");
        a[12] = new Entry<Integer, String>(40, "kiwi");

        BHeap<Integer, String> h = new BHeap<Integer, String>(a, 12);   //BHeap 객체 생성
        System.out.println("힙 만들기 전:");                                      //Heap 만들기 전
        h.print();                                                              //배열에 객체를 넣은 순서대로 출력
        h.createHeap();                                                         //최소가 root가 되는 힙으로 재배열
        System.out.println("최소 힙:");                                          //최소 힙
        h.print();                                                              //배열로 구현한 최소 힙 출력
        System.out.println("min 삭제 후");                                       //min 삭제 후
        System.out.println(h.deleteMin().getValue());                           //삭제한 min값 출력
        h.print();                                                              //min 삭제 후 최소 정렬된 배열 출력
        h.insert(5, "apple");                                   //key: 5, value: apple 새로운 요소 삽입
        System.out.println("5 삽입 후");                                         //5 삽입 후
        h.print();                                                              //삽입 이후 최소 정렬된 배열 출력
    }
}
