/**
 * @author: sufangfang
 * 日期: 2023/6/2
 **/
public class CalculateApplication {
    public static void main(String[] args){
        CalculateInvoker invoker = new CalculateInvoker(new BigDecimalCalculator());

        invoker.add( "100.08");
        invoker.div( "0");
        invoker.sub( "50");
        invoker.mul( "10");
        invoker.div( "2");
        invoker.div( "2");
        invoker.mul( "0");
        invoker.mul( "1");
        invoker.mul( "1");
        invoker.mul( "1");
        invoker.mul( "1");
        invoker.mul( "1");
        invoker.mul( "1");
        invoker.mul( "1");

        invoker.redo();

        invoker.undo();
        invoker.undo();
        invoker.undo();
        invoker.undo();
        invoker.undo();
        invoker.undo();
        invoker.undo();
        invoker.undo();
        invoker.undo();

        invoker.redo();
        invoker.redo();

        invoker.undo(5);
        invoker.redo(10);




        invoker = new CalculateInvoker(new IntCalculator());

        invoker.add( "100");
        invoker.div( "0");
        invoker.sub( "50");
        invoker.mul( "10");
        invoker.div( "2");
        invoker.div( "2");
        invoker.mul( "0");
        invoker.mul( "1");

        invoker.redo();

        invoker.undo();
        invoker.undo();
        invoker.undo();
        invoker.undo();
        invoker.undo();
        invoker.undo();
        invoker.undo();
        invoker.undo();
        invoker.undo();

        invoker.redo();
        invoker.redo();

        invoker.undo(5);
        invoker.redo(10);
    }
}
