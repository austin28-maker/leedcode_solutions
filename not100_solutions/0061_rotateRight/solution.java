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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return null;
        }

        int length = 1;
        ListNode tail = head;
        while(tail.next != null){
            tail = tail.next;
            length++;
        }
        k %= length;

        tail.next = head;
        ListNode newtail = head;
        for(int i = 0; i < length - k - 1; i++){
            newtail = newtail.next;
        }

        ListNode newhead = newtail.next;
        newtail.next = null;
        return newhead;
    }
}