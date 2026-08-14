class Solution {
    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    public ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        if (head.next == tail) { // 这里怎么就判断链表只有一个节点啊？范围是左开右闭区间，不包含tail
            // 所以head.next == tail时，说明head是最后一个节点
            head.next = null;
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode list1 = sortList(head, mid);
        ListNode list2 = sortList(mid, tail);
        ListNode sorted = merge(list1, list2);
        return sorted;
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;// 移动指针到下一个节点
            } else {
                temp.next = temp2;
                temp2 = temp2.next;// 移动指针到下一个节点
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;// 合并剩余的节点
        } else if (temp2 != null) {
            temp.next = temp2;// 合并剩余的节点
        }
        return dummyHead.next;
    }
}
