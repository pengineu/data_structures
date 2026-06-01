package week13.MinHeap;

public class Entry <Key extends Comparable<Key>, Value> {   //Entry class
    private Key k;                                          //key
    private Value v;                                        //value
    public Entry(Key newKey, Value newValue) {              //생성자
        k = newKey;                                         //key 초기화
        v = newValue;                                       //value 초기화
    }
    public Key getKey(){                                    //getter
        return k;                                           //key 반환
    }
    public Value getValue() {                               //getter
        return v;                                           //value 반환
    }
    public void setKey(Key k) {                             //setter
        this.k = k;                                         //key 재설정
    }
    public void setValue(Value v) {                         //setter
        this.v = v;                                         //value 재설정
    }
}
