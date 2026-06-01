package week11.RedBlackTree;
import week06.ListQueue.ListQueue;

public class RedBlackTree<Key extends Comparable<Key>, Value> {
    private static final boolean RED = true;        //red
    private static final boolean BLACK = false;     //black
    private Node root;                              //root
    private class Node {                            //Node class
        Key id;                                     //key(id)
        Value name;                                 //Value(name)
        Node left, right;                           //자식 노드
        boolean color;                              //red, black
        public Node(Key k, Value v, boolean col) {  //생성자
            id = k;                                 //id
            name = v;                               //name
            color = col;                            //color
            left = right = null;                    //자식 노드는 없음을 기본으로
        }
    }

    private boolean isEmpty() {                     //isEmpty class
        return root == null;                        //root가 없으면 빈 트리로
    }
    private boolean isRed(Node n) {                 //red인지 검사
        if (n == null) {                            //n이 null이면
            return false;                           //black으로 취급
        }
        return n.color == RED;                      //red이면 true 반환
    }
    public Value get(Key k) {                       //루트에서부터 k노드의 v를 가져옴
        return get(root, k);                        //root로 get호출
    }
    public Value get(Node n, Key k) {               //n에서 k노드의 v를 가져옴
        if (n == null) {                            //찾는 k인 노드가 없으면
            return null;                            //null 반환
        }
        int t = n.id.compareTo(k);                  //k 비교
        if (t > 0) {                                //찾는 k가 작으면
            return get(n.left, k);                  //왼쪽으로
        }else if (t < 0) {                          //찾는 k가 크면
            return get(n.right, k);                 //오른쪽으로
        } else {                                    //같으면
            return n.name;                          //Value 반환
        }
    }
    private Node rotateRight(Node n) {                      //오른쪽 회전
        Node x = n.left;                                    //왼쪽 노드를 기준으로
        n.left = x.right;                                   //n의 왼쪽노드 재설정
        x.right = n;                                        //x의 양쪽 노드 재설정
        x.color = n.color;                                  //색 재설정
        n.color = RED;
        return x;                                           //변환이 완료된 x 반환
    }
    private Node rotateLeft(Node n) {                       //왼쪽 회전
        Node x = n.right;                                   //오른쪽 자식을 기준으로
        n.right = x.left;                                   //n의 오른쪽 노드 재설정
        x.left = n;                                         //x의 양쪽 노드 재설정
        x.color = n.color;                                  //색 재설정
        n.color = RED;
        return x;                                           //변환이 완료된 x반환
    }
    private Boolean reverseColor(Node n) {                  //색 반전 메서드
        return !n.color;                                    //반대 색 반환
    }
    private void flipColors(Node n) {                       //현 노드와 자식 노드 색 반전 메서드
        n.color = reverseColor(n);                          //현 노드 반전
        n.right.color = reverseColor(n.right);              //자식 노드 반전
        n.left.color = reverseColor(n.left);                //자식 노드 반전
    }
    public void put(Key k, Value v) {                       //root로부터 k, v put 메서드
        root = put(root, k, v);                                    //root노드로 put 호출
        root.color = BLACK;                                 //root의 색은 항상 black
    }
    private Node put(Node n, Key k, Value v) {              //특정 노드로부터 put 메서드
        if (n == null) {                                    //put할 장소를 찾았다면
            return new Node(k, v, RED);                     //red 인 노드 생성 후 반환
        }
        int t = n.id.compareTo(k);                          //Key 비교
        if (t > 0) {                                        //Key가 작으면
            n.left = put(n.left, k, v);                     //왼쪽으로
        } else if (t < 0) {                                 //Key가 크면
            n.right = put(n.right, k, v);                   //오른쪽으로
        } else {                                            //같으면
            n.name = v;                                     //대체
        }
        n = fixup(n);                                           //색 정렬
        return n;                                           //정렬된 노드 반환
    }
    private Node moveRedLeft(Node n) {                      //red를 왼쪽으로 내리는 메서드
        flipColors(n);                                      //filpcolor 시행
        if (isRed(n.right.left)) {                          //right.left가 red이므로 규칙에 어긋날 경우
            n.right = rotateRight(n.right);                 //오른쪽 회전
            n = rotateLeft(n);                              //n회전
            flipColors(n);                                  //flipcolor을 시행하면 red를 올리면서 규칙을 맞춰줌
        }
        return n;                                           //내려진 노드(서브트리) 반환
    }
    public void deleteMin() {                               //root의 최소값 삭제 메서드
        root = deleteMin(root);                             //root로 최소값을 삭제하는 메서드 반환
        root.color = BLACK;                                 //root의 색은 항상 black
    }
    private Node deleteMin(Node n) {                        //특정 노드(서브트리)의 최소값 삭제 메서드
        if (n.left == null) {                               //최소값에 다다르면
            return null;                                    //최소값 삭제
        }
        if (!isRed(n.left) && !isRed(n.left.left)) {        //왼쪽과 왼쪽왼쪽이 red가 아니면
            n = moveRedLeft(n);                             //red를 내림
        }
        n.left = deleteMin(n.left);                         //왼쪽 노드로 재귀하며 최소값 삭제
        return fixup(n);                                    //정렬된 n 반환
    }
    private Node fixup(Node n) {                            //색 정렬 메서드
        if (isRed(n.right)) {                               //오른쪽이 red이면
            n = rotateLeft(n);                              //회전으로 처리
        }
        if (isRed(n.left) && isRed(n.left.left)) {          //왼쪽, 왼쪽왼쪽이 red이면 (red가 연속)
            n = rotateRight(n);                             //오른쪽회전으로 처리
        }
        if (isRed(n.left) && isRed(n.right)) {              //왼쪽이 red이면서 오른쪽이 red이면
            flipColors(n);                                  //자식과 본인 모두 색반전으로 처리
        }
        return n;                                           //색 정렬된 n 반환
    }
    public Key min() {                                      //root에서 최소값 찾기 메서드
        return min(root).id;                                //root로 최소값 찾는 메서드 호출
    }
    private Node min(Node n) {                              //특정 노드에서 최소값 찾기 메서드
        if (n.left == null) {                               //왼쪽이 null이라면
            return n;                                       //해당 노드가 최소값이므로 반환
        }
        return min(n.left);                                 //재귀하며 최소값 탐색
    }
    public void inorder(Node n) {                       //inorder method
        if (n.left != null) {                           //왼쪽이 null이 아니라면
            inorder(n.left);                            //왼쪽으로 내려가면서 inorder 재귀
        }
        System.out.print(n.id + " ");                   //inorder이므로 중앙에서 출력
        if (n.right != null) {                          //오른쪽이 null이 아니라면
            inorder(n.right);                           //오른쪽으로 내려가면서 inorder 재귀
        }
    }
    public void preorder(Node n) {                      //preorder method
        System.out.print(n.id + " ");                   //preorder이므로 앞에서 출력
        if (n.left != null) {                           //왼쪽이 null이 아니라면
            preorder(n.left);                           //왼쪽으로 내려가면서 preorder 재귀
        }
        if (n.right != null) {                          //오른쪽이 null이 아니라면
            preorder(n.right);                          //오른쪽으로 내려가면서 preorder 재귀
        }
    }
    public void levelorder(Node root) {                     //levelorder
        ListQueue<Node> queue = new ListQueue<Node>();         //queue로 구현
        queue.add(root);                                    //queue에 최상위 노드 삽입
        while (!queue.isEmpty()) {                          //queue가 빌 때까지
            Node t = queue.remove();                        //queue에서 요소를 뺴내면서
            if (t.left != null) {                           //빼낸 요소의 자식 노드를 넣음
                queue.add(t.left);
            }
            if (t.right != null) {
                queue.add(t.right);
            }
            System.out.print(t.id + " ");                    //빼낸 요소를 출력
        }
    }

