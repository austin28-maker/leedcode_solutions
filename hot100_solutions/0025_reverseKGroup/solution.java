class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode lastTail = dummy; // 上一组翻转后的尾节点

        // k 个一组处理
        while (true) {
            // 看看这一组是否有 k 个节点
            ListNode cur = lastTail;
            for (int i = 0; i < k; i++) {
                cur = cur.next;
                if (cur == null) { // 不足 k 个节点
                    return dummy.next;
                    // 为什么返回dummy.next？
                    // 因为dummy.next指向的是头节点，而头节点是原始链表的头节点，所以返回dummy.next就是返回原始链表的头节点
                    // 而不是返回lastTail.next，因为lastTail.next指向的是当前组的头节点，而当前组的头节点是翻转后的尾节点
                }
            }

            ListNode pre = null;// pre 是前一个节点，初始值为 null，因为头节点没有前一个节点
            cur = lastTail.next; // 这里的cur不要与上面的cur混淆，这里是当前组的头节点
            // 这里的cur为什么不用ListNode cur 重新定义？

            for (int i = 0; i < k; i++) { // 同 92 题
                ListNode nxt = cur.next;
                cur.next = pre; // 每次循环只修改一个 next，方便大家理解
                pre = cur;
                cur = nxt;
            }

            // 翻转后：
            // pre 是当前组的头节点
            // cur 是下一组的起始节点
            // lastTail 是上一组的尾节点，上一组的尾节点指向当前组的头节点
            // 这么说，上一组时已经翻转了，所以lastTail.next指向当前组的头节点，然后当前组是没有翻转的
            // lastTail.next 是当前组的尾节点，是当前组反转后的头节点

            // 下面一段是在连接当前组的头节点和下一组的起始节点，以及上一组的尾节点和当前组的头节点
            // 这样就实现了当前组的翻转
            ListNode tail = lastTail.next;
            tail.next = cur; // 当前组的尾节点指向下一组的起始节点
            lastTail.next = pre; // 上一组的尾节点指向当前组的头节点
            lastTail = tail;
        }
    }
}