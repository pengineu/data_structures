package week06.BinaryTree;

public class Main {
    public static void main(String[] args) {
        Node n1 = new Node(100, null, null);      //100
        Node n2 = new Node(200, null, null);      //200
        Node n3 = new Node(300, null, null);      //300
        Node n4 = new Node(400, null, null);      //400
        Node n5 = new Node(500, null, null);      //500
        Node n6 = new Node(600, null, null);      //600
        Node n7 = new Node(700, null, null);      //700
        Node n8 = new Node(800, null, null);      //800

        n1.setLeft(n2); n1.setRight(n3);                        //100의 left = 200, right = 300
        n2.setLeft(n4); n2.setRight(n5);                        //200의 left = 400, right = 500
        n3.setLeft(n6); n3.setRight(n7);                        //300의 left = 600, right = 700
        n4.setLeft(n8);                                         //400의 left = 800

        BinaryTree t = new BinaryTree();                        //BinaryTree 객체 생성
        t.setRoot(n1);                                          //100을 root노드로 저장

        System.out.print("트리 노드 수 = " + t.size(t.getRoot()) + "\n트리 높이 = " + t.height(t.getRoot()));    //노드 수 = 8 높이 = 4
        System.out.print("\n전위 순회: ");                      //100 200 400 800 500 300 600 700
        t.preorder(t.getRoot());
        System.out.print("\n중위 순회: ");                      //800 400 200 500 100 600 300 700
        t.inorder(t.getRoot());
        System.out.print("\n후위 순회: ");                      //800 400 500 200 600 700 300 100
        t.postorder(t.getRoot());
        System.out.print("\n레벨 순회: ");                      //100 200 300 400 500 600 700 800
        t.levelorder(t.getRoot());
        System.out.println();                                   //가독성을 위한 줄바꿈

        Node n10 = new Node(100, null, null);       //100
        Node n20 = new Node(200, null, null);       //200
        Node n30 = new Node(300, null, null);       //300
        Node n40 = new Node(400, null, null);       //400
        Node n50 = new Node(500, null, null);       //500
        Node n60 = new Node(600, null, null);       //600
        Node n70 = new Node(700, null, null);       //700
        Node n80 = new Node(800, null, null);       //800


        n10.setLeft(n20); n10.setRight(n30);                    //100의 left = 200, right = 300
        n20.setLeft(n40); n20.setRight(n50);                    //200의 left = 400, right = 500
        n30.setLeft(n60); n30.setRight(n70);                    //300의 left = 600, right = 700
        n40.setLeft(n80);                                       //400의 left = 800

        BinaryTree t2 = new BinaryTree();                       //새로운 트리 객체 생성
        t2.setRoot(n10);                                        //100을 루트노드로

        System.out.printf("동일성 검사: " + BinaryTree.isEqual(t.getRoot(), t2.getRoot()));  //이전 생성했던 트리와 같은지 확인 = true
        System.out.println();                                   //가독성을 위한 줄바꿈

        BinaryTree t3 = new BinaryTree();                       //새로운 트리 객체 생성
        t3.setRoot(t3.copy(t.getRoot()));                       //첫 번째 트리를 복사해서 t3으로
        System.out.printf("copy 테스트: " + BinaryTree.isEqual(t.getRoot(), t3.getRoot()));  //복사한 트리가 같은지 확인 = ture
        System.out.println();                                   //가독성을 위한 줄바꿈
    }
}
