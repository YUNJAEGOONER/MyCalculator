package Lv3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArithmeticCalculator {
    //연산 결과를 저장하는 컬렉션 타입 필드
    //외부에서 직접 접근하지 못하도록 -> private
    private List<Double> arrList = new ArrayList<>();

    //사칙연산 수행 후, 결과 값을 반환
    public double calculate(double x, double y, OperatorType op){
        double result = 0;
        switch (op) {
            case ADD:
                result = x + y;
                break;
            case SUB:
                result = x - y;
                break;
            case MUL:
                result = x * y;
                break;
            case DIV:
                result = x / y;
        }
        arrList.add(result); //연산 결과를 저장
        return result;
    }

    public void setArrList(List<Double> arrList){
        this.arrList = arrList;
    }

    public List<Double> getArrList(){
        return arrList;
    }

    //저장된 연산 결과들 중 가장 먼저 저장된 데이터를 삭제
    public void removeResult(){
        if(!arrList.isEmpty()){arrList.remove(0);}
        else System.out.println("EmptyArray!!!");
    }

    public void bigElement(double max){
        List<Double> filtered = arrList.stream()
                .filter(e -> e > max)
                .collect(Collectors.toList());
        System.out.println(filtered);
    }

}
