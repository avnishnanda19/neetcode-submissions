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
        ListNode parent = dummy; 
        ListNode curr =  head;

        while(curr!=null)
        {
            int count=k;
            ListNode nextHead=curr;
            while(nextHead!=null && count>=1)
            {
                nextHead=nextHead.next;
                count--;
            }
            if(count!=0) break;
            
            ListNode prev=null; 
            ListNode last=curr; 
            while(curr!=nextHead)
            {
                ListNode n= curr;
                curr=curr.next; 
                n.next=prev; 
                prev=n;
            }
            last.next=nextHead;
            parent.next=prev;
            parent=last;

        }
        return dummy.next;
    }
}
