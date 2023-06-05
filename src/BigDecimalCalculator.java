import java.math.BigDecimal;

/**
 * @author: sufangfang
 * 日期: 2023/6/2
 **/
public class BigDecimalCalculator extends AbstractCalculator<BigDecimal> {

    public BigDecimalCalculator() {
        result = new BigDecimal(0);
        System.out.println(">>> calculator start from 0 ！");
    }

    @Override
    public boolean checkValid(char op, BigDecimal operand){
        switch (op) {
            case '/':
                if (operand.compareTo(BigDecimal.ZERO) == 0){
                    return false;
                }
        }
        return true;
    }

    @Override
    public BigDecimal convert(String inputVal) {
        try {
            return new BigDecimal(inputVal);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public void doOperation(char op, BigDecimal operand) {
        switch (op) {
            case '+':
                result = result.add(operand);
                break;
            case '-':
                result = result.subtract(operand);
                break;
            case '*':
                result = result.multiply(operand);
                break;
            case '/':
                result = result.divide(operand);
                break;
        }
        if (BigDecimal.ZERO.compareTo(result) == 0){
            result = BigDecimal.ZERO;
        }
    }
}
