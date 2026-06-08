package week14.SortTest;

public class Insertion {
    private static boolean isLess(Comparable i, Comparable j) {     //비교 메서드
        return (i.compareTo(j) < 0);                                //첫 번째 인자가 더 적으면 true 반환
    }
    private static void swap(Comparable[] arr, int i, int j) {      //두 요소의 위치를 바꾸는 메서드
        Comparable temp = arr[i];                                   //arr[i] 와
        arr[i] = arr[j];                                            //arr[j] 를 바꿈
        arr[j] = temp;
    }
    public static void sort(Comparable[] arr) {                     //Insertion Sort 메서드
        for (int i = 1; i < arr.length; i++) {                      //두 번째 요소부터 순회
            for (int j = i; j > 0; j--) {                           //해당 요소부터 아래로 내려감
                if (isLess(arr[j], arr[j-1])) {                     //더 큰 요소를 발견했다면
                    swap(arr, j, j-1);                            //두 요소를 바꿈
                } else {                                            //더 큰 요소를 발견하지 못했다면
                    break;                                          //아래는 이미 정렬되어있으므로 break
                }
            }
        }
    }
}
