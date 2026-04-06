package week04.Calculation;
import java.util.*;
import java.lang.Math;
public class Postfix {                  //postfix class
    private String infix;               //infix 문자열
    private StringBuilder postfix;      //postfix 문자열
    public Postfix(String string) {     //생성자
        infix = string;                 //infix를 입력으로
        postfix = new StringBuilder();  //postfix는 가변 문자열로 객체 생성
        infixToPostfix(0);        //postfix를 만드는 함수 호출
    }
    private double operate(String num1, String num2, String operator) { //문자열로 이루어진 2항 연산을 계산해주는 메서드
        double a = Double.parseDouble(num1);                            //문자열 피연산자를 실수double로
        double b = Double.parseDouble(num2);                            //문자열 피연산자를 실수double로
        if (operator.equals("+")) {                                     //연산자가 +일 때
            return a + b;                                               //덧셈 연산
        } else if (operator.equals("-")) {                              //연산자가 -일 때
            return a - b;                                               //뺄셈 연산
        } else if (operator.equals("*")) {                              //연산자가 *일 때
            return a * b;                                               //곱셈 연산
        } else if (operator.equals("/")) {                              //연산자가 /일 때
            return a / b;                                               //몫 연산
        } else if (operator.equals("%")) {                              //연산자가 %일 때
            return a % b;                                               //나머지 연산
        } else if (operator.equals("^")) {                              //연산자가 ^일 때
            return Math.pow(a, b);                                      //지수 연산
        }
        return 0;                                                       //기대하는 입력이 아닐 때
    }
    private int priority(String s) {                                    //우선순위를 반환하는 메서드
        if (s.equals("(")) {                                            //괄호 연산자의 우선순위
            return 0;                                                   //가장 낮음(stack에 있을 때)
        }
        if (s.equals("+") || s.equals("-")) {                           //덧셈, 뺄셈 연산자의 우선순위
            return 1;
        } else if (s.equals("*") || s.equals("/") || s.equals("%")) {   //곱셈, 나눗셈, 나머지 연산자의 우선순위
            return 2;
        } else {
            return 3;                                                   //지수 연산자의 우선순위(가장 높음)
        }
    }
    private boolean prior(String token1, String token2) {               //우선순위가 높은지 확인하는 메서드
        return priority(token1) >= priority(token2);                    //앞의 인자가 뒤의 인자보다 우선순위가 높으면 true 반환
    }
    private boolean isOperator(String s) {                              //해당 문자열이 연산자인지 확인하는 메서드
        String[] operator = {"+", "-", "*", "/", "%", "^", "(", ")"};   //연산자 집합
        return Arrays.asList(operator).contains(s);                     //주어진 문자열이 연산자 집합에 포함되면 true 반환
    }
    private int infixToPostfix(int index) {                             //infix 문자열을 Postfix로 변환하는 메서드
        ArrayStack<String> stack = new ArrayStack<>();                  //stack 객체 생성
        String[] tokens = infix.split("");                        //infix의 문자열을 공백 단위로 구분해서 문자열 배열로
        for (int i = index; i < tokens.length; i++) {                   //infix 길이만큼 반복
            String token = tokens[i];                                   //순서대로 token을 받음
            if (!isOperator(token)) {                                   //연산자가 아니면 바로 postfix로 들어감
                postfix.append(token);
            } else if (stack.isEmpty()) {                               //stack가 비어있으면 연산자는 stack으로 들어감
                stack.push(token);
            } else if (token.equals("(")) {                             //괄호 연산자면 우선순위가 가장 높으므로(들어가기 전) 무조건 들어감
                stack.push(token);
            } else if (token.equals(")")) {                             //괄호가 닫힐 때
                String t = "";                                          //토큰을 저장할 변수
                while (!t.equals("(")) {                                //괄호가 닫히기 전까지
                    t = stack.pop();                                    //연산자들을 stack에서 pop해서
                    if (!t.equals("(") && !t.equals(")")) {             //괄호 연산자가 아닐 때
                        postfix.append(t);                              //postfix에 집어넣음(괄호는 계산하는 연산자가 아니기에 포함 X)
                    }
                }
            } else if (prior(stack.peek(), token) && !stack.peek().equals("(") && !stack.peek().equals(")")){
                postfix.append(stack.pop());                            //새로 들어가는 연산자가 기존보다 우선순위가 낮으면
                stack.push(token);                                      //기존에 우선순위가 높은 연산자를 계산하도록 하고 낮은 우선순위가 stack에 들어감
            } else {                                                    //우선순위가 높으면
                stack.push(token);                                      //우선순위가 낮거나 같은 연산자가 들어올 때까지 stack에서 기다림
            }
        }
        while (!stack.isEmpty() ) {                                     //기다리다가 전부 순회하면
            String t = stack.pop();                                     //기다리던 연산자들을 빼냄
            if (!t.equals("(") && !t.equals(")")) {                     //괄호연산자 빼고 다 집어넣음
                postfix.append(t);
            }
        }
        return 0;
    }
    public double calculate() {                                         //postfix를 계산해주는 메서드
        ArrayStack<String> stack = new ArrayStack<>();                  //stack으로 계산하기 위해 stack객체 생성
        for (int i = 0; i < postfix.length(); i++) {                    //postfix의 길이만큼 순회
            String c = String.valueOf(postfix.charAt(i));               //순서대로 순회
            if (!isOperator(c)) {                                       //연산자가 아니면
                stack.push(c);                                          //스택에 넣음
            } else {                                                    //연산자면
                String operand2 = stack.pop();                          //stack의 마지막 값을 두 번째 피연산자로
                String operand1 = stack.pop();                          //stack의 마지막 이전 값을 첫 번째 피연산자로
                stack.push(String.valueOf(operate(operand1, operand2, c))); //operate를 호출해 스택의 마지막에 결과값을 넣음
            }
        }
        return Double.parseDouble(stack.pop());  //전부 순회할 시 모든 계산을 거친 결과가 stack의 첫 번째 요소에 남기에 이를 반환
    }
    public String getInfix() {      //infix를 반환하는 메서드
        return infix;
    }
    public String getPostfix() {    //postfix를 반환하는 메서드
        return String.join(" ", String.valueOf(postfix).split("")); //가독성을 위해 공백으로 구분해서 문자열로 반환
    }
}
