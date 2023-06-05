/**
 * @author: sufangfang
 * 日期: 2023/6/2
 **/
public class CalculateCommand implements Command{
    char op;
    Number operand;
    AbstractCalculator calculator;
    Number lastR;

    public CalculateCommand(AbstractCalculator calculator, char op, Number operand) {
        this.calculator = calculator;
        this.op = op;
        this.operand = operand;
    }

    public char getOp() {
        return op;
    }

    public void setOp(char op) {
        this.op = op;
    }

    public Number getOperand() {
        return operand;
    }

    public void setOperand(Number operand) {
        this.operand = operand;
    }

    public AbstractCalculator getCalculator() {
        return calculator;
    }

    public void setCalculator(IntCalculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public void execute() {
        lastR = calculator.result;
        calculator.operation(op,operand);
    }

    @Override
    public void undoExecute() {
        calculator.undoOperation(lastR,op,operand);
    }
}
