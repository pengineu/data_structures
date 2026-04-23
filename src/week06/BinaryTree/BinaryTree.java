package week06.BinaryTree;
import java.util.*;
import week06.ListQueue.ListQueue;

public class BinaryTree<Key extends Comparable<Key>> {      //BinaryTree Class
    private Node root;                                      //최상위 노드
    public BinaryTree() {                                   //생성자
        root = null;                                        //최상위 노드 초기화
    }
    public Node getRoot() {                                 //getter
        return root;                                        //최상위 노드 반환
    }
    public void setRoot(Node newRoot) {                     //setter
        root = newRoot;                                     //최상위 노드 지정
    }
    public boolean isEmpty() {                              //비어있는지 확인
        return root == null;                                //최상위 노드가 없으면 비어있음
    }
    public void preorder(Node n) {                          //preorder
        System.out.print(n.getItem() + " ");                //앞에서 출력하고
        if (n.getLeft() != null) {                          //왼쪽 재귀
            preorder(n.getLeft());
        }
        if (n.getRight() != null) {                         //오른쪽 재귀
            preorder(n.getRight());
        }
    }
    public void inorder(Node n) {                           //inorder
        if (n.getLeft() != null) {                          //왼쪽 재귀하고
            inorder(n.getLeft());
        }
        System.out.print(n.getItem() + " ");                //가운데에서 출력
        if (n.getRight() != null) {                         //오른쪽 재귀
            inorder(n.getRight());
        }
    }
    public void postorder(Node n) {                         //postorder
        if (n.getLeft() != null) {                          //왼쪽 재귀
            postorder(n.getLeft());
        }
        if (n.getRight() != null) {                         //오른쪽 재귀 한 뒤에
            postorder(n.getRight());
        }
        System.out.print(n.getItem() + " ");                //뒤에서 출력
    }
    public void levelorder(Node root) {                     //levelorder
        ListQueue<Node> queue = new ListQueue<Node>();         //queue로 구현
        queue.add(root);                                    //queue에 최상위 노드 삽입
        while (!queue.isEmpty()) {                          //queue가 빌 때까지
            Node t = queue.remove();                        //queue에서 요소를 뺴내면서
            if (t.getLeft() != null) {                      //빼낸 요소의 자식 노드를 넣음
                queue.add(t.getLeft());
            }
            if (t.getRight() != null) {
                queue.add(t.getRight());
            }
            System.out.print(t.getItem() + " ");            //빼낸 요소를 출력
        }
    }

    public int size(Node n) {                               //size를 반환하는 메서드
        if (n == null) {                                    //재귀 초기값 설정
            return 0;
        }
        return 1 + size(n.getLeft()) + size(n.getRight());  //왼쪽 사이즈와 오른쪽 사이즈 + 현재 노드
    }
    public int height(Node n) {                             //height를 반환하는 메서드
        if (n == null) {                                    //재귀 초기값 설정
            return 0;
        }
        return 1 + Math.max(height(n.getLeft()), height(n.getRight())); //현재 노드 + 최대값(왼쪽자식, 오른쪽자식)
    }

    public static boolean isEqual(Node n, Node m) {         //트리 두 개가 똑같은지 판별
        if (n == null && m == null) {                       //둘 다 null이면 같음(재귀 초기값)
            return true;
        }
        if (!n.getItem().equals(m.getItem())) {             //노드의 item이 다르다면 false 반환(재귀 초기값)
            return false;
        }
        if (isEqual(n.getLeft(), m.getLeft()) && isEqual(n.getRight(), m.getRight())) { //재귀
            return true;                                    //false를 만나지 않고 모두 true라면 true반환
        } else {
            return false;                                   //하나라도 false면 false반환
        }
    }

    public Node copy(Node n) {                              //복사 메서드
        if (n == null) {                                    //null이라면 null복사
            return null;                                    //재귀 초기값
        }
        Node t = new Node(n.getItem(), null, null);   //같은 요소를 가지는 노드 생성
        t.setLeft(copy(n.getLeft()));                       //노드의 왼쪽쪽 요소 복사 재귀
        t.setRight(copy(n.getRight()));                     //노드의 오른쪽 요소 복사 재귀
        return t;                                           //맨 처음 생성했던 루트 노드 반환
    }
}   