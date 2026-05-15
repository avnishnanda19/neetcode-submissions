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

        ListNode parent = dummy; 
        ListNode curr= head; 
        ListNode forward = dummy; 

        while(forward!=null && n!=0)
        {
            forward=forward.next; 
            n--;
        }
        while(forward.next!=null)
        {
            parent=parent.next; 
            curr=curr.next;
            forward=forward.next;
        }
        parent.next =  curr.next;
        curr.next=null; 
        return dummy.next;
    }
}
