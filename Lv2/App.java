package Lv2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        //Calculator 인스턴스 생성
        Calculator calc = new Calculator();

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

            //getter와 setter를 활용해보기
            //getter
            List <Integer> myresult = calc.getArrList();
            for(Integer v : myresult){
                System.out.println("i번째 result" + v);
            }

            //setter
            List <Integer> newArr = new ArrayList<Integer>(List.of(321,456,789,123,443));
            calc.setArrList(newArr);

            //저장된 연산 결과들 중 가장 먼저 저장된 데이터를 삭제
            calc.removeResult();
            
            //연산 수행 역할 -> Calculator 클래스가 담당
            try{
                int result = calc.calculate(x, y, op);
                System.out.println("결과 : " + result);
            }
            catch (ArithmeticException e){
                System.out.println("0으로 나눌 수 없습니다.");
            }
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
