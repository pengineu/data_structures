package week03.DList;

public class Main {                             //Main class
    public static void main(String[] args) {
        DList<String> s = new DList<String>();  //DList 객체 생성

        s.insertAfter(s.head, "apple");             //apple
        s.insertBefore(s.tail, "orange");           //apple orange
        s.insertBefore(s.tail, "cherry");           //apple orange cherry
        s.insertAfter(s.head.getNext(), "pear");    //apple pear orange cherry
        s.print();                                          //출력
        System.out.println();                               //줄바꿈

        s.delete(s.tail.getPrevious());                     //apple pear orange
        s.print();                                          //출력
        System.out.println();                               //줄바꿈

        s.insertBefore(s.tail, "grape");            //apple pear orange grape
        s.print();                                          //출력
        System.out.println();                               //줄바꿈

        s.delete(s.head.getNext());                         //apple orange grape
        s.print();                                          //출력
        System.out.println();                               //줄바꿈
        s.delete(s.head.getNext());                         //orange grape
        s.print();                                          //출력
        System.out.println();                               //줄바꿈
        s.delete(s.head.getNext());                         //grape
        s.print();                                          //출력
        System.out.println();                               //줄바꿈
        s.delete(s.head.getNext());                         //리스트 비어있음
        s.print();                                          //출력
    }
}
