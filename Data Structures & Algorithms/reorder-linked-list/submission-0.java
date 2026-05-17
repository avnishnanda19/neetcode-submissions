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
    public void reorderList(ListNode head) {
        ListNode slow = head; 
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null)
        {
            slow= slow.next;
            fast= fast.next.next;
        }

        System.out.print(slow.val+"-");
        
        ListNode nextHead = slow.next;
        slow.next=null;

        ListNode curr= nextHead; 
        ListNode prev =null;
        ListNode rev = nextHead;
        while(curr!=null)
        {
            rev= curr;
            curr= curr.next;
            rev.next=prev;
            prev=rev;
        }
        nextHead=prev;

        ListNode dummy = new ListNode(); 
        ListNode curr1=head; 
        ListNode curr2=nextHead; 
        while(curr1!=null && curr2!=null)
        {
            dummy.next=curr1; 
            curr1=curr1.next;
            dummy=dummy.next;
            dummy.next=curr2; 
            curr2=curr2.next;
            dummy=dummy.next; 
        }
        if(curr1!=null)
            dummy.next= curr1;
    }
}
