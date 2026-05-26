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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(); 
        dummy.next=head;
        ListNode parent =dummy;
        ListNode curr = head;
        while(true)
        {
            int counter = k;
            ListNode nextHead = curr;
            while(nextHead!=null && counter>0)
            {
                nextHead=nextHead.next;
                counter--;
            }
            if(counter!=0) break;

            ListNode lastTail=curr;
            ListNode prev = null; 
            while(curr!=nextHead)
            {
                ListNode n =  curr.next;
                curr.next=prev; 
                prev=curr;
                curr=n;
            }
            parent.next = prev;
            lastTail.next=curr;
            parent=lastTail;
            
        }
        return dummy.next;
    }
}
