package Lv2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    //연산 결과를 저장하는 컬렉션 타입 필드
    //외부에서 직접 접근하지 못하도록 -> private
    private List<Integer> arrList = new ArrayList<>();
    
    //사칙연산 수행 후, 결과 값을 반환
    public int calculate(int x, int y, char op){
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
                result = x / y;
        }
        arrList.add(result); //연산 결과를 저장
        return result;
    }

    public void setArrList(List<Integer> arrList){
        this.arrList = arrList;
    }

    public List<Integer> getArrList(){
        return arrList;
    }

    //저장된 연산 결과들 중 가장 먼저 저장된 데이터를 삭제
    public void removeResult(){
        if(!arrList.isEmpty()){arrList.remove(0);}
        else System.out.println("EmptyArray!!!");
    }

}
