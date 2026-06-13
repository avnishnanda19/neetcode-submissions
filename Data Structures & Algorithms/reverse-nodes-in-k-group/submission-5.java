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
            int count = k; 
            while(count>0)
            {
                if(nextHead==null)
                break;
                nextHead=nextHead.next; 
                count--;
            }
            if(count>0) break;

            ListNode prev =null; 
            ListNode tail =curr;
            while(curr!=nextHead)
            {
                ListNode temp =  curr;
                curr=curr.next;
                temp.next=prev;
                prev=temp;
            }
            
            tail.next=nextHead;

            parent.next=prev;
            parent=tail;
        }
        return dummy.next;
    }
}
