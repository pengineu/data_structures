package week14.SortTest;

public class Selection {                                            //선택 정렬 class
    private static boolean isLess(Comparable i, Comparable j) {     //비교 메서드
        return (i.compareTo(j) < 0);                                //첫 번째 인자가 더 적으면 true 반환
    }
    private static void swap(Comparable[] arr, int i, int j) {      //두 요소의 위치를 바꾸는 메서드
        Comparable temp = arr[i];                                   //arr[i] 와
        arr[i] = arr[j];                                            //arr[j] 를 바꿈
        arr[j] = temp;
    }
    public static void sort(Comparable[] arr) {                     //Selection sort 메서드
        for (int i = 0; i < arr.length; i++) {                      //크기만큼 순회
            int min = i;                                            //최소값을 설정
            for (int j = i+1; j < arr.length; j++) {                //i부터 키워가며 순회
                if (isLess(arr[min], arr[j])) {                     //최소값과 크기를 비교하며 최소값 탐색
                    min = j;                                        //더 작은 값 최소값으로 할당
                }
            }
            swap(arr, i, min);                                      //최소값을 맨 앞으로 보내는것을 반복하며 정렬
        }
    }
}
