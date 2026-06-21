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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a,b)->(Integer.compare(a.val,b.val))); 

        for(ListNode l : lists)
        {
            heap.offer(l);
        }

        ListNode dummy = new ListNode(); 
        ListNode curr = dummy;
        while(!heap.isEmpty())
        {
            ListNode n = heap.poll();
            curr.next = n; 
            if(n.next!=null) heap.offer(n.next);
            curr=curr.next; 
            curr.next=null;
        }
        return dummy.next;

    }
}
