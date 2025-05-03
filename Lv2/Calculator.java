package Lv2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    //외부에서 직접 접근하지 못하도록...
    private List<Integer> arr = new ArrayList<>();

//    List<Integer> arr;
//
//    Calculator() {
//        arr = new ArrayList<>();
//    }
    
    //사칙연산 수행 후, 결과 값을 반환
    public String calculate(int x, int y, char op){
        int result = 0;
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
                try{
                    result = x / y;
                }
                catch(ArithmeticException e){
                    return "0으로 나눌 수 없습니다.";
                }
        }
        arr.add(result);
        return Integer.toString(result);
    }

//    public getArr(){
//
//    }

    public void removeResult(){
        if(!arr.isEmpty()){arr.remove(0);}
        else System.out.println("EmptyArray!!!");
    }
}
