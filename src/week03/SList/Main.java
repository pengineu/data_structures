package week03.SList;

public class Main {
    public static void main(String[] args) {        //Main class
        SList<String> s = new SList<String>();              //SList 객체 생성
        s.insertFront("orange");                    //orange
        s.insertFront("apple");                     //apple orange
        s.insertAfter("cherry", s.head.getNext());  //apple orange cherry
        s.insertFront("peer");                      //pear apple orange cherry

        s.print();                                          //출력
        System.out.println(": s의 길이 = " + s.size() + "\n");                     //s.size() 출력
        System.out.println("체리가 \t" + s.search("cherry") + "번째에 있다."); //체리 인덱스 출력
        System.out.println("키위가 \t" + s.search("Kiwi") + "번째에 있다.");   //kiwi 인덱스 출력(없음)
        s.deleteAfter(s.head);                                                    //pear orange cherry
        s.print();                                                                //출력
        System.out.println(": s의 길이 = " + s.size());                //하나 줄은 size출력
        System.out.println();                                         //줄바꿈
        s.deleteFront();                                              //orange cherry
        s.print();                                                    //출력
        System.out.println(": s의 길이 = " + s.size());                //하나 줄은 size 출력
        System.out.println();                                         //줄바꿈

        SList<Integer> t = new SList<Integer>();            //integer 배열 객체 생성
        t.insertFront(500);                   //500
        t.insertFront(200);                   //200 500
        t.insertAfter(400, t.head);           //200 400 500
        t.insertFront(100);                   //100 200 400 500
        t.insertAfter(300, t.head.getNext()); //100 200 300 400 500
        t.print();                                    //출력
        System.out.println(": t의 길이 = " + t.size());//size 출력
    }
}
