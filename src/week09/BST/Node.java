package week09.BST;

public class Node <Key extends Comparable<Key>, Value>{     //Node class
    private Key id;                                         //Key
    private Value name;                                     //Value
    private Node left, right;                               //자식 노드

    public Node(Key newId, Value newName) {                 //생성자
        id = newId;                                         //Key 초기화
        name = newName;                                     //Value 초기화
        left = right = null;                                //자식 초기화
    }

    public Key getId() {                                    //getter
        return id;                                          //Key 반환
    }
    public Value getName() {                                //getter
        return name;                                        //Value 반환
    }
    public Node getLeft() {                                 //getter
        return left;                                        //왼쪽 자식 반환
    }
    public Node getRight() {                                //getter
        return right;                                       //오른쪽 자식 반환
    }
    public void setId(Key newId) {                          //setter
        id = newId;                                         //Key 재설정
    }
    public void setName(Value newName) {                    //setter
        name = newName;                                     //Value 재설정
    }
    public void setLeft(Node newLeft) {                     //setter
        left = newLeft;                                     //왼쪽 자식 재설정
    }
    public void setRight(Node newRight) {                   //setter
        right = newRight;                                   //오른쪽 자식 재설정
    }
}
