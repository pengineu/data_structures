package week08.UnionFind;

public class UnionFind {                //union find class
    protected Node[] a;                 //배열로 union find

    public UnionFind(Node[] iarray) {   //생성자
        a = iarray;                     //배열 초기화
    }

    protected int find(int i) {         //root의 값을 반환하는 find 메서드
        if (a[i].getParent() == i) {    //parent가 본인과 같다면(root라면)
            return i;                   //값 반환
        }
        a[i].setParent(find(a[i].getParent())); //재귀를 통해 경로 압축
        return find(a[i].getParent());  //재귀를 통해 parent 탐색
    }

    public void union(int i, int j) {                           //두 트리를 합치는 union 메서드
        int root1 = find(i);                                    //두 요소의 root를 탐색
        int root2 = find(j);                                    //두 요소의 root를 탐색
        if (a[root1].getRank() > a[root2].getRank()) {          //첫 번째 트리의 rank가 더 크다면
            a[root2].setParent(root1);                          //두 번째 트리를 첫 번째 트리에 붙임
        } else if (a[root1].getRank() < a[root2].getRank()) {   //두 번째 트리의 rank가 더 크다면
            a[root1].setParent(root2);                          //첫 번째 트리를 두 번째 트리에 붙임
        } else {                                                //둘의 rank가 같을 때
            a[root2].setParent(root1);                          //두 번째 트리를 첫 번째 트리에 붙임
            a[root1].setRank(a[root1].getRank() + 1);           //첫 번째 root의 rank를 1늘림
        }
    }
}
