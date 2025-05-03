package Lv1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            //양의 정수를 입력받기
            //TODO: InputMismatchException 처리하기
            int x;
            while(true){
                try{
                    System.out.print("첫 번째 숫자를 입력하세요: ");
                    x = sc.nextInt();
                    if(x >= 0) break;
                    else System.out.println("양의 정수를 입력해 주세요 : ");
                }
                catch (InputMismatchException e){
                    System.out.println("입력의 형식을 지켜주세요.");
                    sc.nextLine(); //버퍼 비우기
                }
            }

            int y;
            while(true){
                try{
                    System.out.print("두 번째 숫자를 입력하세요: ");
                    y = sc.nextInt();
                    if(y >= 0) break;
                    else System.out.println("양의 정수를 입력해 주세요 : ");
                }
                catch (InputMismatchException e){
                    System.out.println("입력의 형식을 지켜주세요.");
                    sc.nextLine(); //버퍼 비우기
                }
            }

            System.out.print("사칙연산 기호를 입력하세요 (+ , - , *, / ): ");
            char op = sc.next().charAt(0);
            while (op != '+' && op != '-' && op != '*' && op != '/') {
                System.out.print("사칙 연산 기호만을 입력하세요 (+ , - , *, / ): ");
                op = sc.next().charAt(0);
            }

            int result = 0;
            boolean flag = true; //연산 결과가 없는 경우에는 false : 0으로 나누는 경우

            switch (op) {
                case '+':
                    result = x + y;
                    break;
                case '-':
                    result = x - y;
                    break;
                case '*':
                    result = x * y;
                    break;
                case '/':
                    try {
                        result = x / y;
                    }
                    catch (ArithmeticException e) {
                        flag = false;
                        System.out.println("0으로 나눌 수 없습니다.");
                    }
                    break;
            }
            if(flag) System.out.println("결과 : " + result);
            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료) : ");

            sc.nextLine(); // 버퍼 비우기
            String cmd = sc.nextLine(); //sc.next()로 입력받기...
            if(cmd.equals("exit")){
                System.out.println("프로그램이 종료됩니다.");
                break;
            }

        }
    }
}
