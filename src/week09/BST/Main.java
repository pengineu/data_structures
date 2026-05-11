package week09.BST;

public class Main {                                     //main class
    public static void main(String[] args) {
        BST t = new BST(500, "Apple");  //500

        t.put(600, "Banana");                   //500 600
        t.put(200, "Melon");                    //200 500 600
        t.put(100, "Orange");                   //100 200 500 600
        t.put(400, "Tangerine");                //100 200 400 500 600
        t.put(250, "Kiwi");                     //100 200 250 400 500 600
        t.put(150, "Grape");                    //100 150 200 250 400 500 600
        t.put(800, "Strawberry");               //100 150 200 250 400 500 600 800
        t.put(700, "Cherry");                   //100 150 200 250 400 500 600 700 800
        t.put(50, "Pear");                      //50 100 150 200 250 400 500 600 700 800
        t.put(350, "Lemon");                    //50 100 150 200 250 350 400 500 600 700 800
        t.put(10, "Watermelon");                //10 50 100 150 200 250 350 400 500 600 700 800
        t.print(t.root); System.out.println();        //전부 출력(inorder, preorder, levelorder) 줄바꿈
        System.out.println("높이 = "+ t.height());    //높이 출력 = 5
        System.out.println("Key 350 값 = "+ t.get(350)); //Key가 350인 값을 찾음 = Lemon
        System.out.println("최소값 = "+ t.min());         //Key가 최소 = 10;
        t.deleteMin();                                  //최소 삭제
        t.deleteMax();                                  //최대 삭제
        t.delete(200);                               //Key가 200인 노드 삭제
        t.print(t.root);                                //출력
    }
}
