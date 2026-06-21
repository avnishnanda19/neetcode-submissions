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
        ListNode dummy = new ListNode(); 
        dummy.next = head; 
        ListNode parent  = dummy;
        ListNode fast =  head;
        while(n>0)
        {
            fast=fast.next;
            n--; 
        }
        ListNode curr = head;
        while(fast!=null)
        {
            fast= fast.next; 
            curr=curr.next;
            parent = parent.next;
        }

        parent.next= curr.next;


        return dummy.next;
    }
}
