package week04.Calculation;
import java.util.Scanner;

public class Main {                                         //main class
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);           //입력받을 scanner 객체 생성
        System.out.println(" :: 프로그램을 시작합니다. :: ");   //시작 알림
        System.out.println("[ 수식 입력을 시작합니다. ]");      //수식 입력 알림
        System.out.println("[ Infix를 postfix로 ]");         //기능 알림
        String string;                                      //입력받을 String변수 선언
        while (true) {                                      //무한루프
            System.out.print(" > 수식을 입력하시오 : ");       //입력 알림
            string = scanner.nextLine();                    //한 줄을 문자열로 입력받음
            if ("!".equals(string)) {                       //!로 무한루프를 끊음
                break;
            }
            Postfix postfix = new Postfix(string);                          //postfix 객체 생성
            System.out.println("입력: " + postfix.getInfix());               //infix 반환
            System.out.println("postfix: " + postfix.getPostfix());         //postfix 반환

            System.out.println("계산 결과: " + postfix.calculate() + "\n");   //계산 결과 반환
        }
        System.out.println("[ 수식 입력을 종료합니다. ]");                      //종료 알림
        System.out.println(" :: 프로그램을 종료합니다. :: ");                   //종료 알림
    }
}
