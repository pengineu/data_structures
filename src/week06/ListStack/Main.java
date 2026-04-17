package week06.ListStack;

public class Main {
    public static void main(String[] args) {
        ListStack<String> stack = new ListStack<String>();  //ListStack 객체 생성
        stack.push("apple");                        //apple
        stack.push("orange");                       //ornge apple
        stack.push("cherry");                       //cherry orange apple
        System.out.println(stack.peek());                   //cherry를 peek
        stack.push("pear");                         //pear cherry orange apple
        stack.print();                                      //위 내용 출력
        stack.pop();                                        //pear 반환(출력X)
        System.out.println(stack.peek());                   //cherry를 peek
        stack.push("grape");                        //grape cherry orange apple
        stack.print();                                      //위 내용 출력
    }
}