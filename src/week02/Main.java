package week02;

public class Main {
    public static void main(String[] args) {
        ArrList<String> s = new ArrList<String>();          //ArrList 객체 생성
        s.insertLast("apple");                      //["apple"]
        s.print();                                          //출력
        s.insertLast("Orange");                     //["apple", "Orange"]
        s.print();                                          //출력
        s.insertLast("cherry");                     //["apple", "Orange", "cherry", null]
        s.print();                                          //출력
        s.insertLast("pear");                       //["apple", "Orange", "cherry", "pear"]
        s.print();                                          //출력
        s.insert("grape", 1);                    //["apple", "grape", "Orange", "cherry", "pear", null, null, null]
        s.print();                                          //출력
        s.insert("Lemon", 4);                    //["apple", "grape", "Orange", "cherry", "Lemon", "pear", null, null]
        s.print();                                          //출력
        s.insertLast("Kiwi");                       //["apple", "grape", "Orange", "cherry", "Lemon", "pear", "Kiwi", null]
        s.print();                                          //출력
        s.delete(4);                                     //["apple", "grape", "Orange", "cherry", "pear", "Kiwi", null, null]
        s.print();                                          //출력
        s.delete(0);                                     //["grape", "Orange", "cherry", "pear", "Kiwi", null, null, null]
        s.print();                                          //출력
        s.delete(0);                                     //["Orange", "cherry", "pear", "kiwi", null, null, null, null]
        s.print();                                          //출력
        s.delete(3);                                     //["Orange", "cherry", "pear", null, null, null, null, null]
        s.print();                                          //출력
        s.delete(0);                                     //["cherry", "pear", null, null, null, null, null, null]
        s.print();                                          //출력

        System.out.println("1번째 항목은 " + s.peek(1) + "이다."); //1번째 인덱스 출력
        System.out.println();                                      //줄바꿈
    }
}
