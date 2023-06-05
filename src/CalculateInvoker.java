import java.util.ArrayList;

/**
 * @author: sufangfang
 * 日期: 2023/6/2
 **/
public class CalculateInvoker {
    private AbstractCalculator calculator;
    private ArrayList<CalculateCommand> commands = new ArrayList<CalculateCommand>();
    private int current = 0;
    private final static int MAX_COMMAND_SIZE = 1000;

    public CalculateInvoker(AbstractCalculator calculator) {
        this.calculator = calculator;
    }

    public void redo(){
        redo(1);
    }

    public void undo(){
        undo(1);
    }

    public void redo(int levels) {
        if (current >= commands.size()-1){
            System.out.println(">>> redo nothing");
            return;
        }
        if(levels + current > commands.size()){
            System.out.println("bad redo levels! max undo level is " + (commands.size() - current ));
            levels = (commands.size() - current );
        }
        System.out.println(">>> redo "+levels);
        for (int i = 0; i < levels; i++){
            if (current < commands.size()){
                System.out.print("redo step " + (current+1)+": ");
                (commands.get(current++)).execute();
            }
        }
    }

    public void undo(int levels) {
        if (current <= 0 ){
            System.out.println(">>> undo nothing");
            return;
        }
        if(levels > current +1){
            System.out.println("bad undo levels! max undo level is " + (current ));
            levels = current;
        }
        System.out.println(">>> undo " + levels);
        for (int i = 0; i < levels; i++){
            if (current > 0){
                System.out.print("undo step " + current+": ");
                CalculateCommand command = commands.get(--current);
                command.undoExecute();
            }
        }
    }


    private void compute(char op, Number operand) {
        if(commands.size() > MAX_COMMAND_SIZE){
            //程序保护
            System.out.println("当前计算队列缓存命令数量超过"+MAX_COMMAND_SIZE+"! 请及时保存再开始重新计算！");
            return;
        }
        CalculateCommand command = new CalculateCommand(calculator, op, operand);
        System.out.print("step " + (current+1)+" :");
        command.execute();
        commands.add(command);
        current++;
    }

    /**
     * 加
     * @param numStr
     */
    public void add(String numStr){
        Number num = calculator.convert(numStr);
        if(num == null){
            System.out.println("bad number input! "+numStr +" is not allowed!");
            return;
        }
        compute('+',num);
    }

    /**
     * 减
     * @param numStr
     */
    public void sub(String numStr){
        Number num = calculator.convert(numStr);
        if(num == null){
            System.out.println("bad number input! "+numStr +" is not allowed!");
            return;
        }
        compute('-',num);
    }

    /**
     * 乘
     * @param numStr
     */
    public void mul(String numStr){
        Number num = calculator.convert(numStr);
        if(num == null){
            System.out.println("bad number input! "+numStr +" is not allowed!");
            return;
        }
        compute('*',num);
    }

    /**
     * 除
     * @param numStr
     */
    public void div(String numStr){
        char op = '/';
        Number num = calculator.convert(numStr);
        if(num == null){
            System.out.println("[error] bad number input! "+numStr +" is not allowed!");
            return;
        }
        if(!calculator.checkValid(op,num)){
            System.out.println("[error] bad div number! "+numStr +" is not allowed!");
            return;
        }
        compute('/',num);
    }
}
