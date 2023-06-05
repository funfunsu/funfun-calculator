/**
 * @author: sufangfang
 * 日期: 2023/6/2
 **/
public class IntCalculator extends AbstractCalculator<Integer> {

    public IntCalculator() {
        result = 0;
        System.out.println(">>> calculator start from 0 ！");
    }

    @Override
    boolean checkValid(char op, Integer operand) {
        switch (op) {
            case '/':
                if (operand.equals(0)){
                    return false;
                }
        }
        return true;
    }

    @Override
    public Integer convert(String inputVal) {
        try {
            return Integer.valueOf(inputVal);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public void doOperation(char op, Integer operand) {
        switch (op) {
            case '+':
                result += operand;
                break;
            case '-':
                result -= operand;
                break;
            case '*':
                result *= operand;
                break;
            case '/':
                result /= operand;
                break;
        }
    }
}
