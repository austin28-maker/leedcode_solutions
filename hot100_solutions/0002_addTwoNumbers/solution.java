/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);// Head节点
        ListNode cursor = root;// 游标节点，用于遍历链表
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0) {
            int l1Val = l1 != null ? l1.val : 0;// l1.val表示l1节点的值，l1.next表示l1节点的下一个节点
            // l1不是链表么，.val表示的节点值是指哪个节点？
            int l2Val = l2 != null ? l2.val : 0;
            int sumVal = l1Val + l2Val + carry;
            carry = sumVal / 10;
            
            ListNode sumNode = new ListNode(sumVal % 10);
            cursor.next = sumNode;// 连接新节点
            cursor = sumNode;// 更新游标节点
            // cursor..next被赋值为sumNode节点了，为什么cursor要更新为sumNode节点？
            // 因为cursor节点是链表的最后一个节点，而sumNode节点是新添加的节点，所以要更新为sumNode节点
            
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        
        return root.next;
    }
}