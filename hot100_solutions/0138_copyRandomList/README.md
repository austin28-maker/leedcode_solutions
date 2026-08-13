## 感悟

感觉链表的题目就是把链表的一些套路和用法记下来，剩下的就是理解题目意思了

例如本题目中需要掌握的有：
- 复制链表中每个节点，把新节点直接插到原节点的后面
    - 为什么要 cur.next.next 而不是 cur.next？
    - 因为 cur.next 是新节点，而新节点的 next 是 cur.next.next，所以要跳过 cur.next，直接跳到新节点的 next
    - 也就是说条件判断中的条件是会根据循环内部的执行语句进行更新的？
- 遍历交错链表中的原链表节点
    - 遍历交错链表中的原链表节点，要根据 cur.next.next 来遍历，而不是 cur.next
    - 因为 cur.next 是新节点，而新节点的 next 是 cur.next.next，所以要跳过 cur.next，直接跳到新节点的 next
    - 也就是说条件判断中的条件是会根据循环内部的执行语句进行更新的？
- 把交错链表分离成两个链表
    - 把交错链表分离成两个链表，要根据 cur.next.next 来分离，而不是 cur.next
    - 因为 cur.next 是新节点，而新节点的 next 是 cur.next.next，所以要跳过 cur.next，直接跳到新节点的 next
    - 也就是说条件判断中的条件是会根据循环内部的执行语句进行更新的？

# 注意

本题中节点类型是Node，而不是ListNode，所以要特殊处理 random 指针
随机指针指向的节点可能是 null，所以要判断一下是否为 null
如果为 null，就直接把 random 指针设为 null
如果不是 null，就把 random 指针设为 cur.random 的下一个节点
- 要复制的 random 是 cur.random 的下一个节点
- 所以要 cur.next.random = cur.random.next