## 时间复杂度

O(n) 表示算法的运行时间与输入规模成 线性关系
排序算法（如快速排序）的时间复杂度是 O(n log n)

## 知识点

HashSet 是一种基于哈希表实现的集合，它不允许重复元素。
HashMap定义的语法结构
Map<String, List<Integer>> map = new HashMap<>>();// 创建一个空的HashMap，键值对

HashSet定义的语法结构
Set<Integer> set = new HashSet<>();// 单元素集合

哈希集合的增删改查
add() 方法：添加元素到集合中
remove() 方法：从集合中删除元素
contains() 方法：检查元素是否在集合中
哈希集合如何修改元素？
set.remove(old);// 先删除旧元素
set.add(new);// 再添加新元素

## 遗漏点

for循环和while循环的区别
for循环：在循环开始前确定循环次数，循环次数是确定的。
while循环：在循环开始前不确定循环次数，循环次数是不确定的。