    public void print() {                       //출력 method
        System.out.printf("\ninorder:\n");      //inorder 출력
        inorder(root);
        System.out.printf("\npreorder:\n");     //preorder 출력
        preorder(root);
        System.out.printf("\nlevelorder:\n");   //levelorder 출력
        levelorder(root);
    }

    public void delete(Key k) {                 //root에서 Key가 k인 노드 삭제 메서드
        root = delete(root, k);                 //root에서 delete 메서드 호출
        root.color = BLACK;                     //root의 색은 항상 black
    }

    private Node delete(Node n, Key k) {                //특정 노드에서 Key가 k인 노드 삭제 메서드
        if (n.id.compareTo(k) > 0) {                    //k가 작으면
            if (!isRed(n.left) && !isRed(n.right)) {    //또 왼쪽 오른쪽이 다 red가 아니면
                n = moveRedLeft(n);                     //왼쪽으로 red를 내림
            }
            n.left = delete(n.left, k);                 //왼쪽을 삭제 재귀돌림
        }
        else {                                          //k가 같거나 크면
            if(isRed(n.left)) {                        //왼쪽이 red가 아니면
                n = rotateRight(n);                     //오른쪽으로 회전
            }
            if (n.id.compareTo(k) == 0 && (n.right == null)) {  //삭제할 k를 찾았고, 오른쪽이 null이면
                return null;                                    //null반환
                }
            if (!isRed(n.right) && !isRed(n.right.left)) {      //오른쪽이 red가 아니고 오른쪽의 왼쪽이 red가 아니면
                n = moveRedRight(n);                            //오른쪽으로 red를 내림
            }
            if (n.id.compareTo(k) == 0) {                       //삭제할 k를 찾았으면
                Node successor = min(n.right);                  //선행자는 오른쪽 노드의 최소값
                n.name = get(n.right, successor.id);            //n의 name을 선행자로 교체
                n.id = successor.id;                            //n의 id를 선행자로 교체
                n.right = deleteMin(n.right);                   //n의 선행자 삭제
            }
            else {
                n.right = delete(n.right, k);                   //같지 않다면 재귀로 같은 값을 찾음
            }
        }
        return fixup(n);                                        //색 정렬된 n 반환
    }
    private Node moveRedRight(Node n) {                         //red를 오른쪽으로 내리는 메서드
        flipColors(n);                                          //n과 자식노드들 색반전
        if (isRed(n.left.left)) {                               //왼쪽의 왼쪽이 red라면
            n = rotateRight(n);                                 //n을 오른쪽으로 회전
            flipColors(n);                                      //n과 자식노드 색반전
        }
        return n;                                               //n반환
    }
    public static void main(String[] args) {
        RedBlackTree<Integer, String> rbt = new RedBlackTree<Integer, String>();    //RedBlackTree 객체 생성
        rbt.put(700, "strawberry");                                             //id: 700, value: strawberry
        rbt.put(250, "eggplant");                                               //id: 250, value: eggplant
        rbt.put(100, "apple");                                                  //id: 100, value: apple
        rbt.put(500, "raspberry");                                              //id: 500, value: raspberry
        rbt.put(150, "cherry");                                                 //id: 150, value: cherry
        rbt.put(300, "honeydew");                                               //id: 300, value: honeydew
        rbt.put(900, "watermelon");                                             //id: 900, value: watermelon
        rbt.put(400, "mango");                                                  //id: 400, value: mango
        rbt.put(450, "pear");                                                   //id: 450, value: pear
        rbt.put(350, "lime");                                                   //id: 350, value: lime

        System.out.println(rbt.min());                          //최소값인 100 출력
        System.out.println(rbt.get(500));                       //500을 가진 raspberry출력
        rbt.print();                                            //inorder, preorder, levelorder 출력
        System.out.println("\n-----------------------------");
        rbt.delete(350);                                     //key가 350인 노드 삭제
        rbt.print();                                            //inorder, preorder, levelorder 출력
        System.out.print("\n-----------------------------");
    }
}
