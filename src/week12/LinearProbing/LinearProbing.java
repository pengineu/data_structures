package week12.LinearProbing;

public class LinearProbing<K, V> {              //LinearProbing class
    private int M = 13;                         //M = hash table 크기
    private K[] a = (K[]) new Object[M];        //Key를 저장하는 배열
    private V[] d = (V[]) new Object[M];        //Value를 저장하는 배열

    private int hash(K key) {                   //hash function
        return (key.hashCode() & 0x7fffffff) % M;   //정의
    }

    private void put(K key, V value) {          //hash table에 집어넣는 메서드
        int hashValue = hash(key);              //hash function 값
        int j = 1, init = hashValue;            //hash function 초기값과 jump index j 설정
        while (j != M) {                        //hash table의 크기만큼 반복
            if (a[hashValue] == null) {         //hash table의 key가 비어있다면
                a[hashValue] = key;             //key 삽입
                d[hashValue] = value;           //value 삽입
                return;                         //종료
            }
            if (a[hashValue].equals(key)) {     //hash table에 같은 key가 이미 존재한다면
                d[hashValue] = value;           //value만 재설정
                return;                         //종료
            }
            hashValue = (init + j++) % M;       //충돌 시 다음 칸으로 이동
        }
        System.out.println("저장 실패");         //크기만큼 반복 이후에도 없으면 저장 실패
        return;
    }
    public V get(K key) {                       //hash table에서 key를 통해 value를 받는 메서드
        int hashValue = hash(key);              //hash function
        int j = 1, init = hashValue;            //hash function 초기값과 jump index j 를 설정
        while (j != M) {                        //hash table 크기만큼 반복
            if (a[hashValue].equals(key)) {     //(충돌 방지) hash table에 저장되어있는 값이 key와 같다면
                return d[hashValue];            //value 반환
            }
            hashValue = (init + j++) % M;       //충돌 시 한 칸 이동하며 찾음
        }
        return null;                            //크기만큼 순회했을 때 못찾았을 경우 null return
    }

    public static void main(String[] args) {    //main
        LinearProbing t = new LinearProbing();  //객체 생성
        t.put(25, "grape");                     //8개의 key, value를 put
        t.put(37, "apple");
        t.put(18, "banana");
        t.put(55, "cherry");
        t.put(22, "mango");
        t.put(35, "lime");
        t.put(50, "orange");
        t.put(63, "watermelon");
        System.out.println("탐색 결과:");
        System.out.println("50의 data = " + t.get(50));  //key가 50 에 해당하는 value를 찾음
        System.out.println("63의 data = " + t.get(63));  //key가 63 에 해당하는 value를 찾음
        System.out.println();   //줄바꿈

        System.out.println("해시 테이블:");  //해시 테이블 출력
        for (int i = 0; i < t.M; i++) {
            System.out.printf("\t%2d", i);  //인덱스 값 출력
        }
        System.out.println();               //줄바꿈
        for (int i = 0; i < t.M; i++) {
            System.out.print("\t" + t.a[i]);//해시 테이블 key값 출력
        }
    }

}