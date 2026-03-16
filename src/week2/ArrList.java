package week2;

public class ArrList <E> {
    private E a[];
    private int size;
    private ArrList() {
        a = (E[]) new Object[1];
        size = 0;
    }

    public boolean isEmpty() {
        return a.length == 0;   // a의 길이가 0이면 True 그대로 return
    }

    public void insertLast(E newItem) {
        a[size] = newItem;  // size가 마지막 요소의 인덱스이므로 a[size]에 newItem 저장
    }

    public void insert(E newItem, int k) {
        a[k] = newItem;
    }

    public E deleate(int k) {
        a[k] = null;
        return a[k];
    }

    public E peek(int k) {
        return a[k];
    }

    private void resize(int newSize) {
        E resizeList[] = (E[]) new Object[newSize];
        for (int i = 0; i < size; i++) {
            resizeList[i] = a[i];
            a = resizeList;
        }
    }

    public void print() {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
        System.out.println();
    }
}
