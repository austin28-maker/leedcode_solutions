/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 利用双指针的方法解决改题目确保结果正确
        ListNode root = new ListNode(0, head);// ListNode(0, head)表示创建一个新的节点，节点值为0，下一个节点为head节点
        ListNode slow = root;
        ListNode fast = root;
        for(int i = 0; i < n; i++) {// fast指针先走n步
            // fast指针先走n步，slow指针再走，当fast指针走到链表的末尾时，slow指针就走到倒数第n个节点的前一个节点
            // 所以，slow指针的下一个节点就是要删除的节点
            fast = fast.next;
        }
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // 你没有判断slow.next是否为空，所以会报错，因为slow.next为空时，slow.next.next会报错
        if(slow.next != null) {
            slow.next = slow.next.next;// 删除slow指针的下一个节点
        }
        return root.next;
    }
}
