package Lv3;


import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        //Calculator 인스턴스 생성
        ArithmeticCalculator calc = new ArithmeticCalculator();

        Scanner sc = new Scanner(System.in);
        while(true){
            //양의 정수를 입력받기
            //TODO: InputMismatchException 처리하기
            double x;
            while(true){
                try{
                    System.out.print("첫 번째 숫자를 입력하세요: ");
                    x = sc.nextDouble();
                    if(x >= 0) break;
                    else System.out.println("양의 정수를 입력해 주세요 : ");
                }
                catch (InputMismatchException e){
                    System.out.println("입력의 형식을 지켜주세요.");
                    sc.nextLine(); //버퍼 비우기
                }
            }

            double y;
            while(true){
                try{
                    System.out.print("두 번째 숫자를 입력하세요: ");
                    y = sc.nextDouble();
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

            //convert char to Enum class
            OperatorType opCode = null;
            if(op == '+'){opCode = OperatorType.ADD;}
            else if(op == '-'){opCode = OperatorType.SUB;}
            else if(op == '*'){opCode = OperatorType.MUL;}
            else if(op == '/'){opCode = OperatorType.DIV;}

            try {
                Object result = calc.calculate(x, y, opCode);
                System.out.println("결과 : " + result.toString());
            }
            catch (ArithmeticException e){
                System.out.println("0으로 나눌 수 없습니다.");
            }
            catch (NullPointerException e){
                System.out.println("연산자가 지정되지 않았습니다. ");
            }

            //저장된 연산 결과들 중 Scanner로 입력받은 값보다 큰 결과값 들을 출력
            double max = x;
            if(max < y) max = y;
            System.out.println("입력받은 값보다 큰 결과값 들을 출력");
            calc.bigElement(max);

            //반복문 종료
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
