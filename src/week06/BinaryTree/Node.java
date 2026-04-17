package week06.BinaryTree;

public class Node <Key extends Comparable<Key>> {       //Node class
    private Key item;                                   //해당 item
    private Node<Key> left;                             //왼쪽 자식 노드
    private Node<Key> right;                            //오른쪽 자식 노드

    public Node(Key newItem, Node lt, Node rt) {        //생성자
        item = newItem;                                 //요소 초기화
        left = lt;                                      //왼쪽 자식노드 초기화
        right = rt;                                     //오른쪽 자식노드 초기화
    }

    public Key getItem() {                              //getter
        return item;                                    //요소 반환
    }
    public void setItem(Key newItem) {                  //setter
        item = newItem;                                 //요소 지정
    }

    public void setLeft (Node<Key> newNode) {           //setter
        left = newNode;                                 //왼쪾 자식 노드 지정
    }

    public void setRight(Node<Key> newNode) {           //setter
        right = newNode;                                //오른쪽 자식 노드 지정
    }

    public Node<Key> getLeft() {                        //getter
        return left;                                    //왼쪽 자식 노드 반환
    }

    public Node<Key> getRight() {                       //getter
        return right;                                   //오른쪽 자식 노드 반환
    }
}
