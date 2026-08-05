## 易错点

该语句注意：
boolean[] rowZero = new boolean[m], colZero = new boolean[n];
错误写法：
Boolean[] rowZero = new Boolean[m], colZero = new Boolean[n];

当声明一个 Boolean 数组（例如 Boolean[]）时，其元素默认值是 null。
如果在后续代码中直接将其用于条件判断（例如 if (row[i])），Java 会尝试自动拆箱（即调用 booleanValue() 方法）。
此时如果遇到未初始化的 null 值，就会抛出 NullPointerException。

## 掌握读懂报错的信息
NullPointerException