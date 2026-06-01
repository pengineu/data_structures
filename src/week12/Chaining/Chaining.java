package week12.Chaining;

public class Chaining<K, V> {       //chaining class
    private int M = 11;             //hash table 크기
    public static class Node {      //Node inner class
        private Object key;         //key
        private Object value;       //value
        private Node next;          //reference next
        public Node(Object K, Object V, Node ref) { //생성자
            key = K;                //key 초기화
            value = V;              //value 초기화
            next = ref;             //next 초기화
        }
        public Object getKey() {    //getter
            return key;             //key 반환
        }
        public Object getValue() {  //getter
            return value;           //value 반환
        }
        public Node getNext() {     //getter
            return next;            //next 반환
        }
    }
    private Node[] a= new Node[M];                  //hash table 크기만큼 Node 배열 생성
    private int hash(K key) {                       //hash function
        return (key.hashCode() & 0x7fffffff) % M;   //hash function 정의
    }
    public void put(K key, V value) {               //hash table에 값을 넣는 메서드
        int hashValue = hash(key);                  //hash function 값
        for (Node x = a[hashValue]; x != null; x = x.next) {    //key 의 next를 순회
            if (key.equals(x.key)) {                            //동일 key가 있는경우
                x.value = value;                                //value 대체
                return;                                         //종료
            }
        }
        a[hashValue] = new Node(key, value, a[hashValue]);      //a의 key를 ref로 하는 새로운 값을 밀어넣음
    }
    public V get(K key) {                                       //ket로 value를 받는 메서드
        int hashValue = hash(key);                              //hash function
        for (Node x = a[hashValue]; x != null; x = x.next) {    //key의 next를 순회
            if (key.equals(x.key)) {                            //찾고자 하는 key를 찾은경우
                return (V)x.value;                              //value값 반환
            }
        }
        return null;                                            //전부 순회했는데 못 찾은경우 null 반환
    }

    public static void main(String[] args) {                    //main class
        Chaining t = new Chaining();                            //객체 생성
        t.put(71, "grape");                                     //7개의 값으로 hash table 구성
        t.put(23, "apple");
        t.put(73, "banana");
        t.put(49, "cherry");
        t.put(54, "mango");
        t.put(89, "lime");
        t.put(39, "orange");
        System.out.println();                                   //줄바꿈
        System.out.println("해시 테이블");                        //hash table
        for (int i = 0; i < t.M; i++) {                         //hash table 순회
            System.out.print(String.format("%2d", i));          //인덱스 출력
            Node x = t.a[i];                                    //hash table의 Node를 받아옴
            while (x != null) {                                 //Node가 null이면 종료
                System.out.print("-->[" + x.getKey() +", " + x.getValue() + "]");   //Node의 key, value를 받아옴
                x = x.getNext();                                //next로 바꾸면서 순회
            }
            System.out.println();
        }
    }
}