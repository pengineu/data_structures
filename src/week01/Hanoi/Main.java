package week01.Hanoi;
import java.util.Scanner;

public class Main {
    public static void moveDown(char source, char aux, char dest) {         //binary tree로 구현
        System.out.println("move disk from " + source  + " to " + dest);    //현재 노드 그대로 출력
    }
    public static void move(int disk, char source, char aux, char dest) {   //Recursion method using source, auxiliary, destination
        if (disk == 1) {
            System.out.println("move disk from " + source  + " to " + dest); //원위치에서 목적지로 가는 출력
        } else {
            move(disk-1, source, dest, aux);                           //좌측 노드로 내려갈 경우 목적지와 보조 변경
            moveDown(source, aux, dest);                                    //현재 노드 출력
            move(disk-1, aux, source, dest);                           //우측 노드로 내려갈 경우 원위치와 보조 변경
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);                                //Disk 개수를 입력받을 Scanner 객체 생성
        int n;                                                              //디스크 개수를 입력받을 변수 저장

        System.out.print("Input Disk Number >> ");                          //입력 포맷
        n = sc.nextInt();                                                   //디스크 개수 입력
        move(n, 'A', 'B', 'C');                         // source: A, aux: B, dest: C
    }
}
