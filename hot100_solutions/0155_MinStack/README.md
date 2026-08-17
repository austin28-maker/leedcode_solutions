## 知识点

- 栈是一种"后进先出"（LIFO）的数据结构
- 栈的"栈顶"是最新入栈的元素，"栈底"是最早入栈的元素
- 核心操作有push、pop、top/peek等
- Java里推荐用 Deque（双端队列）来当栈用，配 ArrayDeque
    Deque<Integer> stack = new ArrayDeque<>();
    stack.push(5);        // 放入 5，栈顶是 5
    stack.push(3);        // 放入 3，栈顶是 3
    stack.peek();         // 看栈顶 → 3（不拿走）
    stack.pop();          // 拿走栈顶 → 3，现在栈顶是 5，但返回值是3
    stack.isEmpty();      // 栈空了吗？
- Java 有个叫 Stack 的类，但它线程同步、性能差，现在都推荐用 Deque 代替。
- Deque 叫 双端队列，但只用 push/pop/peek 时它就是个栈
- 回顾Java类中的构造器作用
- 创建类时，要有自己的字段，辅助该类中的方法设计

## 思路

- 本题目是设计类，与“给你输入、你返回输出"的算法题目不同
- 利用 辅助栈