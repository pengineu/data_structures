package week14.SortTest;

public class Shell {
    private static boolean isLess(Comparable i, Comparable j) {     //비교 메서드
        return (i.compareTo(j) < 0);                                //첫 번째 인자가 더 적으면 true 반환
    }
    private static void swap(Comparable[] arr, int i, int j) {      //두 요소의 위치를 바꾸는 메서드
        Comparable temp = arr[i];                                   //arr[i] 와
        arr[i] = arr[j];                                            //arr[j] 를 바꿈
        arr[j] = temp;
    }
    public static void sort(Comparable[] arr) {                     //Shell sort 메서드
        int n = arr.length;                                         //요소 개수
        int h = n/2;                                                //h 초기값 = 요소 개수 / 2
        while (h >= 1) {                                            //h가 1이 될 때까지 반복
            for (int i = h; i < n; i++) {                           //h값을 받는 i로 순회
                for (int j = i; j >= h && isLess(arr[j], arr[j-h]); j -= h) {   //h의 간격을 가진 요소와 비교하여 뒤의 요소가 더 작다면
                    swap(arr, j, j-h);                            //두 요소를 교체(swap)
                }
            }
            h /= 2;                                                 //h를 줄임
        }
    }
}
