package week05.ArrayQueue;

public class Main {
    public static void main(String[] args) {
        ArrayQueue<String> queue = new ArrayQueue<String>();    //ArrayQueue 객체 생성
        queue.add("apple");     //null apple
        queue.add("orange");    //null apple orange null
        queue.add("cherry");    //null apple orange cherry
        queue.add("pear");      //null apple orange cherry pear null null null
        queue.print();          //위 결과 출력
        queue.remove();         //null null orange cherry pear null null null
        queue.print();          //위 결과 출력
        queue.add("grape");     //null null orange cherry pear grape null null
        queue.print();          //위 결과 출력
        queue.remove();         //null null null cherry pear grape null null
        queue.print();          //위 결과 출력
        queue.add("lemon");     //null null null cherry pear grape lemon null
        queue.print();          //위 결과 출력
        queue.add("mango");     //null null null cherry pear grape lemon mango
        queue.print();          //위 결과 출력
        queue.add("lime");      //lime null null cherry pear grape lemon mango
        queue.print();          //위 결과 출력
        queue.add("kiwi");      //lime kiwi null cherry pear grape lemon mango
        queue.print();          //위 결과 출력
        queue.remove();         //lime kiwi null null pear grape lemon mango
        queue.print();          //위 결과 출력
    }
}