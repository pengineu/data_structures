package week09.BST;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BST<Key extends Comparable<Key>, Value> {      //Binary Search Tree class
    public Node root;                                       //root 노드
    public Node getRoot() {                                 //getter
        return root;                                        //root 노드 반환
    }
    public BST(Key newId, Value newName) {                  //생성자
        root = new Node(newId, newName);                    //root 생성
    }
    public Value get(Key k) {                               //root로부터 Key가 k인 값을 찾는 메서드
        return get(root, k);                                //get에서 노드를 root로 호출
    }
    public Value get(Node n, Key k) {                       //특정 노드로부터 Key가 k인 값을 찾는 메서드
        if (n == null) {                                    //노드가 null이라면(찾는 노드가 해당 트리에 없다면)
            return null;                                    //null 반환
        }
        int t = n.getId().compareTo(k);                     //노드와 찾는 Key를 비교함
        if (t > 0) {                                        //노드가 크면
            return get(n.getLeft(), k);                     //왼쪽 자식으로 찾음
        } else if (t < 0) {                                 //작으면
            return get(n.getRight(), k);                    //오른쪽 자식으로 찾음
        } else {                                            //같으면
            return (Value)n.getName();                      //해당 Value값 반환
        }
    }
    public void put(Key k, Value v) {                       //Key와 Value를 가지는 노드를 루트 트리에 삽입
        root = put(root, k, v);                             //Node을 root로 하는 put 메서드 호출
    }
    public Node put(Node n, Key k, Value v) {               //특정 노드 아래에 K V 노드를 삽입
        if (n == null) {                                    //맨 끝 노드를 찾아 그 아래로 왔다면
            Node newNode = new Node(k, v);                  //삽입할 노드 생성
            return newNode;                                 //삽입할 노드 반환
        }
        int t = n.getId().compareTo(k);                     //삽입할 노드의 Key를 특정 노드와 비교
        if (t > 0) {                                        //특정 노드가 크다면
            n.setLeft(put(n.getLeft(), k, v));              //그 노드의 왼쪽으로 가면서 반환받는 노드 값을 set함
        } else if (t < 0) {                                 //특정 노드가 작다면
            n.setRight(put(n.getRight(), k , v));           //그 노드의 오른쪽으로 가면서 반환값는 노드 값을 set함
        } else {                                            //같으면
            n.setName(v);                                   //해당 노드의 Value를 대체함
        }
        return n;                                           //put한 노드 반환
    }
    public Key min() {                                      //루트 노드로부터 Key가 최소인 노드의 Key를 반환하는 메서드
        Node t = min(root);                                 //특정 노드를 root로 하는 min 메서드 호출
        return (Key)t.getId();                              //찾은 노드의 Key 반환
    }
    public Node min(Node n) {                               //특정 노드 아래의 Key가 최소인 것을 찾아 Node를 반환하는 메서드
        if (n.getLeft() == null) {                          //왼쪽 자식이(더 작은 자식이) 없는 노드를 찾았으면
            return n;                                       //해당 노드를 최소값으로 간주하고 반환
        }
        return min(n.getLeft());                            //왼쪽 자식 노드의 최소값을 찾음
    }
    public void deleteMin() {                               //루트 노드로부터 최소값을 삭제하는 메서드
        deleteMin(root);                                    //최소값을 삭제하는 메서드를 루트 노드로부터 호출
    }
    public Node deleteMin(Node n) {                         //특정 노드의 최소값을 삭제하는 메서드
        if (n.getLeft() == null) {                          //최소값을 찾았다면
            return n.getRight();                            //최소값의 오른쪽 자식을 반환
        }
        n.setLeft(deleteMin(n.getLeft()));                  //최소값을 삭제한 뒤 대체
        return n;                                           //해당 노드(대체 값) 반환
    }

    public void deleteMax() {                               //루트 노드로부터 최대값을 삭제하는 메서드
        deleteMax(root);                                    //특정 노드를 root로 하는 최대값 삭제 메서드 호출
    }
    public Node deleteMax(Node n) {                         //특정 노드에서 최대값을 삭제하는 메서드
        if (n.getRight() == null) {                         //최대값을 찾았다면
            return n.getLeft();                             //대체할 값 왼쪽 자식노드 선정
        }
        n.setRight(deleteMax(n.getRight()));                //대체하고 삭제
        return n;                                           //대체할 노드 반환
    }
    public void delete(Key k){                              //루트 노드에서 k를 가지는 노드 삭제
        delete(root, k);                                    //특정 노드를 루트 노드로 하는 삭제 메서드 호출
    }
    public Node delete(Node n, Key k) {                     //특정 노드에서 k를 가지는 노드를 삭제하는 메서드
        if (n == null) {                                    //삭제할 노드가 없다면
            return null;                                    //null 반환
        }
        int t = n.getId().compareTo(k);                     //비교해서 내려감
        if (t > 0) {                                        //비교하는 노드가 더 크다면
            n.setLeft(delete(n.getLeft(), k));              //왼쪽 노드로 가면서 set
        } else if (t < 0) {                                 //더 작다면
            n.setRight(delete(n.getRight(), k));            //오른쪽 노드로 가면서 set
        } else {                                            //찾았을 때
            if (n.getRight() == null) {                     //오른쪽이 없다면
                n.getLeft();                                //왼쪽노드로 대체
            }
            if (n.getLeft() == null) {                      //왼쪽이 없다면
                return n.getRight();                        //오른쪽으로 대체 (null포함)
            }
            Node after = min(n.getRight());                 //자식이 둘다 있다면 후행자를 선정 (오른쪽 자식의 최소)
            deleteMin(n.getRight());                        //후행자를 삭제
            after.setLeft(n.getLeft());                     //후행자의 왼쪽과
            after.setRight(n.getRight());                   //오른쪽을 기존 노드의 자식으로 맞춰줌
            return after;                                   //후행자 반환
        }
        return n;                                           //노드 반환
    }
    public int height() {                                   //root로부터 높이를 반환하는 메서드
        return height(root);                                //root로 하는 height 호출
    }
    private int height(Node n) {                            //특정 노드로부터 높이를 반환하는 메서드
        if (n == null) {                                    //기본값 재귀
            return 0;
        }
        return 1 + Math.max(height(n.getLeft()), height(n.getRight())); //높이를 재귀로 구함
    }
    public void print(Node root) {                          //print 메서드
        System.out.printf("\ninorder:\n");                  //inorder 호출
        inorder(root);
        System.out.printf("\npreorder\n");                  //preorder 호출
        preorder(root);
        System.out.printf("\nlevelorder\n");                //levelorder 호출
        levelorder(root);
    }
    public void inorder(Node n) {                           //inorder
        if (n.getLeft() != null) {                          //왼쪽 null확인
            inorder(n.getLeft());                           //재귀
        }
        System.out.print(n.getId() + " ");                  //왼쪽 재귀 후 출력
        if (n.getRight() != null) {                         //마지막으로 실행될 오른쪽 재귀
            inorder(n.getRight());
        }
    }
    public void preorder(Node n) {                          //preorder
        System.out.print(n.getId() + " ");                  //먼저 출력
        if (n.getLeft() != null) {                          //왼쪽 재귀
            preorder(n.getLeft());
        }
        if (n.getRight() != null) {                         //오른쪽 재귀
            preorder(n.getRight());
        }
    }
    public void levelorder(Node n) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {                          //queue가 빌 때까지
            Node t = q.remove();                        //queue에서 요소를 뺴내면서
            if (t.getLeft() != null) {                      //빼낸 요소의 자식 노드를 넣음
                q.add(t.getLeft());
            }
            if (t.getRight() != null) {
                q.add(t.getRight());
            }
            System.out.print(t.getId() + " ");            //빼낸 요소를 출력
        }
    }

}
