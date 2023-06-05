/**
 * @author: sufangfang
 * 日期: 2023/6/2
 **/
public abstract class AbstractCalculator<T extends Number> {
    protected T result;

    /**
     * 判断 operand 和 op 是否合法
     * @param op
     * @param operand
     * @return
     */
    abstract boolean checkValid(char op, T operand);

    /**
     * 计算
     *
     * @param op
     * @param operand
     */
    abstract void doOperation(char op, T operand);

    public void operation(char op, T operand) {
        T lastR = result;
        doOperation(op,operand);
        System.out.println(" ("+lastR.toString()+" "+ op + " "+operand.toString() +") = "+result.toString());
    }

    public void undoOperation(T lastResult, char op, T operand) {
        char undoOp = undoOp(op);
        if(!checkValid(undoOp,operand)){
            //遇到不可逆向计算的情况，如x*0=0，不能通过0/0得到x，直接取回上一步的结果
            System.out.println(" (skip "+lastResult +op+  operand+") : "+lastResult);
        }else{
            System.out.println(" ("+result+" "+ undoOp + " "+operand.toString() +") = "+lastResult);
        }
        result = lastResult;
    }

    public char undoOp(char op) {
        char undo = ' ';
        switch (op) {
            case '+':
                undo = '-';
                break;
            case '-':
                undo = '+';
                break;
            case '*':
                undo = '/';
                break;
            case '/':
                undo = '*';
                break;
        }
        return undo;
    }

    /**
     * 入参转换
     *
     * @param inputVal
     * @return
     */
    abstract T convert(String inputVal);
}
