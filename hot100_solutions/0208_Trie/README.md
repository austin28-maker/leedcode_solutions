## 解题思路

- 26叉树，区别于普通树，每个节点有26个子节点，分别对应26个字母。

## 知识点

- 外部类和内部类的写法
- 无参构造器、有参构造器
- 在链表、二叉树、Trie树中，节点的定义和初始化、每个节点的子节点数组的定义和初始化，都可以在构造中引用自身类型
    - 例如：
    ```java
    class TrieNode {
        private boolean isEnd;
        private TrieNode[] next; // 这里next的类型就是以TrieNode为元素类型的数组，每个元素表示一个字母的子节点

        public TrieNode() {
            isEnd = false;
            next = new TrieNode[26];
        }
    }
    ```

## 注意事项

- cur.end怎么理解？
- cur.end表示当前节点是否是一个单词的结束节点
- 疑问：find函数中cur.end是怎么判断的？通过怎样的流程就判断其是true还是false呢？
    - 答案：
        - 这个cur.end的值就在insert函数中被赋值的。
            - 当遍历到一个单词的最后一个字符时，cur.end为true
            - 当遍历到一个单词的中间字符时，cur.end为false
        - 所以，在find函数中，cur.end不是判断出来的，而是通过遍历到的字符来读出来的。