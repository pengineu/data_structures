package week05.ListQueue;

public class Main {
    public static void main(String[] args) {
        ListQueue<String> q = new ListQueue<String>();  //ListQueue 객체 생성
        q.add("apple");         //apple
        q.add("orange");        //apple orange
        q.add("cherry");        //apple orange cherry
        q.add("pear");          //apple orange cherry pear
        q.print();              //위 내용 출력
        q.remove();             //orange cherry pear
        q.print();              //위 내용 출력
        q.remove();             //cherry pear
        q.print();              //위 내용 출력
        q.add("grape");         //cherry pear grape
        q.print();              //위 내용 출력
    }
}
