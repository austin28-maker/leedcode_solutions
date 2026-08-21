## 解题思路

- 排列组合和参考 树 的结构进行求解。

## 知识点

- 回溯思想

- charAt(int index) 是 String 类的方法，
    - 作用：返回字符串中指定下标的字符
    - 案例：String s = "hello";
            char c = s.charAt(1);   // c = 'e'（下标从 0 开始）

- String[] letterMap = { ... };    // ★ 推荐写法：[] 跟类型
  String letterMap[] = { ... };    // 本题写法：[] 跟变量名（C 语言遗风）

- StringBuffer 是 Java 的可变字符串类——一个可以反复修改（追加、插入、删除）内容而不产生新对象的字符串容器。
    - 作用：用于构建字符串，避免频繁创建新对象，提高效率。增速
    - 案例：StringBuffer sb = new StringBuffer();
            sb.append("hello");
            sb.append("world");
            System.out.println(sb.toString());  // 输出 "helloworld"

## 注意事项

- res.add(sb.toString());// 注意其他题目res如果是列表，加入的时候需要new新的列表，否则最后一定被回溯到空列表
- 与`39题`共同理解该语法的使用场景。