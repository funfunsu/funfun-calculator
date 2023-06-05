## 一个计算器类（Calculator），可以实现两个数的加、减、乘、除运算，并可以进行undo和redo操作
## 本case采用命令模式：
- 实现了两个Receiver（分别是BigDecimalCalculator 和 IntCalculator）
- 采用面向对象的思想对CalculateInvoker实现了计算器封装
- 启动类CalculateApplication 有分别提供两个Receiver的调用示例