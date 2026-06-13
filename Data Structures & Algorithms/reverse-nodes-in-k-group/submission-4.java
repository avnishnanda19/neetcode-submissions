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
        dummy.next= head ; 
        ListNode parent = dummy;
        ListNode curr =  head; 
        ListNode nextHead = head; 

        while(true)
        {
            int i = k; 
            while(i>0)
            {
                if(nextHead==null)
                break;
                nextHead=nextHead.next; 
                i--;
            }
            if(i>0) break;

            ListNode prev =null; 
            ListNode tail =curr;
            while(curr!=nextHead)
            {
                ListNode n =  curr;
                curr=curr.next;
                n.next=prev;
                prev=n;
            }
            parent.next=prev;
            parent=tail;
            tail.next=nextHead;
        }
        return dummy.next;
    }
}
