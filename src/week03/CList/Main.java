package week03.CList;

public class Main {                                     //Circular Linked List Main class
    public static void main(String[] args) {
        CList<String> s = new CList<String>();          //CList 문자열 객체 생성

        s.insert("pear");                       //pear
        s.insert("cherry");                     //cherry pear
        s.insert("orange");                     //orange cherry pear
        s.insert("apple");                      //apple orange cherry pear
        s.print();                                      //출력
        System.out.print(": s의 길이 = " + s.size() + "\n");   //길이 출력

        s.delete();                                     //orange cherry pear
        s.print();                                      //출력
        System.out.print(": s의 길이 = "+s.size());      //길이 출력
        System.out.println();                           //줄바꿈 왜..,?(일단 주어진 Main코드대로 썼습니다.)
    }
}
