## 知识补充

初始化一个空的列表，注意是`Integer`类型，不是`int`类型。new的是ArrayList。
List<Integer> res = new ArrayList<>();

## 新颖思路

滑动窗口
p中每个字符的ASCII码减去'a'的ASCII码，就是字符在数组中的索引位置