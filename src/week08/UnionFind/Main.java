package week08.UnionFind;

public class Main {                                 //Main class
    public static void main(String[] args) {
        int N = 10;                                 //노드 개수
        Node[] a = new Node[N];                     //크기가 10인 노드 배열 생성

        for (int i = 0; i < N; i++) {               //배열 크기만큼 순회
            a[i] = new Node(i, 0);          //각자가 root node인 배열로 표현한 트리 초기화
        }

        UnionFind uf = new UnionFind(a);            //만든 배열로 UnionFind 생성자

        uf.union(2, 1);uf.union(2, 6);    //2를 root로 하고 1과 6이 leaf 노드
        uf.union(7, 3);uf.union(4, 5);    //7을 root로 하고 3이 leaf, 4를 root로 하고 5가 leaf
        uf.union(9, 5);uf.union(7, 2);    //4를 root로 하고 5와 9가 leaf, 7을 level 2인 root로 하고 3이 leaf, 2는 level 1, 2아래에 1과 6이 leaf 노드
        uf.union(7, 8);uf.union(0, 4);    //level 2인 7에 8인 leaf 노드, 4를 root로 하고 5, 9, 0이 leaf

        System.out.print("8번의 union 연산 수행 후 \n(i:parent, rank):");  //text template
        for (int i = 0; i < N; i++) {                                   //크기만큼 순회
            System.out.print("("+i+":"+uf.a[i].getParent()+","+uf.a[i].getRank()+") ");  //노드에 저장되어있는 정보, 숫자:parent:rank 출력
        }

        uf.union(9, 1);                                                             //find로 1을 경로압축하며 root가 7인 트리에 root가 4인 트리 union
        System.out.println();       //줄바꿈
        System.out.println();       //줄바꿈
        System.out.print("union(9,1) 수행 후\n(i:parent, rank):");                         //text template
        for (int i = 0; i < N; i++) {                                                     //크기만큼 순회
            System.out.print("("+i+":"+uf.a[i].getParent()+","+uf.a[i].getRank()+") ");   //노드에 저장되어있는 정보, 숫자:parent:rank 출력
        }
        System.out.println();       //줄바꿈
    }
}
