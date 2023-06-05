/**
 * @author: sufangfang
 * 日期: 2023/6/2
 **/
public interface Command {
    /**
     * 执行命令
     */
    void execute();
    /**
     * 撤销上次执行的命令
     */
    void undoExecute();
}
