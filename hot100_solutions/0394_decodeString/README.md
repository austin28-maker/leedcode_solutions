## 解题思路

- 栈、辅助栈
    - 用于存储当前的字符串和重复次数
    - 遍历字符串，根据字符的类型进行处理
    - 先入后出的原理，用于存储当前的字符串和重复次数

## 注意事项

- 注意字符串的拼接和重复操作
    - 字符串中可能会包含多个括号，需要递归处理每个括号内的字符串
        - 字符串中出现的数字，需要转换为整数，用于倍数计算
        - 字符串中出现的字母，需要拼接到当前字符串中
        - 字符串中出现的括号分类讨论，括号内还会嵌套括号，需要递归处理括号内的字符串

- 将字符转换为整数时，为什么要让c + ""？
    - 因为parseInt方法需要一个字符串作为参数，而c是一个字符，需要将其转换为字符串，才能调用parseInt方法
    - 例如，c = '3'，则c + "" = "3"

- digit.removeLast()不可以作为重复次数，因为重复次数是一个整数，而digit.removeLast()是一个字符串，需要将其转换为整数，才能用于重复操作
    - 例如，digit.removeLast() = "3"，则Integer.parseInt(digit.removeLast()) = 3
    - 代码中`int cur_multi = stack_multi.removeLast();`就是解决这个问题

- StringBuilder的初始化写法
    - 例如，`StringBuilder sb = new StringBuilder();`，表示初始化一个空的StringBuilder对象
    - 区别于LinkedList，ArrayList等集合类，StringBuilder是字符串类，用于拼接字符串，而不是存储元素

- stack_multi和stack_res作为辅助栈，用于存储当前的重复次数和字符串
    - 理解好栈在遍历字符串时的作用，以及在遇到括号时的处理逻辑
    - 而res则用于存储当前的字符串，相当于临时的变量，可以在将待处理的字符送入栈内再进行初始化，会有增删操作

## 知识点

- 栈的使用
- 字符串的拼接和重复操作
- StringBuilder的使用
    - 可变的字符串类，与StringBuffer不同，StringBuilder是线程不安全的，而StringBuffer是线程安全的
- Integer.parseInt(c + "")方法：将字符转换为整数
