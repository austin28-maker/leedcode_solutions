class Solution:
    # 获取链表长度
    def getListLength(self, head: Optional[ListNode]) -> int:
        length = 0
        while head:
            length += 1
            head = head.next
        return length

    # 分割链表
    # 如果链表长度 <= size，不做任何操作，返回空节点
    # 如果链表长度 > size，把链表的前 size 个节点分割出来（断开连接），并返回剩余链表的头节点
    def splitList(self, head: Optional[ListNode], size: int) -> Optional[ListNode]:
        # 先找到 next_head 的前一个节点
        cur = head
        for _ in range(size - 1):
            if cur is None:
                break
            cur = cur.next

        # 如果链表长度 <= size
        if cur is None or cur.next is None:
            return None  # 不做任何操作，返回空节点

        next_head = cur.next
        cur.next = None  # 断开 next_head 的前一个节点和 next_head 的连接
        return next_head

    # 21. 合并两个有序链表（双指针）
    # 返回合并后的链表的头节点和尾节点
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        cur = dummy = ListNode()  # 用哨兵节点简化代码逻辑
        while list1 and list2:
            if list1.val < list2.val:
                cur.next = list1  # 把 list1 加到新链表中
                list1 = list1.next
            else:  # 注：相等的情况加哪个节点都是可以的
                cur.next = list2  # 把 list2 加到新链表中
                list2 = list2.next
            cur = cur.next
        cur.next = list1 or list2  # 拼接剩余链表
        while cur.next:
            cur = cur.next
        # 循环结束后，cur 是合并后的链表的尾节点
        return dummy.next, cur

    def sortList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        length = self.getListLength(head)  # 获取链表长度
        dummy = ListNode(next=head)  # 用哨兵节点简化代码逻辑
        step = 1  # 步长（参与合并的链表长度）
        while step < length:
            new_list_tail = dummy  # 新链表的末尾
            cur = dummy.next  # 每轮循环的起始节点
            while cur:
                # 从 cur 开始，分割出两段长为 step 的链表，头节点分别为 head1 和 head2
                head1 = cur
                head2 = self.splitList(head1, step)
                cur = self.splitList(head2, step)  # 下一轮循环的起始节点
                # 合并两段长为 step 的链表
                head, tail = self.mergeTwoLists(head1, head2)
                # 合并后的头节点 head，插到 new_list_tail 的后面
                new_list_tail.next = head
                new_list_tail = tail  # tail 现在是新链表的末尾
            step *= 2
        return dummy.next

作者：灵茶山艾府
链接：https://leetcode.cn/problems/sort-list/solutions/2993518/liang-chong-fang-fa-fen-zhi-die-dai-mo-k-caei/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。