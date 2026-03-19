package week01.Fibonacchi;
import java.util.Scanner;


public class Main {
    public static long fibonacci(int n) {       //Iteration version method
        int num = 0;                            //Fn = fibonacci(n)일 때 F0값 초기화
        int addition = 1;                       //F1값 초기화
        int result = 0;                         //누적 합을 저장할 결과 값 초기화

        for (int i = 1; i < n; i++) {           //Iteration을 구현하기 위한 for문, 정의에 의해 피보나치 함수의 덧셈은 F2부터 시작하므로 초기 i값을 1로 설정
            result = num + addition;            //F2 = F0 + F1
            num = addition;                     //이후 반복을 위해 F1 <- F0으로 sliding
            addition = result;                  //이후 반복을 위해 F2 <- F1으로 sliding
        }
        return result;                          //결과 값 반환
    }
    public static long fibonacciR(int n) {      //Recursion version method
        if (n == 0) {
            return 0;                           //F0인 경우 0 반환
        } else if (n == 1) {
            return 1;                           //F1인 경우 1 반환
        } else {
            return fibonacciR(n-1) + fibonacciR(n-2);   //피보나치 수열의 정의에 따라 재귀적으로 내려가며 최종적으로 Fn값 계산
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);                    //입력받을 Scanner 객체 생성
        int n;                                                  //입력받을 변수 선언
        long startTime, endTime, result;                        //재귀를 사용하지 않는 피보나치 수열의 정보를 저장하는 변수들
        long startRecursive, endRecursive, resultRecursive;     //재귀를 사용하는 피보나치 수열의 정보를 저장하는 변수들

        System.out.print("[Fibonacci] input an integer number >> ");    //입력 포맷
        n = sc.nextInt();                                               //피보나치 수열의 인자를 입력받음
        startTime = System.nanoTime();                                  //함수를 실행하기 전의 시간
        result = fibonacci(n);                                          //재귀를 사용하지 않는 피보나치 수열 함수 호출
        endTime = System.nanoTime();                                    //함수를 실행한 후의 시간
        System.out.println("No Recursive: " + n + " = " + result);      //피보나치 수열 값 출력
        System.out.printf("Duration: %d nano sec.\n", (endTime-startTime)); //함수 실행에 소요된 시간 측정

        startRecursive = System.nanoTime();                             //실행 전 시간
        resultRecursive = fibonacciR(n);                                //재귀를 사용한 피보나치 수열 함수 호출
        endRecursive = System.nanoTime();                               //실행 후 시간
        System.out.println("Recursive: " + n + " = " + resultRecursive);    //피보나치 수열 값 출력
        System.out.printf("Duration %d nano sec.\n", (endRecursive-startRecursive));    //함수 실행에 소요된 시간 축정
    }
}
