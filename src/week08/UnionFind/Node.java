package week08.UnionFind;

public class Node {                                 //Node class
    int parent;                                     //parent attr
    int rank;                                       //rank attr

    public Node(int newParent, int newRank) {       //생성자
        parent = newParent;                         //parent 초기화
        rank = newRank;                             //rank 초기화
    }

    public int getParent() {                        //getter
        return parent;                              //parent 반환
    }

    public int getRank() {                          //getter
        return rank;                                //rank 반환
    }

    public void setParent(int newParent) {          //setter
        parent = newParent;                         //parent 변환
    }

    public void setRank(int newRank) {              //setter
        rank = newRank;                             //rank 변환
    }
}
