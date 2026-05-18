    package week10.AVL;

    import week06.BinaryTree.Node;
    import week06.ListQueue.ListQueue;

    import java.util.*;

    public class AVL <Key extends Comparable<Key>, Value> {         //AVL class
        private Node root;                                          //root
        public class Node {                                         //Node inner class
            private Key id;                                         //id
            private Value name;                                     //name
            private int height;                                     //높이
            private Node left, right;                               //자식 노드
            public Node(Key newId, Value newName, int newHt) {      //생성자
                id = newId;                                         //id 초기화
                name = newName;                                     //name 초기화
                height = newHt;                                     //높이 초기화(1)
                left = right = null;                                //자식 초기화
            }
        }

        private int height(Node n) {                                //height method
            if (n == null) {                                        //노드가 null이라면
                return 0;                                           //0반환
            }
            return 1 + Math.max(height(n.left), height(n.right));   //자식 노드 중 높은 노드 + 1 재귀
        }
        public void put(Key k, Value v) {                       //Key와 Value를 가지는 노드를 루트 트리에 삽입
            root = put(root, k, v);                             //Node을 root로 하는 put 메서드 호출
        }
        public Node put(Node n, Key k, Value v) {               //특정 노드 아래에 K V 노드를 삽입
            if (n == null) {                                    //맨 끝 노드를 찾아 그 아래로 왔다면
                Node newNode = new Node(k, v, 1);        //삽입할 노드 생성
                return newNode;                                 //삽입할 노드 반환
            }
            int t = n.id.compareTo(k);                          //삽입할 노드의 Key를 특정 노드와 비교
            if (t > 0) {                                        //특정 노드가 크다면
                n.left = put(n.left, k, v);                     //그 노드의 왼쪽으로 가면서 반환받는 노드 값을 set함
            } else if (t < 0) {                                 //특정 노드가 작다면
                n.right = put(n.right, k, v);                  //그 노드의 오른쪽으로 가면서 반환값는 노드 값을 set함
            } else {                                            //같으면
                n.name = v;                                     //해당 노드의 Value를 대체함
                return n;                                       //put한 노드 반환
            }
            n.height = height(n);                               //높이 재조정
            return balance(n);                                  //편향 재조정

        }
        private Node balance(Node n) {                          //재조정 method
            if (bf(n) > 1) {                                    //Balance Factor 가 1이상(차이가 왼쪽 2를 넘을때)
                if (bf(n.left) < 0) {                           //그 아래가 편향되었다면
                    n.left = rotateLeft(n.left);                //LR 회전
                }
                n = rotateRight(n);                             //Right 회전은 기본값if문
            } else if (bf(n) < -1) {                            //만약 차이가 오른쪽 2를 넘을때
                if (bf(n.right) > 0) {                          //거기서 왼쪽으로 편향된 경우
                    n.right = rotateRight(n.right);             //RL 회전
                }
                n = rotateLeft(n);                              //기본값 L회전
            }
            return n;                                           //회전한 노드 n 반환
        }
        private int bf(Node n) {                                //노드의 Balance Factor
            return height(n.left) - height(n.right);            //왼쪽 높이 - 오른쪽 높이
        }
        private Node rotateRight(Node n) {                      //오른쪽 회전
            Node x = n.left;                                    //왼쪽 노드를 기준으로
            n.left = x.right;                                   //n의 왼쪽노드 재설정
            x.right = n;                                        //x의 양쪽 노드 재설정
            x.height = height(x);
            n.height = height(n);                               //높이 재설정
            return x;                                           //변환이 완료된 x 반환
        }
        private Node rotateLeft(Node n) {                       //왼쪽 회전
            Node x = n.right;                                   //오른쪽 자식을 기준으로
            n.right = x.left;                                   //n의 오른쪽 노드 재설정
            x.left = n;                                         //x의 양쪽 노드 재설정
            x.height = height(x);
            n.height = height(n);                               //x의 높이 재설정
            return x;                                           //변환이 완료된 x반환
        }
        public void deleteMin() {                               //최소값 삭제 method
            root = deleteMin(root);                             //root의 최소값 삭제
        }
        private Node deleteMin(Node n) {                    //특정 노드의 최소값 삭제 method
            if (n.left == null) {                          //최소값을 찾았다면
                return n.right;                            //최소값의 오른쪽 자식을 반환
            }
            n.left = (deleteMin(n.left));                    //최소값을 삭제한 뒤 대체
            n.height = height(n);                           //높이 재설정
            return balance(n);                              //편향 재설정
        }
        public Key min() {                                  //root의 최소값을 찾는 method
            return min(root).id;                            //최소값 id 반환
        }

        private Node min(Node n) {                          //특정 노드의 최소값을 삭제하는 method
            if (n.left == null) {                           //왼쪽 노드가 null이라면
                return n;                                   //해당 노드가 최소값
            }
            return min(n.left);                             //최소값까지 왼쪽으로 내려감
        }
        public void delete(Key k) {                         //루트에서부터 특정 노드 삭제하는 method
            root = delete(root, k);                         //root에서 특정 노드를 삭제한 root노드 반환
        }
        private Node delete(Node n, Key k) {                //특정 노드에서 특정 노드를 삭제하는 method
            if (n == null) {                                //찾는 노드가 없다면
                return null;                                //null반환
            }
            int t = n.id.compareTo(k);                      //값을 비교하면서 찾음
            if (t > 0) {                                    //기준 노드값이 크다면
                n.left = delete(n.left, k);                 //왼쪽으로 내려감
            } else if (t < 0) {                             //기준 노드값이 크다면
                n.right = delete(n.right, k);               //오른쪽으로 내려감
            } else {                                        //찾았다면
                if (n.right == null) {                      //오른쪽이 null이라면
                    return n.left;                          //왼쪽을 반환
                }
                Node temp = min(n.right);                   //오른쪽의 min을 반환
                n.right = deleteMin(n.right);               //후행자를 제거
                temp.left = n.left;                         //노드 재설계
                temp.right = n.right;                       //노드 재설계
                n = temp;                                   //적용
            }
            n.height = height(n);                           //높이 재조정
            return balance(n);                              //편향 조정 후 반환
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
                if (t.left != null) {                      //빼낸 요소의 자식 노드를 넣음
                    queue.add(t.left);
                }
                if (t.right != null) {
                    queue.add(t.right);
                }
                System.out.print(t.id + " ");            //빼낸 요소를 출력
            }
        }

        public void print(Node root) {              //출력 method
            System.out.printf("\ninorder:\n");      //inorder 출력
            inorder(root);
            System.out.printf("\npreorder:\n");     //preorder 출력
            preorder(root);
            System.out.printf("\nlevelorder:\n");   //levelorder 출력
            levelorder(root);
        }

        public static void main(String[] args) {                                            //main class
            AVL<Integer, String> st = new AVL<Integer, String>();                                         //AVL 선언
            st.put(30, "Apple");st.put(40, "Grape"); st.put(100, "Lime");           //트리 만들기
            st.put(20, "Mango"); st.put(10, "Strawberry"); st.put(60, "Banana");
            st.put(70, "Cherry"); st.put(120, "Watermelon"); st.put(110, "Melon");
            st.print(st.root);                                  //완성된 트리 출력
            System.out.println("\nmin value: " + st.min());     //최소값 출력
            st.deleteMin();                                     //최소값 삭제
            System.out.println("\nmin value: " + st.min());     //최소깂 출력
            st.delete(30);                                  //id가 30인 노드 삭제
            st.print(st.root);                                  //출력
        }
    }
