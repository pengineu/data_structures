package week14.SortTest;


public class Merge {
    private static boolean isLess(Comparable i, Comparable j) {     //비교 메서드
        return (i.compareTo(j) < 0);                                //첫 번째 인자가 더 적으면 true 반환
    }
    private static void merge(Comparable arr[], Comparable temp[], int low, int mid, int high) {    //Merge 메서드
        int i = low, j = mid + 1;               //반을 나누어 low와 mid+1 을 설정 (절반에서 가장 작은 값)
        for (int k = low; k <= high; k++) {     //크기만큼 순회
            if (i > mid) {                      //절반을 모두 사용해서 넘어갔다면
                temp[k] = arr[j];               //나머지 요소만 사용
                j++;                            //나머지 요소 인덱스를 늘림
            }
            else if (j > high) {                //절반을 모두 사용해서 넘어갔다면
                temp[k] = arr[i];               //나머지 요소만 사용
                i++;                            //나머지 요소 인덱스를 늘림
            }
            else if (isLess(arr[i], arr[j])) {  //반으로 나누어 양쪽의 최소값끼리 비교
                temp[k] = arr[i];               //low쪽이 작다면 low쪽을 넣음
                i++;                            //low 쪽의 다음으로 작은 값으로 이동
            }
            else {
                temp[k] = arr[j];               //mid 쪽이 작다면 mid 쪽을 넣음
                j++;                            //mid 쪽의 다음으로 작은 값으로 이동
            }
        }
        for (int k = low; k <= high; k++) {     //처음부터 순회
            arr[k] = temp[k];                   //정렬된 temp 복사
        }
    }
    private static void sort(Comparable[] arr, Comparable[] temp, int low, int high) {  //Merge sort 메서드
        if (high <= low) {                              //크기가 1 이하라면
            return;                                     //바로 반환
        }
        int mid = low + (high-low) / 2;                 //가운데 설정
        sort(arr, temp, low, mid);                      //왼쪽 Merge sort 재귀
        sort(arr, temp, mid+1, high);               //오른쪽 Merge sort 재귀
        merge(arr, temp, low, mid, high);               //양쪽 병햡
    }
    public static void sort(Comparable[] arr) {         //사용자 버전 Merge sort
        Comparable[] temp = new Comparable[arr.length]; //배열 객체 생성
        sort(arr, temp, 0, arr.length-1);     //정렬된 배열을 temp에 넣음
    }
}
