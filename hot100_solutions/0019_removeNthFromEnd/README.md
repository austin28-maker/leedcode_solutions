## 思路
- 利用双指针的方法解决改题目
- fast指针先走n步，slow指针再走，当fast指针走到链表的末尾时，slow指针就走到倒数第n个节点的前一个节点
- 所以，slow指针的下一个节点就是要删除的节点
- 删除slow指针的下一个节点，就是将slow指针的下一个节点的下一个节点赋值给slow指针的下一个节点
- 即：slow.next = slow.next.next;
- 最后，返回root.next，就是删除了倒数第n个节点后的链表头节点

## 注意事项
- 注意判断slow.next是否为空，因为slow.next为空时，slow.next.next会报错
- 所以，在删除slow指针的下一个节点前，要判断slow.next是否为空
- 如果slow.next为空，就直接返回root.next，就是删除了倒数第n个节点后的链表头节点